package com.maoshen.idautocreate.interceptor;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.maoshen.component.aop.interceptor.service.ServiceInterceptor;

@Aspect
@Component
@Order(0)
public class IdServiceInterceptor extends ServiceInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(IdServiceInterceptor.class);

	public IdServiceInterceptor() {
		LOGGER.info("{} {}_service Interceptor is start", IdServiceInterceptor.class.getName(), getServiceName());
	}

	@Override
	@Pointcut("execution(* com.maoshen.*.service.impl.*.*(..))")
	public void pointcut() {

	}

	@Override
	public String getServiceName() {
		return "commonSpringMvc";
	}
}
