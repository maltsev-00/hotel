package com.hotel.pets.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Boolean access;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "offers_type_offers",
            joinColumns = @JoinColumn(
                    name = "offer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "offer_type_id", referencedColumnName = "id"))
    private Collection<TypeOffer> typeOffer;
}
