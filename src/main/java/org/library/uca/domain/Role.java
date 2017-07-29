package org.library.uca.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends EntityBase {
	
    private String name;
    private Set<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
