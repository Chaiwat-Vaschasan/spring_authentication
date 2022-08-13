package authorization.repository;

import authorization.entity.RoleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleGroupRepository extends JpaRepository<RoleGroup, Integer> {
    Optional<RoleGroup> findByRoleName (String roleName);
}