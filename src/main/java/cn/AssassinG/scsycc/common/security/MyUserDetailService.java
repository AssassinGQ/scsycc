package cn.AssassinG.scsycc.common.security;

import cn.AssassinG.scsycc.entitys.User.biz.UserService;
import cn.AssassinG.scsycc.entitys.User.entity.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;
    private static Logger logger = Logger.getLogger(MyUserDetailService.class);
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findUserByUname(s);
        if(user == null)
            throw new UsernameNotFoundException("");
        Set<Permission> permissions = userService.findUserPermissions(user.getId());
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for(Permission permission : permissions){
            logger.info(permission);
            authorities.add(new SimpleGrantedAuthority(permission.getPermissionName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassWord(), authorities);
    }
}
