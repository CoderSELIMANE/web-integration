package rmiAnalytics;

import java.io.Serializable;
import java.util.Date;

public class Vente implements Serializable {

    private int saleId;
    private String product;
    private String region;
    private double amount;
    private Date date;

    public Vente(int saleId, String product, String region, double amount, Date date) {
        this.saleId = saleId;
        this.product = product;
        this.region = region;
        this.amount = amount;
        this.date = date;
    }

    public int getSaleId() { return saleId; }
    public String getProduct() { return product; }
    public String getRegion() { return region; }
    public double getAmount() { return amount; }
    public Date getDate() { return date; }
    
}