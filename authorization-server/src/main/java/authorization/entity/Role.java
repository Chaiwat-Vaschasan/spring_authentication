package authorization.entity;

import authorization.utility.serializable.RoleSerializable;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "role")
@IdClass(RoleSerializable.class)
public class Role {

    @Id
    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    @Id
    @Column(name = "account_id", nullable = false)
    private UUID accountId;


}