package com.dont.forget.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "user_name"
        })
})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @Size(min = 6)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(
            mappedBy = "user",
            targetEntity = Item.class,
            fetch = FetchType.EAGER
            )
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId=true)
    private List<Item> userItem;

    @OneToMany(
            mappedBy = "user",
            targetEntity = ItemList.class,
            fetch = FetchType.EAGER
            )
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId=true)
    private List<ItemList> userList;

    public Users() {

    }

    public Users( String userName, Role role) {
        this.userName = userName;
        this.role = role;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Item> getUserItem() {
        return userItem;
    }

    public void setUserItem(List<Item> userItem) {
        this.userItem = userItem;
    }

    public List<ItemList> getUserList() {
        return userList;
    }

    public void setUserList(List<ItemList> userList) {
        this.userList = userList;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
