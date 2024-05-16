package org.nika.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

   /* @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    private Ticket ticket;*/

}
