package org.zerock.model;

import lombok.Data;

@Data
public class BoardDTO {
	private int num, hitcount;
	private String title, content, writer, regdate, password;

}
