package com.laptrinhjavaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.service.IBuildingService;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {

	@Autowired
	private IBuildingService buildingService;
	@Autowired
	private BuildingConverter buildingConverter;
	
	@RequestMapping(value = "admin/building/list", method = RequestMethod.GET)
	public ModelAndView showBuilding(@ModelAttribute("model") BuildingDTO model) {		
		ModelAndView mav = new ModelAndView("admin/building/list");
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
				.setName(model.getName()) .setDistrict(model.getDistrict())
				.setBuildingArea(model.getBuildingArea())
				.setNumberOfBasement(model.getNumberOfBasement())
				.setStreet(model.getStreet()) .setWard(model.getWard())
				.setBuildingTypes(model.getBuildingTypes())
				.setRentAreaFrom(model.getRentAreaFrom())
				.setRentAreaTo(model.getRentAreaTo())
				.setCostRentFrom(model.getCostRentFrom())
				.setCostRentTo(model.getCostRentTo()) .setStaffId(model.getStaffId())
				.build();
		Pageable pageable = null;
		if(model.getPage() == null || model.getLimit() == null) {
			pageable = new PageRequest(0, 5);
		}else {
			pageable = new PageRequest(model.getPage() - 1, model.getLimit());
		}		
		List<BuildingDTO> buildings = buildingService.findAll(buildingSearchBuilder, pageable);	
		int totalItems = buildingService.getCountAllItems(buildingSearchBuilder);
		if(buildings.size() == 0 && totalItems > 0) {
			pageable = new PageRequest(pageable.getPageNumber() - 1, pageable.getPageSize());
			buildings = buildingService.findAll(buildingSearchBuilder, pageable);
		}
		model.setTotalPage((int) Math.ceil((double)totalItems/(double)pageable.getPageSize()));
		model.setPage(pageable.getPageNumber() + 1);	
		model.setLimit(pageable.getPageSize());
		mav.addObject("districts", buildingService.getDistricts());
		mav.addObject("buildingTypes", buildingService.getBuildingTypes());
		mav.addObject("buildings", buildings);	
		mav.addObject("model", model);
		return mav;
	}	
	

	@RequestMapping(value = "admin/building/edit", method = RequestMethod.GET)
	public ModelAndView editBuilding(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("admin/building/edit");
		BuildingDTO model = new BuildingDTO();
		if(id != null) {
			BuildingEntity buildingEntity = buildingService.findById(id);
			model = buildingConverter.convertToDTO(buildingEntity);
			model.setBuildingTypes(buildingEntity.getType().split("//,"));
			model.setRentArea(buildingService.generateTypes(buildingEntity));
		}
		mav.addObject("districts", buildingService.getDistricts());
		mav.addObject("buildingTypes", buildingService.getBuildingTypes());
		mav.addObject("model", model);
		return mav;
	}
}
