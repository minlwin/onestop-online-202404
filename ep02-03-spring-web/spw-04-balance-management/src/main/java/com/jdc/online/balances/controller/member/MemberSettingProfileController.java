package com.jdc.online.balances.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.online.balances.controller.member.dto.ProfileEditForm;

@Controller
@RequestMapping("member/profile")
public class MemberSettingProfileController {

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
}
