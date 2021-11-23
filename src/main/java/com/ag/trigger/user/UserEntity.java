package com.ag.trigger.user;

import com.ag.trigger.model.PersonEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Data
public class UserEntity extends PersonEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;


}
