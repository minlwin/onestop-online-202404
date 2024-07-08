package com.jdc.online.pos.model.output;

import java.io.Serializable;

public record Product(
		int id,
		String name,
		int price) implements Serializable{

}
