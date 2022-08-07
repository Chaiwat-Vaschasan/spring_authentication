package authorization.controller;

import authorization.model.AccountDetailModel;
import authorization.model.ResponseModel;
import authorization.service.AccountService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/account")
public class AccountController {

    @Autowired private AccountService accountService;

    @PostMapping("/registered")
    public ResponseModel<UUID> registered(@RequestBody AccountDetailModel item){
        var res = accountService.registered(item);
        return  res;
    }
}
