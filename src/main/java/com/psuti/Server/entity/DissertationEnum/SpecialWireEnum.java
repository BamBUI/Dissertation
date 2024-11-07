package com.psuti.Server.entity.DissertationEnum;

import org.springframework.lang.Nullable;

public enum SpecialWireEnum {
    A("A"),
    B("B"),
    C("C"),
    D("D");

    private final String id;

    SpecialWireEnum(String id){this.id = id;}

    public String getId(){return id;}

    @Nullable
    public static SpecialWireEnum fromId(String id){
        for(SpecialWireEnum at : SpecialWireEnum.values()){
            if(at.getId().equals(id)){
                return at;
            }
        }
        return null;
    }
}
