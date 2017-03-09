package com.tim.springEL;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * Created by Admin on 2017/3/7.
 */
@Configuration
@ComponentScan("com.tim.springEL")
@PropertySource("classpath:com/tim/springEL/test.properties")
public class ELConfig {
    // 注入普通字符
    @Value("I Love YOU")
    private String normalName;

    //注入操作系统属性
    @Value("#{systemProperties['os.name']}")
    private String osname;

    // 注入表达式运算结果
    @Value("#{ T(java.lang.Math).random() * 100.0}")
    private double randomNumber;

    // 注入其他Bean的属性
    @Value("#{ demoService.another}")
    private String fromAnother;

    // 注入文件内容
    @Value("classpath:com/tim/springEL/test.txt")
    private Resource fileContent;

    // 注入网址内容
    @Value("http://www.baidu.com")
    private Resource testUrl;

    // 注入属性文件
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;

    //若要使用@Value注入，则要配置PropertySourcePlaceholderConfigurer的Bean
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try{
            System.out.println("nornal:"+normalName);
            System.out.println("osname:"+osname);
            System.out.println(randomNumber);
            System.out.println(fromAnother);

            System.out.println("test.txt:"+IOUtils.toString(fileContent.getInputStream()));
            System.out.println("baidu:"+IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            System.out.println("book.author:"+environment.getProperty("book.author"));
        } catch(Exception e){
            e.printStackTrace();
        }
    }


}
