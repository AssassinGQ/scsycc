drop table if exists t_usergroup_user;

create table t_usergroup_user (
  id            BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'ID',
  create_time   DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
  update_time   DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  delete_time   DATETIME COMMENT '删除时间',
  is_deleted   BOOLEAN NOT NULL DEFAULT false COMMENT '数据是否已经删除',
  usergroup_id  BIGINT(20) COMMENT '用户组id',
  user_id       BIGINT(20) COMMENT '用户id',
  PRIMARY KEY (id)
);

alter table t_usergroup_user comment '用户组用户关联表';

## 用户角色关联信息初始化
##insert into t_usergroup_user(user_id, role_id) values ("superadmin", "123456");