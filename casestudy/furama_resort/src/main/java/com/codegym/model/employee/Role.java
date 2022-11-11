package com.codegym.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String roleName;
    @Column(columnDefinition = "int default 1")
    private int status = 1;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Role(Integer roleId, String roleName, int status, Set<User> users) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.status = status;
        this.users = users;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}