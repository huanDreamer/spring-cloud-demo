package top.sillifan.springcloud.feign.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.sillifan.springcloud.feign.consumer.service.HelloService;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/feign-hello")
    public String hello() {
        return helloService.hello();
    }

    @RequestMapping("/feign-hello2")
    public String hello2(@RequestParam String name) {
        return helloService.hello2(name);
    }
}
