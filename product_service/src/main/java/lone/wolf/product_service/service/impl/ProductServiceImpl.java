package lone.wolf.product_service.service.impl;

import lone.wolf.product_service.domain.Product;
import lone.wolf.product_service.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description 商品业务实现类
 * @Author hechunhui
 * @Created 2018/12/6 15:17
 */
@Service
public class ProductServiceImpl implements ProductService {
    private static final Map<Long, Product> daoMap = new HashMap<>();

    static {
        Product p1 = new Product(1L, "iPhoneXR", 1000000, 100);
        Product p2 = new Product(2L, "保温杯", 10000, 50);
        Product p3 = new Product(3L, "冰箱", 5000000, 10);
        Product p4 = new Product(4L, "飞行堡垒5代", 800000, 88);
        Product p5 = new Product(5L, "小企鹅", 10000000, 1);
        daoMap.put(p1.getId(), p1);
        daoMap.put(p2.getId(), p2);
        daoMap.put(p3.getId(), p3);
        daoMap.put(p4.getId(), p4);
        daoMap.put(p5.getId(), p5);
    }

    @Override
    public List<Product> listProduct() {
        Collection<Product> products = daoMap.values();
        List<Product> list = new ArrayList<>(products);
        return list;
    }

    @Override
    public Product findById(Long id) {
        return daoMap.get(id);
    }
}
