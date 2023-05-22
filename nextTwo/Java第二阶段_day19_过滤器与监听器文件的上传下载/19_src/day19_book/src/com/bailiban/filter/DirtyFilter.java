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
	
		//���岻�����ʻ㼯��
		List<String> list = Arrays.asList("ɵx","����","ɵX");
		//�����������
		ServletRequest proxy_request = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(),new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//��ǿgetParameterMap����
				 //�ж��Ƿ���getParameter����
                if(method.getName().equals("getParameterMap")){
                    //��ǿ����ֵ
                    //��ȡ����ֵ
                
                	Map<String, String[]> map = (Map<String, String[]> ) method.invoke(request,args);
                	
                	for (Entry<String, String[]> entry : map.entrySet()) {
						 
                		   //��ȡ���������еĵ�һ��Ԫ��
                		   String value = entry.getValue()[0];
                		  //�ж����������е�һ��Ԫ���Ƿ�������дʻ�
                		  for (String dirty : list) {
							  //�������
                			  if(value.contains(dirty)) {
                				  //�����д��滻Ϊ***
                				  entry.getValue()[0]= value.replace(dirty, "***");
                			  }
						  }
					 }
                	//���ش���õ�map
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
