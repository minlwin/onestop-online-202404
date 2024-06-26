package com.jdc.pattern.generics;

public record Container<T>(T value) implements ContainerInf<T>{

}
