package cn.AssassinG.scsycc.entitys.User.biz;

import cn.AssassinG.scsycc.entitys.User.dao.PermissionDaoImpl;
import cn.AssassinG.scsycc.entitys.User.dao.RoleDaoImpl;
import cn.AssassinG.scsycc.entitys.User.dao.RolePermissionDao;
import cn.AssassinG.scsycc.entitys.User.dao.UserRoleDaoImpl;
import cn.AssassinG.scsycc.entitys.User.entity.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserServices userServices;
    @Autowired
    private UserRoleDaoImpl userRoleDao;
    @Autowired
    private RoleDaoImpl roleDao;
    @Autowired
    private RolePermissionDao rolePermissionDao;
    @Autowired
    private PermissionDaoImpl permissionDao;
    private static Logger logger = Logger.getLogger(MyUserDetailService.class);
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userServices.findUserByUname(s);
        if(user == null)
            throw new UsernameNotFoundException("");
        logger.info(user);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("UserId", user.getId());
        List<User_Role> user_roles = userRoleDao.listBy(paramMap);
        List<Permission> permissions = new ArrayList<Permission>();
        for(User_Role user_role : user_roles){
            logger.info(user_role);
            paramMap.clear();
            paramMap.put("RoleId", user_role.getRoleId());
            List<Role_Permission> role_permissions = rolePermissionDao.listBy(paramMap);
            for(Role_Permission role_permission : role_permissions){
                permissions.add(permissionDao.getById(role_permission.getPermissionId()));
            }
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for(Permission permission : permissions){
            logger.info(permission);
            authorities.add(new SimpleGrantedAuthority(permission.getPermissionName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
