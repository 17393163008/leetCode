package com.pqq.test;

import lombok.Getter;

/**
 * @author 潘勤强
 * @create 2021-12-19 18:11
 */
public enum  CountryEnum {
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵国"),FIVE(5,"魏"),SIX(6,"韩");

    @Getter private Integer retCode;
    @Getter private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public CountryEnum forEach_countryEnum(int index)
    {
        return null;
    }
}
