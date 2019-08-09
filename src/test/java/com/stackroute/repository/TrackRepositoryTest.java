package com.stackroute.repository;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.NoSuchElementException;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrackRepositoryTest {

    @Autowired
    private TrackRepository trackRepository;
    private Track track;

    @Before
    public void setUp() throws Exception {
        track = new Track();
        track.setId(12);
        track.setName("ghjk");
        track.setComments("hgjgkkf");
        trackRepository.save(track);
    }

    @After
    public void tearDown() throws Exception {
        trackRepository.deleteAll();
    }

    @Test
    public void saveTrack() {

        Track testTrack = trackRepository.findById(track.getId()).get();
        assertEquals(track, testTrack);
    }

    @Test
    public void saveTrackFailure() {

        Track newTrack = new Track(44, "kjli", "tretuyww");
        trackRepository.save(newTrack);
        assertNotSame(track, newTrack);
    }

    @Test
    public void getAllTracks() {
        Track track1 = new Track(34, "ghjfjjf", "jhklvxvc");
        Track track2 = new Track(35, "nvbcvncx", "klfdjgdh");
        Track track3 = new Track(36, "sVxhc", "cbzxcnv");
        trackRepository.save(track1);
        trackRepository.save(track2);
        trackRepository.save(track3);

        List<Track> trackList = trackRepository.findAll();

        assertEquals("klfdjgdh", trackList.get(35).getName());
    }
    @Test
    public void getTrackById() {
        Track t1 = new Track();
        Track t2 = new Track(2, "cgcuu", "ashuadfuf");
        Track t3 = new Track(3, "cdgudcgf", "sakhvcaf");
        trackRepository.save(t2);
        trackRepository.save(t3);
        t1.setId(3);
        Track t4 = trackRepository.findById(t1.getId()).get();

        assertEquals(t3, t4);

    }

    @Test
    public void deleteTrackById() {

        assertEquals(true, trackRepository.existsById(track.getId()));
        trackRepository.deleteById(track.getId());

    }

    @Test
    public void updateTrackById() {
        Track t1 = new Track(2, "hgjfkjd", "bcbncnbxbncx");
        Track t2 = new Track(3, "dnckzbcvckv", "cnvckjbv");
        Track t3 = new Track(4, "cjkvcxkzh", "ckjhcxg");
        trackRepository.save(t1);
        trackRepository.save(t2);
        trackRepository.save(t3);

        Track trackList = trackRepository.findById(t2.getId()).get();
        trackList.setName(t3.getName());

        assertEquals(trackList.getName(), t3.getName());

    }




}