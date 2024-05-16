package org.nika.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="full_name")
    private String fullName;

    @OneToOne(mappedBy = "passenger", cascade = CascadeType.ALL)
    private Passport passport;

    /*@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<Ticket> ticketList;*/

}
