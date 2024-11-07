package com.psuti.Server.entity.DissertationEnum;

import org.springframework.lang.Nullable;

public enum Unit {
    A("A"),
    B("B"),
    C("C"),
    D("D");

    private final String id;

    Unit(String id){this.id = id;}

    public String getId(){return id;}

    @Nullable
    public static Unit fromId(String id){
        for(Unit at : Unit.values()){
            if(at.getId().equals(id)){
                return at;
            }
        }
        return null;
    }
}
