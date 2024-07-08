package com.jdc.online.pos.model.storage;

import java.io.Serializable;

import com.jdc.online.pos.model.output.Sale;

public record SaleStorage(
		int lastId,
		Sale [] sales) implements Serializable{

}
