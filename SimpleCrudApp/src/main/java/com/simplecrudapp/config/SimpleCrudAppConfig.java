package com.simplecrudapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration 
@EnableWebMvc   
@ComponentScan(basePackages = "com.simplecrudapp") 
public class SimpleCrudAppConfig {  
} 