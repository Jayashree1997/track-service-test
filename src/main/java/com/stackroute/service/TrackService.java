package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    public Track saveTrack (Track track) throws TrackAlreadyExistsException;
    public Track getById(int id) throws TrackNotFoundException;
    public List<Track> getAllTracks() throws Exception;
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException;
    public Track updateTrack(int id, Track track)throws TrackNotFoundException;

    //getByName implemented
    public Track getByName(String name) throws TrackNotFoundException;

//    public List<Track> getByName(String name) throws TrackNotFoundException;
}
