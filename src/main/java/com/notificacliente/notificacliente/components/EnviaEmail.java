package com.notificacliente.notificacliente.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EnviaEmail {

    @Autowired
    private JavaMailSender javaMail;
    public void enviaEmail(String email){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Registro Sistema Teste");
        mailMessage.setText("Registrado com sucesso");
        javaMail.send(mailMessage);
    }
}
