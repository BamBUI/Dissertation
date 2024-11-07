package com.psuti.Server.entity.DissertationEntityes;

import com.psuti.Server.entity.DissertationEnum.Category;
import lombok.Getter;
import lombok.Setter;
import com.psuti.Server.entity.DissertationEnum.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "information")
public class Information implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(length = 25,name = "createdBy")
    private String createdBy;

    @Column(length = 25,name = "codename")
    private String codename;

    @Column(length = 25,name = "CreationDate")
    private Date CreationDate;

    @Column(length = 25,name = "author")
    private String author;

    @Column(length = 25,name = "customer")
    private String customer;

    @Column(length = 25,name = "platform")
    private String platform;

    @Column(length = 25,name = "model")
    private String model;

    @Column(length = 25,name = "modelYear")
    private String modelYear;

    @Column(length = 25,name = "type")
    private String type;

    @Column(length = 25,name = "partNumber")
    private String partNumber;

    @Column(length = 25,name = "description_1")
    private String description_1;

    @Column(length = 25,name = "description_2")
    private String description_2;

    @Column(length = 25,name = "drawingDate")
    private Date drawingDate;

    @Column(length = 25,name = "wirelistImportDate")
    private Date wirelistImportDate;

    @Column(length = 25,name = "designerName")
    private String designerName;

    @Column(length = 25,name = "settings")
    private String settings;

    @Column(length = 25,name = "gsdData")
    private String gsdData;

    @Column(length = 25,name = "customerData")
    private String customerData;

    @Column(length = 25,name = "harnessFactor")
    private String harnessFactor;

    @Column(length = 25,name = "wireLengthRange")
    private String wireLengthRange;

    @Column(length = 25,name = "general")
    private String general;

    @Column(length = 25,name = "inhouseTwistedWire")
    private String inhouseTwistedWire;

    @Column(length = 25,name = "purchasedTwistedWire")
    private String purchasedTwistedWire;

    @Column(length = 25,name = "atConnector")
    private String atConnector;

    @Column(length = 25,name = "atRingterminal")
    private String atRingterminal;

    @Column(length = 25,name = "atDangler")
    private String atDangler;

    @Column(length = 25,name = "atUltrasonicSplice")
    private String atUltrasonicSplice;

    @Column(length = 25,name = "atUCABSplice")
    private String atUCABSplice;

    @Column(length = 25,name = "atBlunt")
    private String atBlunt;

    @Column(length = 25,name = "junctionNodesOnRoute")
    private String junctionNodesOnRoute;

    @Column(length = 25,name = "wirebridgeLength")
    private String wirebridgeLength;

    @Column(length = 25,name = "atNodeWithSplice")
    private String atNodeWithSplice;

    @Column(length = 25,name = "atNodeWithClip")
    private String atNodeWithClip;

    @Column(length = 25,name = "atBreakoutNode")
    private String atBreakoutNode;

    @Column(length = 25,name = "atOtherNodes")
    private String atOtherNodes;

    @Column(length = 25,name = "fullTape")
    private String fullTape;

    @Column(length = 25,name = "solidTape")
    private String solidTape;

    @Column(length = 25,name = "spiralTape")
    private String spiralTape;

    @Column(length = 25,name = "spaceTape")
    private String spaceTape;

    @Column(length = 25,name = "tube")
    private String tube;

    @Column(length = 25,name = "sleeve")
    private String sleeve;

    @Column(length = 25,name = "conduit")
    private String conduit;

    //region should be enum

    @Column (name = "region")
    private String region;

    public Region getRegion() {
        return region == null ? null : Region.fromId(region);
    }

    public void setRegion(Region region) {
        this.region = region == null ? null :  region.getId();
    }
}
