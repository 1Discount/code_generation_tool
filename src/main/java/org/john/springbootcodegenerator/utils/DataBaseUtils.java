package org.john.springbootcodegenerator.utils;

/**
 * 数据库工具类
 * @author JohnDeng
 * @datatime 2019年5月25日下午11:12:45
 */
public class DataBaseUtils {

	/**
	 * 根据全局配置的url截取数据库名称
	 * @author JohnDeng
	 * @datatime 2019年5月25日下午11:12:52
	 * @param url
	 * @return
	 */
	public static  String getDatabaseName(String url) {
		int i = url.lastIndexOf("/");
		int j = url.indexOf("?");
		return  url.substring(i + 1, j);
	}
	
	
}
