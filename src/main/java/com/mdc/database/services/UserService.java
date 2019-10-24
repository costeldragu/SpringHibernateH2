package com.mdc.database.services;

import com.mdc.database.dto.RoleDto;
import com.mdc.database.dto.UserDto;
import com.mdc.database.models.Role;
import com.mdc.database.models.User;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    AuditReader auditReader;

    public User mapFromDto(UserDto userDto) {
        User user = new User();
        user.setUid(userDto.getUid());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());

        List<Role> roles = new ArrayList<>();

        for (RoleDto roleDto : userDto.getRoleList()) {
            Role role = new Role();
            role.setRoleName(roleDto.getRoleName());
            roles.add(role);
        }
        user.setRoleList(roles);
        return user;
    }

    public UserDto mapToDto(User user) {

        UserDto userDto = UserDto.builder()
                .uid(user.getUid())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .username(user.getUsername())
                .roleList(new ArrayList<>())
                .build();

        user.getRoleList().forEach(roleDto -> userDto.getRoleList().add(RoleDto.builder().roleName(roleDto.getRoleName()).build()));
        return userDto;
    }

    public List getAllRevision(Long userId) {
        return auditReader.createQuery()
                .forRevisionsOfEntity(User.class, true, true)
                .add(AuditEntity.id().eq(userId))
                .addOrder(AuditEntity.revisionNumber().asc())
                .getResultList();

    }
}
