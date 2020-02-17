package com.mdc.database.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
@Data
@Audited(withModifiedFlag = true)
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long uid;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "uid")
    List<Role> roleList;


}
