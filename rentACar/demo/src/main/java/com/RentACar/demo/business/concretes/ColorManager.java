package com.RentACar.demo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RentACar.demo.business.abstracts.ColorService;
import com.RentACar.demo.business.dtos.ColorListDto;
import com.RentACar.demo.business.requests.CreateColorRequest;
import com.RentACar.demo.core.concretes.BusinessException;
import com.RentACar.demo.core.utilities.mapping.ModelMapperService;
import com.RentACar.demo.dataAccess.abstracts.ColorDao;
import com.RentACar.demo.entities.concretes.Color;


@Service
public class ColorManager implements ColorService{
	
	private ColorDao colorDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
		this.colorDao = colorDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<ColorListDto> getAll() {
		var result = this.colorDao.findAll();
		List<ColorListDto> response = result.stream().map(color->this.modelMapperService.forDto().map(color, ColorListDto.class)).collect(Collectors.toList());
		return response;
	}

	@Override
	public void add(CreateColorRequest createColorRequest) throws BusinessException {
		Color color=this.modelMapperService.forRequest().map(createColorRequest, Color.class);
		checkColorNames(color);
		this.colorDao.save(color);
		
	}

	private boolean checkColorNames(Color color) throws BusinessException {
		
		var result = this.colorDao.getByColorName(color.getColorName());
		if(result != null) {
			throw new BusinessException("Bu renk var.");
		}
		else {
			return true;
		}
	}

	@Override
	public ColorListDto getById(int colorId) throws BusinessException {
		var result=this.colorDao.getByColorId(colorId);
		if(result==null) {
			throw new BusinessException("Bu ID'ye sahip bir renk bulunmuyor.");
		}
		else {
			ColorListDto response = this.modelMapperService.forDto().map(result, ColorListDto.class);
			return response;
		}
		
	}

}
