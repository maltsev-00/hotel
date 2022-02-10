package com.hotel.pets.repository;

import com.hotel.pets.model.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findOfferByTypeOfferNameAndAccess(String name, boolean access);
}
