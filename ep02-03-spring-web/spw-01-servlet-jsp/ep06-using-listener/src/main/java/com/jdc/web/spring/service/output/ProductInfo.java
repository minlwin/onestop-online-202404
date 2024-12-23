package com.jdc.web.spring.service.output;

import java.time.LocalDateTime;

import org.springframework.util.StringUtils;

import com.jdc.web.spring.entity.Category_;
import com.jdc.web.spring.entity.Product;
import com.jdc.web.spring.entity.Product_;
import com.jdc.web.spring.entity.SaleItem_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {

	private int id;
	private String name;
	private int price;
	private String image;
	private boolean deleted;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private int categoryId;
	private String categoryName;
	private Number saleItems;
	private Number saleAmount;
	
	public static void select(CriteriaBuilder cb, CriteriaQuery<ProductInfo> cq, Root<Product> root) {
		
		var category = root.join(Product_.category);
		var saleItems = root.join(Product_.saleItems, JoinType.LEFT);
		
		cq.multiselect(
			root.get(Product_.id),
			root.get(Product_.name),
			root.get(Product_.price),
			root.get(Product_.image),
			root.get(Product_.deleted),
			root.get(Product_.createdAt),
			root.get(Product_.updatedAt),
			category.get(Category_.id),
			category.get(Category_.name),
			cb.sum(saleItems.get(SaleItem_.quantity)),
			cb.sum(cb.prod(saleItems.get(SaleItem_.quantity), saleItems.get(SaleItem_.salePrice)))
		);
		
		cq.groupBy(
			root.get(Product_.id),
			root.get(Product_.name),
			root.get(Product_.price),
			root.get(Product_.image),
			root.get(Product_.deleted),
			root.get(Product_.createdAt),
			root.get(Product_.updatedAt),
			category.get(Category_.id),
			category.get(Category_.name)
		);
	}

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
		
		return "default-image.jpg";
	}
}
