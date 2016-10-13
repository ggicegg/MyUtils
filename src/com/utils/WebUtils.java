package com.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {
	public static Object form2Bean(HttpServletRequest request,Class clazz) throws InstantiationException, IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {

		//实例化对象，拿到所有字段
		Object o = clazz.newInstance();
		Field[] filds = o.getClass().getDeclaredFields();
		
		//拿到所有参数Map，可能拿到的是checkbox的数据，所以value是String[]
		Map<String,String[]> paraMap = request.getParameterMap();
		//给set设置string泛型防止报错
		Set<String> keySet = paraMap.keySet();
		for(String key : keySet){
			String[] values = paraMap.get(key);
			for(String value:values){
				String methodName = "set" + key.substring(0, 1).toUpperCase()+key.substring(1,key.length());
				Method method;
				try {
					method = clazz.getMethod(methodName, String.class);
				} catch (NoSuchMethodException e) {
					return o;
				}
				method.invoke(o, value);
			}
		}
		
		return o;
	}
}
