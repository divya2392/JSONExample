package com.corvi.jsonapicallexample;

/**
 * Created by divya on 19/04/17.
 */

public class Model {

    String bookId;
    String name;
    String price;
    String inStock;

    public Model() {
    }

    public Model(String bookId, String name, String price, String inStock) {
        this.bookId = bookId;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Model{" +
                "bookId='" + bookId + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", inStock='" + inStock + '\'' +
                '}';
    }
}
