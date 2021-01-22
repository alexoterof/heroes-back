package com.alex.prueba.dto.input;

import java.io.Serializable;

import lombok.Data;

@Data
public class HeroInputDto implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 7677610862625200882L;
	
	private long id;
	
	private String name;
}
