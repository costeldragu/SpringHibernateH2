package com.mdc.database.models;

import lombok.Builder;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
@Data
@Builder
@Audited
public class Role {
    @Id
    @GeneratedValue
    private Long rid;
    private Long uid;
    private String roleName;
}
