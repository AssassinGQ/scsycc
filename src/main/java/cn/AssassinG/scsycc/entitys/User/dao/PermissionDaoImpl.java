package cn.AssassinG.scsycc.entitys.User.dao;

import cn.AssassinG.scsycc.common.dao.BaseDaoImpl;
import cn.AssassinG.scsycc.entitys.User.entity.Permission;
import cn.AssassinG.scsycc.entitys.User.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class PermissionDaoImpl extends BaseDaoImpl<Permission> implements PermissionDao {
    public static final String SQL_FINDBYROLEID = "listByRoleId";
    public static final String SQL_FINDBYROLENAME = "listByRolename";

    @Override
    public Set<Permission> findByRoleId(long id) {
        List<Permission> permissions = super.getSessionTemplate().selectList(super.getStatement(SQL_FINDBYROLEID), id);
        Set<Permission> ret = new HashSet<Permission>();
        ret.addAll(permissions);
        return ret;
    }

    @Override
    public Set<Permission> findByRolename(String rolename) {
        List<Permission> permissions = super.getSessionTemplate().selectList(super.getStatement(SQL_FINDBYROLENAME), rolename);
        Set<Permission> ret = new HashSet<Permission>();
        ret.addAll(permissions);
        return ret;
    }
}
