package com.kodilla.testing.forum.statistics;

import java.util.List;

public class ForumStatistics  {
    private Statistics statistics;
    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public ForumStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics() {
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();

        if (numberOfUsers > 0) {
            averagePostsPerUser = (double) numberOfPosts / numberOfUsers;
            averageCommentsPerUser = (double) numberOfComments / numberOfUsers;
        } else {
            averagePostsPerUser = 0;
            averageCommentsPerUser = 0;
        }

        if (numberOfPosts > 0) {
            averageCommentsPerPost = (double) numberOfComments / numberOfPosts;
        } else {
            averageCommentsPerPost = 0;
        }
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}
