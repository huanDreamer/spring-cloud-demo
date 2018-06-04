package top.sillyfan.springcloud.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import top.sillyfan.springcloud.consumer.support.MyCommand;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

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

    @GetMapping("/useMyCommand")
    public String useMyCommand() {

        List<String> stringList = new ArrayList<>();

        MyCommand myCommand = new MyCommand();
        Observable<String> observe = myCommand.observe();

        observe.forEach(stringList::add);

        return stringList.get(0);
    }
}
