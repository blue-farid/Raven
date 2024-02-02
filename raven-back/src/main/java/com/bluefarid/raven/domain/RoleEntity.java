package com.bluefarid.raven.domain;

import com.bluefarid.raven.security.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role name;

    @Override
    public String getAuthority() {
        return name.name();
    }
}
