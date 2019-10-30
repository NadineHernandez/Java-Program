package com.company.reccolldao.dao.service;

import com.company.reccolldao.ViewModel.AlbumViewModel;
import com.company.reccolldao.dao.AlbumDao;
import com.company.reccolldao.dao.ArtistDao;
import com.company.reccolldao.dao.LabelDao;
import com.company.reccolldao.dao.TrackDao;
import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {
    private AlbumDao albumDao;
    private ArtistDao artistDao;
    private LabelDao labelDao;
    private TrackDao trackDao;

    @Autowired
    //constructor
    public ServiceLayer(AlbumDao albumDao, ArtistDao artistDao, LabelDao labelDao, TrackDao trackDao){
        this.albumDao = albumDao;
        this.artistDao = artistDao;
        this.labelDao = labelDao;
        this.trackDao = trackDao;
    }

    @Transactional
    public AlbumViewModel saveAlbum(AlbumViewModel viewModel){
        //persist album
        Album a = new Album();
        a.setTitle(viewModel.getTitle());
        a.setReleaseDate(viewModel.getReleaseDate());
        a.setArtistId(viewModel.getArtist().getId());
        a.setLabelId(viewModel.getLabel().getId());
        a.setListPrice(viewModel.getListPrice());
        a = albumDao.addAlbum(a);
        viewModel.setId(a.getId());

        //add Album Id to Tracks and Persist tracks
        List<Track> tracks = viewModel.getTrackList();

        tracks.stream()
                .forEach(t ->
                    {t.setAlbumId(viewModel.getId());
                    trackDao.addTrack(t);
                });

        tracks = trackDao.getTracksByAlbum(viewModel.getId());
        viewModel.setTrackList(tracks);

        return viewModel;
    }

    public AlbumViewModel findAlbum(int id){
        Album album = albumDao.getAlbum(id);
        return buildAlbumViewModel(album);
    }

    private AlbumViewModel buildAlbumViewModel(Album album){
        //Get the associate artist
        Artist artist = artistDao.getArtist(album.getArtistId());

        //get the associated label
        Label label = labelDao.getLabel(album.getLabelId());

        //assemble the tracks associated with the album
        List<Track> trackList = trackDao.getTracksByAlbum(album.getId());

        //assemble the albumviewmodel
        AlbumViewModel avm = new AlbumViewModel();
        avm.setId(album.getId());
        avm.setTitle(album.getTitle());
        avm.setReleaseDate(album.getReleaseDate());
        avm.setListPrice(album.getListPrice());
        avm.setArtist(artist);
        avm.setLabel(label);
        avm.setTrackList(trackList);

        //return albumviewmodel
        return avm;
    }

    private List<AlbumViewModel> findallAlbums(){
        List<Album> albumList = albumDao.getAllAlbums();
        List<AlbumViewModel> avmList = new ArrayList<>();

        for(Album album:albumList){
            AlbumViewModel avm = buildAlbumViewModel(album);
            avmList.add(avm);
        }
        return avmList;
    }

    @Transactional
    public void updateAlbum(AlbumViewModel viewModel){
        //update the album information
        Album album = new Album();
        album.setId(viewModel.getId());
        album.setArtistId(viewModel.getArtist().getId());
        album.setLabelId(viewModel.getLabel().getId());
        album.setListPrice(viewModel.getListPrice());
        album.setTitle(viewModel.getTitle());
        album.setReleaseDate(viewModel.getReleaseDate());

        albumDao.updateAlbum(album);

        //We don't know if any track has been removed so delete all associated tracks
        //and then associate the tracks in the viewModel with the album

        List<Track> trackList = trackDao.getTracksByAlbum(album.getId());
        trackList.stream()
                .forEach(track -> trackDao.deleteTrack(track.getId()));

        List<Track> tracks = viewModel.getTrackList();
        tracks.stream()
                .forEach(t ->
                {
                    t.setAlbumId(viewModel.getId());
                    t = trackDao.addTrack(t);
                });
    }

    @Transactional
    public void removeAlbum(int id){
        //remove all associated tracks first
        List<Track> trackList = trackDao.getTracksByAlbum(id);

        trackList.stream()
                .forEach(track -> trackDao.deleteTrack(track.getId()));

        //remove album
        albumDao.deleteAlbum(id);
    }

    public Artist saveArtist(Artist artist) {

        return artistDao.addArtist(artist);
    }

    public Artist findArtist(int id) {

        return artistDao.getArtist(id);
    }

    public List<Artist> findAllArtists() {

        return artistDao.getAllArtists();
    }

    public void updateArtist(Artist artist) {

        artistDao.updateArtist(artist);
    }

    public void removeArtist(int id) {

        artistDao.deleteArtist(id);
    }

    //
    // Label API
    //

    public Label saveLabel(Label label) {

        return labelDao.addLabel(label);
    }

    public Label findLabel(int id) {

        return labelDao.getLabel(id);
    }

    public List<Label> findAllLabels() {

        return labelDao.getAllLabels();
    }

    public void updateLabel(Label label) {

        labelDao.updateLabel(label);
    }

    public void removeLabel(int id) {

        labelDao.deleteLabel(id);
    }

    public List<AlbumViewModel> findAllAlbums() {

        List<Album> albumList = albumDao.getAllAlbums();

        List<AlbumViewModel> avmList = new ArrayList<>();

        for (Album album : albumList) {
            AlbumViewModel avm = buildAlbumViewModel(album);
            avmList.add(avm);
        }

        return avmList;
    }

    public Track saveTrack(Track track) {

        return trackDao.addTrack(track);
    }

    public Track findTrack(int id) {

        return trackDao.getTrack(id);
    }

    public List<Track> findAllTracks() {

        return trackDao.getAllTracks();
    }

    public List<Track> findTracksByAlbum(int id) {

        return trackDao.getTracksByAlbum(id);
    }

    public void removeTrack(int id) {

        trackDao.deleteTrack(id);
    }

    public void updateTrack(Track track) {

        trackDao.updateTrack(track);
    }
}
