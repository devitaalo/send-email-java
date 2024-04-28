package br.com.enviando_email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest{ 

	private String userName = "typescriptemail@gmail.com";
	private String password = "twdrylhbzxttghre";
	
	@org.junit.Test
	public void testeEmail () {
		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.ssl.trust", "*");
			properties.put("mail.smtp.auth", "true"); /* Autorizacao */
			properties.put("mail.smtp.starttls", "true"); // Autenticacao
			properties.put("mail.smtp.host", "smtp.gmail.com"); //Servidor gmail Google 
			properties.put("mail.smtp.port", "465"); // Porta do servidor
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication(userName, password);
				}
			});
			
			Address[] toUser = InternetAddress.parse("italoredmi@gmail.com, contadoitalo911@gmail.com"); 
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName, "Ítalo Dev - Testes")); /* quem está enviando */
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Chegou o e-mail enviado com java");
			message.setText("Olá programador, vc acaba de receber um e-mail enviado com java!");
			
			Transport.send(message);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
