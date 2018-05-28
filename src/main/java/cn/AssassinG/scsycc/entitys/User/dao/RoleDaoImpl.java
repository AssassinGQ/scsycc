package cn.AssassinG.scsycc.entitys.User.dao;

import cn.AssassinG.scsycc.common.dao.BaseDaoImpl;
import cn.AssassinG.scsycc.entitys.User.entity.Permission;
import cn.AssassinG.scsycc.entitys.User.entity.Role;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
    public static final String SQL_FINDBYUSERID = "listByUserId";
    public static final String SQL_FINDBYUSERNAME = "listByUsername";

    @Override
    public Set<Role> findByUserId(long id) {
        List<Role> roles = super.getSessionTemplate().selectList(super.getStatement(SQL_FINDBYUSERID), id);
        Set<Role> ret = new HashSet<Role>();
        ret.addAll(roles);
        Queue<Role> queue = new LinkedList<Role>();
        ((LinkedList<Role>) queue).addAll(roles);
        while(queue.size() > 0){
            Role role = queue.poll();
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("SuperRoleName", role.getRoleName());
            List<Role> tmproles = super.getSessionTemplate().selectList(super.getStatement(SQL_LIST_BY), params);
            ret.addAll(tmproles);
            for(Role tmprole : tmproles){
                queue.offer(tmprole);
            }
        }
        return ret;
    }

    @Override
    public Set<Role> findByUsername(String username) {
        List<Role> roles = super.getSessionTemplate().selectList(super.getStatement(SQL_FINDBYUSERNAME), username);
        Set<Role> ret = new HashSet<Role>();
        ret.addAll(roles);
        Queue<Role> queue = new LinkedList<Role>();
        ((LinkedList<Role>) queue).addAll(roles);
        while(queue.size() > 0){
            Role role = queue.poll();
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("SuperRoleName", role.getRoleName());
            List<Role> tmproles = super.getSessionTemplate().selectList(super.getStatement(SQL_LIST_BY), params);
            ret.addAll(tmproles);
            for(Role tmprole : tmproles){
                queue.offer(tmprole);
            }
        }
        return ret;
    }
}
