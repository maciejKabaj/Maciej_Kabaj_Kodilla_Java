package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;
import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {

    User userMillenial;
    User userYGen;
    User userZGen;

    @BeforeEach
    void setUp() {
        userMillenial = new Millenials("John Smith");
        userYGen = new YGeneration("James Bound");
        userZGen = new ZGeneration("Sabrina Woodworker");
    }

    @Test
    void testDefaultSharingStrategies() {
        //Given
        //When
        String userMillenialShouldPost = userMillenial.sharePost();
        String userYGenShouldPost = userYGen.sharePost();
        String userZGenShouldPost = userZGen.sharePost();
        //Then
        assertEquals("Posting stuff on Facebook!", userMillenialShouldPost);
        assertEquals("Posting stuff on Snapchat!", userYGenShouldPost);
        assertEquals("Posting stuff on Twitter!", userZGenShouldPost);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        userMillenial.setSocialPublisher(new SnapchatPublisher());
        userYGen.setSocialPublisher(new TwitterPublisher());
        userZGen.setSocialPublisher(new FacebookPublisher());
        //When
        String userMillenialShouldPost = userMillenial.sharePost();
        String userYGenShouldPost = userYGen.sharePost();
        String userZGenShouldPost = userZGen.sharePost();
        //Then
        assertEquals("Posting stuff on Snapchat!", userMillenialShouldPost);
        assertEquals("Posting stuff on Twitter!", userYGenShouldPost);
        assertEquals("Posting stuff on Facebook!", userZGenShouldPost);
    }
}
