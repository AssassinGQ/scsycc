package cn.AssassinG.scsycc.entitys.User.dao;

import cn.AssassinG.scsycc.common.dao.BaseDao;
import cn.AssassinG.scsycc.entitys.User.entity.User;
import org.springframework.stereotype.Component;

public interface UserDao extends BaseDao<User> {
    User findByUserName(String userName);
}
