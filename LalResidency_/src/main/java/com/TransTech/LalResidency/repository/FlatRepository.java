package com.TransTech.LalResidency.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.TransTech.LalResidency.entity.Flat;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Long> {
		@Query("SELECT f FROM Flat f WHERE f.property.id = :propertyId")
	    List<Flat> findFlatsByPropertyId(Long propertyId);

}
