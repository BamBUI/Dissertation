package com.psuti.Server.entity.DissertationEnum;

import org.springframework.lang.Nullable;

public enum Options {
    A("A"),
    B("B"),
    C("C"),
    D("D");

    private final String id;

    Options(String id){this.id = id;}

    public String getId(){return id;}

    @Nullable
    public static Options fromId(String id){
        for(Options at : Options.values()){
            if(at.getId().equals(id)){
                return at;
            }
        }
        return null;
    }
}
