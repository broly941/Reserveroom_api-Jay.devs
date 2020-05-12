package com.javainuse.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends PersistenceEntity {
    public static final String ATTRIBUTE_ROLES = "roles";
    public static final String ATTRIBUTE_USER_NAME = "userName";

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MOBILE_PHONE_NUMBER")
    private String mobilePhoneNumber;

    //	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "USER_ROLES",
//			joinColumns = @JoinColumn(name = "FK_APPLICATION_USER_ID", nullable = false),
//			inverseJoinColumns = @JoinColumn(name = "FK_ROLE_ID", nullable = false))
//	private Set<RoleEntity> roles = new HashSet<>();

    @OneToMany(mappedBy = Event.ATTRIBUTE_USER)
    Set<Event> events;
}