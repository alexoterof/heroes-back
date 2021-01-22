package com.alex.prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.prueba.modelo.Hero;

public interface HeroDao extends JpaRepository<Hero, Long>{

}
