package top.sillyfan.springcloud.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/hello")
    public String hello() throws InterruptedException {

        // 使线程阻塞，客户端将会调用容错保护
        // 超时2000
        int sleepTime = new Random().nextInt(3000);
        Thread.sleep(sleepTime);

        return "hello" + port + ", sleepd" + sleepTime;
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam String name) {
        return "hello2: " + name;
    }
}
