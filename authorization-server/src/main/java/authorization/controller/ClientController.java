package authorization.controller;

import authorization.model.AccountDetailModel;
import authorization.model.ClientModel;
import authorization.model.ResponseModel;
import authorization.service.ClientService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired private ClientService clientService;

    @PostMapping("/registered")
    public ResponseModel<UUID> registered(@RequestBody ClientModel client){
        var res = clientService.registered(client);
        return  res;
    }
}
