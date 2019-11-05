package org.john.springbootcodegenerator.enums;

/**
 * 数据类型枚举
 * @author JohnDeng
 * @datatime 2019年1月17日上午9:49:04
 */
public enum DataTypeEnums {
	
	CHAR("char","String"),
	VARCHAR("varchar","String"),
	BLOB("blob","byte[]"),
	TEXT("text","String"),
	INTEGER("integer","Long"),
	TINYINT("tinyint","Integer"),
	SMALLINT("varchar","Integer"),
	MEDIUMINT("mediumint","Integer"),
	BIT("bit","Boolean"),
	BIGINT("bigint","Long"),
	FLOAT("float","Float"),
	DOUBLE("double","Double"),
	DECIMAL("decimal","java.math.BigDecimal"),
	BOOLEAN("varchar","Integer"),
	DATE("date","Date"),
	DATETIME("datetime","java.util.Date"),
	INT("int","Integer"),
	TIMESTAMP("timestamp","java.util.Date");

	private final String mySqlDataType;
	private final String javaDataType;
	
	public static String getJavaDataTypeByMysqlDataType(String mySqlDataType) {
		for (DataTypeEnums e : DataTypeEnums.values()) {
			if (e.getMySqlDataType().equals((mySqlDataType))) {
				return e.getJavaDataType();
			}
		}
		return "";
	}
	
	
	private DataTypeEnums(String mySqlDataType, String javaDataType) {
		this.mySqlDataType = mySqlDataType;
		this.javaDataType = javaDataType;
	}
	public String getMySqlDataType() {
		return mySqlDataType;
	}
	public String getJavaDataType() {
		return javaDataType;
	}
}
