package com.app.model;

public class Pets {// wagpansininito
    // instance variable
    private int pet_id;
    private String pet_type;
    private String pet_name;
    private int pet_age;
    private String pet_breed;
    private String pet_prevState;
    private String pet_status;
    private int adopter_id;
    private int owner_id;

    public Pets() { // default constructor

    }

    // initialized constructor
    public Pets(int pet_id, String pet_type, String pet_name, int pet_age, String pet_breed, String pet_prevState,
            String pet_status, int adopter_id, int owner_id) {
        this.pet_id = pet_id;
        this.pet_type = pet_type;
        this.pet_name = pet_name;
        this.pet_age = pet_age;
        this.pet_breed = pet_breed;
        this.pet_prevState = pet_prevState;
        this.pet_status = pet_status;
        this.adopter_id = adopter_id;
        this.owner_id = owner_id;
    }

    // setters and getters

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public String getPet_type() {
        return pet_type;
    }

    public void setPet_type(String pet_type) {
        this.pet_type = pet_type;
    }

    public String getPet_name() {
        return pet_name;
    }

    public void setPet_name(String pet_name) {
        this.pet_name = pet_name;
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

    public void setPet_status(String pet_status) {
        this.pet_status = pet_status;
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


}
