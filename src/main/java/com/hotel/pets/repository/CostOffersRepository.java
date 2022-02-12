package com.hotel.pets.repository;

import com.hotel.pets.model.entity.CostOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostOffersRepository extends JpaRepository<CostOffers, Long> {
    CostOffers findCostOffersByName(String name);
}
