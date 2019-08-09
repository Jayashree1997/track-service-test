package com.stackroute.repository;

import com.stackroute.domain.Track;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track, Integer> {

    //getByName implemented
//    @Query("select t from Track t where t.name = ?1")
    public Track findByName(String name);

//    @Query("select t from Track t where t.name = ?1")
//    public List<Track> findByName(String name);

}
