package com.sipdasrh.ews.repository;

import com.sipdasrh.ews.domain.SpasArrLog;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the SpasArrLog entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SpasArrLogRepository extends JpaRepository<SpasArrLog, Long>, JpaSpecificationExecutor<SpasArrLog> {}
