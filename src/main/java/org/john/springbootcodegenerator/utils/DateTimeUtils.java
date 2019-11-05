package org.john.springbootcodegenerator.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 时间工具类
 * @author JohnDeng
 * @datatime 2019年5月25日下午10:57:37
 */
public class DateTimeUtils {

	/**
	 * 获取当前时间字符串
	 * 格式：yyyy-MM-dd hh:mm:ss
	 * @author JohnDeng
	 * @dateTime 2019年5月30日下午5:12:09
	 * @return
	 */
	public  static String getDatatime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(new Date());
	}
}
