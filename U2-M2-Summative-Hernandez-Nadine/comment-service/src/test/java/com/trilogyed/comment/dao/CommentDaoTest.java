package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommentDaoTest {

    @Autowired
    CommentDao commentDao;

    @Before
    public void setUp() throws Exception {
        List<Comment> tasks = commentDao.getAllComments();
        tasks.stream()
                .forEach(comment -> commentDao.deleteComment(comment.getCommentId()));
    }

    @Test
    public void addComment() {
        Comment comment = new Comment(1, LocalDate.of(2019, 7, 30),
                "Sample Name", "Sample Comment");

        comment = commentDao.addComment(comment);

        assertEquals(comment, commentDao.getComment(comment.getCommentId()));
    }

    @Test
    public void getComment() {
        Comment comment = new Comment(1, LocalDate.of(2019, 7, 30),
                "Sample Name", "Sample Comment");

        comment = commentDao.addComment(comment);
        Comment fromDao = commentDao.getComment(comment.getCommentId());

        assertEquals(comment, fromDao);
    }

    @Test
    public void getAllComments() {
        Comment comment = new Comment(1, LocalDate.of(2019, 7, 30),
                "Sample Name", "Sample Comment");

        comment = commentDao.addComment(comment);

        assertEquals(1, commentDao.getAllComments().size());
        assertEquals(comment, commentDao.getAllComments().get(0));
    }

    @Test
    public void getCommentsByPostId() {
        Comment comment = new Comment(1, LocalDate.of(2019, 7, 30),
                "Sample Name", "Sample Comment");

        comment = commentDao.addComment(comment);
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        assertEquals(comments, commentDao.getCommentsByPostId(comment.getPostId()));
    }

    @Test
    public void updateComment() {
        Comment comment = new Comment(1, LocalDate.of(2019, 7, 30),
                "Sample Name", "Sample Comment");

        comment = commentDao.addComment(comment);

        comment.setPostId(2);
        comment.setCreateDate(LocalDate.of(2019, 8, 30));
        comment.setCommenterName("Updated Name");
        comment.setComment("Updated Comment");

        commentDao.updateComment(comment);

        assertEquals(comment, commentDao.getComment(comment.getCommentId()));
    }

    @Test
    public void deleteComment() {
        Comment comment = new Comment(1, LocalDate.of(2019, 7, 30),
                "Sample Name", "Sample Comment");

        comment = commentDao.addComment(comment);
        commentDao.deleteComment(comment.getCommentId());

        assertNull(commentDao.getComment(comment.getCommentId()));
    }
}