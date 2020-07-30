package com.essContext.domain.enums;

public enum LegalTypeEnum {
    /*
    企业
     */
    ENTERPRISE("0"),
    /*
    农专社
     */
    AGRICULTURAL("1"),
    /*
    个体工商户
     */
    INDIVIDUALLY("2"),
    ;

    private String type;

    LegalTypeEnum(String type) {
        this.type = type;
    }

}
