package com.psuti.Server.entity.DissertationEnum;

import org.springframework.lang.Nullable;

public enum PartType {
    A("A"),
    B("B"),
    C("C"),
    D("D");

    private final String id;

    PartType(String id){this.id = id;}

    public String getId(){return id;}

    @Nullable
    public static PartType fromId(String id){
        for(PartType at : PartType.values()){
            if(at.getId().equals(id)){
                return at;
            }
        }
        return null;
    }
}
