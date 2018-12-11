package lone.wolf.product_service.service;

import lone.wolf.product_service.domain.Product;

import java.util.List;

/**
 * @Description 商品业务接口
 * @Author hechunhui
 * @Created 2018/12/6 15:16
 */
public interface ProductService {
    List<Product> listProduct();

    Product findById(Long id);
}
