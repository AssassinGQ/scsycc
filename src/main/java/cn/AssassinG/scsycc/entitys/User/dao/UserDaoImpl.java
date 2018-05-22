package cn.AssassinG.scsycc.entitys.User.dao;

import cn.AssassinG.scsycc.common.dao.BaseDaoImpl;
import cn.AssassinG.scsycc.entitys.User.entity.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

//    public static final String SQL_FINDWITHROLE = "findUserWithRoleById";
//    public static final String SQL_FINDWITHPERMISSION = "findUserWithPermissionById";

    public User findByUserName(String userName) {
        return super.getSessionTemplate().selectOne(super.getStatement("findByUserNo"), userName);
    }

//    @Override
//    public UserWithRole findRoleById(long id) {
//        return super.getSessionTemplate().selectOne(super.getStatement("findUserWithRoleById"), id);
//    }
//
//    @Override
//    public UserWithPermission findPermissionById(long id) {
//        return super.getSessionTemplate().selectOne(super.getStatement("findUserWithPermissionById"), id);
//    }
//
//    @Override
//    public UserWithRole findRoleByUserName(String userName) {
//        return null;
//    }
//
//    @Override
//    public UserWithPermission findPermissionByUserName(String userName) {
//        return null;
//    }
}
