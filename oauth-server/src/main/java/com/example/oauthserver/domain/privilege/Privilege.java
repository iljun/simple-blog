package com.example.oauthserver.domain.privilege;

import com.example.oauthserver.domain.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = 0")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

    @Column
    private boolean deleted;

    public void deleted(){
        this.deleted = false;
    }
}
