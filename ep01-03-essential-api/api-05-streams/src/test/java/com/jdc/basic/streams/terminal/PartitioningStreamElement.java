package com.jdc.basic.streams.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.jdc.stream.domain.Sale;

public class PartitioningStreamElement {
	
	@Test
	void test_pertition() {
		try(var stream = Files.lines(Path.of("data", "sales.txt"))) {

			System.out.println("""
					-----------------------
					Pertitioning
					-----------------------
					""");
			
			var result = stream
					.map(line -> line.split("\t"))
					.map(Sale::from)
					.collect(Collectors.partitioningBy(sale -> sale.getTotal() < 10000));
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void test_pertition_downstream() {
		try(var stream = Files.lines(Path.of("data", "sales.txt"))) {

			System.out.println("""
					-----------------------
					Pertitioning Downstream
					-----------------------
					""");
			
			var result = stream
					.map(line -> line.split("\t"))
					.map(Sale::from)
					.collect(Collectors.partitioningBy(
							sale -> sale.getTotal() < 10000,
							Collectors.groupingBy(
									Sale::category, 
									Collectors.reducing(0, sale -> sale.getTotal(), (a, b) -> a + b)
								)
							));
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
