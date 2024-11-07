package com.psuti.Server.entity.DissertationEnum;

import org.springframework.lang.Nullable;

public enum Region {
    A("A"),
    B("B"),
    C("C"),
    D("D");

    private final String id;

    Region(String id){this.id = id;}

    public String getId(){return id;}

    @Nullable
    public static Region fromId(String id){
        for(Region at : Region.values()){
            if(at.getId().equals(id)){
                return at;
            }
        }
        return null;
    }
}
