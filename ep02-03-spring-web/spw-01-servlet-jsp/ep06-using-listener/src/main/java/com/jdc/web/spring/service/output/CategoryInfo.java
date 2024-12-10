package com.jdc.web.spring.service.output;

import java.time.LocalDateTime;

import com.jdc.web.spring.entity.Category;
import com.jdc.web.spring.entity.Category_;
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
public class CategoryInfo {

	private int id;
	private String name;
	private boolean deleted;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private Number products;
	private Number sales;
	
	public static void select(CriteriaBuilder cb, CriteriaQuery<CategoryInfo> cq, Root<Category> root) {
		
		var product = root.join(Category_.products, JoinType.LEFT);
		var saleItem = product.join(Product_.saleItems, JoinType.LEFT);
		
		cq.multiselect(
			root.get(Category_.id),
			root.get(Category_.name),
			root.get(Category_.deleted),
			root.get(Category_.createdAt),
			root.get(Category_.updatedAt),
			cb.count(product.get(Product_.id)),
			cb.sum(saleItem.get(SaleItem_.quantity))
		);
		
		cq.groupBy(
			root.get(Category_.id),
			root.get(Category_.name),
			root.get(Category_.deleted),
			root.get(Category_.createdAt),
			root.get(Category_.updatedAt)
		);
		
	}
	
	public String getStatus() {
		return deleted ? "Deleted" : "Available";
	}
}
