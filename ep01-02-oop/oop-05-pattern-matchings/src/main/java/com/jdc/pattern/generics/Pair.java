package com.jdc.pattern.generics;

public record Pair<K, V>(K key, V value) 
	implements PairInf<K, V>{

}
