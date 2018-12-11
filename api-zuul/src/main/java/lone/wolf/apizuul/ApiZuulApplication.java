package lone.wolf.apizuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
/**
 * @Description 网关服务启动类
 * @Author hch
 * @Created 2018/12/10 17:18
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class ApiZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiZuulApplication.class, args);
    }
}
