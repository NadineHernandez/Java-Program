package com.company.reccolldao.ViewModel;

import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AlbumViewModel {
    private int id;
    private String title;
    private LocalDate releaseDate;
    private BigDecimal listPrice;
    private Artist artist = new Artist();
    private Label label = new Label();
    private List<Track> trackList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumViewModel that = (AlbumViewModel) o;
        return id == that.id &&
                title.equals(that.title) &&
                releaseDate.equals(that.releaseDate) &&
                listPrice.equals(that.listPrice) &&
                artist.equals(that.artist) &&
                label.equals(that.label) &&
                trackList.equals(that.trackList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseDate, listPrice, artist, label, trackList);
    }
}
