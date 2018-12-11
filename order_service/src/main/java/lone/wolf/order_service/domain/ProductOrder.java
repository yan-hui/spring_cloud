package lone.wolf.order_service.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 商品订单实体类
 * @Author hechunhui
 * @Created 2018/12/6 21:29
 */
public class ProductOrder implements Serializable {
    private Long id;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 订单号
     */
    private String tradeNo;
    /**
     * 价格：分
     */
    private Integer price;
    private Date createTime;


    private Long userId;
    private String userName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
