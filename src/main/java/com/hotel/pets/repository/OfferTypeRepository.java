package com.hotel.pets.repository;

import com.hotel.pets.model.entity.TypeOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferTypeRepository extends JpaRepository<TypeOffer,Long> {
}
