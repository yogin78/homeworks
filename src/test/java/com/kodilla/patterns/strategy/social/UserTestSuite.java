package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void testDefaultStrategy() {
        // Given
        User john = new Millenials("John Doe");
        User jane = new YGeneration("Jane Smith");
        User emily = new ZGeneration("Emily Johnson");

        // When
        String johnPost = john.sharePost();
        String janePost = jane.sharePost();
        String emilyPost = emily.sharePost();

        // Then
        assertEquals("Sharing post on Facebook", johnPost);
        assertEquals("Sharing post on Twitter", janePost);
        assertEquals("Sharing post on Snapchat", emilyPost);
    }

    @Test
    void testStrategyCanBeChanged() {
        // Given
        User john = new Millenials("John Doe");
        User jane = new YGeneration("Jane Smith");

        // When
        john.setSocialPublisher(new TwitterPublisher());
        jane.setSocialPublisher(new SnapchatPublisher());

        String johnPost = john.sharePost();
        String janePost = jane.sharePost();

        // Then
        assertEquals("Sharing post on Twitter", johnPost);  // John now uses Twitter
        assertEquals("Sharing post on Snapchat", janePost);  // Jane now uses Snapchat
    }
}
