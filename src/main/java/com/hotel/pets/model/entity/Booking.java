package com.hotel.pets.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameAnimal;
    private String typeAnimal;
    private int countDay;
    private String telephoneNumber;
    private String infoAboutAnimal;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "booking_menu",
            joinColumns = @JoinColumn(
                    name = "booking_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "menu_item_id", referencedColumnName = "id"))
    private List<MenuItem> menuItems = new ArrayList<>();
    private BigDecimal finalCost;
}
