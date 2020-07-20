package com.n1b3lung0.cars.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String username;

    @Column(length = 60)
    private String password;

    private Boolean enabled;

    private String name;
    private String surname;

    @Column(unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = { "user_id", "role_id" })})
    private List<Role> roles;

    public Long         getId()                         { return id; }
    public void         setId(Long id)                  { this.id = id; }
    public String       getUsername()                   { return username; }
    public void         setUsername(String username)    { this.username = username; }
    public String       getPassword()                   { return password; }
    public void         setPassword(String password)    { this.password = password; }
    public Boolean      getEnabled()                    { return enabled; }
    public void         setEnabled(Boolean enabled)     { this.enabled = enabled; }
    public List<Role>   getRoles()                      { return roles; }
    public void         setRoles(List<Role> roles)      { this.roles = roles; }
    public String       getName()                       { return name; }
    public void         setName(String name)            { this.name = name; }
    public String       getSurname()                    { return surname; }
    public void         setSurname(String surname)      { this.surname = surname; }
    public String       getEmail()                      { return email; }
    public void         setEmail(String email)          { this.email = email; }

    private static final long serialVersionUID = 1L;
}