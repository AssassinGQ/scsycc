package cn.AssassinG.scsycc.entitys.User.dao;

import cn.AssassinG.scsycc.common.dao.BaseDaoImpl;
import cn.AssassinG.scsycc.entitys.User.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    public User findByUserName(String userName) {
        return super.getSqlSession().selectOne(getStatement("findByUserNo"), userName);
    }
}
