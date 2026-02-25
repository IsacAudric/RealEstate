package model;

import java.util.UUID;

public class Property {
    private final String id; // UUID textual
    private String title;
    private String address;
    private double price;
    private Owner owner;

    public Property(String title, String address, double price, Owner owner) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.address = address;
        this.price = price;
        this.owner = owner;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public Owner getOwner() { return owner; }
    public void setOwner(Owner owner) { this.owner = owner; }

    @Override
    public String toString() {
        return String.format("Property{id=%s, title='%s', address='%s', price=%.2f, owner=%s}",
                id, title, address, price, owner != null ? owner.getName() : "null");
    }
}