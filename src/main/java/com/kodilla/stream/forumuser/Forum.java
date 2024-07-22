package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    List<ForumUser> forumUsers= new ArrayList<ForumUser>();
    public Forum() {
        forumUsers.add(new ForumUser(01, "Wojtek", 'M', LocalDate.of(1988,05,04), 8));
        forumUsers.add(new ForumUser(02, "Anna", 'F', LocalDate.of(1995,12,8), 7));
        forumUsers.add(new ForumUser(03, "Dorota", 'F', LocalDate.of(2003, 01,16), 16));
        forumUsers.add(new ForumUser(04, "Marcin", 'M', LocalDate.of(1999, 04,15), 10));
        forumUsers.add(new ForumUser(05, "Andrzej", 'M', LocalDate.of(2002, 11, 01), 0));
    }
    public List<ForumUser> getList() {
        return new ArrayList<>(forumUsers);
    }
}