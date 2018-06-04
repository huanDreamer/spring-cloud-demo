package top.sillyfan.springcloud.consumer.support;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class MyCommand extends HystrixCommand<String> {
    public MyCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("mycommand"));
    }

    @Override
    protected String run() throws Exception {
        return "this is my command";
    }
}
