package com.jdc.web.spring.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.web.spring.entity.Category_;
import com.jdc.web.spring.entity.Product;
import com.jdc.web.spring.entity.Product_;
import com.jdc.web.spring.repo.CategoryRepo;
import com.jdc.web.spring.repo.ProductRepo;
import com.jdc.web.spring.service.input.ProductForm;
import com.jdc.web.spring.service.input.ProductSearch;
import com.jdc.web.spring.service.output.ProductDetails;
import com.jdc.web.spring.service.output.ProductInfo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.servlet.http.Part;

@Service
@Transactional(readOnly = true)
public class ProductService {
	
	private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private CategoryRepo categoryRepo;

	public List<ProductInfo> findByCategory(int id) {
		
		Function<CriteriaBuilder, CriteriaQuery<ProductInfo>> queryFunc = cb -> {
			var cq = cb.createQuery(ProductInfo.class);
			var root = cq.from(Product.class);
			
			ProductInfo.select(cb, cq, root);
			cq.where(cb.equal(root.get(Product_.category).get(Category_.id), id));

			cq.orderBy(cb.desc(root.get(Product_.createdAt)));
			
			return cq;
		};
		
		return productRepo.search(queryFunc);
	}

	public ProductDetails findById(int id) {
		return productRepo.findById(id)
				.map(ProductDetails::from)
				.orElseThrow();
	}

	public List<ProductInfo> search(ProductSearch search) {
		Function<CriteriaBuilder, CriteriaQuery<ProductInfo>> queryFunc = cb -> {
			var cq = cb.createQuery(ProductInfo.class);
			var root = cq.from(Product.class);
			
			ProductInfo.select(cb, cq, root);
			cq.where(search.where(cb, root));
			
			cq.orderBy(cb.desc(root.get(Product_.createdAt)));
			
			return cq;
		};
		
		return productRepo.search(queryFunc);
	}

	@Transactional
	public int create(ProductForm form) {
		
		var category = categoryRepo.findById(form.getCategoryId()).orElseThrow();
		var entity = new Product();
		
		entity.setCategory(category);
		entity.setName(form.getName());
		entity.setPrice(form.getPrice());
		entity.setDeleted(form.isDeleted());
		entity.setCreatedAt(LocalDateTime.now());
		entity.setUpdatedAt(LocalDateTime.now());
		
		entity = productRepo.save(entity);
		return entity.getId();
	}

	@Transactional
	public int update(int id, ProductForm form) {
		
		
		var entity = productRepo.findById(id).orElseThrow();
		
		entity.setName(form.getName());
		entity.setPrice(form.getPrice());
		entity.setDeleted(form.isDeleted());
		
		entity.setUpdatedAt(LocalDateTime.now());
		
		return entity.getId();
	}

	@Transactional
	public void upload(int categoryId, Part part) {
		
		var category = categoryRepo.findById(categoryId).orElseThrow();
		
		try(var br = new BufferedReader(new InputStreamReader(part.getInputStream()))) {
			
			String line = null;
			var products = new ArrayList<Product>();
			
			while(null != (line = br.readLine())) {
				
				var array = line.split("\t");
				
				var product = new Product();
				product.setCategory(category);
				product.setName(array[0]);
				product.setPrice(Integer.parseInt(array[1]));
				product.setDeleted("Deleted".equals(array[2]));
				product.setCreatedAt(LocalDateTime.now());
				product.setUpdatedAt(LocalDateTime.now());
				products.add(product);
			}
			
			if(!products.isEmpty()) {
				productRepo.saveAll(products);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void uploadPhotos(int productId, Collection<Part> photos, String folder) {
		
		var fileNames = new ArrayList<String>();
		
		var i = 0;
		
		for(var photo : photos) {
			i ++;
			var fileName = getFileName(photo, i, productId);
			
			if(null != fileName) {
				
				try {
					Files.copy(photo.getInputStream(), Path.of(folder, fileName), StandardCopyOption.REPLACE_EXISTING);
					fileNames.add(fileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		var product = productRepo.findById(productId).orElseThrow();
		product.setImage(fileNames.stream().collect(Collectors.joining(",")));
		
	}

	private String getFileName(Part photo, int index, int productId) {
		var originalFileName = photo.getSubmittedFileName();
		
		if(null != originalFileName 
				&& (originalFileName.endsWith("png") 
					|| originalFileName.endsWith("PNG") 
					|| originalFileName.endsWith("jpg") 
					|| originalFileName.endsWith("JPG") 
					|| originalFileName.endsWith("jpeg")
					|| originalFileName.endsWith("JPEG"))) {
			
			var array = originalFileName.split("\\.");
			var extension = array[array.length - 1];
			
			return "photo-%s-%04d%02d.%s".formatted(LocalDateTime.now().format(DF), productId, index, extension);
		}
		
		return null;
	}
}
