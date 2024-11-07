package com.psuti.Server.entity.DissertationEnum;

import org.springframework.lang.Nullable;

public enum Category {

    A("A"),
    B("B"),
    C("C"),
    D("D");

    private final String id;

    Category(String id){this.id = id;}

    public String getId(){return id;}

    @Nullable
    public static Category fromId(String id){
        for(Category at : Category.values()){
            if(at.getId().equals(id)){
                return at;
            }
        }
        return null;
    }
}
