package com.jdc.web.spring.service.output;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.util.StringUtils;

import com.jdc.web.spring.entity.Product;

import lombok.Data;

@Data
public class ProductDetails {

	private int id;
	private String name;
	private int price;
	private String image;
	private boolean deleted;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private int categoryId;
	private String categoryName;
	
	private List<SaleItemInfo> saleItems;
	
	public String getStatus() {
		return deleted ? "Deleted" : "Available";
	}
	
	public String getDefaultImage() {
		if(StringUtils.hasLength(image)) {
			var array = image.split(",");
			if(array.length > 0) {
				return array[0];
			}
		}
		
		return null;
 	}
	
	public List<String> getImages() {
		if(StringUtils.hasLength(image)) {
			List.of(image.split(","));
		}
		
		return List.of();
	}
	
	public static ProductDetails from(Product entity) {
		
		var dto = new ProductDetails();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setImage(entity.getImage());
		dto.setDeleted(entity.isDeleted());
		dto.setCreatedAt(entity.getCreatedAt());
		dto.setUpdatedAt(entity.getUpdatedAt());
		dto.setCategoryId(entity.getCategory().getId());
		dto.setCategoryName(entity.getCategory().getName());
		
		if(null != entity.getSaleItems()) {
			dto.setSaleItems(entity.getSaleItems().stream().map(SaleItemInfo::from).toList());
		}
		
		return dto;
	}

}
