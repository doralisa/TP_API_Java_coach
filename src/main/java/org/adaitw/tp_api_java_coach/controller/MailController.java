package org.adaitw.tp_api_java_coach.controller;

import org.adaitw.tp_api_java_coach.model.dto.MailDTO;
import org.adaitw.tp_api_java_coach.service.impl.MailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "enviar")
public class MailController {

    @Autowired
    MailServiceImpl mailService;

    private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @PostMapping(value = "/consejo/{nombreUsuario}")
    public ResponseEntity mailConsejo(@PathVariable String nombreUsuario) {

        try {
        MailDTO mailDTOResponse = mailService.mailConsejo(nombreUsuario);
            logger.info("correo enviado con exito");
            return ResponseEntity.status(HttpStatus.OK).body(mailDTOResponse);
        } catch (Exception e) {
            logger.error("Error al enviar correo" + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage());
        }
    }
}
