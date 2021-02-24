package com.example.intercam.mail;

import com.example.intercam.dto.ChangeResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;


@Slf4j
@Component
@RequiredArgsConstructor
public class HtmlEmailService{

    private final JavaMailSender javaMailSender;

    public void sendEmail(ChangeResponseDto changeResponseDto, String uuid){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();



        try{
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
//            "gitvideouser@gmail.com"
            mimeMessageHelper.setFrom("gitvideouser@gmail.com");
            mimeMessageHelper.setTo(changeResponseDto.getUsername());

            mimeMessageHelper.setSubject("변경된 비밀번호입니다.");

            mimeMessageHelper.setText("바뀐 비밀번호 : "+uuid);

            javaMailSender.send(mimeMessage);

        }catch(Exception e){
            e.printStackTrace();
        }
    }




}

