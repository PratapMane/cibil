package com.cibil.app.main.service;

import java.io.ByteArrayInputStream;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cibil.app.main.controller.CibilController;
import com.cibil.app.main.model.Cibil;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class CibilPdfService {
	private Logger logger=LoggerFactory.getLogger(CibilPdfService.class);
	
	public ByteArrayInputStream cibilpdf(Cibil cibil) {
		
		logger.info("Cibil pdf started");
		
		String title="Dear Customer your CIBIL information is";
		String content="Your CIBIL Generation ID="+cibil.getCibilId();     
		String content1="Your CIBIL Score is="+cibil.getCibilScore() ;      
		String content2="Your CIBIL Generation ID="+cibil.getCibilGeneratedDate();      
		String content3="Cibil Remark="+cibil.getRemark();
		String content4="Your Previous EMI="+cibil.getPreviousEmi();
		
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		Document document=new Document();
		
		 
			PdfWriter.getInstance(document, out);
			document.open();
			Font titlefont=FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
			Paragraph titlepara=new Paragraph(title,titlefont);
			titlepara.setAlignment(Element.ALIGN_CENTER);
			document.add(titlepara);
			
			Paragraph paracontent=new Paragraph(content);
			document.add(paracontent);
			
			Paragraph paracontent1=new Paragraph(content1);
			document.add(paracontent1);
			
			Paragraph paracontent2=new Paragraph(content2);
			document.add(paracontent2);
			
			Paragraph paracontent3=new Paragraph(content3);
			document.add(paracontent3);
			
			Paragraph paracontent4=new Paragraph(content4);
			document.add(paracontent4);
			document.close();
			
			
		 
		return new ByteArrayInputStream(out.toByteArray());
		
	}
}
