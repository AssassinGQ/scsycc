package cn.AssassinG.scsycc.entitys.User.dao;

import cn.AssassinG.scsycc.common.dao.BaseDaoImpl;
import cn.AssassinG.scsycc.entitys.User.entity.Permission;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class PermissionDaoImpl extends BaseDaoImpl<Permission> implements PermissionDao {
    public static final String SQL_FINDBYUSERID = "listByUserId";
    public static final String SQL_FINDBYUSERNAME = "listByUsername";

    @Override
    public Set<Permission> findByUserId(long id) {
        List<Permission> permissions = super.getSessionTemplate().selectList(super.getStatement(SQL_FINDBYUSERID), id);
        Set<Permission> ret = new HashSet<Permission>();
        ret.addAll(permissions);
        return ret;
    }

    @Override
    public Set<Permission> findByUsername(String username) {
        List<Permission> permissions = super.getSessionTemplate().selectList(super.getStatement(SQL_FINDBYUSERNAME), username);
        Set<Permission> ret = new HashSet<Permission>();
        ret.addAll(permissions);
        return ret;
    }
}
