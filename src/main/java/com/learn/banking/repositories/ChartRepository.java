package com.learn.banking.repositories;

import com.learn.banking.models.Chart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartRepository extends JpaRepository<Chart,Long> {
    Chart findByidBarang(String idBarang);
}
