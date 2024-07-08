package com.jdc.online.pos.model.storage;

import java.io.Serializable;

import com.jdc.online.pos.model.output.Product;

public record ProductStorage(
		int lastId,
		Product[] product) implements Serializable{

}
