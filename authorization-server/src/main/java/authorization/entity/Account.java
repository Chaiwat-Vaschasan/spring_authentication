package authorization.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "account_id", nullable = false)
    private UUID accountId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "update_date")
    private Timestamp updateDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "is_active",columnDefinition = "boolean default true",nullable = false)
    private Boolean isActive;

}