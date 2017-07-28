package com.wcy;

import org.junit.Test;

import java.math.BigDecimal;


public class TestBigDecimal {

    @Test
    public void add(){
        BigDecimal a = new BigDecimal("11.2");
        BigDecimal b = new BigDecimal("22.1");
        BigDecimal c = new BigDecimal("33.3");
        System.out.println(a.add(b).equals(c));
    }

}
