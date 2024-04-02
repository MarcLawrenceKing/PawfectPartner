package com.app.model;

public class Pets {
    private int pet_id;
    private String pet_name;
    private int pet_age;   
    private String pet_breed;
    private String pet_prevState;
    private String pet_status;
    private int adopter_id;
    private int owner_id;
    
    public String getPet_name() {
        return pet_name;
    }
    public void setPet_name(String pet_name) {
        this.pet_name = pet_name;
    }
    public int getAdopter_id() {
        return adopter_id;
    }
    public void setAdopter_id(int adopter_id) {
        this.adopter_id = adopter_id;
    }
    public int getOwner_id() {
        return owner_id;
    }
    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }
    public int getPet_id() {
        return pet_id;
    }
    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }
    public int getPet_age() {
        return pet_age;
    }
    public void setPet_age(int pet_age) {
        this.pet_age = pet_age;
    }
    public String getPet_breed() {
        return pet_breed;
    }
    public void setPet_breed(String pet_breed) {
        this.pet_breed = pet_breed;
    }
    public String getPet_prevState() {
        return pet_prevState;
    }
    public void setPet_prevState(String pet_prevState) {
        this.pet_prevState = pet_prevState;
    }
    public String getPet_status() {
        return pet_status;
    }
    public void setPrev_status(String pet_status) {
        this.pet_status = pet_status;
    }
    
    
}
