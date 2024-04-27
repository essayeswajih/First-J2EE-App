package com.example.frist_j2ee_app.models;


import java.io.Serializable;

public class Student implements Serializable {

    private int id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(int id,String name, int age) {
        this.id=id;
        this.name = name;
        this.age = age;
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
