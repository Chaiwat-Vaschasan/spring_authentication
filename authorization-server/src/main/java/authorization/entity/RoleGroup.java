package authorization.entity;

import authorization.model.RoleGroupModel;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "role_group")
public class RoleGroup {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "update_date")
    private Timestamp updateDate;

    @Column(name = "update_by")
    private String updateBy;

    public void created(RoleGroupModel item, String by){
        createDate = Timestamp.from(Instant.now());
        createBy = by;
        roleName = item.getRoleName();
    }

    public void updated(RoleGroupModel item, String by){
        updateDate = Timestamp.from(Instant.now());
        updateBy = by;
        roleName = item.getRoleName();
    }

}