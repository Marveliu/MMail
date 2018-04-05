package com.marveliu.service.impl;

import com.marveliu.service.MMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MMailServiceImplTest {

    @Autowired
    private MMailService mMailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void showMailConf() {
        mMailService.showMailConf();
    }

    @Test
    public void sendSimpleMail() {
       assertEquals(
               true,
               mMailService.sendSimpleMail("897920245@qq.com","雇佣帮哈哈","喜欢你"));
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>Marveliu ! 下午来开会，谢谢!</h3>\n" +
                "</body>\n" +
                "</html>";
        mMailService.sendHtmlMail("897920245@qq.com","办公室会议！",content);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath="/Users/mac/Downloads/IMG_1596.JPG";
        mMailService.sendAttachmentsMail("897920245@qq.com", "办公室会议记录附件", "有附件，请查收！", filePath);
    }


    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\summer\\Pictures\\favicon.png";

        mMailService.sendInlineResourceMail("897920245@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }


    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);
        mMailService.sendHtmlMail("897920245@qq.com","主题：这是模板邮件",emailContent);
    }
}