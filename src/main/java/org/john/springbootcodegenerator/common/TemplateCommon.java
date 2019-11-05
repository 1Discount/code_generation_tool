package org.john.springbootcodegenerator.common;

/**
 * 模板名称常量
 * 
 * @author JohnDeng
 * @datatime 2019年5月25日上午10:06:08
 */
public class TemplateCommon {

	/******************************需要继承模板************************************************/
	public static String entityTemplateFileName = "needExtend\\entityTemplate.txt";

	public static String voTemplateFileName = "needExtend\\voTemplate.txt";

	public static String serviceTemplateFileName = "needExtend\\serviceTemplate.txt";

	public static String daoTemplateFileName = "needExtend\\daoTemplate.txt";

	public static String serviceImplTemplateFileName = "needExtend\\serviceImplTemplate.txt";

	public static String controllerTemplateFileName = "needExtend\\controllerTemplate.txt";
	
	public static String mapperTemplateFileName = "needExtend\\mapperTemplate.xml";

	/******************************默认模板************************************************/
	public static String defaultEntityTemplateFileName = "default\\entityTemplate.txt";

	public static String defaultServiceTemplateFileName = "default\\serviceTemplate.txt";

	public static String defaultDaoTemplateFileName = "default\\daoTemplate.txt";

	public static String defaultServiceImplTemplateFileName = "default\\serviceImplTemplate.txt";

	public static String defaultControllerTemplateFileName = "default\\controllerTemplate.txt";
	
	public static String defaultMapperTemplateFileName = "default\\mapperTemplate.xml";
	
	/******************************文件后缀************************************************/
	
	public static String javaSuffix = ".java";

	public static String javaVOSuffix = "VO.java";

	public static String javaDaoSuffix = "DAO.java";

	public static String javaServiceSuffix = "Service.java";

	public static String javaServiceImplSuffix = "ServiceImpl.java";

	public static String javaControllerImplSuffix = "Controller.java";
	
	public static String xmlMapperImplSuffix = "Mapper.xml";

	/******************************模块************************************************/
	
	public static String entity = "";

	public static String vo = "vo";

	public static String dao = "dao";

	public static String service = "service";

	public static String serviceImpl = "serviceImpl";
	
	public static String impl ="impl";

	public static String controller = "controller";
	
	public static String mapper = "mapper";
	
	

}
