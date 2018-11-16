package com.zjx.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class MyZuulFilter extends ZuulFilter {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
	 */
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if (accessToken == null){
			log.warn("token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			
			try {
				ctx.getResponse().getWriter().write("token is empty!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		log.info("ok");
		return null;
	}

	/**
	 * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * filterOrder：过滤的顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * filterType
	 * pre：路由之前
	 * routing：路由之时
	 * post： 路由之后
	 * error：发送错误调用
	 * */
	@Override
	public String filterType() {
		return "pre";
	}

}
