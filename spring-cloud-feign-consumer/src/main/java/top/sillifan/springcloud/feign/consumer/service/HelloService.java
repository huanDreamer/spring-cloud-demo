package top.sillifan.springcloud.feign.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("provider") // 这里绑定的是服务的名称 不区分大小写
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping("/hello2")
    String hello2(@RequestParam("name") String name);
}
