package com.ecommerceback.Model.User;

import com.ecommerceback.Model.Card.Card;
import com.ecommerceback.Model.Localization.LocalizationModel;
import com.ecommerceback.Model.User.Enum.TypeUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class UserModel implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String name;
    @NotNull
    @Column(unique = true)
    @Email(message = "Email inválido")
    private String email;
    @NotNull
    @Column(unique = true)
    private String cpf;
    private String phone;
    @ElementCollection(fetch=FetchType.EAGER)
    private Set<Integer> typeUser = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<LocalizationModel> address_user = new ArrayList<LocalizationModel>();
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Card> cards_id = new ArrayList<Card>();

    public UserModel() {
    }

    public UserModel(Long id_user, String name, String email, String cpf, String phone, TypeUser typeUser, List<LocalizationModel> address_user) {
        this.id_user = id_user;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
        setTypeUser(typeUser.equals("")?TypeUser.USER: TypeUser.toEnum(typeUser.getCode()));
        this.address_user = address_user;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<TypeUser> getTypeUser() {
        return typeUser.stream().map(x -> TypeUser.toEnum(x)).collect(Collectors.toSet());
    }
    public void setTypeUser(TypeUser type) {
        typeUser.add(type.getCode());
    }



    public List<LocalizationModel> getAddress_user() {
        return address_user;
    }

    public void setAddress_user(List<LocalizationModel> address_user) {
        this.address_user = address_user;
    }

}
