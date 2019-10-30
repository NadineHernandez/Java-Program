package com.trilogyed.comment.dto;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CommentDaoJdbcTemplateImpl implements CommentDao {

    //prepared statements
    public static final String INSERT_COMMENT_SQL =
            "INSERT INTO comment (post_id, create_date, commenter_name, comment) VALUES (?, ?, ?, ?)";
    public static final String SELECT_COMMENT_SQL =
            "SELECT * FROM comment WHERE comment_id = ?";
    public static final String SELECT_ALL_COMMENTS_SQL =
            "SELECT * FROM comment";
    public static final String SELECT_COMMENT_BY_POST_SQL =
            "SELECT * FROM comment WHERE post_id = ?";
    public static final String UPDATE_COMMENT =
            "UPDATE comment SET post_id = ?, create_date = ?, commenter_name = ?, comment = ? WHERE comment_id = ?";
    public static final String DELETE_COMMENT =
            "DELETE FROM comment WHERE comment_id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CommentDaoJdbcTemplateImpl (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Comment addComment(Comment comment) {
        jdbcTemplate.update(INSERT_COMMENT_SQL, comment.getPostId(), comment.getCreateDate(),
                comment.getCommenterName(), comment.getComment());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        comment.setCommentId(id);
        return comment;
    }

    @Override
    public Comment getComment(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_COMMENT_SQL, this::mapToRowComment, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Comment> getAllComments() {
        return jdbcTemplate.query(SELECT_ALL_COMMENTS_SQL, this::mapToRowComment);
    }

    @Override
    public List<Comment> getCommentsByPostId(int postId) {
        return jdbcTemplate.query(SELECT_COMMENT_BY_POST_SQL, this::mapToRowComment, postId);
    }

    @Override
    public void updateComment(Comment comment) {
        jdbcTemplate.update(UPDATE_COMMENT, comment.getPostId(), comment.getCreateDate(),
                comment.getCommenterName(), comment.getComment(), comment.getCommentId());
    }

    @Override
    public void deleteComment(int id) {
        jdbcTemplate.update(DELETE_COMMENT, id);
    }

    private Comment mapToRowComment(ResultSet rs, int rowNum) throws SQLException{
        Comment comment = new Comment();
        comment.setCommentId(rs.getInt("comment_id"));
        comment.setPostId(rs.getInt("post_id"));
        comment.setCreateDate(rs.getDate("create_date").toLocalDate());
        comment.setCommenterName(rs.getString("commenter_name"));
        comment.setComment(rs.getString("comment"));

        return comment;
    }
}
