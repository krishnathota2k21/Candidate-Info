package com.ivispl.candidate.reposiroty;

import com.ivispl.candidate.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);

    List<Role> findAllByName(String roleName);
}
