package org.nika.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "time")
    private String time;

    @Column(name = "departure_point")
    private String departurePoint;

    @Column(name = "arrival_point")
    private String arrivalPoint;

    @Column(name = "price")
    private double price;

   /* @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<Ticket> tickets;*/
}
