package com.psuti.Server.entity.DissertationEntityes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table (name = "dpn")
public class DPN implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(length = 25,name = "name")
    private String name;

    @Column(length = 25,name = "dpnName")
    private String dpnName;

}
