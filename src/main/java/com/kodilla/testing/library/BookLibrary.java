package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookLibrary {
    LibraryDatabase libraryDatabase;

    private Map<LibraryUser, List<String>> booksInHandsOfUsers = new HashMap<>();

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public BookLibrary() {

    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase
                .listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }

    public List<String> listBooksInHandsOf(LibraryUser libraryUser) {
        return booksInHandsOfUsers.getOrDefault(libraryUser, new ArrayList<>());
    }

    public void addBooksToUser(LibraryUser libraryUser, List<String> books) {
        booksInHandsOfUsers.put(libraryUser, books);
    }
}