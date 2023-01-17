package com.cibil.app.main.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Cibil {
	private String cibilId;
	private Integer cibilScore;
	private Date cibilGeneratedDate;
	private String remark;
	private Integer previousEmi;
}
