package com.RentACar.demo.business.abstracts;

import java.util.List;
import com.RentACar.demo.business.dtos.BrandListDto;
import com.RentACar.demo.business.requests.CreateBrandRequest;
import com.RentACar.demo.core.concretes.BusinessException;

public interface BrandService {

	List<BrandListDto> getAll();
	void add(CreateBrandRequest createBrandRequest) throws BusinessException;
	BrandListDto getById(int brandId) throws BusinessException;

	
}
