package org.app.data_base.entities;

import jakarta.persistence.*;

import java.util.Objects;

@NamedQuery(
        name = "Clients.findByLogin",
        query = "select c from Clients c where  c.login=:login"
)
@NamedQuery(
        name = "Clients.deleteByLogin",
        query = "delete from Clients c where c.login=:login"
)
@NamedQuery(
        name = "Clients.findMaxId",
        query = "select max(c.id) from Clients c"
)
@NamedQuery(
        name = "Clients.findAllClients",
        query = "select c from Clients c"
)
@Entity
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "role", nullable = false, length = 200)
    private String role;
    @Basic
    @Column(name = "login", nullable = false, length = 200, unique = true)
    private String login;
    @Basic
    @Column(name = "password", nullable = false, length = 254)
    private String password;

    public Clients(int id, String role, String login, String password) {
        this.id = id;
        this.role = role;
        this.login = login;
        this.password = password;
    }
    public Clients() {}
    public Clients(String role, String login, String password) {
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return id == clients.id && Objects.equals(role, clients.role) && Objects.equals(login, clients.login) && Objects.equals(password, clients.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, login, password);
    }

    @Override
    public String toString() {return "Clients [ id: " + this.id + ", role: " + this.role + ", login: " + this.login +
            ", password: " + this.password + "]";}
}
