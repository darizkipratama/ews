package com.sipdasrh.ews.repository;

import com.sipdasrh.ews.domain.SpasArrInstall;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the SpasArrInstall entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SpasArrInstallRepository extends JpaRepository<SpasArrInstall, Long>, JpaSpecificationExecutor<SpasArrInstall> {}
