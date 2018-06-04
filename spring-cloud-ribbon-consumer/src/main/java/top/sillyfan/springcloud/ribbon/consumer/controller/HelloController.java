package top.sillyfan.springcloud.ribbon.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    @HystrixCommand(fallbackMethod = "defaultHello")
    public String test() {
        return restTemplate.getForEntity("http://PROVIDER/hello", String.class).getBody();
    }

    // 在 PROVIDER 服务没有启动/阻塞的时候，将会调用该函数
    public String defaultHello() {

//        throw new RuntimeException("测试异常");
        return "defaultHello";
    }


}
