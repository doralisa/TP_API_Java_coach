package org.adaitw.tp_api_java_coach.controller;

import org.adaitw.tp_api_java_coach.model.dto.ConceptoDTO;
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

    private static final Logger logger = LoggerFactory.getLogger(CuestionarioServiceImpl.class);

    @GetMapping(path = "/por/concepto/{id}", produces = "application/json")
    public ResponseEntity getCuestionarioPorConceptos(@PathVariable Long id) {

        try {
        List<CuestionarioDTO> cuestionarioDTOResponse = cuestionarioServiceImpl.getByIdConcepto(id);
            logger.info("Se muestra lista de cuestionario con exito");
            return new ResponseEntity<>(cuestionarioDTOResponse, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error al mostrar la lista de cuestionario" + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage());
        }
    }

    @GetMapping(path = "/id_respuesta/id_pregunta/{id}", produces = "application/json")
    public ResponseEntity getCorreccionCuestionario(@PathVariable Long id) {

        try {
            Boolean correccion = cuestionarioServiceImpl.getCorreccionRespuesta(id);
            String msg;
            if (correccion == true) {
                msg = "Respuesta correcta";
            } else {
                msg = "Respuesta incorrecta";
            }
            logger.info("Se muestra respuesta");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error al mostrar respuesta" + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage());
        }
    }

}
