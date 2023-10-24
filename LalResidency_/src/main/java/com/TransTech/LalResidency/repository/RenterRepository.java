package com.TransTech.LalResidency.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TransTech.LalResidency.entity.Renter;

@Repository
public interface RenterRepository extends JpaRepository<Renter, Long> {
    List<Renter> findByFlatId(Long flatId);
}
