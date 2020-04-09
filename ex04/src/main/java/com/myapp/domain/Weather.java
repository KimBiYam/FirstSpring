package com.myapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Weather {
	private String area;
	private String date;
	private String pop;
	private String reh;
	private Double tmn;
	private Double tmx;
}
