drop table if exists t_usergroup;

create table t_usergroup (
  id            BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'ID',
  create_time   DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
  update_time   DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  delete_time   DATETIME COMMENT '删除时间',
  usergroup_name  VARCHAR(20) COMMENT '用户组名称',
  father_group_id BIGINT(20) COMMENT '父用户组id',
  PRIMARY KEY (id)
);

alter table t_usergroup comment '用户组信息表';

## 用户组的初始化数据
insert into t_usergroup(usergroup_name) values ("超级管理用户组");