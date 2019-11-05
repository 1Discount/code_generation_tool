package org.john.springbootcodegenerator.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.john.springbootcodegenerator.common.TemplateCommon;
import org.john.springbootcodegenerator.config.ExtendsConfig;
import org.john.springbootcodegenerator.config.GlobalConfig;
import org.john.springbootcodegenerator.service.MyBatisMapperService;
import org.john.springbootcodegenerator.service.TableColumnsService;
import org.john.springbootcodegenerator.service.TemplateGeneratorService;
import org.john.springbootcodegenerator.utils.DateTimeUtils;
import org.john.springbootcodegenerator.utils.FileUtlis;
import org.john.springbootcodegenerator.utils.FormatNameUtlis;
import org.john.springbootcodegenerator.utils.ReplaceUtlis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 获取默认（不继承）的代码生成器
 * @author JohnDeng
 * @dateTime 2019年6月17日下午6:15:06
 */
@Service
public class TemplateDefaultGeneratorServiceImpl implements TemplateGeneratorService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private TableColumnsService tableColumnsService;
	@Resource
	private GlobalConfig codeGeneratorConfig;
	@Resource
	private ExtendsConfig extendsSettings;
	@Resource
	private MyBatisMapperService myBatisMapperService;

	/**
	 * 通用的替换
	 * 
	 * @author JohnDeng
	 * @datatime 2019年5月26日下午9:39:17
	 * @param tableName
	 * @param classDescription
	 * @return
	 */
	private Map<String, Object> replaceMap(String tableName, String classDescription) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("classDescription", classDescription);
		map.put("author", codeGeneratorConfig.getAuthor());
		map.put("datatime", DateTimeUtils.getDatatime());
		map.put("className", tableColumnsService.getClassName(tableName));
		map.put("primaryKey", tableColumnsService.getPrimaryKeyDataType(tableName));
		return map;
	}

	/**
	 * 获取包路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年5月26日下午10:53:38
	 * @param name
	 * @return
	 */
	private String getPackgePath(String name) {
		if (TemplateCommon.entity.equals(name)) {
			return codeGeneratorConfig.getPackgePath() + "." + TemplateCommon.entity;
		} else if (TemplateCommon.dao.equals(name)) {
			return codeGeneratorConfig.getPackgePath() + "." + TemplateCommon.dao;
		} else if (TemplateCommon.service.equals(name)) {
			return codeGeneratorConfig.getPackgePath() + "." + TemplateCommon.service;
		} else if (TemplateCommon.serviceImpl.equals(name)) {
			return codeGeneratorConfig.getPackgePath() + "." + TemplateCommon.service + "." + TemplateCommon.impl;
		} else if (TemplateCommon.controller.equals(name)) {
			return codeGeneratorConfig.getPackgePath() + "." + TemplateCommon.controller;
		}
		return "";
	}

	/**
	 * 获取模板路径和名称
	 * 
	 * @author JohnDeng
	 * @datatime 2019年5月26日下午11:12:02
	 * @param name
	 * @return
	 */
	private String getTemplateFileName(String name) {
		if (TemplateCommon.entity.equals(name)) {
			return codeGeneratorConfig.getTemplateBasePath() + TemplateCommon.defaultEntityTemplateFileName;
		} else if (TemplateCommon.dao.equals(name)) {
			return codeGeneratorConfig.getTemplateBasePath() + TemplateCommon.defaultDaoTemplateFileName;
		} else if (TemplateCommon.service.equals(name)) {
			return codeGeneratorConfig.getTemplateBasePath() + TemplateCommon.defaultServiceTemplateFileName;
		} else if (TemplateCommon.serviceImpl.equals(name)) {
			return codeGeneratorConfig.getTemplateBasePath() + TemplateCommon.defaultServiceImplTemplateFileName;
		} else if (TemplateCommon.controller.equals(name)) {
			return codeGeneratorConfig.getTemplateBasePath() + TemplateCommon.defaultControllerTemplateFileName;
		} else if (TemplateCommon.mapper.equals(name)) {
			return codeGeneratorConfig.getTemplateBasePath() + TemplateCommon.defaultMapperTemplateFileName;
		}
		return "";
	}

	/**
	 * 获取生成路径
	 * 
	 * @author JohnDeng
	 * @datatime 2019年5月26日下午11:12:19
	 * @param name
	 * @return
	 */
	private String getWriteFilePath(String name) {
		if (TemplateCommon.entity.equals(name)) {
			if (StringUtils.isNotEmpty(codeGeneratorConfig.getWriteFileBaseEntityPath())) {
				return codeGeneratorConfig.getWriteFileBaseEntityPath();
			}
			return codeGeneratorConfig.getWriteFileBasePath() + TemplateCommon.entity;
		} else if (TemplateCommon.dao.equals(name)) {
			if (StringUtils.isNotEmpty(codeGeneratorConfig.getWriteFileBaseDaoPath())) {
				return codeGeneratorConfig.getWriteFileBaseDaoPath();
			}
			return codeGeneratorConfig.getWriteFileBasePath() + TemplateCommon.dao;
		} else if (TemplateCommon.service.equals(name)) {
			if (StringUtils.isNotEmpty(codeGeneratorConfig.getWriteFileBaseServicePath())) {
				return codeGeneratorConfig.getWriteFileBaseServicePath();
			}
			return codeGeneratorConfig.getWriteFileBasePath() + TemplateCommon.service;
		} else if (TemplateCommon.serviceImpl.equals(name)) {
			if (StringUtils.isNotEmpty(codeGeneratorConfig.getWriteFileBaseServiceImplPath())) {
				return codeGeneratorConfig.getWriteFileBaseServiceImplPath();
			}
			return codeGeneratorConfig.getWriteFileBasePath() + TemplateCommon.service + "\\" + TemplateCommon.impl;
		} else if (TemplateCommon.controller.equals(name)) {
			if (StringUtils.isNotEmpty(codeGeneratorConfig.getWriteFileBaseControllerPath())) {
				return codeGeneratorConfig.getWriteFileBaseControllerPath();
			}
			return codeGeneratorConfig.getWriteFileBasePath() + TemplateCommon.controller;
		}else if (TemplateCommon.mapper.equals(name)) {
			return codeGeneratorConfig.getMapperPath();
		}
		return "";
	}

	/**
	 * 获取生成文件名+后缀
	 * 
	 * @author JohnDeng
	 * @dateTime 2019年5月30日下午5:35:15
	 * @param name
	 * @param tableName
	 * @return
	 */
	private String getWriteFileName(String name, String tableName) {
		if (TemplateCommon.entity.equals(name)) {
			return tableColumnsService.getClassName(tableName) + TemplateCommon.javaSuffix;
		} else if (TemplateCommon.dao.equals(name)) {
			return tableColumnsService.getClassName(tableName) + TemplateCommon.javaDaoSuffix;
		} else if (TemplateCommon.service.equals(name)) {
			return tableColumnsService.getClassName(tableName) + TemplateCommon.javaServiceSuffix;
		} else if (TemplateCommon.serviceImpl.equals(name)) {
			return tableColumnsService.getClassName(tableName) + TemplateCommon.javaServiceImplSuffix;
		} else if (TemplateCommon.controller.equals(name)) {
			return tableColumnsService.getClassName(tableName) + TemplateCommon.javaControllerImplSuffix;
		}else if (TemplateCommon.mapper.equals(name)) {
			return tableColumnsService.getClassName(tableName) + TemplateCommon.xmlMapperImplSuffix;
		}
		return "";
	}

	/**
	 * 生成文件
	 * 
	 * @author JohnDeng
	 * @datatime 2019年5月26日下午11:24:40
	 * @param name
	 * @param tableName
	 * @param fileName
	 */
	private void fileWrite(String name, String tableName, String fileName) {
		if (TemplateCommon.entity.equals(name)) {
			FileUtlis.wirteContent(getWriteFilePath(TemplateCommon.entity),
					getWriteFileName(TemplateCommon.entity, tableName), fileName);
		} else if (TemplateCommon.dao.equals(name)) {
			FileUtlis.wirteContent(getWriteFilePath(TemplateCommon.dao),
					getWriteFileName(TemplateCommon.dao, tableName), fileName);
		} else if (TemplateCommon.service.equals(name)) {
			FileUtlis.wirteContent(getWriteFilePath(TemplateCommon.service),
					getWriteFileName(TemplateCommon.service, tableName), fileName);
		} else if (TemplateCommon.serviceImpl.equals(name)) {
			FileUtlis.wirteContent(getWriteFilePath(TemplateCommon.serviceImpl),
					getWriteFileName(TemplateCommon.serviceImpl, tableName), fileName);
		} else if (TemplateCommon.controller.equals(name)) {
			FileUtlis.wirteContent(getWriteFilePath(TemplateCommon.controller),
					getWriteFileName(TemplateCommon.controller, tableName), fileName);
		}else if (TemplateCommon.mapper.equals(name)) {
			FileUtlis.wirteContent(getWriteFilePath(TemplateCommon.mapper),
					getWriteFileName(TemplateCommon.mapper, tableName), fileName);
		}

	}

	@Override
	public void createEntityTemplate(String tableName, String classDescription) {
		logger.info(">>>>>开始创建实体<<<<<");

		String fileName = FileUtlis.readFileText(getTemplateFileName(TemplateCommon.entity));

		Map<String, Object> map = replaceMap(tableName, classDescription);
		map.put("packgePath", getPackgePath(TemplateCommon.entity));
		map.put("alias", tableColumnsService.getAliasName(tableName));
		map.put("table", tableName);
		map.put("entityData", tableColumnsService.getEntityData(tableName));

		fileName = ReplaceUtlis.replace(fileName, map);

		logger.info("创建实体文本:\n" + fileName);
		fileWrite(TemplateCommon.entity, tableName, fileName);
		logger.info(">>>>>结束创建实体<<<<<");
	}

	@Override
	public void createVOTemplate(String tableName, String classDescription) {
		logger.info(">>>>>开始创建实体<<<<<");

		String fileName = FileUtlis.readFileText(getTemplateFileName(TemplateCommon.vo));

		Map<String, Object> map = replaceMap(tableName, classDescription);
		map.put("packgePath", getPackgePath(TemplateCommon.vo));
		map.put("alias", tableColumnsService.getAliasName(tableName));
		map.put("table", tableName);
		map.put("entityData", tableColumnsService.getEntityData(tableName));

		fileName = ReplaceUtlis.replace(fileName, map);

		logger.info("创建实体文本:\n" + fileName);
		fileWrite(TemplateCommon.vo, tableName, fileName);
		logger.info(">>>>>结束创建实体<<<<<");
	}

	@Override
	public void createDaoTemplate(String tableName, String classDescription) {
		logger.info(">>>>>开始创建DAO<<<<<");

		String fileName = FileUtlis.readFileText(getTemplateFileName(TemplateCommon.dao));

		Map<String, Object> map = replaceMap(tableName, classDescription);
		map.put("packgePath", getPackgePath(TemplateCommon.dao));

		fileName = ReplaceUtlis.replace(fileName, map);

		logger.info("创建DAO文本:\n" + fileName);
		fileWrite(TemplateCommon.dao, tableName, fileName);
		logger.info(">>>>>结束创建DAO<<<<<");

	}

	@Override
	public void createServiceTemplate(String tableName, String classDescription) {
		logger.info(">>>>>开始创建Service<<<<<");

		String fileName = FileUtlis.readFileText(getTemplateFileName(TemplateCommon.service));

		Map<String, Object> map = replaceMap(tableName, classDescription);
		map.put("packgePath", getPackgePath(TemplateCommon.service));

		fileName = ReplaceUtlis.replace(fileName, map);

		logger.info("创建Service文本:\n" + fileName);
		fileWrite(TemplateCommon.service, tableName, fileName);
		logger.info(">>>>>结束创建Service<<<<<");
	}

	@Override
	public void createServiceImplTemplate(String tableName, String classDescription) {
		logger.info(">>>>>开始创建ServiceImpl<<<<<");
		String fileName = FileUtlis.readFileText(getTemplateFileName(TemplateCommon.serviceImpl));

		Map<String, Object> map = replaceMap(tableName, classDescription);
		map.put("lowerClassName", FormatNameUtlis.formatNameLowerCase(tableColumnsService.getClassName(tableName)));
		map.put("packgePath", getPackgePath(TemplateCommon.serviceImpl));
		map.put("daoPackgePath", getPackgePath(TemplateCommon.dao));
		map.put("servicePackgePath", getPackgePath(TemplateCommon.service));

		fileName = ReplaceUtlis.replace(fileName, map);

		logger.info("创建ServiceImpl文本:\n" + fileName);
		fileWrite(TemplateCommon.serviceImpl, tableName, fileName);
		logger.info(">>>>>结束创建ServiceImpl<<<<<");

	}

	@Override
	public void createControllerTemplate(String tableName, String classDescription) {
		logger.info(">>>>>开始创建controller<<<<<");
		String fileName = FileUtlis.readFileText(getTemplateFileName(TemplateCommon.controller));

		Map<String, Object> map = replaceMap(tableName, classDescription);
		map.put("packgePath", getPackgePath(TemplateCommon.controller));
		map.put("servicePackgePath", getPackgePath(TemplateCommon.service));
		map.put("lowerClassName", FormatNameUtlis.formatNameLowerCase(tableColumnsService.getClassName(tableName)));

		fileName = ReplaceUtlis.replace(fileName, map);

		logger.info("创建控制器文本:\n" + fileName);
		fileWrite(TemplateCommon.controller, tableName, fileName);
		logger.info(">>>>>结束创建controller<<<<<");
	}

	@Override
	public void createMapperTeplate(String tableName, String classDescription) {
		logger.info(">>>>>开始创建Mapper<<<<<");
		String fileName = FileUtlis.readFileText(getTemplateFileName(TemplateCommon.mapper));
		
		Map<String, Object> map = replaceMap(tableName, classDescription);
		map.put("tableName", tableName);
		map.put("className", tableColumnsService.getClassName(tableName));
		map.put("alias", FormatNameUtlis.formatNameLowerCase(tableColumnsService.getClassName(tableName)));
		map.put("daoPackgePath",  getPackgePath(TemplateCommon.dao));
		map.put("Columms", myBatisMapperService.getMapperColumns(tableName));
		map.put("insertColumms", myBatisMapperService.getInsertColums(tableName));
		map.put("insertBatchValues", myBatisMapperService.getInsertBatchValue(tableName));
		map.put("insertValues", myBatisMapperService.getInsertValues(tableName));
		map.put("updateColumms", myBatisMapperService.getUpdateColumms(tableName));
		
		fileName = ReplaceUtlis.replace(fileName, map);

		logger.info("创建mybaits文本:\n:" + fileName);
		fileWrite(TemplateCommon.mapper, tableName, fileName);
		logger.info(">>>>>结束创建Mapper<<<<<");

	}

}
