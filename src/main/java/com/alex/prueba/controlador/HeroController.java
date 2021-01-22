package com.alex.prueba.controlador;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alex.prueba.dto.input.HeroInputDto;
import com.alex.prueba.dto.response.HeroDto;
import com.alex.prueba.servicio.IHeroesService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class HeroController {
	@Autowired
	IHeroesService heroesService;
	
	@GetMapping("/")
	@ResponseBody
	public Iterable<HeroDto> getAll(){
		System.out.println("Obteniendo all heroes...");
		return heroesService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public HeroDto getById(@PathVariable(value = "id") long id,
									HttpServletResponse response){
		System.out.println("Obteniendo by id...");
		try{
			return heroesService.findById(id);
		}catch(NoSuchElementException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}
	
	//createorupdate
	@PutMapping("/")
	@ResponseBody
	public HeroDto createOrUpdate(@RequestBody HeroInputDto input) {
		System.out.println("Añadiendo o editando heroe");
		try {
			return heroesService.createOrUpdate(input);
		}catch(Exception e) { //Esto arreglarlo
			return null;
		}
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void deleteById(@PathVariable(value = "id") long id,
								HttpServletResponse response) {
		System.out.println("Obteniendo by id...");
		try{
			heroesService.deleteById(id);
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
		}catch(NoSuchElementException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
	
	
}
