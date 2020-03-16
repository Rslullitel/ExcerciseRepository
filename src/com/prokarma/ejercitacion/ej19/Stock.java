package com.prokarma.ejercitacion.ej19;

public class Stock {

    private int idSandwich;
    private int stockQuantity;

    public Stock(int id, int stock){
        this.idSandwich = id;
        this.stockQuantity = stock;
    }

    public int getIdSandwich() {
        return idSandwich;
    }

    public void setIdSandwich(int idSandwich) {
        this.idSandwich = idSandwich;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int cantStock) {
        this.stockQuantity = cantStock;
    }
}
