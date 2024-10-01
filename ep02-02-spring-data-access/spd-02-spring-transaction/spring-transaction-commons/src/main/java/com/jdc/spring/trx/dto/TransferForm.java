package com.jdc.spring.trx.dto;

public record TransferForm(String from, String to, int amount, String remark) {

}
