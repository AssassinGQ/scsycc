package cn.AssassinG.scsycc.entitys.User.dao;

import cn.AssassinG.scsycc.common.dao.BaseDao;
import cn.AssassinG.scsycc.entitys.User.entity.Permission;
import cn.AssassinG.scsycc.entitys.User.entity.Role;

import java.util.Set;

public interface RoleDao extends BaseDao<Role> {
    Set<Role> findByUserId(long Id);
    Set<Role> findByUsername(String UserName);
}
