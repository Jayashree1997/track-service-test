package com.stackroute.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Track {

    @Id
    private int id;
    private String name;
    private String comments;


}
