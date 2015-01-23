/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.data.jpa.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nicolas
 */
@Entity
@Table(name = "userrole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userrole.findAll", query = "SELECT u FROM Userrole u"),
    @NamedQuery(name = "Userrole.findById", query = "SELECT u FROM Userrole u WHERE u.id = :id"),
    @NamedQuery(name = "Userrole.findByRole", query = "SELECT u FROM Userrole u WHERE u.role = :role"),
    @NamedQuery(name = "Userrole.findByUseremail", query = "SELECT u FROM Userrole u WHERE u.useremail = :useremail"),
    @NamedQuery(name = "Userrole.findByUsersIdusers", query = "SELECT u FROM Userrole u WHERE u.usersIdusers = :usersIdusers")})
public class Userrole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "role")
    private String role;
    @Size(max = 255)
    @Column(name = "useremail")
    private String useremail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "users_idusers")
    private int usersIdusers;
    @JoinColumn(name = "usersidusers", referencedColumnName = "idusers")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Users usersidusers;

    public Userrole() {
    }

    public Userrole(Integer id) {
        this.id = id;
    }

    public Userrole(Integer id, int usersIdusers) {
        this.id = id;
        this.usersIdusers = usersIdusers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public int getUsersIdusers() {
        return usersIdusers;
    }

    public void setUsersIdusers(int usersIdusers) {
        this.usersIdusers = usersIdusers;
    }

    public Users getUsersidusers() {
        return usersidusers;
    }

    public void setUsersidusers(Users usersidusers) {
        this.usersidusers = usersidusers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userrole)) {
            return false;
        }
        Userrole other = (Userrole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infinity.data.jpa.domain.Userrole[ id=" + id + " ]";
    }
    
}
