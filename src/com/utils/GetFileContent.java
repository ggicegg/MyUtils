package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class GetFileContent {
	private static Properties properties = null;
	static{
		properties = new Properties();
	}
	/**
	 * 通用从类加载目录加载配置资源文件工具
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getContent(String key) throws FileNotFoundException, IOException{
		String value = "";
		//从这里拿到的file路径如果包含中文，会被URL编码成%__所以使用URLDecoder解码
		
		//使用getClassLoader()会从编译根目录下加载。问题：如果这里使用'/',指的是哪里
//		String path = GetFileContent.class.getClassLoader().getResource
//				("Resources/mysql.properties").getFile();
		
		
		//不使用getClassLoader()会从该类的包目录下加载,也可以再getResource()中使用'/'根目录
		//最合适的应该是再编译根目录下建立Resource文件夹目录
		String path = GetFileContent.class.getResource
				("/Resources/mysql.properties").getFile();
		
		System.out.println(path);
		//解码后的路径才能被FileInputStream或者FileReader类读入
		path = URLDecoder.decode(path, "UTF-8");
		System.out.println(path);
		File file = new File(path);
		properties.load(new FileInputStream(file));
//		System.out.println(file);
		value = properties.getProperty(key);
		return value;
	}
}
