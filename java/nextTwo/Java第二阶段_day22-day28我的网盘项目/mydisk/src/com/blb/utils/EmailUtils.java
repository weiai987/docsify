package com.blb.utils;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * 邮件工具类
 * @author huahao
 *
 */
public class EmailUtils {

	public static void send(final String title, final String context, final String receiveMail) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Session session = Session.getInstance(PropertiesUtils.getProperties());
					// 设置为debug模式, 可以查看详细的发送 log
					session.setDebug(false);
					MimeMessage message = createMimeMessage(session, title, context, receiveMail);
					Transport transport = session.getTransport();
					transport.connect(PropertiesUtils.getValue("mail.username"), PropertiesUtils.getValue("mail.password"));
					transport.sendMessage(message, message.getAllRecipients());
					transport.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	private static MimeMessage createMimeMessage(Session session, String title, String context, String receiveMail) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);
        // 2. From: 发件人
        message.setFrom(new InternetAddress(PropertiesUtils.getValue("mail.username"), PropertiesUtils.getValue("mail.sendMail"), "UTF-8"));
        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail));
        // 4. Subject: 邮件主题
        message.setSubject(title, "UTF-8");
        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent(context, "text/html;charset=UTF-8");
        // 6. 设置发件时间
        message.setSentDate(new Date());
        // 7. 保存设置
        message.saveChanges();
        return message;
	}
	
	public static void main(String[] args) throws Exception {
		EmailUtils.send("系统消息", "你好啊", "3094759846@qq.com");
	}
}
