package com.jdc.spring.web.databinding.model.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.spring.web.databinding.model.entity.Category;
import com.jdc.spring.web.databinding.model.repo.CategoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	
	private final CategoryRepo repo;

	@Transactional
	public void upload(MultipartFile file) {
		if(null != file) {
			try (var br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

				String line = null;
				while (null != (line = br.readLine())) {
					
					if(repo.findOneByName(line).isEmpty()) {
						var entity = new Category();
						entity.setName(line);
						repo.save(entity);
					}
				}
				
			} catch (Exception e) {
                e.printStackTrace();
			}
		}
	}

	@Transactional(readOnly = true)
	public List<Category> findAll() {
		return repo.findAll();
	}
}
