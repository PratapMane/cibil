package com.cibil.app.main.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibil.app.main.model.Cibil;
import com.cibil.app.main.service.CibilPdfService;
//import com.cibil.app.main.service.CibilPdfService;

@RestController
@RequestMapping("GCappps/CIBILScore")
public class CibilController {
	
	@Autowired
	Cibil cibil;
	
//	@Autowired
//	CibilPdfService cps;
//	ResponseEntity<InputStreamResource>

	@GetMapping("/check/{pancardNumber}")
	public Cibil cibilcheck(@PathVariable String pancardNumber) 
	{
			 
		cibil.setCibilId("CB-"+ThreadLocalRandom.current().nextInt(999,9999));
		Integer cib=ThreadLocalRandom.current().nextInt(300,900);
		cibil.setCibilScore(cib);
		Date date=new Date();
		cibil.setCibilGeneratedDate(date);
		String remark=null;
		if(cib<500)
		{
			remark="Poor";
		}
		else if(cib>=500 && cib <700)
		{
			remark="Average";
		}
		else {
			remark="Satisfactory";
		}
		cibil.setRemark(remark);
		Integer d=ThreadLocalRandom.current().nextInt(1000,20000);
		cibil.setPreviousEmi(d);
		
//		ByteArrayInputStream pdf=cps.cibilpdf(cibil);
//		HttpHeaders http=new HttpHeaders();
//		http.add("CIBIL","Data;file=cibil.pdf");
//		return ResponseEntity.ok().headers(http).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(pdf));
		return cibil;
	}

}
