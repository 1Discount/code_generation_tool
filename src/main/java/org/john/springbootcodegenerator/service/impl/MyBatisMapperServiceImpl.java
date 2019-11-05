package org.john.springbootcodegenerator.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.john.springbootcodegenerator.entity.TableColumns;
import org.john.springbootcodegenerator.service.MyBatisMapperService;
import org.john.springbootcodegenerator.service.TableColumnsService;
import org.john.springbootcodegenerator.utils.FormatNameUtlis;
import org.springframework.stereotype.Service;

@Service
public class MyBatisMapperServiceImpl implements MyBatisMapperService {

	@Resource
	private TableColumnsService tableColumnsService;

	@Override
	public String getMapperColumns(String tableName) {
		StringBuilder columns = new StringBuilder();
		boolean flag = false;
		for (TableColumns tableColumns : tableColumnsService.getListByTable(tableName)) {
			if (flag) {
				columns.append(",\n");
			}
			columns.append("		");
			columns.append(FormatNameUtlis.formatNameLowerCase(tableColumnsService.getClassName(tableName)));
			columns.append(".");
			columns.append(tableColumns.getColumnName());
			columns.append(" AS ");
			columns.append(FormatNameUtlis.formatNameLowerCase(tableColumns.getColumnName()));
			flag = true;
		}
		return columns.toString();
	}

	@Override
	public String getInsertColums(String tableName) {
		StringBuilder insertColums = new StringBuilder();
		boolean flag = false;
		for (TableColumns tableColumns : tableColumnsService.getListByTable(tableName)) {
			if (flag) {
				insertColums.append(",\n");
			}
			insertColums.append("			");
			insertColums.append(tableColumns.getColumnName());
			flag = true;
		}
		return insertColums.toString();
	}

	@Override
	public String getInsertValues(String tableName) {
		StringBuilder insertValues = new StringBuilder();
		boolean flag = false;
		for (TableColumns tableColumns : tableColumnsService.getListByTable(tableName)) {
			if (flag) {
				insertValues.append(",\n");
			}
			insertValues.append("			");
			insertValues.append("#{");
			insertValues.append(FormatNameUtlis.formatNameLowerCase(tableColumns.getColumnName()));
			insertValues.append("}");
			flag = true;
		}
		return insertValues.toString();
	}

	@Override
	public String getUpdateColumms(String tableName) {
		StringBuilder updateValues = new StringBuilder();
		boolean flag = false;
		List<TableColumns> list = tableColumnsService.getListByTable(tableName);
		//过滤
		//list=FilterColumnsUtils.filter(list,FilterColumnsUtils.arrayMapper);
		for (TableColumns tableColumns : list) {
			if (flag) {
				updateValues.append("\n");
			}
			updateValues.append("			");
			updateValues.append("<if test=\"" + FormatNameUtlis.formatNameLowerCase(tableColumns.getColumnName()) + "!=null\">");
			updateValues.append(tableColumns.getColumnName());
			updateValues.append("=#{");
			updateValues.append(FormatNameUtlis.formatNameLowerCase(tableColumns.getColumnName()));
			updateValues.append("},</if>");
			flag = true;
		}
		return updateValues.toString();
	}

	@Override
	public String getInsertBatchValue(String tableName) {
		StringBuilder insertValues = new StringBuilder();
		boolean flag = false;
		for (TableColumns tableColumns : tableColumnsService.getListByTable(tableName)) {
			if (flag) {
				insertValues.append(",\n");
			}
			insertValues.append("			");
			insertValues.append("#{item.");
			insertValues.append(FormatNameUtlis.formatNameLowerCase(tableColumns.getColumnName()));
			insertValues.append("}");
			flag = true;
		}
		return insertValues.toString();
	}

}
