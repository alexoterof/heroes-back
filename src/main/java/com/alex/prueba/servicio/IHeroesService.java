package com.alex.prueba.servicio;

import com.alex.prueba.dto.input.HeroInputDto;
import com.alex.prueba.dto.response.HeroDto;

public interface IHeroesService {
	public Iterable<HeroDto> findAll();
	public HeroDto findById(long id);
	public HeroDto createOrUpdate(HeroInputDto input);
	public void deleteById(long id);
}
