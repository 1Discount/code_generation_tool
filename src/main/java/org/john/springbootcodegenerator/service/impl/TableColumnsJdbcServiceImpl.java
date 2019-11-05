package org.john.springbootcodegenerator.service.impl;

import java.util.List;

import org.john.springbootcodegenerator.config.DatasourceConfig;
import org.john.springbootcodegenerator.entity.TableColumns;
import org.john.springbootcodegenerator.service.TableColumnsJdbcService;
import org.john.springbootcodegenerator.utils.DataBaseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TableColumnsJdbcServiceImpl  implements TableColumnsJdbcService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired 
	private DatasourceConfig datasourceSettings;

	/**
	 * 获取表结构
	 * 
	 * @author johnDeng
	 * @dataTime 2019年3月5日下午3:51:10
	 * @param tableName
	 * @return
	 */
	@Override
	public List<TableColumns> getListByTable(String tableName) {
		StringBuffer sql=new StringBuffer();
		sql.append(" SELECT TABLE_SCHEMA AS tableSchema,TABLE_NAME AS tableName,COLUMN_NAME AS columnName,");
		sql.append(" ORDINAL_POSITION AS ordinalPosition,IS_NULLABLE AS notNullFlag,DATA_TYPE AS dataType,");
		sql.append(" CHARACTER_MAXIMUM_LENGTH AS columnLength,COLUMN_KEY AS  cloumnKey,COLUMN_COMMENT AS cloumnComent");
		sql.append(" FROM information_schema.columns WHERE 1=1 AND table_schema = '");
		sql.append(DataBaseUtils.getDatabaseName(datasourceSettings.getUrl()));
		sql.append("' AND table_name = '");
		sql.append(tableName);
		sql.append("'");
		logger.info("jdbc getListByTable sql:"+sql.toString());
		return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<TableColumns>(TableColumns.class));
	}

}
