package authorization.service;

import authorization.entity.Role;
import authorization.entity.RoleGroup;
import authorization.model.ResponseModel;
import authorization.model.RoleGroupModel;
import authorization.model.UserRoleModel;
import authorization.repository.AccountRepository;
import authorization.repository.RoleGroupRepository;
import authorization.repository.RoleRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RoleService {

    @Autowired private RoleRepository roleRepository;
    @Autowired private RoleGroupRepository roleGroupRepository;
    @Autowired private AccountRepository accountRepository;

    public ResponseModel<Integer> createRoleGroup(RoleGroupModel item){
        var res = new ResponseModel<Integer>();

        var duplicate = roleGroupRepository.findByRoleName(item.getRoleName());
        if(duplicate.isPresent()){
            res.setError("This role name has already been used.");
        }else{
            var newItem = new RoleGroup();
            newItem.created(item,"system");
            roleGroupRepository.save(newItem);
            res.setSuccess(newItem.getRoleId());
        }

        return res;
    }

    public ResponseModel<Integer> updateRoleGroup(RoleGroupModel item){
        var res = new ResponseModel<Integer>();
        var update = roleGroupRepository.findById(item.getRoleId());

        if(!update.isPresent()){
            res.setError("Not found role group.");
            return res;
        }

        var updateItem = update.get();

        if(!updateItem.getRoleName().equals(item.getRoleName())){
            var duplicate = roleGroupRepository.findByRoleName(item.getRoleName());
            if(duplicate.isPresent()){
                res.setError("This role name has already been used.");
                return res;
            }
        }

        updateItem.updated(item,"system");
        roleGroupRepository.save(updateItem);
        res.setSuccess(updateItem.getRoleId());
        return res;
    }

    public ResponseModel<UUID> updateAccountRole(UserRoleModel item){
        var res = new ResponseModel<UUID>();
        var account = accountRepository.findById(item.getAccountId());

        if(account.isPresent()){
            List<Role> roleList = new ArrayList<>();
            for (var role: item.getRoleId()) {
                roleList.add(new Role(role,item.getAccountId()));
            }
            roleRepository.saveAll(roleList);
            res.setSuccess(account.get().getAccountId());
        }else{
            res.setError("Not found account.");
        }
        return res;
    }

}
