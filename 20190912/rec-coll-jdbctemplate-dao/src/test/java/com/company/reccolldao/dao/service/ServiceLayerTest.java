package com.company.reccolldao.dao.service;

import com.company.reccolldao.ViewModel.AlbumViewModel;
import com.company.reccolldao.dao.*;
import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {
    private AlbumDao albumDao;
    private ArtistDao artistDao;
    private LabelDao labelDao;
    private TrackDao trackDao;
    private ServiceLayer serviceLayer;

    private void setupAlbumDaoMock(){
        albumDao = mock(AlbumDaoJdbcTemplateImpl.class);
            Album album = new Album();
            album.setId(1);
            album.setArtistId(45);
            album.setLabelId(10);
            album.setTitle("Greatest Hits");
            album.setListPrice(new BigDecimal("14.99"));
            album.setReleaseDate(LocalDate.of(1999, 05, 15));

            Album album2 = new Album();
            album2.setArtistId(45);
            album2.setLabelId(10);
            album2.setTitle("Greatest Hits");
            album2.setListPrice(new BigDecimal("14.99"));
            album2.setReleaseDate(LocalDate.of(1999, 05, 15));

        List<Album> aList = new ArrayList<>();
        aList.add(album);

        //return album when on the albumDao someone adds album2
        //so that we can test some other part that requires an addalbum method as part of its test
        doReturn(album).when(albumDao).addAlbum(album2);
        doReturn(album).when(albumDao).getAlbum(1);
        doReturn(aList).when(albumDao).getAllAlbums();
    }

    private void setupLabelDaoMock(){
        labelDao = mock(LabelDaoJdbcTemplateImpl.class);
            Label label = new Label();
            label.setId(10);
            label.setWebsite("bluenote.com");
            label.setName("Blue Note");

            Label label2 = new Label();
            label2.setWebsite("bluenote.com");
            label2.setName("Blue Note");

            List<Label> labelList = new ArrayList<>();
            labelList.add(label);

            doReturn(label).when(labelDao).addLabel(label2);
            doReturn(label).when(labelDao).getLabel(10);
            doReturn(labelList).when(labelDao).getAllLabels();
    }

    private void setupTrackDaoMock(){
        trackDao = mock(TrackDaoJdbcTemplateImpl.class);
        Track track = new Track();
        track.setId(1);
        track.setAlbumId(1);
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");

        Track track2 = new Track();
        track2.setAlbumId(1);
        track2.setRunTime(180);
        track2.setTitle("Number 1 Hit!");

        List<Track> trackList = new ArrayList<>();
        trackList.add(track);

        doReturn(track).when(trackDao).addTrack(track2);
        doReturn(track).when(trackDao).getTrack(1);
        doReturn(trackList).when(trackDao).getAllTracks();
        doReturn(trackList).when(trackDao).getTracksByAlbum(1);
    }

    private void setupArtistDaoMock(){
        artistDao = mock(ArtistDaoJdbcTemplateImpl.class);
            Artist artist = new Artist();
            artist.setId(45);
            artist.setName("Jane Doe");
            artist.setTwitter("@JaneDoe");
            artist.setInstagram("JaneDoe");

            Artist artist2 = new Artist();
            artist2.setName("Jane Doe");
            artist2.setTwitter("@JaneDoe");
            artist2.setInstagram("JaneDoe");

            List<Artist> artistList = new ArrayList<>();
            artistList.add(artist);

            doReturn(artist).when(artistDao).addArtist(artist2);
            doReturn(artist).when(artistDao).getArtist(45);
            doReturn(artistList).when(artistDao).getAllArtists();
    }

    @Before
    public void setUp() throws Exception{
        setupAlbumDaoMock();
        setupArtistDaoMock();
        setupLabelDaoMock();
        setupTrackDaoMock();

        serviceLayer = new ServiceLayer(albumDao, artistDao, labelDao, trackDao);
    }

    @Test
    public void saveFindFindAllAlbums(){
        AlbumViewModel avm = new AlbumViewModel();

        avm.setListPrice(new BigDecimal("14.99"));
        avm.setReleaseDate(LocalDate.of(1999, 05, 15));
        avm.setTitle("Greatest Hits");

        Artist artist = new Artist();
        artist.setName("Jane Doe");
        artist.setTwitter("@JaneDoe");
        artist.setInstagram("JaneDoe");
        artist = serviceLayer.saveArtist(artist);

        avm.setArtist(artist);

        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("bluenote.com");
        label = serviceLayer.saveLabel(label);

        avm.setLabel(label);

        Track track = new Track();
        track.setId(1);
        track.setAlbumId(1);
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");
        List<Track> tlist = new ArrayList<>();
        tlist.add(track);

        avm.setTrackList(tlist);

        avm = serviceLayer.saveAlbum(avm);

        AlbumViewModel fromService = serviceLayer.findAlbum(avm.getId());
        Assert.assertEquals(avm, fromService);

        List<AlbumViewModel> albumList = serviceLayer.findAllAlbums();
        assertEquals(1, albumList.size());
        assertEquals(avm, albumList.get(0));
    }

    @Test
    public void saveFindFindAllArtists(){
        Artist artist = new Artist();
        artist.setName("Jane Doe");
        artist.setTwitter("@JaneDoe");
        artist.setInstagram("JaneDoe");

        artist = serviceLayer.saveArtist(artist);
        Artist fromService = serviceLayer.findArtist(artist.getId());
        assertEquals(artist, fromService);

        List<Artist> artistList = serviceLayer.findAllArtists();
        assertEquals(1, artistList.size());
        assertEquals(artist, artistList.get(0));
    }

    @Test
    public void saveFindFindAllLabels(){
        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("bluenote.com");

        label = serviceLayer.saveLabel(label);
        Label fromService = serviceLayer.findLabel(label.getId());
        assertEquals(label, fromService);

        List<Label> labelList = serviceLayer.findAllLabels();
        assertEquals(1,labelList.size());
        assertEquals(label, labelList.get(0));
    }

    @Test
    public void testDeleteAlbum(){
        //set up
        AlbumViewModel avm = new AlbumViewModel();
        avm.setId(1);
        avm.setListPrice(new BigDecimal("14.99"));
        avm.setTitle("Greatest Hits");
        avm.setReleaseDate(LocalDate.of(1999, 05, 15));


        Artist artist = new Artist();
        artist.setId(1);
        artist.setName("Jane Doe");
        artist.setTwitter("@JaneDoe");
        artist.setInstagram("JaneDoe");

        avm.setArtist(artist);

        Label label = new Label();
        label.setId(10);
        label.setName("Blue Note");
        label.setWebsite("bluenote.com");

        avm.setLabel(label);

        Track track = new Track();
        track.setId(1);
        track.setAlbumId(1);
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");
        List<Track> tlist = new ArrayList<>();
        tlist.add(track);

        avm.setTrackList(tlist);

        //this argument capture should work with type Album
        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);

        doNothing().when(albumDao).deleteAlbum(integerCaptor.capture());
        //act
        serviceLayer.removeAlbum(avm.getId());
        verify(albumDao, times(1)).deleteAlbum(integerCaptor.getValue());

        assertEquals(1, integerCaptor.getValue().intValue());
    }

    @Test
    public void testDeleteLabel(){
        Label label = new Label();
        label.setId(10);

        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(labelDao).deleteLabel(integerCaptor.capture());
        serviceLayer.removeLabel(10);

        verify(labelDao, times(1)).deleteLabel(integerCaptor.getValue());

        assertEquals(10, integerCaptor.getValue().intValue());
    }

    @Test
    public void testUpdateAlbum(){
        //set up
        AlbumViewModel avm = new AlbumViewModel();
        avm.setId(1);
        avm.setListPrice(new BigDecimal("14.99"));
        avm.setTitle("Greatest Hits");
        avm.setReleaseDate(LocalDate.of(1999, 05, 15));


        Artist artist = new Artist();
        artist.setId(1);
        artist.setName("Jane Doe");
        artist.setTwitter("@JaneDoe");
        artist.setInstagram("JaneDoe");

        avm.setArtist(artist);

        Label label = new Label();
        label.setId(10);
        label.setName("Blue Note");
        label.setWebsite("bluenote.com");

        avm.setLabel(label);

        Track track = new Track();
        track.setId(1);
        track.setAlbumId(1);
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");
        List<Track> tlist = new ArrayList<>();
        tlist.add(track);

        avm.setTrackList(tlist);

        //this argument capture should work with type Album
        ArgumentCaptor<Album> albumCaptor = ArgumentCaptor.forClass(Album.class);

        doNothing().when(albumDao).updateAlbum(albumCaptor.capture());
        //act
        serviceLayer.updateAlbum(avm);
        //assert
        //if you call album dao and it only gets called 1 time
        verify(albumDao, times(1)).updateAlbum(albumCaptor.getValue());

        //optional
        Album album = albumCaptor.getValue();
        assertEquals(avm.getId(), album.getId());
        assertEquals(avm.getListPrice(), album.getListPrice());
        assertEquals(avm.getTitle(), album.getTitle());
        assertEquals(avm.getReleaseDate(), album.getReleaseDate());
        assertEquals(avm.getArtist().getId(), album.getArtistId());
        assertEquals(avm.getLabel().getId(), album.getLabelId());
    }

    @Test
    public void saveFindFindAllTracks(){
        Track track = new Track();
        track.setAlbumId(1);
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");

        track = serviceLayer.saveTrack(track);
        Track fromService = serviceLayer.findTrack(track.getId());
        assertEquals(track, fromService);

        List<Track> trackList = serviceLayer.findAllTracks();
        assertEquals(1, trackList.size());
        assertEquals(track, trackList.get(0));
    }

    @Test
    public void testFindTrackByAlbum(){
        Track track = new Track();
        track.setAlbumId(1);
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");

        track = serviceLayer.saveTrack(track);
        assertEquals(1, serviceLayer.findTracksByAlbum(track.getAlbumId()).size());
        assertEquals(track, serviceLayer.findTracksByAlbum(track.getAlbumId()).get(0));
    }

    @Test
    public void testDeleteTrack(){
        Track track = new Track();
        track.setId(1);

        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(trackDao).deleteTrack(integerCaptor.capture());
        serviceLayer.removeTrack(1);

        verify(trackDao, times(1)).deleteTrack(integerCaptor.getValue());
        assertEquals(1, integerCaptor.getValue().intValue());
    }

    @Test
    public void testDeleteArtist(){
        Artist artist = new Artist();
        artist.setId(45);

        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(artistDao).deleteArtist(integerCaptor.capture());
        serviceLayer.removeArtist(45);

        verify(artistDao, times(1)).deleteArtist(integerCaptor.getValue());
        assertEquals(45, integerCaptor.getValue().intValue());
    }

    @Test
    public void testUpdateTrack(){
        Track track = new Track();
        track.setId(1);
        track.setAlbumId(1);
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");

        ArgumentCaptor<Track> trackCaptor = ArgumentCaptor.forClass(Track.class);

        doNothing().when(trackDao).updateTrack(trackCaptor.capture());
        serviceLayer.updateTrack(track);
        verify(trackDao, times(1)).updateTrack(trackCaptor.getValue());

        Track track1 = trackCaptor.getValue();
        assertEquals(track.getId(), track1.getId());
        assertEquals(track.getAlbumId(), track1.getAlbumId());
        assertEquals(track.getRunTime(), track1.getRunTime());
        assertEquals(track.getTitle(), track1.getTitle());
    }

    @Test
    public void testUpdateArtist(){
        Artist artist = new Artist();
        artist.setId(45);
        artist.setName("Jane Doe");
        artist.setTwitter("@JaneDoe");
        artist.setInstagram("JaneDoe");

        ArgumentCaptor<Artist> artistCaptor = ArgumentCaptor.forClass(Artist.class);

        doNothing().when(artistDao).updateArtist(artistCaptor.capture());
        serviceLayer.updateArtist(artist);
        verify(artistDao, times(1)).updateArtist(artistCaptor.getValue());

        Artist artist1 =  artistCaptor.getValue();
        assertEquals(artist.getId(), artist1.getId());
        assertEquals(artist.getInstagram(), artist1.getInstagram());
        assertEquals(artist.getName(), artist1.getName());
        assertEquals(artist.getTwitter(), artist.getTwitter());
    }

    @Test
    public void testUpdateLabel(){
        Label label = new Label();
        label.setId(10);
        label.setWebsite("bluenote.com");
        label.setName("Blue Note");

        ArgumentCaptor<Label> labelCaptor = ArgumentCaptor.forClass(Label.class);

        doNothing().when(labelDao).updateLabel(labelCaptor.capture());
        serviceLayer.updateLabel(label);
        verify(labelDao, times(1)).updateLabel(labelCaptor.getValue());

        Label label1 = labelCaptor.getValue();
        assertEquals(label.getId(), label1.getId());
        assertEquals(label.getName(), label1.getName());
        assertEquals(label.getWebsite(), label1.getWebsite());
    }
}