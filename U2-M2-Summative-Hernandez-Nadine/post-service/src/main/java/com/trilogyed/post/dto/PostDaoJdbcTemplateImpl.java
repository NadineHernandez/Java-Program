package com.trilogyed.post.dto;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostDaoJdbcTemplateImpl implements PostDao {

    //prepared statements
    public static final String INSERT_POST_SQL =
            "INSERT INTO post (post_date, poster_name, post) VALUES (?, ?, ?)";

    public static final String SELECT_POST_SQL =
            "SELECT * FROM post WHERE post_id = ?";

    public static final String SELECT_ALL_POSTS_SQL =
            "SELECT * FROM post";

    public static final String SELECT_POSTS_BY_POSTER_SQL =
            "SELECT * FROM post WHERE poster_name = ?";

    public static final String UPDATE_POST_SQL =
            "UPDATE post SET post_date = ?, poster_name = ?, post = ? WHERE post_id = ?";

    public static final String DELETE_POST_SQL =
            "DELETE FROM post WHERE post_id = ?";

    private JdbcTemplate jdbcTemplate;

    public PostDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Post addPost(Post post) {
        jdbcTemplate.update(INSERT_POST_SQL, post.getPostDate(), post.getPosterName(), post.getPost());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        post.setPostID(id);
        return post;
    }

    @Override
    public Post getPost(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_POST_SQL, this::mapRowToPost, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Post> getAllPosts() {
        return jdbcTemplate.query(SELECT_ALL_POSTS_SQL, this::mapRowToPost);
    }

    @Override
    public List<Post> getPostsByPoster(String poster) {
        return jdbcTemplate.query(SELECT_POSTS_BY_POSTER_SQL, this::mapRowToPost, poster);
    }

    @Override
    public void updatePost(Post post) {
        jdbcTemplate.update(UPDATE_POST_SQL, post.getPostDate(), post.getPosterName(), post.getPost(), post.getPostID());
    }

    @Override
    public void deletePost(int id) {
        jdbcTemplate.update(DELETE_POST_SQL, id);
    }

    private Post mapRowToPost(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setPostID(rs.getInt("post_id"));
        post.setPostDate(rs.getDate("post_date").toLocalDate());
        post.setPosterName(rs.getString("poster_name"));
        post.setPost(rs.getString("post"));

        return post;
    }
}
