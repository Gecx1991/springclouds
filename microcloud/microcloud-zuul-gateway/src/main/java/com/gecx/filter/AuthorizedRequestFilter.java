package com.gecx.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author Gecx
 * @Description: 其中filterType为过滤的类型
 * 在进行Zuul过滤的时候可以设置其过滤执行的位置，那么此时有如下几种类型：
 * 	pre：在请求发出之前执行过滤，如果要进行访问，肯定在请求前设置头信息
 * 	route：在进行路由请求的时候被调用；
 * 	post：在路由之后发送请求信息的时候被调用；
 * 	error：出现错误之后进行调用
 * @date 2019/4/17 22:37
 */
public class AuthorizedRequestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 获取当前请求的上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 认证的原始信息
        String auth = "admin:123456";
        // 进行一个加密的处理
        byte[] encodedAuth = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        currentContext.addZuulRequestHeader("Authorization", authHeader);
        return null;
    }
}
