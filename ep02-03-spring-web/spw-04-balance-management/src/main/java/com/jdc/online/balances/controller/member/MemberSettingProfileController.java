package com.jdc.online.balances.controller.member;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.online.balances.controller.member.dto.ProfileEditForm;
import com.jdc.online.balances.model.entity.Region;
import com.jdc.online.balances.service.LocationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("member/profile")
public class MemberSettingProfileController {
	
	private final LocationService locationService;

	@GetMapping
	String editProfile() {
		return "member/profile/edit";
	}
	
	@PostMapping
	String updateProfile(
			@Validated ProfileEditForm editForm, BindingResult result) {
		
		if(result.hasErrors()) {
			return "member/profile/edit";
		}
		
		return "redirect:/member/home";
	}

	@PostMapping("photo")
	String uploadPhoto(@RequestParam MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		return "redirect:/member/profile";
	}
	
	@ModelAttribute(name = "regions")
	List<Region> getRegions() {
		return locationService.getAllLocations();
	}
}
