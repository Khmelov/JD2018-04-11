package by.it.kasiyanov.jd03_03.beans;

public class TravelOffers {
    long id;
    String description;
    String typeOfTravel;
    String destination;
	String hotel;
	String levelOfAccommodation;
	int numberOfNights;
	double price;
    long users_id;

    public TravelOffers() {
    }

    public TravelOffers(long id, String description, String typeOfTravel, String destination,
                        String hotel, String levelOfAccommodation, int numberOfNights, double price, long users_id) {
        this.id = id;
        this.description = description;
        this.typeOfTravel = typeOfTravel;
        this.destination = destination;
        this.hotel = hotel;
        this.levelOfAccommodation = levelOfAccommodation;
        this.numberOfNights = numberOfNights;
        this.price = price;
        this.users_id = users_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOfTravel() {
        return typeOfTravel;
    }

    public void setTypeOfTravel(String typeOfTravel) {
        this.typeOfTravel = typeOfTravel;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getLevelOfAccommodation() {
        return levelOfAccommodation;
    }

    public void setLevelOfAccommodation(String levelOfAccommodation) {
        this.levelOfAccommodation = levelOfAccommodation;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "TravelOffers{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", typeOfTravel='" + typeOfTravel + '\'' +
                ", destination='" + destination + '\'' +
                ", hotel='" + hotel + '\'' +
                ", levelOfAccommodation='" + levelOfAccommodation + '\'' +
                ", numberOfNights=" + numberOfNights +
                ", price=" + price +
                ", users_id=" + users_id +
                '}';
    }
}
