package com.example.oauthserver.domain.role;

import com.example.oauthserver.domain.member.Member;
import com.example.oauthserver.domain.privilege.Privilege;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Where(clause = "deleted = 0")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<Member> members;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id")
    )
    private Collection<Privilege> privileges;

    @Column
    private boolean deleted;

    public void deleted(){
        this.deleted = false;
    }

}
