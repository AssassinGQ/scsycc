package cn.AssassinG.scsycc.entitys.User.biz;

import cn.AssassinG.scsycc.common.entity.BaseEntity;
import cn.AssassinG.scsycc.entitys.User.dao.*;
import cn.AssassinG.scsycc.entitys.User.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RolePermissionDao rolePermissionDao;
    @Autowired
    private PermissionDao permissionDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public long create(User user) {
        return userDao.insert(user);
    }

    public boolean update(User user) {
        int result = userDao.update(user);
        return result == 1;
    }

    public User findUserById(Long userId) {
        User user = userDao.getById(userId);
        if(user == null || user.isDeleted())
            return null;
        else
            return user;
    }

    public void deleteUserById(long userId) {
        User user = userDao.getById(userId);
        if (user != null) {
            userDao.delete(user.getId());
        }
    }

    public User findUserByUname(String username){
        User user = userDao.findByUserName(username);
        if(user == null || user.isDeleted())
            return null;
        else
            return user;
    }

    @Override
    public Set<Permission> findUserPermissions(String username) {
        User user = userDao.findByUserName(username);
        if(user == null || user.isDeleted())
            return null;
        Set<Role> roles = roleDao.findByUserId(user.getId());
        Set<Permission> permissions = new HashSet<Permission>();
        for(Role role : roles){
            permissions.addAll(permissionDao.findByRoleId(role.getId()));
        }
        return permissions;
    }

    @Override
    public List<Permission> findAll() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("isDeleted", false);
        return permissionDao.listBy(params);
    }

    @Override
    public boolean addPermissionToRole(Long roleid, Long permissionid) {
        Role role = roleDao.getById(roleid);
        if(role == null || role.isDeleted())
            return false;
        Permission permission = permissionDao.getById(permissionid);
        if(permission == null || permission.isDeleted())
            return false;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("RoleId", role.getId());
        params.put("PermissionId", permission.getId());
        Role_Permission role_permission = rolePermissionDao.getBy(params);
        if(role_permission == null){
            Role_Permission role_permission_new = new Role_Permission();
            role_permission_new.setRoleId(role.getId());
            role_permission_new.setPermissionId(permission.getId());
            rolePermissionDao.insert(role_permission_new);
            return true;
        }else{
            if(role_permission.isDeleted()){
                role_permission.setDeleted(false);
                rolePermissionDao.update(role_permission);
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public boolean removePermissionFromRole(Long roleid, Long permissionid) {
        Role role = roleDao.getById(roleid);
        if(role == null || role.isDeleted())
            return false;
        Permission permission = permissionDao.getById(permissionid);
        if(permission == null || permission.isDeleted())
            return false;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("RoleId", role.getId());
        params.put("PermissionId", permission.getId());
        Role_Permission role_permission = rolePermissionDao.getBy(params);
        if(role_permission == null || role_permission.isDeleted()){
            return false;
        }else{
            rolePermissionDao.delete(role_permission);
            return true;
        }
    }

    @Override
    public boolean addUserRole(Long userid, Long roleid) {
        User user = userDao.getById(userid);
        if(user == null || user.isDeleted())
            return false;
        Role role = roleDao.getById(roleid);
        if(role == null || role.isDeleted())
            return false;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("UserId", user.getId());
        params.put("RoleId", role.getId());
        User_Role user_role = userRoleDao.getBy(params);
        if(user_role == null){
            User_Role user_role_new = new User_Role();
            user_role_new.setUserId(user.getId());
            user_role_new.setRoleId(role.getId());
            userRoleDao.insert(user_role_new);
            return true;
        }else{
            if(user_role.isDeleted()){
                user_role.setDeleted(false);
                userRoleDao.update(user_role);
                return true;
            }else
                return false;
        }
    }

    @Override
    public boolean removeUserRole(Long userid, Long roleid) {
        User user = userDao.getById(userid);
        if(user == null || user.isDeleted())
            return false;
        Role role = roleDao.getById(roleid);
        if(role == null || role.isDeleted())
            return false;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("UserId", user.getId());
        params.put("RoleId", role.getId());
        User_Role user_role = userRoleDao.getBy(params);
        if(user_role == null || user_role.isDeleted()){
            return false;
        }else{
            userRoleDao.delete(user_role);
            return true;
        }
    }
}
