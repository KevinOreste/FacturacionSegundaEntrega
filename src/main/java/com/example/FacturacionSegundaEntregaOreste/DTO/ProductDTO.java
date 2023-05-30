package com.example.FacturacionSegundaEntregaOreste.DTO;

public class ProductDTO {
    private String description;
    private String code;
    private int stock;
    private double price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
