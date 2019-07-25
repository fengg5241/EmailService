package com.gion.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = "com.gion.cms.mapper")
public class GionDiningCmsApplication extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GionDiningCmsApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(GionDiningCmsApplication.class, args);
	}

}
//public class GionDiningCmsApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(GionDiningCmsApplication.class, args);
//	}
//
//}

