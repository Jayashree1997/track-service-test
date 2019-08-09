//package com.stackroute.seedData;
//
//import com.stackroute.domain.Track;
//import com.stackroute.repository.TrackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SpringApplicationListenerImpl implements ApplicationListener<ContextRefreshedEvent> {
//    private TrackRepository trackRepository;
//
//    @Autowired
//    public SpringApplicationListenerImpl(TrackRepository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        Track t1 = new Track(1,"song1","SongAlbum1");
//        Track t2 = new Track(2,"song2","SongAlbum2");
//        Track t3 = new Track(3,"song3","SongAlbum3");
//        Track t4 = new Track(4,"song4","SongAlbum4");
//        Track t5 = new Track(5,"song5","SongAlbum5");
//        Track t6 = new Track(6,"song6","SongAlbum6");
//
//        trackRepository.save(t1);
//        trackRepository.save(t2);
//        trackRepository.save(t3);
//        trackRepository.save(t4);
//        trackRepository.save(t5);
//        trackRepository.save(t6);
//
//    }
//
//
//
//
//}
