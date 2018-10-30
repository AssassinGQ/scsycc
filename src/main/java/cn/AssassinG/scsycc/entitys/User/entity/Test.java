package cn.AssassinG.scsycc.entitys.User.entity;

import cn.AssassinG.scsycc.common.entity.BaseEntity;

public class Test extends BaseEntity {
    private String IP;

    public Test() {
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    @Override
    public String toString() {
        return "Test{" +
                "IP='" + IP + '\'' +
                ", UpdateTime=" + UpdateTime +
                ", IsDeleted=" + IsDeleted +
                '}';
    }
}
