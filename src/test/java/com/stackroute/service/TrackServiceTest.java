package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TrackServiceTest {

    Track track;

    @Mock
    private TrackRepository trackRepository;

    @InjectMocks
    private TrackServiceImpl trackService;
    private List<Track> list = null;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setId(13);
        track.setName("ghsjdsk");
        track.setComments("ghjfkhkjg");
        list = new ArrayList<>();
        list.add(track);
    }

    @Test
    public void saveTrack() throws TrackAlreadyExistsException {

        when(trackRepository.save(any())).thenReturn(track);
        Track savedTrack = trackService.saveTrack(track);
        assertEquals(track,savedTrack);

        verify(trackRepository,times(1)).save(track);

    }

    @Test
    public void saveTrackNotNull() throws TrackAlreadyExistsException {

        when(trackRepository.save(any())).thenReturn(track);
        Track savedTrack1 = trackService.saveTrack(track);

        assertNotNull(savedTrack1);

        verify(trackRepository,times(1)).save(track);

    }

    @Test
    public void getById() throws TrackNotFoundException {

        trackRepository.save(track);

        when(trackRepository.existsById(track.getId())).thenReturn(true);
        when(trackRepository.findById(track.getId())).thenReturn(java.util.Optional.of(track));
        Track getTrack = trackService.getById(track.getId());
        assertEquals(track,getTrack);

    }

    @Test
    public void getByIdFailure() throws TrackNotFoundException {

        trackRepository.save(track);

        when(trackRepository.existsById(track.getId())).thenReturn(true);
        when(trackRepository.findById(track.getId())).thenReturn(java.util.Optional.of(track));
        Track getTrack = trackService.getById(35);
        assertEquals(track,getTrack);

    }

    @Test
    public void getAllTracks() throws Exception {

        trackRepository.save(track);

        when(trackRepository.findAll()).thenReturn(list);
        List<Track> savedList = trackService.getAllTracks();
        assertEquals(list,savedList);
    }

    @Test
    public void deleteTrackById() throws TrackNotFoundException {
        trackRepository.save(track);

        when(trackRepository.existsById(track.getId())).thenReturn(true);
        when(trackRepository.findById(track.getId())).thenReturn(java.util.Optional.of(track));

        Optional<Track> track1 = trackService.deleteTrackById(track.getId());

        assertEquals(true,trackRepository.existsById(track.getId()));

    }



    @Test
    public void updateTrack() throws TrackNotFoundException {

        trackRepository.save(track);
        Track track1 = new Track();
        track1.setName("fdhkdfhv");
        track1.setComments("sdjacd");

        when(trackRepository.findById(track.getId())).thenReturn(Optional.of(track));
        Track trackUpdated =  trackService.updateTrack(1,track1);
        when(trackRepository.save(trackUpdated)).thenReturn(trackUpdated);
        assertNotEquals(trackUpdated,track);

    }



    @Test
    public void getByName() throws TrackNotFoundException {

        trackRepository.save(track);

        when(trackRepository.findByName(track.getName())).thenReturn(track);

        Track searchedName = trackService.getByName("dgahchah");

        assertSame(searchedName,track);
    }

}