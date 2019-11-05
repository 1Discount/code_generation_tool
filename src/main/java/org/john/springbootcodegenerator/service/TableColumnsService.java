package org.john.springbootcodegenerator.service;

import java.util.List;

import org.john.springbootcodegenerator.entity.TableColumns;

public interface TableColumnsService {

	/**
	 * 别名
	 * 
	 * @author dulin
	 * @datatime 2019年1月16日下午5:08:02
	 * @return
	 */
	public String getAliasName(String className);


	/**
	 * 类名
	 * 
	 * @author dulin
	 * @datatime 2019年1月16日下午5:08:24
	 * @return
	 */
	public String getClassName(String tableName);

	/**
	 * 类名
	 *
	 * @author dulin
	 * @datatime 2019年1月16日下午5:08:24
	 * @return
	 */
	public String getEntityClassName(String tableName);

	/**
	 * 主键
	 * 
	 * @author dulin
	 * @datatime 2019年1月16日下午5:08:35
	 * @return
	 */
	public String getPrimaryKeyDataType(String tableName);

	/**
	 * 获取实体set方法
	 * 
	 * @author dulin
	 * @datatime 2019年1月17日上午10:06:35
	 * @param ColumnName
	 * @param dataType
	 * @return
	 */
	public String getEntitySetFunction(String ColumnName, String dataType);

	/**
	 * 获取实体get方法
	 * 
	 * @author dulin
	 * @datatime 2019年1月17日上午10:07:32
	 * @param ColumnName
	 * @param dataType
	 * @return
	 */
	public String getEntityGetFunction(String ColumnName, String dataType);

	/**
	 * 创建属性
	 * 
	 * @author dulin
	 * @datatime 2019年1月17日上午11:01:54
	 * @param ColumnName
	 * @param dataType
	 * @return
	 */
	public String getProperty(String ColumnName, String dataType);

	/**
	 * 获取实体数据
	 * 
	 * @author dulin
	 * @datatime 2019年1月17日上午11:13:13
	 * @param list
	 * @return
	 */
	public String getEntityData(String tableName);

	/**
	 * 获取实体数据
	 *
	 * @author dulin
	 * @datatime 2019年1月17日上午11:13:13
	 * @param tableName
	 * @return
	 */
	public String getVOData(String tableName);
	
	/**
	 * 根据表名获取所有数据
	 * @author dulin
	 * @datatime 2019年1月19日上午12:45:27
	 * @param tableName
	 * @return
	 */
	public List<TableColumns> getListByTable(String tableName);
	
	
	/**
	 * 获取属性注释
	 * @author dulin
	 * @datatime 2019年1月21日下午5:42:56
	 * @return
	 */
	public String  getPropertyComments(String comments);

	/**
	 * 获取swagger注释
	 * @author dulin
	 * @datatime 2019年1月21日下午5:42:56
	 * @return
	 */
	public String  getPropertySwaggerComments(String comments);
}
