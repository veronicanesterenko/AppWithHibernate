package org.nika.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(mappedBy = "seat", cascade = CascadeType.ALL)
    private Ticket ticket;

    @ManyToMany(mappedBy = "seats")
    List<Route> routes;



}
