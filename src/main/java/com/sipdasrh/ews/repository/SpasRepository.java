package com.sipdasrh.ews.repository;

import com.sipdasrh.ews.domain.Spas;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Spas entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SpasRepository extends JpaRepository<Spas, Long>, JpaSpecificationExecutor<Spas> {}
