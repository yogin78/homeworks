package com.kodilla.stream.immutable;

public class ForumUser {

    private final String name = "name";
    private final String  realName = "real name";

    private String getName() {
        return name;
    }

    private String getRealName() {
        return realName;
    }

    public ForumUser(String name, String realName){};
}
