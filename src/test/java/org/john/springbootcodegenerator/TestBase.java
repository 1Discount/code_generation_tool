package org.john.springbootcodegenerator;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试用例
 * @author JohnDeng
 * @dateTime 2019年6月17日下午4:27:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringbootCodeGeneratorApplication.class)
public abstract class TestBase {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public abstract void test();
	
}
