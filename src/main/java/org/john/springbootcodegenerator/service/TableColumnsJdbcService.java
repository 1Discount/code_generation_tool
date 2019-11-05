package org.john.springbootcodegenerator.service;

import java.util.List;

import org.john.springbootcodegenerator.entity.TableColumns;


/**
 * jdbc 表结构 Service
 * @author JohnDeng
 * @dateTime 2019年5月30日下午5:10:04
 */
public interface TableColumnsJdbcService {
	
	/**
	 * 根据数据库表名称获取表结构
	 * @author JohnDeng
	 * @dateTime 2019年5月30日下午5:09:44
	 * @param tableName
	 * @return
	 */
	public List<TableColumns> getListByTable(String tableName) ;
	
}
