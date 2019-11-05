package org.john.springbootcodegenerator.service;

public interface MyBatisMapperService {
	

	/**
	 * 获取mapper全部列
	 * @author johnDeng
	 * @dataTime 2019年3月14日下午2:28:11
	 * @return
	 */
	public String  getMapperColumns(String tableName);
	
	/**
	 * 获取新增字段全部列
	 * @author johnDeng
	 * @dataTime 2019年3月14日下午5:44:09
	 * @param tableName
	 * @return
	 */
	public String  getInsertColums(String tableName);
	
	/**
	 * 获取新增字段全部值
	 * @author johnDeng
	 * @dataTime 2019年3月14日下午5:44:09
	 * @param tableName
	 * @return
	 */
	public String getInsertValues(String tableName);
	
	/**
	 * 获取修改字段全部列和值
	 * @author johnDeng
	 * @dataTime 2019年3月14日下午5:44:09
	 * @param tableName
	 * @return
	 */
	public String getUpdateColumms(String tableName);
	
	/**
	 * 获取新增批量全部值
	 * @author johnDeng
	 * @dataTime 2019年3月14日下午6:01:18
	 * @param tableName
	 * @return
	 */
	public String getInsertBatchValue(String tableName);
	
}
