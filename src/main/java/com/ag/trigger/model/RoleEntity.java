package com.ag.trigger.model;

import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "roles")
@Entity
public class RoleEntity extends BaseEntity {

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private ERole roleName;

    public RoleEntity() {
    }

    public RoleEntity(ERole roleName) {
        this.roleName = roleName;
    }
}
