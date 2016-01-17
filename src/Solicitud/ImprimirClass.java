package Solicitud;

import java.awt.Desktop;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ImprimirClass {
	
	public static boolean imprimircla(DatosImprimir objeto)  {
		// TODO Auto-generated method stub
		boolean pdf= false;

	   try {
           OutputStream file = new FileOutputStream(new File("Test1.pdf"));
           String nombre = "Jose";
           Document document = new Document();
           PdfWriter.getInstance(document, file);
           document.open();
           document.add(new Paragraph("Estimado Usuario, le informamos que su solicitud de Cheque de Gerencia se ha procesado con la siguiente información:"));
           document.add(new Paragraph("Nombre del Beneficiario: "+ objeto.getBeneficiario()));
           document.add(new Paragraph("Monto "+ objeto.getMonto()));
           document.add(new Paragraph(new Date().toString()));
           Image foto = Image.getInstance("logo.png");
           foto.scaleToFit(100, 100);
           foto.setAlignment(Chunk.ALIGN_MIDDLE);
           document.add(foto);

           document.close();
           file.close();
         pdf = true;

       } catch (Exception e) {

           e.printStackTrace();
       }
	return pdf;
}}
