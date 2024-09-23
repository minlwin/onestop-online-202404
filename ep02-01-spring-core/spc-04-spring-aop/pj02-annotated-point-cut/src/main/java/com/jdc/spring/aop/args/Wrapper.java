package com.jdc.spring.aop.args;

import com.jdc.spring.aop.OnArgument;

@OnArgument("string wrapper value")
public record Wrapper(String value) {

}
