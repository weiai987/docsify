package com.bailiban.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class DirtyFilter implements Filter {

   

	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		//定义不文明词汇集合
		List<String> list = Arrays.asList("傻x","畜生","傻X");
		//创建代理对象
		ServletRequest proxy_request = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(),new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//增强getParameterMap方法
				 //判断是否是getParameter方法
                if(method.getName().equals("getParameterMap")){
                    //增强返回值
                    //获取返回值
                
                	Map<String, String[]> map = (Map<String, String[]> ) method.invoke(request,args);
                	
                	for (Entry<String, String[]> entry : map.entrySet()) {
						 
                		   //获取数据数组中的第一个元素
                		   String value = entry.getValue()[0];
                		  //判断数据数组中第一个元素是否包含敏感词汇
                		  for (String dirty : list) {
							  //如果包含
                			  if(value.contains(dirty)) {
                				  //将敏感词替换为***
                				  entry.getValue()[0]= value.replace(dirty, "***");
                			  }
						  }
					 }
                	//返回处理好的map
                     return  map;
                }
                return method.invoke(request,args);
			
			}
		});
		
		
		chain.doFilter(proxy_request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
