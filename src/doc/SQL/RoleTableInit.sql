drop table if exists t_role;

create table t_role (
  id          BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'ID',
  create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
  update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  delete_time DATETIME COMMENT '删除时间',
  role_name   VARCHAR(20) COMMENT '角色名称',
  PRIMARY KEY (id)
);

alter table t_role comment '角色信息表';

## 角色的初始化数据
insert into t_role(role_name) values ("超级管理员");