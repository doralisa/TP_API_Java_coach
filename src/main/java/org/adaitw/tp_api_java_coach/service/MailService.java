package org.adaitw.tp_api_java_coach.service;

import org.adaitw.tp_api_java_coach.model.dto.MailDTO;

import javax.mail.MessagingException;

public interface MailService <T,E> {

    /**
     *
     * @param a
     * @return
     */
    T mailConsejo(String a) throws MessagingException;

    /**
     *
     * @param dto
     * @return
     */
    T enviarMailConsejo(T dto) throws MessagingException;
}
