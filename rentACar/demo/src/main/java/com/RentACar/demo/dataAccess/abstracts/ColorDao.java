package com.RentACar.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RentACar.demo.entities.concretes.Color;

@Repository
public interface ColorDao extends JpaRepository<Color, Integer>{
	
	Color getByColorName(String colorName);
	Color getByColorId(int colorId);
}
