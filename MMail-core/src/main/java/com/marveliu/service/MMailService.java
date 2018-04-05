package com.marveliu.service;

public interface MMailService {

    /**
     * 展示当前配置文件
     */
    public void showMailConf();

    // 发送文本文件
    public Boolean sendSimpleMail(String to, String subject, String content);

    // 发送html邮件
    public Boolean sendHtmlMail(String to, String subject, String content);

    // 发送带附件的邮件
    public Boolean sendAttachmentsMail(String to, String subject, String content, String filePath);

    // 发送嵌入静态资源的邮件
    public Boolean sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
