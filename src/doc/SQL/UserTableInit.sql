drop table if exists t_user;

create table t_user (
  id          BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'ID',
  create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
  update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  delete_time DATETIME COMMENT '删除时间',
  user_name   VARCHAR(20) COMMENT '登录用户名',
  password    VARCHAR(20) COMMENT '登录密码',
  PRIMARY KEY (id)
);

alter table t_user comment '用户信息表';

## 用户的初始化数据（密码123456）
insert into t_user(user_name, password) values ("superadmin", "123456");