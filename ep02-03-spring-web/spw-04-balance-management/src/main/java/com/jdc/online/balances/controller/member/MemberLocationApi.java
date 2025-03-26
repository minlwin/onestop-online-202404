package com.jdc.online.balances.controller.member;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.online.balances.model.entity.District;
import com.jdc.online.balances.model.entity.Township;
import com.jdc.online.balances.service.LocationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("member/location")
public class MemberLocationApi {
	
	private final LocationService service;

	@GetMapping("district")
	List<District> findDestrict(@RequestParam int regionId) {
		return service.findDistrictByRegion(regionId);
	}
	
	@GetMapping("township")
	List<Township> findTownship(@RequestParam int districtId) {
		return service.findTownshipByDistrict(districtId);
	}
	
}
