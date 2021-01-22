package com.alex.prueba.dto.response;

import java.io.Serializable;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Data;

@Data
public class HeroDto implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 4070849182608098411L;

	@JMap
	private Long id;
	
	@JMap
	private String name;
}
