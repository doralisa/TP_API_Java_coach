package org.adaitw.tp_api_java_coach.util;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.*;
import org.adaitw.tp_api_java_coach.model.dto.ReporteDTO;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ReportePdfBuilder {

    private  List<ReporteDTO> listaReporteDTO;

    public ReportePdfBuilder(List<ReporteDTO> listaReporteDTO) {
        this.listaReporteDTO = listaReporteDTO;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(4);

        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Capitulos", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Conceptos", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Ejemplos", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Niveles", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Preguntas", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Respuestas", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Usuarios", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (ReporteDTO reporteDTO : listaReporteDTO) {
            table.addCell(String.valueOf(reporteDTO.getCantidadCapitulos()));
            table.addCell(String.valueOf(reporteDTO.getCantidadConceptos()));
            table.addCell(String.valueOf(reporteDTO.getCantidadEjemplos()));
            table.addCell(String.valueOf(reporteDTO.getCantidadNiveles()));
            table.addCell(String.valueOf(reporteDTO.getCantidadPreguntas()));
            table.addCell(String.valueOf(reporteDTO.getCantidadRespuestas()));
            table.addCell(String.valueOf(reporteDTO.getCantidadUsuarios()));
        }
    }

    public Document export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Cantidad de registros por Entidad", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);
        document.addAuthor("Creado por: Doralys Contreras");

        document.close();
        return document;
    }
}
