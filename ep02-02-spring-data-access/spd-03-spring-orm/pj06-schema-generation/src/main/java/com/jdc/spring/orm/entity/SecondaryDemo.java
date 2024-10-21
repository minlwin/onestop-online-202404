package com.jdc.spring.orm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "main_tbl")
@SecondaryTable(name = "sub_table")
@SecondaryTable(name = "other_table")
public class SecondaryDemo {

	@Id
	private int id;
	
	private String name;
	
	@Column(table = "sub_table", name = "information")
	private String subInformation;

	@Column(table = "other_table", name = "information")
	private String otherInformation;
}
