package lone.wolf.product_service.controller;

import lone.wolf.product_service.domain.Product;
import lone.wolf.product_service.service.ProductService;
import lone.wolf.utils.JsonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author hechunhui
 * @Created 2018/12/6 15:24
 */
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private ProductService productService;
    @GetMapping("list")
    public JsonResult<List<Product>> listProduct() {
        List<Product> products = productService.listProduct();
        return JsonResult.success(products);
    }
    @GetMapping("find")
    public Product findById(@RequestParam("id")Long id){
        Product product = productService.findById(id);
        Product result = new Product();
        BeanUtils.copyProperties(product,result);
        result.setName(result.getName()+" data from port="+port);
        return result;
    }
}
