package org.adaitw.tp_api_java_coach.controller;

import org.adaitw.tp_api_java_coach.advice_validation.RestResponse;
import org.adaitw.tp_api_java_coach.advice_validation.Time;
import org.adaitw.tp_api_java_coach.model.dto.ConceptoDTO;
import org.adaitw.tp_api_java_coach.service.impl.ConceptoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "conceptos")
public class ConceptoController {

    @Autowired
    private ConceptoServiceImpl conceptoServiceImpl;

    RestResponse resultado;

    private static final Logger logger = LoggerFactory.getLogger(ConceptoController.class);

    @GetMapping(path = "")
    public ResponseEntity getConceptos() {

        List<ConceptoDTO> conceptoDTOResponse = conceptoServiceImpl.getAllConceptos();
        logger.info("Se muestra lista de conceptos: " + conceptoDTOResponse);
        return new ResponseEntity<>(conceptoDTOResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/crear")
    public ResponseEntity crearConcepto(@RequestBody ConceptoDTO conceptoDTO) {

        ConceptoDTO nuevoConcepto = conceptoServiceImpl.crearNuevoConcepto(conceptoDTO);
        logger.info("Concepto creado con exito: " + nuevoConcepto);
        resultado = new RestResponse(Time.getTime(), nuevoConcepto.toString(), 200, "Success");
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity deleteConcepto(@PathVariable Long id) {

        conceptoServiceImpl.borrarConcepto(id);
        logger.info("Concepto borrado con exito");
        resultado = new RestResponse(Time.getTime(), "Se ha borrado el registro con éxito.", 200, "Success");
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @PatchMapping(path="/actualizar")
    public ResponseEntity updateConcepto(@RequestBody ConceptoDTO conceptoDTO) {

        ConceptoDTO conceptoActualizado = conceptoServiceImpl.actualizarConcepto(conceptoDTO);
        logger.info("Concepto actualizado con exito");
        resultado = new RestResponse(Time.getTime(), conceptoActualizado.toString(), 200, "Success");
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<RestResponse> indexOutOfBoundsException(IndexOutOfBoundsException e) {
        resultado = new RestResponse(Time.getTime(),
                "ConceptoController] - IndexOutOfBoundsException: Not Found " + e.getMessage(), 404, "Error");
        return new ResponseEntity<>(resultado, HttpStatus.IM_USED);
    }


}
