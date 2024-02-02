package com.bluefarid.raven.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
    @Id
    private Long id;
    @OneToMany
    private List<Client> clients;
    @OneToMany
    @ToString.Exclude
    private List<Message> messages;
}
