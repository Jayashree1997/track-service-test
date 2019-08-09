package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
//@Profile("dev")
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;


    public TrackServiceImpl() {
    }

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException {
        Optional<Track> optional = trackRepository.findById(id);

        if (!optional.isPresent()) {
            throw new TrackNotFoundException("Track Not Found");
        }

        trackRepository.deleteById(id);
        return optional;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.findById(track.getId()).isPresent()){
            throw new TrackAlreadyExistsException("Track Already Exists");
        }
        Track saveTrack = trackRepository.save(track);
        return saveTrack;
    }


    @Override
    public Track updateTrack(int id, Track track) throws TrackNotFoundException {
        if (!trackRepository.findById(id).isPresent()){
            throw new TrackNotFoundException("Track Not Found");

        }
        Track update = trackRepository.findById(id).get();
        update.setName(track.getName());
        update.setComments(track.getComments());
        return trackRepository.save(track);

    }

    @Override
    public Track getById(int id) throws TrackNotFoundException {
        if (!trackRepository.findById(id).isPresent()) {

            throw new TrackNotFoundException("Track Not Found");
        }

        return trackRepository.findById(id).get();

    }



    @Override
    public List<Track> getAllTracks() throws Exception {
        List<Track> data = trackRepository.findAll();
        if (data.isEmpty()){
            throw new Exception("No Tracks Available");
        }
        return trackRepository.findAll();
    }


    @Override
    public Track getByName(String name) throws TrackNotFoundException {

        return trackRepository.findByName(name);
    }

//    @Override
//    public List<Track> getByName(String name) throws TrackNotFoundException{
//        List<Track> dbName = trackRepository.findByName(name);
//        if (!dbName.contains(name)){
//            throw new TrackNotFoundException("Track Not Found");
//        }
//        return dbName;
//    }
}
