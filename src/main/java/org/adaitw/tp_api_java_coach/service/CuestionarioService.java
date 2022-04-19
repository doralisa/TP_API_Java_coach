package org.adaitw.tp_api_java_coach.service;

import java.util.List;

public interface CuestionarioService <T,E> {
    /**
     *
     * @param id
     * @return
     */
    List<T> getByIdConcepto(Long id);

    /**
     *
     * @param id
     * @return
     */
    boolean getCorreccionRespuesta(Long id);
}
