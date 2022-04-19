package org.adaitw.tp_api_java_coach.service;

import org.adaitw.tp_api_java_coach.model.dto.*;

import java.util.List;

public interface ReporteService <T, E>
{
    /**
     * @param
     * @return list
     */
    List<ReporteDTO> getData ();

}
