package org.adaitw.tp_api_java_coach.controller;

import com.lowagie.text.DocumentException;
import org.adaitw.tp_api_java_coach.model.dto.ReporteDTO;
import org.adaitw.tp_api_java_coach.service.impl.ReporteServiceImpl;
import org.adaitw.tp_api_java_coach.util.ReportePdfBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "generar")
public class ReporteController {

    @Autowired
    ReporteServiceImpl reporteServiceImpl;

    private static final String reportes = ".//reportes";

    @GetMapping(value= "/reporte")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Reporte_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<ReporteDTO> cantidadEntidades = reporteServiceImpl.getData();

        ReportePdfBuilder exporter = new ReportePdfBuilder(cantidadEntidades);
        exporter.export(response);

    }

}
