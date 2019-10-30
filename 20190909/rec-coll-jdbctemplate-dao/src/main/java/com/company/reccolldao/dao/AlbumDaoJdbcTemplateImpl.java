package com.company.reccolldao.dao;

import com.company.reccolldao.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AlbumDaoJdbcTemplateImpl implements AlbumDao {

    private static final String INSERT_ALBUM_SQL =
            "INSERT INTO album (title, artist_id, release_date, label_id, list_price) VALUES(?, ?, ?, ?, ?)";

    private static final String SELECT_ALBUM_SQL =
            "SELECT * FROM album WHERE album_id = ?";

    private static final String SELECT_ALL_ALBUMS_SQL =
            "SELECT * FROM album";

    private static final String UPDATE_ALBUM_SQL =
            "UPDATE album SET title = ?, artist_id = ?, release_date = ?, label_id =?, list_price = ? WHERE album_id = ?";

    private static final String DELETE_ALBUM_SQL =
            "DELETE FROM album WHERE album_id = ?";

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public AlbumDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Album addAlbum(Album album) {
        jdbcTemplate.update(INSERT_ALBUM_SQL, album.getTitle(), album.getArtistId(), album.getReleaseDate(), album.getLabelId(), album.getListPrice());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        album.setId(id);
        return album;
    }

    @Override
    @Transactional
    public Album getAlbum(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_ALBUM_SQL, this::mapRowToAlbum, id);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Album> getAllAlbums() {
        return jdbcTemplate.query(SELECT_ALL_ALBUMS_SQL, this::mapRowToAlbum);
    }

    @Override
    public void updateAlbum(Album album) {
        jdbcTemplate.update(UPDATE_ALBUM_SQL, album.getTitle(), album.getArtistId(),
                album.getReleaseDate(), album.getLabelId(), album.getListPrice(), album.getId());
    }

    @Override
    public void deleteAlbum(int id) {
        jdbcTemplate.update(DELETE_ALBUM_SQL, id);
    }

    public Album mapRowToAlbum(ResultSet rs, int rowNum) throws SQLException {
        Album album = new Album();
        album.setId(rs.getInt("album_id"));
        album.setTitle(rs.getString("title"));
        album.setArtistId(rs.getInt("artist_id"));
        album.setReleaseDate(rs.getDate("release_date").toLocalDate());
        album.setLabelId(rs.getInt("label_id"));
        album.setListPrice(rs.getBigDecimal("list_price"));

        return album;
    }
}
