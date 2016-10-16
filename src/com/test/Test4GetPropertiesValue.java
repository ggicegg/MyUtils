package com.test;

import java.io.IOException;

import org.junit.Test;

import com.utils.GetPropertiesValue;

public class Test4GetPropertiesValue {
	
	
	@Test
	public void test(){
		String value = "";
		try {
			String key = "dir";
			String fileName = "mysql";
			int type = GetPropertiesValue.ROOT_TYPE;
			String filePath = "Resources";
			value = GetPropertiesValue.getValue(key,type,fileName,filePath);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(value);
	}
}
