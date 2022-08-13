package authorization.model;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRoleModel {
    private UUID accountId;
    private List<Integer> roleId;
}
