package lone.wolf.order_service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lone.wolf.order_service.domain.ProductOrder;
import lone.wolf.order_service.service.ProductOrderService;
import lone.wolf.utils.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @Description 订单控制层
 * @Author hechunhui
 * @Created 2018/12/6 21:33
 */
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private ProductOrderService productOrderService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public JsonResult save(@RequestParam("user_id") Long userId, @RequestParam("product_id") Long productId, HttpServletRequest request) {
        ProductOrder order = productOrderService.save(userId, productId);
        String token = request.getHeader("token");
        String cookie = request.getHeader("cookie");
        System.out.println("token-->" + token + ",cookie----->" + cookie);
        return JsonResult.success(order);
    }

    private JsonResult saveOrderFail(Long userId, Long productId, HttpServletRequest request) {
        /**
         * 监控报警
         */

        String saveOrderKey = "save-order";
        String sendValue = redisTemplate.opsForValue().get(saveOrderKey);
        new Thread(() -> {
            if (StringUtils.isBlank(sendValue)) {
                System.out.println("紧急短信，用户下单失败，请立刻查找原因！");
                //防止重复发送
                redisTemplate.opsForValue().set(saveOrderKey, "save-order-fail", 10, TimeUnit.SECONDS);
            } else {
                System.out.println("已经发送过短信，10秒内不在重复发送！");
            }
        }).start();


        return JsonResult.fail(-1, null, "当前访问人数过多，请稍后尝试");
    }
}
