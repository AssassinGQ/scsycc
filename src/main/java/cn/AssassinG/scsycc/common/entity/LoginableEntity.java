package cn.AssassinG.scsycc.common.entity;

public abstract class LoginableEntity extends BaseEntity {
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
