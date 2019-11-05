package org.john.springbootcodegenerator.service;

public interface TemplateGeneratorService {

	/**
	 * 创建实体模板
	 * @author JohnDeng
	 * @datatime 2019年5月26日下午2:28:37
	 * @param tableName
	 * @param classDescription
	 */
	public void createEntityTemplate(String tableName, String classDescription);

	/**
	 * 创建实体模板
	 * @author JohnDeng
	 * @datatime 2019年5月26日下午2:28:37
	 * @param tableName
	 * @param classDescription
	 */
	public void createVOTemplate(String tableName, String classDescription);

	/**
	 * 创建DAO模板
	 * @author JohnDeng
	 * @datatime 2019年5月26日下午2:28:49
	 * @param tableName
	 * @param classDescription
	 */
	public void createDaoTemplate(String tableName, String classDescription);
	
	/**
	 * 创建service模板
	 * @author JohnDeng
	 * @datatime 2019年5月26日下午2:29:01
	 * @param tableName
	 * @param classDescription
	 */
	public void createServiceTemplate(String tableName, String classDescription);
	
	/**
	 * 创建service实现类模板
	 * @author JohnDeng
	 * @datatime 2019年5月26日下午2:29:19
	 * @param tableName
	 * @param classDescription
	 */
	public void createServiceImplTemplate(String tableName, String classDescription) ;
	
	/**
	 * 创建控制器模板
	 * @author JohnDeng
	 * @datatime 2019年5月26日下午2:36:42
	 * @param tableName
	 * @param classDescription
	 */
	public void createControllerTemplate(String tableName, String classDescription);
	
	/**
	 * 创建mybaits-mapper模板
	 * @author johnDeng
	 * @dataTime 2019年3月13日下午6:31:11
	 * @param tableName
	 * @param classDescription
	 */
	public void createMapperTeplate(String tableName, String classDescription);
	
}
