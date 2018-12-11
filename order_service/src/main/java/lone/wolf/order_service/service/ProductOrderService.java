package lone.wolf.order_service.service;

import lone.wolf.order_service.domain.ProductOrder;

/**
 * @Description
 * @Author hechunhui
 * @Created 2018/12/6 21:33
 */
public interface ProductOrderService {
    /**
     * 下单
     * @param userId
     * @param productId
     * @return
     */
    ProductOrder save(Long userId,Long productId);
}
