package com.jdc.basic.streams.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Sale;

public class CollectingAsGroup {

	@Test
	void test_group_by_category() {
		try(var stream = Files.lines(Path.of("data", "sales.txt"))) {
			
			System.out.println("""
					-----------------------
					Group By Category
					-----------------------
					""");
			
			Map<String, List<Sale>> result = stream
						.map(line -> line.split("\t"))
						.map(Sale::from)
						.collect(Collectors.groupingBy(Sale::category));
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_group_by_product() {
		try(var stream = Files.lines(Path.of("data", "sales.txt"))) {

			System.out.println("""
					-----------------------
					Group By Product
					-----------------------
					""");
			
			Map<String, List<Sale>> result = stream
					.map(line -> line.split("\t"))
					.map(Sale::from)
					.collect(Collectors.groupingBy(Sale::product));
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Test
	void test_group_by_sale_date() {
		try(var stream = Files.lines(Path.of("data", "sales.txt"))) {

			System.out.println("""
					-----------------------
					Group By Sale Date
					-----------------------
					""");
			
			Map<LocalDate, List<Sale>> result = stream
					.map(line -> line.split("\t"))
					.map(Sale::from)
					.collect(Collectors.groupingBy(sale -> sale.saleAt().toLocalDate()));
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
