package com.gion.cms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gion.cms.entity.TUser;
import com.gion.cms.entity.TUserTransaction;
import com.gion.cms.service.UserService;
import com.gion.cms.service.UserTransactionService;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.gion.cms.mapper")
public class GionDiningCmsApplicationTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserTransactionService tranService;

	@Test
	public void testQuery(){
		TUser user = userService.getUserById(1);
		System.out.println(user.getName());
	}
	
	@Test
	public void testTransactionInsert(){
		TUserTransaction record = new TUserTransaction();
//		record.setPayment(100L);
//		record.setUserId(1);
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		tranService.insert(record);
	}

	@Test
	public void mybatisGeneratorTest() throws FileNotFoundException{
		List<String> warnings = new ArrayList<String>();  
        boolean overwrite = true;
        String genCfg = "generatorConfig.xml";  
        File configFile = new File(getClass().getClassLoader().getResource(genCfg).getFile());
        ConfigurationParser cp = new ConfigurationParser(warnings);  
        Configuration config = null;  
        try {  
            config = cp.parseConfiguration(configFile);  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (XMLParserException e) {  
            e.printStackTrace();  
        }  
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);  
        MyBatisGenerator myBatisGenerator = null;  
        try {  
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);  
        } catch (InvalidConfigurationException e) {  
            e.printStackTrace();  
        }  
        try {  
            myBatisGenerator.generate(null);  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }
}

