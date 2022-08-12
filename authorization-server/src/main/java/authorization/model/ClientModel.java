package authorization.model;

import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientModel {
    private UUID id;
    private String clientId;
    private String clientSecret;
    private List<String> scope;
    private List<String> uri;
    private Boolean isCredentials;
    private Boolean isCode;
}
