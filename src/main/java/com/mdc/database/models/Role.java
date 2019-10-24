package com.mdc.database.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
@Data
@Audited(withModifiedFlag = true)
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue
    private Long rid;
    private String roleName;


}
