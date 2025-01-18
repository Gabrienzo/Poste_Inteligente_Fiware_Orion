package com.ufrn.isp.api.repository;

import com.ufrn.isp.api.domain.SecurityIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityIncidentRepository extends JpaRepository<SecurityIncident, Long> {

}
