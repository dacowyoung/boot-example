package com.young.service;

/**
 * @author: young
 * @create: 2020/5/15 14:10
 * @desc: 邮件服务接口
 */
public interface MailService {

    /**
     * 发送简单邮件
     *
     * @param to      到达邮箱
     * @param subject 标题
     * @param content 内容
     */
    public void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送html邮件
     *
     * @param to      到达邮箱
     * @param subject 标题
     * @param content 内容
     */
    public void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送附件邮件
     *
     * @param to       到达邮箱
     * @param subject  标题
     * @param content  内容
     * @param filePath 附件地址
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filePath);

    /**
     * 发送静态资源邮件
     *
     * @param to      到达邮箱
     * @param subject 标题
     * @param content 内容
     * @param rscPath 资源地址
     * @param rscId   资源id
     */
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);

}
