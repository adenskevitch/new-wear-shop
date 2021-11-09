package com.solvd.newwearshop;

public abstract class Product {

    protected ProductType productName;
    protected Double productCost;

    public Product(ProductType productName) {
        switch (productName) {
            case PANTS:
                this.productCost = 100.00;
                break;
            case OUTERWEAR:
                this.productCost = 200.00;
                break;
            case SHIRT:
                this.productCost = 50.00;
                break;
            case SUNGLASSES:
                this.productCost = 60.00;
                break;
            default:
                this.productCost = 0.00;
        }
        this.productName = productName;
    }

    public ProductType getProductType() {
        return productName;
    }

    public void setProductType(ProductType productName) {
        this.productName = productName;
    }

    public Double getProductCost() {
        return productCost;
    }

    public void setProductCost(Double productCost) {
        this.productCost = productCost;
    }
}