drop table if exists t_usergroup;

create table t_usergroup (
  id            BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'ID',
  create_time   DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
  update_time   DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  delete_time   DATETIME COMMENT '删除时间',
  is_deleted   BOOLEAN NOT NULL DEFAULT false COMMENT '数据是否已经删除',
  usergroup_name  VARCHAR(20) COMMENT '用户组名称，唯一',
  usergroup_desc  VARCHAR(20) COMMENT '用户组描述',
  fathergroup_name VARCHAR(20) COMMENT '父用户组名称',
  PRIMARY KEY (id)
);

alter table t_usergroup comment '用户组信息表';

## 用户组的初始化数据
insert into t_usergroup(usergroup_name, usergroup_desc) values ("superadmin", "超级管理员");
insert into t_usergroup(usergroup_name, usergroup_desc, fathergroup_name) values ("corpration", "承运方账号", "superadmin");
insert into t_usergroup(usergroup_name, usergroup_desc, fathergroup_name) values ("government", "政府账号", "superadmin");
insert into t_usergroup(usergroup_name, usergroup_desc, fathergroup_name) values ("admin_warehouse", "库管", "corporation");
insert into t_usergroup(usergroup_name, usergroup_desc, fathergroup_name) values ("admin_project", "项目管理员", "corporation");
insert into t_usergroup(usergroup_name, usergroup_desc, fathergroup_name) values ("admin_finance", "财务管理员", "corporation");
insert into t_usergroup(usergroup_name, usergroup_desc, fathergroup_name) values ("partner_consignor", "客户", "corporation");
insert into t_usergroup(usergroup_name, usergroup_desc, fathergroup_name) values ("partner_manufacturer", "生产厂家", "corporation");
insert into t_usergroup(usergroup_name, usergroup_desc, fathergroup_name) values ("partner_receiver", "收货方", "corporation");
insert into t_usergroup(usergroup_name, usergroup_desc, fathergroup_name) values ("admin_finance", "财务管理员", "corporation");
insert into t_usergroup(usergroup_name, usergroup_desc, fathergroup_name) values ("employee_driver", "驾驶员", "corporation");
insert into t_usergroup(usergroup_name, usergroup_desc, fathergroup_name) values ("employee_supervisor", "监装员", "corporation");
insert into t_usergroup(usergroup_name, usergroup_desc, fathergroup_name) values ("employee_craneman", "起重工", "corporation");
insert into t_usergroup(usergroup_name, usergroup_desc, fathergroup_name) values ("employee_cranedriver", "行车工", "corporation");


