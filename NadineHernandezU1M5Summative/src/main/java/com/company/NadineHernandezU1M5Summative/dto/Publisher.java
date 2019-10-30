package com.company.NadineHernandezU1M5Summative.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Publisher {
    //properties with validations matching schema
    private int publisher_id;
    @NotEmpty(message = "name cannot be empty")
    @Size(max = 50, message = "Cannot be more than 50 characters")
    private String name;
    @NotEmpty(message = "street cannot be empty")
    @Size(max = 50, message = "Cannot be more than 50 characters")
    private String street;
    @NotEmpty(message = "city cannot be empty")
    @Size(max = 50, message = "Cannot be more than 50 characters")
    private String city;
    @NotEmpty(message = "state cannot be empty")
    @Size(max = 50, message = "Cannot be more than 2 characters")
    private String state;
    @NotEmpty(message = "postal_code cannot be empty")
    @Size(max = 50, message = "Cannot be more than 25 characters")
    private String postal_code;
    @NotEmpty(message = "phone cannot be empty")
    @Size(max = 50, message = "Cannot be more than 15 characters")
    private String phone;
    @NotEmpty(message = "email cannot be empty")
    @Size(max = 50, message = "Cannot be more than 60 characters")
    private String email;

    //getters and setters
    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return publisher_id == publisher.publisher_id &&
                name.equals(publisher.name) &&
                street.equals(publisher.street) &&
                city.equals(publisher.city) &&
                state.equals(publisher.state) &&
                postal_code.equals(publisher.postal_code) &&
                phone.equals(publisher.phone) &&
                email.equals(publisher.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisher_id, name, street, city, state, postal_code, phone, email);
    }
}
