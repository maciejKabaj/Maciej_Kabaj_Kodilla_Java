package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

    private int users;
    private int posts;
    private int comments;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public int getUsers() {
        return users;
    }

    public int getPosts() {
        return posts;
    }

    public int getComments() {
        return comments;
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

    public void calculateAdvStatistics(Statistics statistics) {
        users = statistics.usersNames().size();
        posts = statistics.postsCount();
        comments = statistics.commentsCount();

        if (users > 0) {
            averagePostsPerUser = posts / (double) users;
            averageCommentsPerUser = comments / (double) users;
        }
        else {
            averagePostsPerUser = 0;
            averageCommentsPerUser = 0;
        }

        if (posts > 0) {
            averageCommentsPerPost = comments / (double) posts;
        }
        else {
            averageCommentsPerPost = 0;
        }
    }
}
