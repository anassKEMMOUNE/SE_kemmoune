package MainPackage;

import java.lang.String;

public class Trip {
	private long id;
    private String departure;
    private String destination;
    private double price;


    public Trip(long id, String departure, String destination, double price) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;

    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return departure;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "\t" + departure + "\t" + destination + "\t" + price;
    }
}	

