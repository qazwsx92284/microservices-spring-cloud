package com.infybuzz.response;

//This is just to json to our pojo class
//Whatever json response we will get from te address service,
// that will convert into this particular object which is AddressResponse model class.
public class AddressResponse {

    private long addressId;
    private String street;
    private String city;


    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
