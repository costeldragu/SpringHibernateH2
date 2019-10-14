package com.mdc.database.models;

import lombok.Builder;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
@Data
@Builder
@Audited
public class User {
    @Id
    @GeneratedValue
    private Long uid;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany
    @JoinTable(name = "ROLES" ,joinColumns = @JoinColumn( name="UID"))
    List<Role> roleList;
}
