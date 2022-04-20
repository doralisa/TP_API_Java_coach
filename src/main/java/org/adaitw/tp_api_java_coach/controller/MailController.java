package org.adaitw.tp_api_java_coach.controller;

import org.adaitw.tp_api_java_coach.advice_validation.RestResponse;
import org.adaitw.tp_api_java_coach.advice_validation.Time;
import org.adaitw.tp_api_java_coach.model.dto.MailDTO;
import org.adaitw.tp_api_java_coach.service.impl.MailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping(value = "enviar")
public class MailController {

    @Autowired
    MailServiceImpl mailService;

    RestResponse resultado;

    private static final Logger logger = LoggerFactory.getLogger(MailController.class);

    @PostMapping(value = "/consejo/{nombreUsuario}")
    public ResponseEntity mailConsejo(@PathVariable String nombreUsuario) throws MessagingException {

        MailDTO mailDTOResponse = mailService.mailConsejo(nombreUsuario);
        logger.info("correo enviado con exito: " + mailDTOResponse);
        resultado = new RestResponse(Time.getTime(), mailDTOResponse.toString(), 200, "Success");
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<RestResponse> messagingException(MessagingException e) {
        resultado = new RestResponse(Time.getTime(),
                "MailController] - MessagingException: Not Found " + e.getMessage(), 404, "Error");
        return new ResponseEntity<>(resultado, HttpStatus.IM_USED);
    }

}
