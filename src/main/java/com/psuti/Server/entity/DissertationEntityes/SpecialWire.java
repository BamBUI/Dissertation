package com.psuti.Server.entity.DissertationEntityes;

import com.psuti.Server.entity.DissertationEnum.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "specialWire")
public class SpecialWire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
/*
    @OneToOne(targetEntity = CPN.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "specialWireCPN")
    private CPN specialWireCPN;

    @OneToOne(targetEntity = DPN.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "specialWireDPN")
    private DPN specialWireDPN;

    @OneToOne(targetEntity = CPN.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "cpnName")
    private CPN cpn;

    @OneToOne(targetEntity = DPN.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "dpnName")
    private DPN dpn;

 */
    @Column(length = 25,name = "name")
    private String name;

    @Column(length = 125,name = "description")
    private String description;

    @Column(length = 125,name = "supplierPN")
    private String supplierPN;

    @Column(length = 125,name = "supplier")
    private String supplier;

    @Column(length = 20,name = "quantity")
    private int quantity;

    @Column (name = "category")
    private String category;

    @Column (name = "layer")
    private String layer;

    @Column (name = "options")
    private String options;

    @Column (name = "partType")
    private String partType;

    @Column (name = "unit")
    private String unit;

    public Category getCategory() {
        return category == null ? null : Category.fromId(category);
    }

    public void setCategory(Category category) {
        this.category = category == null ? null :  category.getId();
    }

    public Layer getLayer() {
        return category == null ? null : Layer.fromId(layer);
    }

    public void setLayer(Layer layer) {
        this.layer = layer == null ? null :  layer.getId();
    }

    public Options getOptions() {
        return options == null ? null : Options.fromId(options);
    }

    public void setOptions(Options options) {
        this.options = options == null ? null :  options.getId();
    }

    public PartType getPartType() {
        return partType == null ? null : PartType.fromId(partType);
    }

    public void setOptions(PartType partType) {
        this.partType = partType == null ? null :  partType.getId();
    }

    public Unit getUnit() {
        return unit == null ? null : Unit.fromId(unit);
    }

    public void setUnit(Unit unit) {
        this.unit = unit == null ? null :  unit.getId();
    }

}
