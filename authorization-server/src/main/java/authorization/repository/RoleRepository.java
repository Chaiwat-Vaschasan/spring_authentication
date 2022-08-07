package authorization.repository;

import authorization.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query( "select rg.roleName from Role r " +
            "join RoleGroup rg on r.roleId = rg.roleId " +
            "where r.accountId = ?1")
    List<String> findRoleNameByAccountId(UUID accountId);

    Optional<Role> findRoleByRoleIdAndAccountId(Integer roleId , UUID accountId);
}