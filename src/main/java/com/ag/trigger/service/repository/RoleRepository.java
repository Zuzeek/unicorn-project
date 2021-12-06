package com.ag.trigger.service.repository;

import com.ag.trigger.model.ERole;
import com.ag.trigger.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByRoleName(ERole roleName);
}
