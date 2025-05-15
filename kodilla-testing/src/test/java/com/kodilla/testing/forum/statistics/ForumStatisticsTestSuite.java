package com.kodilla.testing.forum.statistics;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    private ForumStatistics forumStatistics;

    @BeforeEach
    void setup() {
        forumStatistics = new ForumStatistics();
        List<String> listWithTenUsers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listWithTenUsers.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(listWithTenUsers);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);
    }

    @Test
    void testCalculateAdvStatisticsWithZeroPosts() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(10, forumStatistics.getUsers());
        Assertions.assertEquals(0, forumStatistics.getPosts());
        Assertions.assertEquals(50, forumStatistics.getComments());
        Assertions.assertEquals(0, forumStatistics.getAveragePostsPerUser(), 0.001);
        Assertions.assertEquals(5, forumStatistics.getAverageCommentsPerUser(), 0.001);
        Assertions.assertEquals(0, forumStatistics.getAverageCommentsPerPost(), 0.001);
    }

    @Test
    void testCalculateAdvStatisticsWithThousandPosts() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(10, forumStatistics.getUsers());
        Assertions.assertEquals(1000, forumStatistics.getPosts());
        Assertions.assertEquals(50, forumStatistics.getComments());
        Assertions.assertEquals(100, forumStatistics.getAveragePostsPerUser(), 0.001);
        Assertions.assertEquals(5, forumStatistics.getAverageCommentsPerUser(), 0.001);
        Assertions.assertEquals(0.05, forumStatistics.getAverageCommentsPerPost(), 0.001);
    }

    @Test
    void testCalculateAdvStatisticsWithZeroComments() {
        //Given
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(10, forumStatistics.getUsers());
        Assertions.assertEquals(100, forumStatistics.getPosts());
        Assertions.assertEquals(0, forumStatistics.getComments());
        Assertions.assertEquals(10, forumStatistics.getAveragePostsPerUser(), 0.001);
        Assertions.assertEquals(0, forumStatistics.getAverageCommentsPerUser(), 0.001);
        Assertions.assertEquals(0, forumStatistics.getAverageCommentsPerPost(), 0.001);
    }

    @Test
    void testCalculateAdvStatisticsWhenCommentsAreLessThanPosts() {
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertTrue(forumStatistics.getComments() < forumStatistics.getPosts());
        Assertions.assertEquals(10, forumStatistics.getUsers());
        Assertions.assertEquals(100, forumStatistics.getPosts());
        Assertions.assertEquals(50, forumStatistics.getComments());
        Assertions.assertEquals(10, forumStatistics.getAveragePostsPerUser(), 0.001);
        Assertions.assertEquals(5, forumStatistics.getAverageCommentsPerUser(), 0.001);
        Assertions.assertEquals(0.5, forumStatistics.getAverageCommentsPerPost(), 0.001);
    }

    @Test
    void testCalculateAdvStatisticsWhenCommentsAreMoreThanPosts() {
        //Given
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.postsCount()).thenReturn(50);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertTrue(forumStatistics.getComments() > forumStatistics.getPosts());
        Assertions.assertEquals(10, forumStatistics.getUsers());
        Assertions.assertEquals(50, forumStatistics.getPosts());
        Assertions.assertEquals(100, forumStatistics.getComments());
        Assertions.assertEquals(5, forumStatistics.getAveragePostsPerUser(), 0.001);
        Assertions.assertEquals(10, forumStatistics.getAverageCommentsPerUser(), 0.001);
        Assertions.assertEquals(2, forumStatistics.getAverageCommentsPerPost(), 0.001);
    }

    @Test
    void testCalculateAdvStatisticsWithZeroUsers() {
        //Given
        List<String> emptyList = Collections.emptyList();
        when(statisticsMock.usersNames()).thenReturn(emptyList);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(0, forumStatistics.getUsers());
        Assertions.assertEquals(100, forumStatistics.getPosts());
        Assertions.assertEquals(50, forumStatistics.getComments());
        Assertions.assertEquals(0, forumStatistics.getAveragePostsPerUser(), 0.001);
        Assertions.assertEquals(0, forumStatistics.getAverageCommentsPerUser(), 0.001);
        Assertions.assertEquals(0.5, forumStatistics.getAverageCommentsPerPost(), 0.001);
    }

    @Test
    void testCalculateAdvStatisticsWithHundredUsers() {
        //Given
        List<String> listWithHundredUsers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listWithHundredUsers.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(listWithHundredUsers);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(100, forumStatistics.getUsers());
        Assertions.assertEquals(100, forumStatistics.getPosts());
        Assertions.assertEquals(50, forumStatistics.getComments());
        Assertions.assertEquals(1, forumStatistics.getAveragePostsPerUser(), 0.001);
        Assertions.assertEquals(0.5, forumStatistics.getAverageCommentsPerUser(), 0.001);
        Assertions.assertEquals(0.5, forumStatistics.getAverageCommentsPerPost(), 0.001);
    }
}
