package authorization.controller;

import authorization.model.ResponseModel;
import authorization.model.RoleGroupModel;
import authorization.model.UserRoleModel;
import authorization.service.RoleService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/role")
public class RoleController {

    @Autowired private RoleService roleService;

    @PostMapping("/group/create")
    public ResponseModel<Integer> createRoleGroup(@RequestBody RoleGroupModel item){
        var res = roleService.createRoleGroup(item);
        return res;
    }

    @PostMapping("/group/update")
    public ResponseModel<Integer> updateRoleGroup(@RequestBody RoleGroupModel item){
        var res = roleService.updateRoleGroup(item);
        return res;
    }

    @PostMapping("/user/update")
    public ResponseModel<UUID> updateRoleGroup(@RequestBody UserRoleModel item){
        var res = roleService.updateAccountRole(item);
        return res;
    }

}
