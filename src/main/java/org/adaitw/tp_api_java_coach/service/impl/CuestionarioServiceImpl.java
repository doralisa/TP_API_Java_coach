package org.adaitw.tp_api_java_coach.service.impl;

import org.adaitw.tp_api_java_coach.component.BusinessLogicExceptionComponent;
import org.adaitw.tp_api_java_coach.model.dto.CuestionarioDTO;
import org.adaitw.tp_api_java_coach.model.dto.RespuestaDTO;
import org.adaitw.tp_api_java_coach.model.entity.PreguntaEntity;
import org.adaitw.tp_api_java_coach.model.entity.RespuestaEntity;
import org.adaitw.tp_api_java_coach.model.repository.PreguntaRepository;
import org.adaitw.tp_api_java_coach.model.repository.RespuestaRepository;
import org.adaitw.tp_api_java_coach.service.CuestionarioService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;
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
        logger.info("Cuestionario por concepto: " + preguntasYRespuestas);
        return preguntasYRespuestas;
    }

    @Override
    public boolean getCorreccionRespuesta(Long idRespuesta, Long idPregunta) {

        Optional<RespuestaEntity> respuestaEntity = respuestaRepository.findById(idRespuesta);
        RespuestaEntity respuestaEntity1 = respuestaEntity
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("RespuestaEntity", idPregunta));
        PreguntaEntity idPreguntaRespuesta = respuestaEntity1.getIdPregunta();
        Long idPreguntaEntity = idPreguntaRespuesta.getIdPregunta();
        if (idPregunta == idPreguntaEntity) {
            logger.info(String.format("El idRespuesta corresponde al idPregunta indicado"));
            Long resultado = respuestaEntity1.getEsCorrecta();
            if (resultado == 1) {
                logger.info(String.format("Se realiza corrección a idRespuesta: %d", resultado));
                return true;
            }
            logger.info(String.format("Se realiza corrección a idRespuesta: %d" + resultado));
            return false;
        }
        logger.info(String.format("El idRespuesta NO corresponde al idPregunta indicado"));
        return false;
        }

}
