package org.adaitw.tp_api_java_coach.service.impl;

import org.adaitw.tp_api_java_coach.component.BusinessLogicExceptionComponent;
import org.adaitw.tp_api_java_coach.model.dto.CuestionarioDTO;
import org.adaitw.tp_api_java_coach.model.entity.PreguntaEntity;
import org.adaitw.tp_api_java_coach.model.entity.RespuestaEntity;
import org.adaitw.tp_api_java_coach.model.repository.PreguntaRepository;
import org.adaitw.tp_api_java_coach.model.repository.RespuestaRepository;
import org.adaitw.tp_api_java_coach.service.CuestionarioService;
import org.modelmapper.ModelMapper;
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

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CuestionarioDTO> getByIdConcepto(Long id) {

        List<PreguntaEntity> preguntasByIdconcepto = preguntaRepository.findByIdconcepto(id);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        List<CuestionarioDTO> preguntasYRespuestas = new ArrayList<>();
        preguntasByIdconcepto.forEach(cuestionario -> preguntasYRespuestas.add(modelMapper.map(cuestionario, CuestionarioDTO.class)));
        return preguntasYRespuestas;
    }

    @Override
    public boolean getCorreccionRespuesta(Long id) {

        Optional<RespuestaEntity> respuestaEntity = respuestaRepository.findById(id);
        RespuestaEntity respuesta = respuestaEntity
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("RespuestaEntity", id));
        Long resultado = respuesta.getEsCorrecta();
        if (resultado == 1) {
            return true;
        } else {
            return false;
        }
    }

}
