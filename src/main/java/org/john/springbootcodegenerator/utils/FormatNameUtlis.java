package org.john.springbootcodegenerator.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 名称转换工具类
 * 
 * @author JohnDeng
 * @datatime 2019年1月17日上午9:12:56
 */
public class FormatNameUtlis {
	public static final char UNDERLINE = '_';
	
	/**
	 * 首字符变成大写
	 * 测试：
	 * java : Java
	 * javaC : JavaC
	 * @author JohnDeng
	 * @datatime 2019年1月22日下午2:54:42
	 * @param ColumnName
	 * @return
	 */
	public static String formatNameIndexToUpperCase(String ColumnName) {
		if(StringUtils.isEmpty(ColumnName)){
			return "";
		}
		return ColumnName.substring(0, 1).toUpperCase() + ColumnName.substring(1, ColumnName.length());
	}
	
	/**
	 * 首字符变成小写
	 * @author JohnDeng
	 * @datatime 2019年1月22日下午2:54:42
	 * @param ColumnName
	 * @return
	 */
	public static String formatNameIndexToLowerCase(String ColumnName) {
		if(StringUtils.isEmpty(ColumnName)){
			return "";
		}
		return ColumnName.substring(0, 1).toLowerCase() + ColumnName.substring(1, ColumnName.length());
	}

	
	/**
	 * 大写转下滑线（JAVA转MySQL) 测试： Java : _java JavaC: _java_c
	 * 
	 * @author JohnDeng
	 * @dateTime 2019年5月30日下午6:09:25
	 * @param param
	 * @return
	 */
	public static String camelToUnderline(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append(UNDERLINE);
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 下划线转驼峰，首字符不大写 测试： sys_user ：sysUser tb_sys_user: tbSysUser
	 * 
	 * @author JohnDeng
	 * @dateTime 2019年5月30日下午6:11:50
	 * @param param
	 * @return
	 */
	public static String underlineToCamel(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (c == UNDERLINE) {
				if (++i < len) {
					sb.append(Character.toUpperCase(param.charAt(i)));
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * 去掉下划线，格式名称，驼峰写法，首字符大写
	 * 格式化name user->User user_role->UserRole
	 *
	 * @param ColumnName
	 * @return
	 * @author John
	 * @datatime 2017年10月30日下午3:14:06
	 */
	public static String formatNameCamelbak(String ColumnName) {
		String arr[] = ColumnName.split("_");
		ColumnName = "";
		for (int i = 0; i < arr.length; i++) {
			ColumnName += arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
		}
		return ColumnName;
	}

	/**
	 * 首字母大写改成小写 
	 * 格式化name User->user UserRole->userRole
	 *
	 * @param ColumnName
	 * @return
	 * @author John
	 * @datatime 2017年10月31日上午11:08:15
	 */
	public static String formatNameLowerCase(String ColumnName) {
		if (StringUtils.isEmpty(ColumnName)) {
			return ColumnName;
		}
		String arr[] = ColumnName.split("_");
		ColumnName = "";
		ColumnName += arr[0].substring(0, 1).toLowerCase() + arr[0].substring(1);
		for (int i = 1; i < arr.length; i++) {
			ColumnName += arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
		}
		return ColumnName;
	}
	
	public static void main(String[] args) {
		System.out.println(formatNameLowerCase("name"));
	}
	
}
