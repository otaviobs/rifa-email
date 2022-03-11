package br.com.rifa.email.controllers;

import br.com.rifa.email.dtos.EmailDto;
import br.com.rifa.email.models.EmailModel;
import br.com.rifa.email.services.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(value = "API REST envio de e-mails")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sending-email")
    @ApiOperation(value="Retorna o JSON enviado com o status SENT ou ERROR")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }
}
