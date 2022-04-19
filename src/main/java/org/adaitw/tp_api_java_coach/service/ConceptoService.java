package org.adaitw.tp_api_java_coach.service;

import java.util.List;

public interface ConceptoService<T, E> {

    /**
     * @return
     */
    List<T> getAllConceptos();

    /**
     * @param dto
     * @return
     */
    T crearNuevoConcepto(T dto);

    /**
     * @param id
     */
    void borrarConcepto(Long id);

    /**
     * @param dto
     * @return
     */
    T actualizarConcepto(T dto);

}
