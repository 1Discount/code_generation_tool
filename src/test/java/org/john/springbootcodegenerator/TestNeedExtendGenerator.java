package org.john.springbootcodegenerator;

import org.john.springbootcodegenerator.service.impl.TemplateNeedExtendGeneratorServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestNeedExtendGenerator extends TestBase  {

	@Autowired
	public TemplateNeedExtendGeneratorServiceImpl templateNeedExtendGeneratorServiceImpl;
	
	/**
	 * 使用需要继承类生成代码
	 * @author JohnDeng
	 * @dateTime 2019年6月19日上午11:26:06
	 */
	@Test
	@Override
	public void test() {
		String tableName="base_zb",classDescription="基础表";
		templateNeedExtendGeneratorServiceImpl.createEntityTemplate(tableName, classDescription);
		templateNeedExtendGeneratorServiceImpl.createVOTemplate(tableName, classDescription);
		templateNeedExtendGeneratorServiceImpl.createDaoTemplate(tableName, classDescription);
		templateNeedExtendGeneratorServiceImpl.createServiceTemplate(tableName, classDescription);
		templateNeedExtendGeneratorServiceImpl.createServiceImplTemplate(tableName, classDescription);
		templateNeedExtendGeneratorServiceImpl.createControllerTemplate(tableName, classDescription);
		templateNeedExtendGeneratorServiceImpl.createMapperTeplate(tableName, classDescription);
	}
}
