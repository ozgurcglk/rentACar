package com.RentACar.demo.business.abstracts;

import java.util.List;

import com.RentACar.demo.business.dtos.ColorListDto;
import com.RentACar.demo.business.requests.CreateColorRequest;
import com.RentACar.demo.core.concretes.BusinessException;

public interface ColorService {
	List<ColorListDto> getAll();
	void add(CreateColorRequest createColorRequest) throws BusinessException;
	ColorListDto getById(int colorId) throws BusinessException;




	
	
}
