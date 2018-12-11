package lone.wolf.order_service.failback;

import lone.wolf.order_service.service.ProductClient;
import org.springframework.stereotype.Component;

/**
 * @Description 针对商品服务的出错降级处理
 * @Author hechunhui
 * @Created 2018/12/8 14:24
 */
@Component
public class ProductClientFailBack implements ProductClient {
    @Override
    public String fingById(Long id) {
        System.out.println("fegin 调用product-service fingById 异常");
        return null;
    }
}
