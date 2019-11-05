package org.john.springbootcodegenerator.entity;

/**
 * 数据表字段
 * 
 * @author JohnDeng
 * @datatime 2019年1月16日上午9:51:12
 */
public class TableColumns {

	/**
	 * 数据库名
	 */
	private String tableSchema;
	/**
	 * 表名
	 */
	private String tableName;
	/**
	 * 列名
	 */
	private String columnName;

	/**
	 * 排序
	 */
	private String ordinalPosition;

	/**
	 * 是否为空标识
	 */
	private String notNullFlag;
	/**
	 * 数据类型
	 */
	private String dataType;

	/**
	 * 字段长度
	 */
	private String columnLength;

	/**
	 * 字段主键
	 */
	private String cloumnKey;
	/**
	 * 字段注释
	 */
	private String cloumnComent;

	public String getTableSchema() {
		return tableSchema;
	}

	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getOrdinalPosition() {
		return ordinalPosition;
	}

	public void setOrdinalPosition(String ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}

	public String getNotNullFlag() {
		return notNullFlag;
	}

	public void setNotNullFlag(String notNullFlag) {
		this.notNullFlag = notNullFlag;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getColumnLength() {
		return columnLength;
	}

	public void setColumnLength(String columnLength) {
		this.columnLength = columnLength;
	}

	public String getCloumnKey() {
		return cloumnKey;
	}

	public void setCloumnKey(String cloumnKey) {
		this.cloumnKey = cloumnKey;
	}

	public String getCloumnComent() {
		return cloumnComent;
	}

	public void setCloumnComent(String cloumnComent) {
		this.cloumnComent = cloumnComent;
	}

}
