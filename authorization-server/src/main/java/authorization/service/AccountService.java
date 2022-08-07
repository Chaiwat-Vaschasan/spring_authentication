package authorization.service;

import authorization.entity.Account;
import authorization.model.AccountDetailModel;
import authorization.model.ResponseModel;
import authorization.repository.AccountRepository;
import authorization.repository.RoleRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService implements UserDetailsService {

    @Autowired private AccountRepository accountRepository;
    @Autowired private RoleRepository roleRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var account =  accountRepository.findByUsername(username)
                               .orElseThrow(() -> new UsernameNotFoundException("Not found user : " + username));

        var role = roleRepository.findRoleNameByAccountId(account.getAccountId());
        var accountDetail = new AccountDetailModel();
        accountDetail.setAccount(account,role);

        return accountDetail;
    }

    public ResponseModel<UUID> registered(AccountDetailModel item){
        var res = new ResponseModel<UUID>();
        var duplicate= accountRepository.findByUsername(item.getUsername());

        if(duplicate.isPresent()){
            res.setError("This username has already been used.");
        }else{
            UUID id = UUID.randomUUID();
            item.setAccountId(id);
            item.setPassword(passwordEncoder.encode(item.getPassword()));
            Account newAccount = new Account();
            newAccount.create(item,"system");
            accountRepository.save(newAccount);
            res.setSuccess(id);
        }
        return res;
    }
}
