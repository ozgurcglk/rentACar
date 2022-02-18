package com.RentACar.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RentACar.demo.business.abstracts.BrandService;
import com.RentACar.demo.business.dtos.BrandListDto;
import com.RentACar.demo.business.requests.CreateBrandRequest;
import com.RentACar.demo.core.concretes.BusinessException;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

	private BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getall")
    public List<BrandListDto> getAll(){
        return this.brandService.getAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody CreateBrandRequest createBrandRequest) throws BusinessException {
        this.brandService.add(createBrandRequest);
    }
    
    @GetMapping("/getid")
    public BrandListDto getById(int brandId) throws BusinessException {
    	return this.brandService.getById(brandId);
    }
	
}