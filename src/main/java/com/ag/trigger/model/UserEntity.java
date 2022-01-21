package com.ag.trigger.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "telephone")
        })
@Data
public class UserEntity extends PersonEntity {

    @Column(name = "username")
    @NotEmpty
    private String username;

    @Column(name = "password")
    @NotEmpty
    private String password;

    @Column(name = "email")
    @NotEmpty
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();

    public UserEntity(@NotBlank String username, @NotBlank @Email String email, @NotBlank String telephone, @NotBlank String firstName, @NotBlank String lastName, String encode) {
    }

    public UserEntity(String username, String password, String email, String telephone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.telephone = telephone;

    }

    public UserEntity() {
    }
}
