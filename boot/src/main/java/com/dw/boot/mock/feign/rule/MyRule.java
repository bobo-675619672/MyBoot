package com.dw.boot.mock.feign.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MyRule extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {}

    @Override
    public Server choose(Object o) {
        ILoadBalancer lb = this.getLoadBalancer();
        List<Server> allList = lb.getAllServers();
        if (0 == allList.size()) {
            return null;
        } else {
            return allList.get(0);
        }
    }
}
