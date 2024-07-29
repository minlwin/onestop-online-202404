package com.jdc.basic.streams.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Sale;

public class CollectingAsGroupDownStream {

	@Test
	void test_group_and_collect_product() {
		
		// Map<Category, List<Product>>
		try(var stream = Files.lines(Path.of("data", "sales.txt"))) {

			System.out.println("""
					-----------------------
					Group By Category and collect product
					-----------------------
					""");
			
			var result = stream
					.map(line -> line.split("\t"))
					.map(Sale::from)
					.collect(Collectors.groupingBy(
							Sale::category, // Classifier
							Collectors.mapping(Sale::product, Collectors.toCollection(() -> new TreeSet<>()))  // Downstream Collector
							));
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_group_and_collect_sum() {

		// Map<Sale Date, Sale Total>
		try(var stream = Files.lines(Path.of("data", "sales.txt"))) {

			System.out.println("""
					-----------------------
					Group By sale date and collect sum
					-----------------------
					""");
			
			var result = stream
					.map(line -> line.split("\t"))
					.map(Sale::from)
					.collect(Collectors.groupingBy(
							sale -> sale.saleAt().toLocalDate(), // Classifier
							Collectors.mapping(
									sale -> sale.quantity() * sale.unitPrice()
									, Collectors.reducing(0, (a, b) -> a + b))  // Downstream Collector
							));
			
			System.out.println(result);
						
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
