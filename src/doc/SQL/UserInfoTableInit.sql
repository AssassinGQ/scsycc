drop table if exists t_userinfo;

create table t_userinfo (
  id          BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'ID',
  create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
  update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  delete_time DATETIME COMMENT '删除时间',
  ##敏感信息
  open_id     TEXT COMMENT 'open_id',
  session_key TEXT COMMENT 'session_key',
  union_id    TEXT COMMENT 'union_id',
  phone       VARCHAR(20) COMMENT '手机号',
  ##userinfo
  nick_name   VARCHAR(100) COMMENT '昵称',
  avatar_url  TEXT COMMENT '头像url',
  gender      VARCHAR(10) COMMENT '性别',
  city        VARCHAR(30) COMMENT '城市',
  province    VARCHAR(30) COMMENT '省份',
  country     VARCHAR(30) COMMENT '国家',
  _language   VARCHAR(30) COMMENT '语言',
  ##other
  raw_data        TEXT COMMENT '不包括敏感信息的原始数据字符串，用于计算签名',
  signature       TEXT COMMENT '使用 sha1( rawData + sessionkey ) 得到字符串，用于校验用户信息',
  encrypted_data  TEXT COMMENT '包括敏感数据在内的完整用户信息的加密数据',
  iv              TEXT COMMENT '加密算法的初始向量',
  PRIMARY KEY (id)
);

alter table t_userinfo comment '用户信息表';

## 用户的初始化数据（密码123456）
##insert into t_userinfo(user_name, password) values ("superadmin", "123456");