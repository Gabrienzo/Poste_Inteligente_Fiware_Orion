package com.ufrn.isp.api.repository;

import com.ufrn.isp.api.domain.Lighting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightingRepository extends JpaRepository<Lighting, Long> {
}
