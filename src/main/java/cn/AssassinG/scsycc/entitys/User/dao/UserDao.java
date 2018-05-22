package cn.AssassinG.scsycc.entitys.User.dao;

import cn.AssassinG.scsycc.common.dao.BaseDao;
import cn.AssassinG.scsycc.entitys.User.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserDao extends BaseDao<User> {
    User findByUserName(String userName);
//    UserWithRole findRoleById(long id);
//    UserWithPermission findPermissionById(long id);
//    UserWithRole findRoleByUserName(String userName);
//    UserWithPermission findPermissionByUserName(String userName);
}
