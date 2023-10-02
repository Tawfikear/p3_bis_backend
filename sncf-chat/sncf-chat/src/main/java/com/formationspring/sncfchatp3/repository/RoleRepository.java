package com.formationspring.sncfchatp3.repository;

import com.formationspring.sncfchatp3.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
