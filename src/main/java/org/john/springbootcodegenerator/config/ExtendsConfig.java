package org.john.springbootcodegenerator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 继承配置
 * <p>
 * 配置信息详情，看application。yml
 * </p>
 * 
 * @author JohnDeng
 * @datatime 2019年5月26日下午7:25:40
 */
@Component
@ConfigurationProperties(prefix = "codegenerator.extends")
public class ExtendsConfig {
	
	/**
	 * 是否需要继承Entity父类
	 */
	private boolean extendsBaseEntity;
	/**
	 * 是否需要继承Dao父类
	 */
	private boolean extendsBaseDao;
	/**
	 * 是否需要继承Service父类
	 */
	private boolean extendsBaseService;
	/**
	 * 是否需要继承ServiceImpl父类
	 */
	private boolean extendsBaseServiceImpl;
	/**
	 * 是否需要继承Controller父类
	 */
	private boolean extendsBaseController;

	/**
	 * 继承Entity父类路径
	 */
	private String baseEntityPath;
	/**
	 * 继承Entity父类路径
	 */
	private String basePath;

	/**
	 * 继承Dao父类路径
	 */
	private String baseDaoPath;
	/**
	 * 继承Service父类路径
	 */
	private String baseServicePath;
	/**
	 * 继承ServiceImpl父类路径
	 */
	private String baseServiceImplPath;
	/**
	 * 继承Controller父类路径
	 */
	private String baseControllerPath;

	public boolean isExtendsBaseEntity() {
		return extendsBaseEntity;
	}

	public void setExtendsBaseEntity(boolean extendsBaseEntity) {
		this.extendsBaseEntity = extendsBaseEntity;
	}

	public boolean isExtendsBaseDao() {
		return extendsBaseDao;
	}

	public void setExtendsBaseDao(boolean extendsBaseDao) {
		this.extendsBaseDao = extendsBaseDao;
	}

	public boolean isExtendsBaseService() {
		return extendsBaseService;
	}

	public void setExtendsBaseService(boolean extendsBaseService) {
		this.extendsBaseService = extendsBaseService;
	}

	public boolean isExtendsBaseServiceImpl() {
		return extendsBaseServiceImpl;
	}

	public void setExtendsBaseServiceImpl(boolean extendsBaseServiceImpl) {
		this.extendsBaseServiceImpl = extendsBaseServiceImpl;
	}

	public boolean isExtendsBaseController() {
		return extendsBaseController;
	}

	public void setExtendsBaseController(boolean extendsBaseController) {
		this.extendsBaseController = extendsBaseController;
	}

	public String getBaseEntityPath() {
		return baseEntityPath;
	}

	public void setBaseEntityPath(String baseEntityPath) {
		this.baseEntityPath = baseEntityPath;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getBaseDaoPath() {
		return baseDaoPath;
	}

	public void setBaseDaoPath(String baseDaoPath) {
		this.baseDaoPath = baseDaoPath;
	}

	public String getBaseServicePath() {
		return baseServicePath;
	}

	public void setBaseServicePath(String baseServicePath) {
		this.baseServicePath = baseServicePath;
	}

	public String getBaseServiceImplPath() {
		return baseServiceImplPath;
	}

	public void setBaseServiceImplPath(String baseServiceImplPath) {
		this.baseServiceImplPath = baseServiceImplPath;
	}

	public String getBaseControllerPath() {
		return baseControllerPath;
	}

	public void setBaseControllerPath(String baseControllerPath) {
		this.baseControllerPath = baseControllerPath;
	}

	

}
