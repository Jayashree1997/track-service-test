//package com.stackroute.seedData;
//
//import com.stackroute.domain.Track;
//import com.stackroute.repository.TrackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SpringCommandLineRunnerImpl implements CommandLineRunner {
//
//    private TrackRepository trackRepository;
//
//    @Autowired
//    public SpringCommandLineRunnerImpl(TrackRepository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Track t1 = new Track(11,"song11","songAlbum11");
//        Track t2 = new Track(22,"song22","songAlbum22");
//        Track t3 = new Track(33,"song33","songAlbum33");
//        Track t4 = new Track(44,"song44","songAlbum44");
//
//        trackRepository.save(t1);
//        trackRepository.save(t2);
//        trackRepository.save(t3);
//        trackRepository.save(t4);
//
//    }
//}
