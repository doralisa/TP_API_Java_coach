package org.adaitw.tp_api_java_coach.service.impl;

import org.adaitw.tp_api_java_coach.component.BusinessLogicExceptionComponent;
import org.adaitw.tp_api_java_coach.controller.ConceptoController;
import org.adaitw.tp_api_java_coach.model.dto.ConceptoDTO;
import org.adaitw.tp_api_java_coach.model.entity.ConceptoEntity;
import org.adaitw.tp_api_java_coach.model.repository.ConceptoRepository;
import org.adaitw.tp_api_java_coach.service.ConceptoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ConceptoServiceImpl implements ConceptoService<ConceptoDTO, ConceptoEntity> {

    @Autowired
    private ConceptoRepository conceptoRepository;

    @Autowired
    private BusinessLogicExceptionComponent logicExceptionComponent;

    private static final Logger logger = LoggerFactory.getLogger(ConceptoServiceImpl.class);

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ConceptoDTO> getAllConceptos() {

        List<ConceptoEntity> conceptoList = conceptoRepository.findAll();
        List<ConceptoDTO> conceptoDTO1 = new ArrayList<>();
        conceptoList.forEach(concepto -> conceptoDTO1.add(modelMapper.map(concepto, ConceptoDTO.class)));
        logger.info("Lista de conceptos encontrada: " + conceptoDTO1);
        return conceptoDTO1;
    }

    @Override
    public ConceptoDTO crearNuevoConcepto(ConceptoDTO conceptoDTO) {

        ConceptoDTO conceptoGuardado = new ConceptoDTO();
        ConceptoEntity concepto = modelMapper.map(conceptoDTO, ConceptoEntity.class);
        conceptoRepository.save(concepto);
        conceptoGuardado = modelMapper.map(concepto, (Type) ConceptoDTO.class);
        if (conceptoGuardado.hasNullOrEmptyAttributes())
            throw logicExceptionComponent.getExceptionEntityEmptyValues("ConceptoEntity");
        logger.info("Nuevo concepto: " + conceptoGuardado);
        return conceptoGuardado;
    }

    @Override
    public void borrarConcepto(Long id) {

        conceptoRepository.deleteById(id);
    }

    @Override
    public ConceptoDTO actualizarConcepto(ConceptoDTO conceptoDTO) {

        ConceptoEntity concepto = modelMapper.map(conceptoDTO, ConceptoEntity.class);
        ConceptoDTO conceptoActualizado = new ConceptoDTO();
        Long id = concepto.getIdConcepto();
        boolean conceptoExiste = conceptoRepository.existsById(id);
        if (conceptoExiste == true) {
            conceptoRepository.save(concepto);
            conceptoActualizado = modelMapper.map(concepto, (Type) ConceptoDTO.class);
            if (conceptoActualizado.hasNullOrEmptyAttributes())
                throw logicExceptionComponent.getExceptionEntityEmptyValues("ConceptoEntity");
            logger.info("Concepto actualizado: " + conceptoActualizado);
            return conceptoActualizado;
        }
        return null;
    }

}
