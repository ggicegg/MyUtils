package com.test;

import java.io.IOException;

import org.junit.Test;

import com.utils.GetFileContent;

public class Test4GetFileContent {
	
	
	@Test
	public void test(){
		String value = "";
		try {
			value = GetFileContent.getContent("password",GetFileContent.CURRENT_TYPE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(value);
	}
}
