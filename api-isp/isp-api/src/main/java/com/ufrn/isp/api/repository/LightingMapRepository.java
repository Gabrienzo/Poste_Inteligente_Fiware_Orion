package com.ufrn.isp.api.repository;

import com.ufrn.isp.api.domain.LightingMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightingMapRepository extends JpaRepository<LightingMap, Long> {
}
