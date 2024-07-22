package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ForumStatistics Test Suite")
public class ForumStatisticsTestSuite {
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;

    @BeforeEach
    public void setUp() {
        statisticsMock = Mockito.mock(Statistics.class);
        forumStatistics = new ForumStatistics(statisticsMock);
    }

    @Test
    @DisplayName("Test calculateAdvStatistics with 0 posts")
    public void testCalculateAdvStatisticsZeroPosts() {
        // Given
        List<String> usersList = generateUserList(100);
        Mockito.when(statisticsMock.usersNames()).thenReturn(usersList);
        Mockito.when(statisticsMock.postsCount()).thenReturn(0);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(500);

        // When
        forumStatistics.calculateAdvStatistics();

        // Then
        assertEquals(100, forumStatistics.getNumberOfUsers());
        assertEquals(0, forumStatistics.getNumberOfPosts());
        assertEquals(500, forumStatistics.getNumberOfComments());
        assertEquals(0, forumStatistics.getAveragePostsPerUser());
        assertEquals(5.0, forumStatistics.getAverageCommentsPerUser());
        assertEquals(0, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    @DisplayName("Test calculateAdvStatistics with 1000 posts")
    public void testCalculateAdvStatisticsThousandPosts() {
        // Given
        List<String> usersList = generateUserList(100);
        Mockito.when(statisticsMock.usersNames()).thenReturn(usersList);
        Mockito.when(statisticsMock.postsCount()).thenReturn(1000);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(500);

        // When
        forumStatistics.calculateAdvStatistics();

        // Then
        assertEquals(100, forumStatistics.getNumberOfUsers());
        assertEquals(1000, forumStatistics.getNumberOfPosts());
        assertEquals(500, forumStatistics.getNumberOfComments());
        assertEquals(10.0, forumStatistics.getAveragePostsPerUser());
        assertEquals(5.0, forumStatistics.getAverageCommentsPerUser());
        assertEquals(0.5, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    @DisplayName("Test calculateAdvStatistics with 0 comments")
    public void testCalculateAdvStatisticsZeroComments() {
        // Given
        List<String> usersList = generateUserList(100);
        Mockito.when(statisticsMock.usersNames()).thenReturn(usersList);
        Mockito.when(statisticsMock.postsCount()).thenReturn(1000);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(0);

        // When
        forumStatistics.calculateAdvStatistics();

        // Then
        assertEquals(100, forumStatistics.getNumberOfUsers());
        assertEquals(1000, forumStatistics.getNumberOfPosts());
        assertEquals(0, forumStatistics.getNumberOfComments());
        assertEquals(10.0, forumStatistics.getAveragePostsPerUser());
        assertEquals(0.0, forumStatistics.getAverageCommentsPerUser());
        assertEquals(0.0, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    @DisplayName("Test calculateAdvStatistics with comments less than posts")
    public void testCalculateAdvStatisticsCommentsLessThanPosts() {
        // Given
        List<String> usersList = generateUserList(100);
        Mockito.when(statisticsMock.usersNames()).thenReturn(usersList);
        Mockito.when(statisticsMock.postsCount()).thenReturn(1000);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(500);

        // When
        forumStatistics.calculateAdvStatistics();

        // Then
        assertEquals(100, forumStatistics.getNumberOfUsers());
        assertEquals(1000, forumStatistics.getNumberOfPosts());
        assertEquals(500, forumStatistics.getNumberOfComments());
        assertEquals(10.0, forumStatistics.getAveragePostsPerUser());
        assertEquals(5.0, forumStatistics.getAverageCommentsPerUser());
        assertEquals(0.5, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    @DisplayName("Test calculateAdvStatistics with comments greater than posts")
    public void testCalculateAdvStatisticsCommentsGreaterThanPosts() {
        // Given
        List<String> usersList = generateUserList(100);
        Mockito.when(statisticsMock.usersNames()).thenReturn(usersList);
        Mockito.when(statisticsMock.postsCount()).thenReturn(1000);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(2000);

        // When
        forumStatistics.calculateAdvStatistics();

        // Then
        assertEquals(100, forumStatistics.getNumberOfUsers());
        assertEquals(1000, forumStatistics.getNumberOfPosts());
        assertEquals(2000, forumStatistics.getNumberOfComments());
        assertEquals(10.0, forumStatistics.getAveragePostsPerUser());
        assertEquals(20.0, forumStatistics.getAverageCommentsPerUser());
        assertEquals(2.0, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    @DisplayName("Test calculateAdvStatistics with 0 users")
    public void testCalculateAdvStatisticsZeroUsers() {
        // Given
        List<String> usersList = new ArrayList<>();
        Mockito.when(statisticsMock.usersNames()).thenReturn(usersList);
        Mockito.when(statisticsMock.postsCount()).thenReturn(1000);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(500);

        // When
        forumStatistics.calculateAdvStatistics();

        // Then
        assertEquals(0, forumStatistics.getNumberOfUsers());
        assertEquals(1000, forumStatistics.getNumberOfPosts());
        assertEquals(500, forumStatistics.getNumberOfComments());
        assertEquals(0, forumStatistics.getAveragePostsPerUser());
        assertEquals(0, forumStatistics.getAverageCommentsPerUser());
        assertEquals(0.5, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    @DisplayName("Test calculateAdvStatistics with 100 users")
    public void testCalculateAdvStatisticsHundredUsers() {
        // Given
        List<String> usersList = generateUserList(100);
        Mockito.when(statisticsMock.usersNames()).thenReturn(usersList);
        Mockito.when(statisticsMock.postsCount()).thenReturn(1000);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(500);

        // When
        forumStatistics.calculateAdvStatistics();

        // Then
        assertEquals(100, forumStatistics.getNumberOfUsers());
        assertEquals(1000, forumStatistics.getNumberOfPosts());
        assertEquals(500, forumStatistics.getNumberOfComments());
        assertEquals(10.0, forumStatistics.getAveragePostsPerUser());
        assertEquals(5.0, forumStatistics.getAverageCommentsPerUser());
        assertEquals(0.5, forumStatistics.getAverageCommentsPerPost());
    }

    private List<String> generateUserList(int numberOfUsers) {
        List<String> usersList = new ArrayList<>();
        for (int i = 0; i < numberOfUsers; i++) {
            usersList.add("User" + i);
        }
        return usersList;
    }
}
