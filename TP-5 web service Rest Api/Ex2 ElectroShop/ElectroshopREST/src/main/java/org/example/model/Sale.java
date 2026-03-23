package org.example.model;

public class Sale {

    private Long id;
    private String date;
    private String product;
    private int quantity;
    private double price;
    private double total;
    private String customer;
    private String region;

    public Sale() {}

    public Long getId() { return id; }
    public String getDate() { return date; }
    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public double getTotal() { return total; }
    public String getCustomer() { return customer; }
    public String getRegion() { return region; }

    public void setId(Long id) { this.id = id; }
    public void setDate(String date) { this.date = date; }
    public void setProduct(String product) { this.product = product; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }
    public void setTotal(double total) { this.total = total; }
    public void setCustomer(String customer) { this.customer = customer; }
    public void setRegion(String region) { this.region = region; }
}