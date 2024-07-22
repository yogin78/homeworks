package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamMain {

    public static void main(String[] args) {
        Forum forumUsers = new Forum();

        LocalDate today = LocalDate.now();

        Map<Integer, ForumUser> theResultList= forumUsers.getList().stream()
                .filter(user -> user.getNumberOfPosts() > 0)
                .filter(user-> user.getGender() == 'M')
                .filter(user -> Period.between(user.getBirthDate(), today).getYears( )>20)
                .collect(Collectors.toMap(ForumUser::getId, ForumUser -> ForumUser));             // [1]

        theResultList.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())                   // [3]
                .forEach(System.out::println);                                            // [4]
    }
}
