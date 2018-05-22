package cn.AssassinG.scsycc.entitys.User.dao;

import cn.AssassinG.scsycc.common.dao.BaseDaoImpl;
import cn.AssassinG.scsycc.entitys.User.entity.Permission;
import cn.AssassinG.scsycc.entitys.User.entity.Role;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
    public static final String SQL_FINDBYUSERID = "listByUserId";
    public static final String SQL_FINDBYUSERNAME = "listByUsername";

    @Override
    public Set<Role> findByUserId(long id) {
        List<Role> roles = super.getSessionTemplate().selectList(super.getStatement(SQL_FINDBYUSERID), id);
        Set<Role> ret = new HashSet<Role>();
        ret.addAll(roles);
        return ret;
    }

    @Override
    public Set<Role> findByUsername(String username) {
        List<Role> roles = super.getSessionTemplate().selectList(super.getStatement(SQL_FINDBYUSERNAME), username);
        Set<Role> ret = new HashSet<Role>();
        ret.addAll(roles);
        return ret;
    }
}
