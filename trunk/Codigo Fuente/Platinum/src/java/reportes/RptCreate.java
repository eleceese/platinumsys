/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportes;
/*
 * RptModulos.java
 *
 * Created on 14 de noviembre de 2006, 04:17 PM
 *
 * Clase que se encarga de generar los reportes
 */
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class RptCreate {

    public void getReport(Connection conn, String sNameReport, String[] sParametersNames, String[] sParametersValues, ServletContext sc) throws Exception{
        String realPathXml = sc.getRealPath("/WEB-INF/classes/reportesFuente/");
        try{
            //JRPdfExporter exporter = new JRPdfExporter();
            // FontKey fontk= new FontKey("COMIC", false, false);
            // PdfFont pdffont= new PdfFont("C:/WINDOWS/FONTS/COMIC.TTF", BaseFont.CP1250, true);
            // Map fontmap= new HashMap();
            // fontmap.put(fontk, pdffont);
            // exporter.setParameter(JRPdfExporterParameter.FONT_MAP, fontmap);
            // First, load JasperDesign from XML and compile it into JasperReport
            JasperDesign jasperDesign = JRXmlLoader.load(realPathXml +"/" +sNameReport);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            // Second, create a map of parameters to pass to the report.
            Map parameters = new HashMap();

            for(int i=0; i<sParametersNames.length; i++){
                parameters.put(sParametersNames[i], sParametersValues[i]);
            }
            // Third, get a database connection

            // Fourth, create JasperPrint using fillReport() method
            byte[] pdf=null;
            pdf= JasperRunManager.runReportToPdf(jasperReport, parameters, conn);
            JasperPrint jp= JasperFillManager.fillReport(jasperReport, parameters, conn);
            // You can use JasperPrint to create PDF
            FacesContext faces = FacesContext.getCurrentInstance();
            HttpServletResponse response =
                    (HttpServletResponse) faces
                    .getExternalContext()
                    .getResponse();
            response.setContentType("application/pdf");
            response.setContentLength(pdf.length);
            response.setHeader("Content-disposition","inline; filename=\"MyPdf.pdf\"");


            //exporter.setParameter(JRExporterParameter.JASPER_PRINT,  jp);
            //exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());

            //exporter.exportReport();

            ServletOutputStream out = response.getOutputStream();
            out.write(pdf);

            faces.responseComplete();
        }

        catch(Exception e){
            throw e;
        }
    }

    public void getReport1(Connection conn, String sNameReport, String[] sParametersNames, String[] sParametersValues, ServletContext sc) throws Exception{
        String realPathXml = sc.getRealPath("/WEB-INF/classes/reportesFuente/");
        JasperViewer visor=null;
        try{
            //JRPdfExporter exporter = new JRPdfExporter();
            // FontKey fontk= new FontKey("COMIC", false, false);
            // PdfFont pdffont= new PdfFont("C:/WINDOWS/FONTS/COMIC.TTF", BaseFont.CP1250, true);
            // Map fontmap= new HashMap();
            // fontmap.put(fontk, pdffont);
            // exporter.setParameter(JRPdfExporterParameter.FONT_MAP, fontmap);
            // First, load JasperDesign from XML and compile it into JasperReport
            JasperDesign jasperDesign = JRXmlLoader.load(realPathXml +"/" +sNameReport);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            // Second, create a map of parameters to pass to the report.
            Map parameters = new HashMap();

            for(int i=0; i<sParametersNames.length; i++){
                parameters.put(sParametersNames[i], sParametersValues[i]);
            }
            // Third, get a database connection

            // Fourth, create JasperPrint using fillReport() method

            JasperPrint jp= JasperFillManager.fillReport(jasperReport, parameters, conn);
            visor = new JasperViewer(jp,false); //Creamos un visor para previsualizar el reporte
            visor.setTitle("Reporte");
            visor.setVisible(true); //Lo hacemos visible


        }

        catch(Exception e){
            throw e;
        }
    }

    public void getReport(JRDataSource ds, String sNameReport, String[] sParametersNames, String[] sParametersValues, ServletContext sc) throws Exception{
        String realPathXml = sc.getRealPath("/WEB-INF/classes/reportesFuente/");
        try{

            JasperDesign jasperDesign = JRXmlLoader.load(realPathXml +"/" +sNameReport);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            // Second, create a map of parameters to pass to the report.
            Map parameters = new HashMap();

            for(int i=0; i<sParametersNames.length; i++){
                parameters.put(sParametersNames[i], sParametersValues[i]);
            }

            byte[] pdf=null;
            pdf= JasperRunManager.runReportToPdf(jasperReport, parameters, ds);
            JasperPrint jp= JasperFillManager.fillReport(jasperReport, parameters, ds);

            FacesContext faces = FacesContext.getCurrentInstance();
            HttpServletResponse response =
                    (HttpServletResponse) faces
                    .getExternalContext()
                    .getResponse();
            response.setContentType("application/pdf");
            response.setContentLength(pdf.length);
            response.setHeader(
                    "Content-disposition",
                    "inline; filename=\"MyPdf.pdf\"");



            ServletOutputStream out = response.getOutputStream();
            out.write(pdf);

            faces.responseComplete();
        }

        catch(Exception e){
            throw e;
        }
    }

    public RptCreate() {
    }

}