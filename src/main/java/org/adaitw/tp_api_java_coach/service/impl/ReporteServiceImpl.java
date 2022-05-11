package org.adaitw.tp_api_java_coach.service.impl;

import org.adaitw.tp_api_java_coach.controller.ReporteController;
import org.adaitw.tp_api_java_coach.model.dto.*;
import org.adaitw.tp_api_java_coach.model.repository.*;
import org.adaitw.tp_api_java_coach.service.ReporteService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReporteServiceImpl implements ReporteService<ReporteDTO, Entity> {

    @Autowired
    CapituloRepository capituloRepository;

    @Autowired
    ConceptoRepository conceptoRepository;

    @Autowired
    EjemploRepository ejemploRepository;

    @Autowired
    NivelRepository nivelRepository;

    @Autowired
    PreguntaRepository preguntaRepository;

    @Autowired
    RespuestaRepository respuestaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    ReporteDTO reporteDTO = new ReporteDTO();

    private static final Logger logger = LoggerFactory.getLogger(ReporteServiceImpl.class);

    @Override
    public List<ReporteDTO> getData() {

        List<ReporteDTO> listaCantidadEntidades = new ArrayList<>();

        Long capitulos = capituloRepository.count();
        reporteDTO.setCantidadCapitulos(capitulos);

        Long conceptos = conceptoRepository.count();
        reporteDTO.setCantidadConceptos(conceptos);

        Long ejemplos = ejemploRepository.count();
        reporteDTO.setCantidadEjemplos(ejemplos);

        Long niveles = nivelRepository.count();
        reporteDTO.setCantidadNiveles(niveles);

        Long preguntas = preguntaRepository.count();
        reporteDTO.setCantidadPreguntas(preguntas);

        Long respuestas = respuestaRepository.count();
        reporteDTO.setCantidadRespuestas(respuestas);

        Long usuarios = usuarioRepository.count();
        reporteDTO.setCantidadUsuarios(usuarios);

        listaCantidadEntidades.add(reporteDTO);
        logger.info("Lista de cantidad de registros: " + listaCantidadEntidades);

        return listaCantidadEntidades;
    }

}
