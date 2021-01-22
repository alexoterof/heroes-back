package com.alex.prueba.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.prueba.dao.HeroDao;
import com.alex.prueba.dto.input.HeroInputDto;
import com.alex.prueba.dto.response.HeroDto;
import com.alex.prueba.modelo.Hero;
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;

@Service
public class HeroesServiceImpl implements IHeroesService {
	@Autowired
	private HeroDao heroDao;

	@Autowired
	private JMapperAPI jmapperApi;
	
	public Iterable<HeroDto> findAll(){
		List<HeroDto> heroes = new ArrayList<HeroDto>();
		heroDao.findAll().forEach(r -> heroes.add(convertToDto(r)));
		return heroes;
	}
	
	public HeroDto findById(long id) {
		return convertToDto(heroDao.findById(id).get());
	}
	
	public HeroDto createOrUpdate(HeroInputDto input) {
		Hero hero = new Hero();
		BeanUtils.copyProperties(input, hero);
		return convertToDto(heroDao.save(hero));
	}
	
	public void deleteById(long id) {
		heroDao.deleteById(id);
	}
	
	private HeroDto convertToDto(Hero input) {
//		JMapper<HeroDto, Hero> mapper = new JMapper<> (HeroDto.class, Hero.class, jmapperApi);
//		HeroDto empresa = mapper.getDestination(input);
		HeroDto output = new HeroDto();
		output.setId(input.getId());
		output.setName(input.getName());
        return output;
	}

	
	
	
}
