package com.solvd.newwearshop.product;

import com.solvd.newwearshop.Buyer;

import java.util.Map;

public class FabricParameter {

    private Color colorClothes;
    private Fabric materialClothes;
    private Map<String, Integer> size;


    public FabricParameter(Color colorClothes, Fabric materialClothes, Buyer buyer) {
        this.colorClothes = colorClothes;
        this.materialClothes = materialClothes;
        this.size = buyer.getSizes();
    }

    public Color getColorClothes() {
        return colorClothes;
    }

    public void setColorClothes(Color colorClothes) {
        this.colorClothes = colorClothes;
    }

    public Fabric getMaterialClothes() {
        return materialClothes;
    }

    public void setMaterialClothes(Fabric materialClothes) {
        this.materialClothes = materialClothes;
    }

    public Map<String, Integer> getSize() {
        return size;
    }

    public void setSize(Map<String, Integer> size) {
        this.size = size;
    }
}
