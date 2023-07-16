package com.common.email;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "email") 
@PropertySource("classpath:email.properties")
public class EmailConfig {
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String name;
	
	private String password;

	public String getTeamLiftName() {
		return teamLiftName;
	}

	public void setTeamLiftName(String teamLiftName) {
		this.teamLiftName = teamLiftName;
	}

	public String getTeamLiftPassword() {
		return teamLiftPassword;
	}

	public void setTeamLiftPassword(String teamLiftPassword) {
		this.teamLiftPassword = teamLiftPassword;
	}

	private String teamLiftName;

	private String teamLiftPassword;
}
