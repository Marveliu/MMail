package com.marveliu.service;

import com.marveliu.WebApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class MMailPropertiesTest {

    private static final Log log = LogFactory.getLog(MMailPropertiesTest.class);


    @Autowired
    private MMailProperties mMailProperties;

    @Test
    public void test1() throws Exception {
        Assert.assertEquals("Marveliu", mMailProperties.getName());
        Assert.assertEquals("基于springboot的邮件发送demo", mMailProperties.getTitle());
        Assert.assertEquals("Marveliu正在努力写《基于springboot的邮件发送demo》", mMailProperties.getDesc());

        log.info("随机数测试输出：");
        log.info("随机字符串 : " + mMailProperties.getValue());
        log.info("随机int : " + mMailProperties.getNumber());
        log.info("随机long : " + mMailProperties.getBignumber());
        log.info("随机10以下 : " + mMailProperties.getTest1());
        log.info("随机10-20 : " + mMailProperties.getTest2());

    }
}