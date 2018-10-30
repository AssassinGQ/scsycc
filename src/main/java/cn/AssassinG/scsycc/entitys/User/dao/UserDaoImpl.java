package cn.AssassinG.scsycc.entitys.User.dao;

import cn.AssassinG.scsycc.common.dao.BaseDaoImpl;
import cn.AssassinG.scsycc.common.exception.DaoException;
import cn.AssassinG.scsycc.entitys.User.entity.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User findByUserName(String UserName) {
        List<User> results = super.getSessionTemplate().selectList(super.getStatement("findByUserNo"), UserName);
        if (results.size() == 0)
            return null;
        else if(results.size() > 1)
            throw DaoException.DB_FINDBYUSERNAME_TOOMANY_RESULT.newInstance("数据库操作,findByUserName返回多个结果.{%s},UserName{%s}", getStatement("findByUserNo"), UserName);
        else
            return results.get(0);
    }
}
