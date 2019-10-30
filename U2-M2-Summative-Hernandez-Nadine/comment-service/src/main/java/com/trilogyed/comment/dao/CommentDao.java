package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;

import java.util.List;

public interface CommentDao {
    //create comment
    public Comment addComment(Comment comment);

    //get comment by id
    public Comment getComment(int id);

    //get all comments
    public List<Comment> getAllComments();

    //get comments by post id
    public List<Comment> getCommentsByPostId(int postId);

    //update comment
    public void updateComment(Comment comment);

    //delete comment
    public void deleteComment(int id);
}
