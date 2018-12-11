package lone.wolf.order_service.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lone.wolf.order_service.domain.ProductOrder;
import lone.wolf.order_service.service.ProductClient;
import lone.wolf.order_service.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @Description 
 * @Author hechunhui
 * @Created 2018/12/6 21:33
 */
@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    //@Autowired
    //private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;
    @Override
    public ProductOrder save(Long userId, Long productId) {
        //Map<String,Object> productMap = restTemplate.getForObject("http://product-service/api/v1/product/find?id=" + productId, Map.class);
        String response = productClient.fingById(productId);
        JSONObject productMap = JSON.parseObject(response);


        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setProductName(productMap.get("name").toString());
        productOrder.setPrice(Integer.valueOf(productMap.get("price").toString()));
        return productOrder;
    }
}
