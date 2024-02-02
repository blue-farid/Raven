package com.bluefarid.raven.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    private Long id;
    private String text;
    @ManyToOne
    private Client sender;
    private String image;
}
