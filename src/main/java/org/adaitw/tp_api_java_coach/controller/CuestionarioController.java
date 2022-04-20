package org.adaitw.tp_api_java_coach.controller;

import org.adaitw.tp_api_java_coach.advice_validation.RestResponse;
import org.adaitw.tp_api_java_coach.advice_validation.Time;
import org.adaitw.tp_api_java_coach.model.dto.CuestionarioDTO;
import org.adaitw.tp_api_java_coach.service.impl.CuestionarioServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "cuestionario")
public class CuestionarioController {

    @Autowired
    private CuestionarioServiceImpl cuestionarioServiceImpl;

    RestResponse resultado;

    private static final Logger logger = LoggerFactory.getLogger(CuestionarioController.class);

    @GetMapping(path = "/por/concepto/{id}")
    public ResponseEntity getCuestionarioPorConceptos(@PathVariable Long id) {

        List<CuestionarioDTO> cuestionarioDTOResponse = cuestionarioServiceImpl.getByIdConcepto(id);
        logger.info("Se muestra lista de cuestionario con exito: " + cuestionarioDTOResponse);
        return new ResponseEntity<>(cuestionarioDTOResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/id_respuesta/id_pregunta/{id}")
    public ResponseEntity getCorreccionCuestionario(@PathVariable Long id) {

        Boolean correccion = cuestionarioServiceImpl.getCorreccionRespuesta(id);
        String msg = correccion ? "Respuesta correcta" : "Respuesta incorrecta";
        logger.info("Se muestra resultado para respuesta seleccionada: " + msg);
        resultado = new RestResponse(Time.getTime(), msg, 200, "Success");
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

}
