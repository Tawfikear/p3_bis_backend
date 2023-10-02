package com.formationspring.sncfchatp3.domain;

public class User {



    private Long id;
    private String name;
    private String firstname;
    private int age;



    public User() {
    }

    public User(String name, String firstname, int age) {
        this.name = name;
        this.firstname = firstname;
        this.age = age;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public boolean isMinored() {
        return age <18;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
