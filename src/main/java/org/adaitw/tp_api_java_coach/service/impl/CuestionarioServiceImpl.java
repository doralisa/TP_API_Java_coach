package org.adaitw.tp_api_java_coach.service.impl;

import org.adaitw.tp_api_java_coach.component.BusinessLogicExceptionComponent;
import org.adaitw.tp_api_java_coach.controller.CuestionarioController;
import org.adaitw.tp_api_java_coach.model.dto.CuestionarioDTO;
import org.adaitw.tp_api_java_coach.model.entity.PreguntaEntity;
import org.adaitw.tp_api_java_coach.model.entity.RespuestaEntity;
import org.adaitw.tp_api_java_coach.model.repository.PreguntaRepository;
import org.adaitw.tp_api_java_coach.model.repository.RespuestaRepository;
import org.adaitw.tp_api_java_coach.service.CuestionarioService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class CuestionarioServiceImpl implements CuestionarioService<CuestionarioDTO, PreguntaEntity> {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private BusinessLogicExceptionComponent logicExceptionComponent;

    private static final Logger logger = LoggerFactory.getLogger(CuestionarioServiceImpl.class);

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CuestionarioDTO> getByIdConcepto(Long id) {

        List<PreguntaEntity> preguntasByIdconcepto = preguntaRepository.findByIdconcepto(id);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        List<CuestionarioDTO> preguntasYRespuestas = new ArrayList<>();
        preguntasByIdconcepto.forEach(cuestionario -> preguntasYRespuestas.add(modelMapper.map(cuestionario, CuestionarioDTO.class)));
        logger.warn("Cuestionario por concepto: " + preguntasYRespuestas);
        return preguntasYRespuestas;
    }

    @Override
    public boolean getCorreccionRespuesta(Long id) {

        Optional<RespuestaEntity> respuestaEntity = respuestaRepository.findById(id);
        RespuestaEntity respuesta = respuestaEntity
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("RespuestaEntity", id));
        Long resultado = respuesta.getEsCorrecta();
        if (resultado == 1) {
            logger.warn(String.format("Corrección respuesta: %d", resultado));
            return true;
        }
        logger.warn(String.format("Corrección respuesta: " + resultado));
        return false;
    }

}
