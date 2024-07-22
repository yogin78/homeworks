package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private int id;
    private String name;
    private char gender;
    private LocalDate birthDate;
    private int numberOfPosts;

    public ForumUser(int id, String name, char gender, LocalDate birthDate, int numberOfPosts) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.numberOfPosts = numberOfPosts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }
}