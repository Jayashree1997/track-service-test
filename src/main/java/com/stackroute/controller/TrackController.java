package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import com.stackroute.service.TrackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class TrackController {

    private TrackServiceImpl trackServiceImpl;
    private ResponseEntity responseEntity;;

    public TrackController() {
    }

    @Autowired
    public TrackController(TrackServiceImpl trackServiceImpl) {
        this.trackServiceImpl = trackServiceImpl;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){

        try{
            trackServiceImpl.saveTrack(track);
            responseEntity = new ResponseEntity("Successfully created", HttpStatus.CREATED);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
      return  responseEntity;

    }

    @GetMapping("track/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){

        try{
            responseEntity = new ResponseEntity<Track>(trackServiceImpl.getById(id),HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks(){

        try{
            responseEntity = new ResponseEntity<List<Track>>(trackServiceImpl.getAllTracks(),HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity(new Exception("Internal Server Error"),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id){

        try{
            responseEntity = new ResponseEntity<Optional<Track>>(trackServiceImpl.deleteTrackById(id),HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @PutMapping("track/{id}")
    public ResponseEntity<?> updateTrack(@PathVariable int id,@RequestBody Track track){

        try{

            responseEntity = new ResponseEntity(trackServiceImpl.updateTrack(id,track),HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    //getByName implemented
//    @GetMapping("trackname/{name}")
//    public ResponseEntity<?> getByName(@PathVariable String name){
//
//        try{
//            responseEntity = new ResponseEntity<Track>(trackService.getByName(name),HttpStatus.OK);
//        }
//        catch (Exception e){
//            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
//        }
//
//        return responseEntity;
//    }

    @GetMapping("tracks/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name){

        try{
            responseEntity = new ResponseEntity<Track>(trackServiceImpl.getByName(name),HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }



}
