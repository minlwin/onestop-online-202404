package com.jdc.online.balances.service;

import static com.jdc.online.balances.utils.EntityOperations.safeCall;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.online.balances.controller.member.dto.MemberProfileDetails;
import com.jdc.online.balances.controller.member.dto.ProfileEditForm;
import com.jdc.online.balances.model.repo.MemberRepo;
import com.jdc.online.balances.model.repo.TownshipRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberProfileService {
	
	private final MemberRepo memberRepo;
	private final TownshipRepo townshipRepo;

	@PreAuthorize("hasAuthority('Admin') or #username eq authentication.name")
	public MemberProfileDetails loadProfile(String username) {
		return safeCall(memberRepo.findOneByAccountUsername(username)
				.map(MemberProfileDetails::from), 
				"Member", "login id", username);
	}

	@PreAuthorize("hasAuthority('Admin') or #username eq authentication.name")
	public ProfileEditForm getEditForm(String username) {
		return safeCall(memberRepo.findOneByAccountUsername(username)
				.map(ProfileEditForm::from), 
				"Member", "login id", username);
	}

	@Transactional
	@PreAuthorize("hasAuthority('Admin') or #username eq authentication.name")
	public void save(String username, ProfileEditForm form) {

		var member = safeCall(memberRepo.findOneByAccountUsername(username), 
				"Member", "login id", username);
		
		member.setName(form.getName());
		member.setGender(form.getGender());
		member.setDob(form.getDob());
		member.setPhone(form.getPhone());
		
		townshipRepo.findById(form.getTownship())
			.ifPresent(member::setTownship);
		
		member.setAddress(form.getAddress());
	}

	@Transactional
	@PreAuthorize("#username eq authentication.name")
	public void saveImage(String username, String imageFolder, MultipartFile file) {
		
		try {
			var profileImageName = getProfileImageName(username, file);

			var member = safeCall(memberRepo.findOneByAccountUsername(username), 
					"Member", "login id", username);
			
			var profileImagePath = Path.of(imageFolder, profileImageName);

			Files.copy(file.getInputStream(), profileImagePath, StandardCopyOption.REPLACE_EXISTING);
			
			member.setProfileImage(profileImageName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getProfileImageName(String username, MultipartFile file) {
		
		var fileName = file.getOriginalFilename();
		var array = fileName.split("\\.");
		var extension = array[array.length - 1];
		
		return "%s.%s".formatted(username, extension);
	}

}
