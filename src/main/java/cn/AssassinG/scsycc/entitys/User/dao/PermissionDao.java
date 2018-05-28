package cn.AssassinG.scsycc.entitys.User.dao;

import cn.AssassinG.scsycc.common.dao.BaseDao;
import cn.AssassinG.scsycc.entitys.User.entity.Permission;

import java.util.List;
import java.util.Set;

public interface PermissionDao extends BaseDao<Permission> {
    Set<Permission> findByRoleId(long id);
    Set<Permission> findByRolename(String rolename);
}
