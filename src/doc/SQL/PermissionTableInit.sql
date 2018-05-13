drop table if exists t_permission;

create table t_permission (
  id          BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'ID',
  create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
  update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  delete_time DATETIME COMMENT '删除时间',
  is_deleted   BOOLEAN NOT NULL DEFAULT false COMMENT '数据是否已经删除',
  permission_name   VARCHAR(20) COMMENT '权限名称',
  PRIMARY KEY (id)
);

alter table t_permission comment '权限信息表';

## 权限的初始化数据
insert into t_permission(permission_name) values ("RES_PAGE_HOME");
insert into t_permission(permission_name) values ("RES_PAGE_HOME2");