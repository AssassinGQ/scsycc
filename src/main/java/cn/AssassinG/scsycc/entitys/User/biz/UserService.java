package cn.AssassinG.scsycc.entitys.User.biz;

import cn.AssassinG.scsycc.entitys.User.entity.Permission;
import cn.AssassinG.scsycc.entitys.User.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    long create(User user);
    boolean update(User user);
    void deleteUserById(long userId);
    User findUserById(Long userId);
    User findUserByUname(String username);
    Set<Permission> findUserPermissions(String username);
    List<Permission> findAll();
    boolean addPermissionToRole(Long roleid, Long permissionid);
    boolean removePermissionFromRole(Long roleid, Long permissionid);
    boolean addUserRole(Long userid, Long roleid);
    boolean removeUserRole(Long userid, Long roleid);
}
