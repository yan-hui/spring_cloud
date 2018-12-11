package lone.wolf.product_service.domain;

/**
 * @Description 商品
 * @Author hechunhui
 * @Created 2018/12/6 15:14
 */
public class Product {
    /**
     * 商品id
     */
    private Long id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 价格，以分为单位
     */
    private Integer price;
    /**
     * 库存
     */
    private Integer store;

    public Product() {
    }

    public Product(Long id, String name, Integer price, Integer store) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.store = store;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }
}
