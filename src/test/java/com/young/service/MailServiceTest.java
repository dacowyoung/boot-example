package com.young.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    // thymeleaf 模板驱动
    @Resource
    private TemplateEngine templateEngine;

    @Resource
    private MailService mailService;

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail("dailiuyang@raxtone.com", "test simple mail", " hello this is simple mail");
    }

    @Test
    public void sendHtmlMail() throws Exception {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello boot2 ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("dailiuyang@raxtone.com", "test html mail", content);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath = "C:\\Users\\Public\\Pictures\\Sample Pictures\\26个英文字母诠释的爱情简约宽屏壁纸\\001.jpg";
        mailService.sendAttachmentsMail("dailiuyang@raxtone.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\Public\\Pictures\\Sample Pictures\\26个英文字母诠释的爱情简约宽屏壁纸\\001.jpg";

        mailService.sendInlineResourceMail("dailiuyang@raxtone.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }

    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("dailiuyang@raxtone.com", "主题：这是模板邮件", emailContent);
    }

}