package com.RentACar.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RentACar.demo.entities.concretes.Brand;

@Repository
public interface BrandDao extends JpaRepository<Brand, Integer> {
 
	Brand getByBrandName(String name);
	Brand getByBrandId(int brandId);
	
}
