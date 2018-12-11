package lone.wolf.order_service.service;

import lone.wolf.order_service.failback.ProductClientFailBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description 商品服务客户端
 * @Author hechunhui
 * @Created 2018/12/7 16:18
 */
@FeignClient(name = "product-service",fallback = ProductClientFailBack.class)
public interface ProductClient {
    @GetMapping("/api/v1/product/find")
    String fingById(@RequestParam(value = "id") Long id);
}
