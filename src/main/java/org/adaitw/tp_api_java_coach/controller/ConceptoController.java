package org.adaitw.tp_api_java_coach.controller;

import org.adaitw.tp_api_java_coach.model.dto.ConceptoDTO;
import org.adaitw.tp_api_java_coach.service.impl.ConceptoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "conceptos")
public class ConceptoController {

    @Autowired
    private ConceptoServiceImpl conceptoServiceImpl;

    private static final Logger logger = LoggerFactory.getLogger(ConceptoServiceImpl.class);

    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity getConceptos() {

        try {
            List<ConceptoDTO> conceptoDTOResponse = conceptoServiceImpl.getAllConceptos();
            logger.info("Se muestra lista de conceptos");
            return new ResponseEntity<>(conceptoDTOResponse, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error al mostrar lista de conceptos" + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage());
        }
    }

    @PostMapping(value = "/crear")
    public ResponseEntity crearConcepto(@RequestBody ConceptoDTO conceptoDTO) {

        try {
            ConceptoDTO newConcepto = conceptoServiceImpl.crearNuevoConcepto(conceptoDTO);
            logger.info("Concepto creado con exito");
            return ResponseEntity
                    .created(new URI("/conceptos/" + newConcepto.getIdConcepto()))
                    .body(newConcepto);
        } catch (Exception e) {
            logger.error("Error al crear concepto" + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity deleteConcepto(@PathVariable Long id) {

        try {
            conceptoServiceImpl.borrarConcepto(id);
            logger.info("Concepto borrado con exito");
            return ResponseEntity.ok("Se ha borrado el registro con éxito.");
        } catch (Exception e) {
            logger.error("Error al borrar concepto" + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage());
        }
    }

    @PatchMapping("/actualizar")
    public ResponseEntity updateConcepto(@RequestBody ConceptoDTO conceptoDTO) {

        ConceptoDTO conceptoActualizado = conceptoServiceImpl.actualizarConcepto(conceptoDTO);
        if (conceptoActualizado != null) {
            logger.info("Concepto actualizado con exito");
            return ResponseEntity.ok().body(conceptoActualizado);
        } else {
            logger.error("Error al actualizar concepto");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": no existe el id indicado}\"");
        }
    }

}
