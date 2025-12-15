package com.kanini;

public class Users {
    private String id;
    private String name;
    private int age;

    public Users(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + age;
    }
}
