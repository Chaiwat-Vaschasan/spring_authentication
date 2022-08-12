package authorization.service;

import authorization.model.ClientModel;
import authorization.model.ResponseModel;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.ClientSettings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private RegisteredClientRepository registeredClientRepository;

    public ResponseModel<UUID> registered(ClientModel client){

        var uuid = UUID.randomUUID();
        var res = new ResponseModel<UUID>();

        var registeredClient = RegisteredClient.withId(uuid.toString())
                .clientId(client.getClientId())
                .clientSecret("{noop}" + client.getClientSecret())
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .scope(OidcScopes.OPENID);

        if(client.getIsCredentials()){
            registeredClient.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS);
        }

        if(client.getIsCode()){
            registeredClient.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE);
            registeredClient.authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN);
            registeredClient.authorizationGrantType(AuthorizationGrantType.JWT_BEARER);
        }

        if(client.getScope().size() > 0){
            client.getScope().forEach(registeredClient::scope);
        }

        if(client.getUri().size() > 0){
            client.getUri().forEach(registeredClient::redirectUri);
        }

        registeredClient.clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build());
        registeredClientRepository.save(registeredClient.build());
        res.setSuccess(uuid);

        return res;
    }

}
