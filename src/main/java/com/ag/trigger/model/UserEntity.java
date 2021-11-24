package com.ag.trigger.model;

import com.ag.trigger.model.PersonEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user")
@Data
public class UserEntity extends PersonEntity {

    @Column(name = "email")
    @NotEmpty
    private String email;

    @Column(name = "telephone")
    @NotEmpty
    private String telephone;


}
