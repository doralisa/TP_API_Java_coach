package org.adaitw.tp_api_java_coach.service.impl;

import org.adaitw.tp_api_java_coach.component.BusinessLogicExceptionComponent;
import org.adaitw.tp_api_java_coach.model.dto.ConceptoDTO;
import org.adaitw.tp_api_java_coach.model.dto.MailDTO;
import org.adaitw.tp_api_java_coach.model.entity.ConceptoEntity;
import org.adaitw.tp_api_java_coach.model.entity.UsuarioEntity;
import org.adaitw.tp_api_java_coach.model.repository.ConceptoRepository;
import org.adaitw.tp_api_java_coach.model.repository.UsuarioRepository;
import org.adaitw.tp_api_java_coach.service.MailService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Optional;
import java.util.Random;

@Service
public class MailServiceImpl implements MailService<MailDTO, UsuarioEntity> {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ConceptoRepository conceptoRepository;

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    private BusinessLogicExceptionComponent logicExceptionComponent;

    private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Value("${spring.mail.username}")
    private String remitente;

    @Override
    public MailDTO mailConsejo(String nombreUsuario) throws MessagingException {

        Random rnd = new Random();
        Long idConcepto = (long) (rnd.nextInt(3 - 1 + 1) + 1);
        Optional<ConceptoEntity> conceptoOptional = conceptoRepository.findById(idConcepto);
        ConceptoEntity concepto = conceptoOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("ConceptoEntity", idConcepto));
        UsuarioEntity usuarioEmail = usuarioRepository.findByNombreUsuario(nombreUsuario);
        MailDTO mailDTO = new MailDTO();
        mailDTO.setAsunto(concepto.getNombreConcepto());
        mailDTO.setDe(remitente);
        mailDTO.setPara(usuarioEmail.getEmail());
        mailDTO.setContenido(concepto.getContenidoConcepto());
        if (mailDTO.hasNullOrEmptyAttributes())
            throw logicExceptionComponent.getExceptionEntityEmptyValues("UsuarioEntity");
        logger.warn("Cuerpo del mail: " + mailDTO);
        return enviarMailConsejo(mailDTO);
    }

    @Override
    public MailDTO enviarMailConsejo(MailDTO mailDTO) throws MessagingException {

        MimeMessage msg = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setSubject("Te enviamos un consejo sobre: " + mailDTO.getAsunto());
            helper.setFrom(mailDTO.getPara());
            helper.setTo(mailDTO.getPara());
            helper.setText(mailDTO.getContenido());
            mailSender.send(msg);
            logger.warn("Mensaje enviado: " + mailDTO);
        return mailDTO;
    }
}
