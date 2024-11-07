package com.psuti.Server.entity.DissertationEnum;

import org.springframework.lang.Nullable;

public enum Layer {
    A("A"),
    B("B"),
    C("C"),
    D("D");

    private final String id;

    Layer(String id){this.id = id;}

    public String getId(){return id;}

    @Nullable
    public static Layer fromId(String id){
        for(Layer at : Layer.values()){
            if(at.getId().equals(id)){
                return at;
            }
        }
        return null;
    }
}
