package com.wj.springboot;

import com.wj.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01HelloworldQuickApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void testHelloService(){
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }


    @Test
    public void contextLoads() {

        System.out.println(person);

        logger.trace("This is trace log...");

        logger.debug("This is debug log...");

        logger.info("This is info log...");

        logger.warn("This is warn log...");

        logger.error("This is error log...");




    }



}
