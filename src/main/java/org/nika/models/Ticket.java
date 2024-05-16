package org.nika.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    private Passenger passenger;

    @Column(name = "date")
    private int date;

    @OneToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seat;

   /* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seat;*/
}
