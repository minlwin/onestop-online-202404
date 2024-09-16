package com.jdc.spring.jdbc.repo;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import com.jdc.spring.jdbc.domain.ProductForm;

public class ProductFormAggregator implements ArgumentsAggregator{

	@Override
	public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context)
			throws ArgumentsAggregationException {
		return new ProductForm(
				accessor.getString(1), accessor.getString(2), accessor.getString(3), accessor.getInteger(4));
	}

}
