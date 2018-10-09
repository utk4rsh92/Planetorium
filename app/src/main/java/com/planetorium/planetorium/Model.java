package com.planetorium.planetorium;

public class Model {
    String name;
    String details;
    String description;
    String imageurl;

    String fact1;
    String fact2;
    String fact3;
    String fact4;
    String fact5;
    String fact6;
    String fact7;
    Model(String name,String details, String description,String imageurl,String fact1,String fact2,String fact3,String fact4,String fact5,String fact6,String fact7){
        this.name = name;
        this.details = details;
        this.description = description;
        this.imageurl = imageurl;
        this.fact1 = fact1;
        this.fact2 = fact2;
        this.fact3 = fact3;
        this.fact4 = fact4;
        this.fact5 = fact5;
        this.fact6 = fact6;
        this.fact7 = fact7;
    }



    public String getFact1() {
        return fact1;
    }

    public Model setFact1(String fact1) {
        this.fact1 = fact1;
        return this;
    }

    public String getFact2() {
        return fact2;
    }

    public Model setFact2(String fact2) {
        this.fact2 = fact2;
        return this;
    }

    public String getFact3() {
        return fact3;
    }

    public Model setFact3(String fact3) {
        this.fact3 = fact3;
        return this;
    }

    public String getFact4() {
        return fact4;
    }

    public Model setFact4(String fact4) {
        this.fact4 = fact4;
        return this;
    }

    public String getFact5() {
        return fact5;
    }

    public Model setFact5(String fact5) {
        this.fact5 = fact5;
        return this;
    }

    public String getFact6() {
        return fact6;
    }

    public Model setFact6(String fact6) {
        this.fact6 = fact6;
        return this;
    }

    public String getFact7() {
        return fact7;
    }

    public Model setFact7(String fact7) {
        this.fact7 = fact7;
        return this;
    }



    public String getName() {
        return name;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public Model setDetails(String details) {
        this.details = details;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Model setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageurl() {
        return imageurl;
    }

    public Model setImageurl(String imageurl) {
        this.imageurl = imageurl;
        return this;
    }
}
