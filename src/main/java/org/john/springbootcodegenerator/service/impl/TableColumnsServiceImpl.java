package org.john.springbootcodegenerator.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.john.springbootcodegenerator.common.KeyCommons;
import org.john.springbootcodegenerator.config.GlobalConfig;
import org.john.springbootcodegenerator.entity.TableColumns;
import org.john.springbootcodegenerator.enums.DataTypeEnums;
import org.john.springbootcodegenerator.service.TableColumnsJdbcService;
import org.john.springbootcodegenerator.service.TableColumnsService;
import org.john.springbootcodegenerator.utils.FormatNameUtlis;
import org.springframework.stereotype.Service;

@Service
public class TableColumnsServiceImpl implements TableColumnsService {
	@Resource
	private TableColumnsJdbcService tableColumnsJdbc;
	@Resource
	public GlobalConfig jdbcTableConfig;

	@Override
	public String getAliasName(String tableName) {
		if (StringUtils.isNotEmpty(tableName)) {
			if(StringUtils.isNotEmpty(jdbcTableConfig.getTablePrefix())){
				String s="";
				String [] splits=tableName.split(jdbcTableConfig.getTablePrefix());
				for(int i=1;i<splits.length;i++){
					s+=splits[i];
				}
				return FormatNameUtlis.formatNameLowerCase(s);
			}
		}
		return "";
	}

	@Override
	public String getClassName(String tableName) {
		if (StringUtils.isNotBlank(jdbcTableConfig.getTablePrefix())) {
			tableName = tableName.replace(jdbcTableConfig.getTablePrefix(), "");
		}
		return FormatNameUtlis.formatNameCamelbak(tableName);
	}

	@Override
	public String getEntityClassName(String tableName) {
		return FormatNameUtlis.formatNameCamelbak(tableName);
	}

	@Override
	public String getPrimaryKeyDataType(String tableName) {
		List<TableColumns> list = getListByTable(tableName);
		if (CollectionUtils.isNotEmpty(list)) {
			for (TableColumns table : list) {
				boolean isPK = KeyCommons.PK.equals(table.getCloumnKey());
				if (isPK) {
					return DataTypeEnums.getJavaDataTypeByMysqlDataType(table.getDataType());
				}
			}
		}
		return null;
	}

	@Override
	public String getEntitySetFunction(String ColumnName, String dataType) {
		StringBuffer sb = new StringBuffer();
		if (StringUtils.isNotEmpty(ColumnName) && StringUtils.isNotEmpty(dataType)) {
			sb.append("    public void set");
			sb.append(FormatNameUtlis.formatNameCamelbak(ColumnName));
			sb.append("(");
			sb.append(DataTypeEnums.getJavaDataTypeByMysqlDataType(dataType));
			sb.append(" ");
			sb.append(FormatNameUtlis.formatNameLowerCase(ColumnName));
			sb.append(") {\n ");
			sb.append("    	this.");
			sb.append(FormatNameUtlis.formatNameLowerCase(ColumnName));
			sb.append(" = ");
			sb.append(FormatNameUtlis.formatNameLowerCase(ColumnName));
			sb.append(";\n");
			sb.append("     }\n\n ");

		}
		return sb.toString();
	}

	@Override
	public String getEntityGetFunction(String ColumnName, String dataType) {
		StringBuffer sb = new StringBuffer();
		if (StringUtils.isNotEmpty(ColumnName) && StringUtils.isNotEmpty(dataType)) {
			sb.append("    public ");
			sb.append(DataTypeEnums.getJavaDataTypeByMysqlDataType(dataType));
			sb.append(" get");
			sb.append(FormatNameUtlis.formatNameCamelbak(ColumnName));
			sb.append("() { \n");
			sb.append("        return ");
			sb.append(FormatNameUtlis.formatNameLowerCase(ColumnName));
			sb.append(";\n");
			sb.append("     }\n\n ");
		}
		return sb.toString();
	}

	@Override
	public String getProperty(String ColumnName, String dataType) {
		StringBuffer sb = new StringBuffer();
		if (StringUtils.isNotEmpty(ColumnName) && StringUtils.isNotEmpty(dataType)) {
			sb.append("    private ");
			sb.append(DataTypeEnums.getJavaDataTypeByMysqlDataType(dataType));
			sb.append(" ");
			sb.append(FormatNameUtlis.formatNameLowerCase(ColumnName));
			sb.append(";\n");
		}
		return sb.toString();
	}

	@Override
	public String getEntityData(String tableName) {
		List<TableColumns> list = getListByTable(tableName);
		StringBuilder propertyString = new StringBuilder();
//		StringBuilder functionString = new StringBuilder();
		if (CollectionUtils.isNotEmpty(list)) {
			for (TableColumns table : list) {
				propertyString.append(getPropertyComments(table.getCloumnComent()));
				propertyString.append(getProperty(table.getColumnName(), table.getDataType()));
//				functionString.append(getEntitySetFunction(table.getColumnName(), table.getDataType()));
//				functionString.append(getEntityGetFunction(table.getColumnName(), table.getDataType()));
			}
//			propertyString.append(functionString.toString());
		}
		return propertyString.toString();
	}

	@Override
	public String getVOData(String tableName) {
		List<TableColumns> list = getListByTable(tableName);
		StringBuilder propertyString = new StringBuilder();
		if (CollectionUtils.isNotEmpty(list)) {
			for (TableColumns table : list) {
				propertyString.append(getPropertyComments(table.getCloumnComent()));
				propertyString.append(getPropertySwaggerComments(table.getCloumnComent()));
				propertyString.append(getProperty(table.getColumnName(), table.getDataType()));
			}
		}
		return propertyString.toString();
	}

	@Override
	public List<TableColumns> getListByTable(String tableName) {

		return tableColumnsJdbc.getListByTable(tableName);
	}

	/**
	 * 创建时间
	 */
	@Override
	public String getPropertyComments(String comments) {
		StringBuffer sb = new StringBuffer();
		sb.append("    /**\n");
		sb.append("     *");
		sb.append("     "+comments + "\n");
		sb.append("     */\n");
		return sb.toString();
	}

	/**
	 * comments
	 */
	@Override
	public String getPropertySwaggerComments(String comments) {
		StringBuffer sb = new StringBuffer();
		sb.append("    @ApiModelProperty(value=\"") .append(comments).append("\")\n");
		return sb.toString();
	}
}
