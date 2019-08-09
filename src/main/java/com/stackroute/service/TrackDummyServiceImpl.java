package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Qualifier("dummyImplementation")
//Inorder to run this implementation class either we can use @Primary annotation or we can specify in @Qualifier

//@Profile("prod")
public class TrackDummyServiceImpl implements TrackService {


    private TrackRepository trackRepository;

    public TrackDummyServiceImpl() {
    }

    @Autowired
    public TrackDummyServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        return null;
    }

    @Override
    public Track getById(int id) throws TrackNotFoundException {
        return null;
    }

    @Override
    public List<Track> getAllTracks() throws Exception {
        return null;
    }

    @Override
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException {
        return Optional.empty();
    }

    @Override
    public Track updateTrack(int id, Track track) throws TrackNotFoundException {
        return null;
    }

    @Override
    public Track getByName(String name) throws TrackNotFoundException {
        return null;
    }
}
