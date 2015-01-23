/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.data.jpa.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nicolas
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByIdusers", query = "SELECT u FROM Users u WHERE u.idusers = :idusers"),
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByAdress", query = "SELECT u FROM Users u WHERE u.adress = :adress"),
    @NamedQuery(name = "Users.findByCreationdate", query = "SELECT u FROM Users u WHERE u.creationdate = :creationdate"),
    @NamedQuery(name = "Users.findByCity", query = "SELECT u FROM Users u WHERE u.city = :city"),
    @NamedQuery(name = "Users.findByPass", query = "SELECT u FROM Users u WHERE u.pass = :pass")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusers")
    private Integer idusers;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "adress")
    private String adress;
    @Column(name = "creationdate")
    @Temporal(TemporalType.DATE)
    private Date creationdate;
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    @Size(max = 100)
    @Column(name = "pass")
    private String pass;
    @ManyToMany(mappedBy = "usersCollection", fetch = FetchType.EAGER)
    private Collection<Project> projectCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersidusers", fetch = FetchType.EAGER)
    private Collection<Code> codeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersidusers", fetch = FetchType.EAGER)
    private Collection<Userlike> userlikeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersidusers", fetch = FetchType.EAGER)
    private Collection<Userrole> userroleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersidusers", fetch = FetchType.EAGER)
    private Collection<Usershasfriends> usershasfriendsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersidusersfriends", fetch = FetchType.EAGER)
    private Collection<Usershasfriends> usershasfriendsCollection1;
    @JoinColumn(name = "countryid", referencedColumnName = "idcountry")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Country countryid;

    public Users() {
    }

    public Users(Integer idusers) {
        this.idusers = idusers;
    }

    public Integer getIdusers() {
        return idusers;
    }

    public void setIdusers(Integer idusers) {
        this.idusers = idusers;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    @XmlTransient
    public Collection<Code> getCodeCollection() {
        return codeCollection;
    }

    public void setCodeCollection(Collection<Code> codeCollection) {
        this.codeCollection = codeCollection;
    }

    @XmlTransient
    public Collection<Userlike> getUserlikeCollection() {
        return userlikeCollection;
    }

    public void setUserlikeCollection(Collection<Userlike> userlikeCollection) {
        this.userlikeCollection = userlikeCollection;
    }

    @XmlTransient
    public Collection<Userrole> getUserroleCollection() {
        return userroleCollection;
    }

    public void setUserroleCollection(Collection<Userrole> userroleCollection) {
        this.userroleCollection = userroleCollection;
    }

    @XmlTransient
    public Collection<Usershasfriends> getUsershasfriendsCollection() {
        return usershasfriendsCollection;
    }

    public void setUsershasfriendsCollection(Collection<Usershasfriends> usershasfriendsCollection) {
        this.usershasfriendsCollection = usershasfriendsCollection;
    }

    @XmlTransient
    public Collection<Usershasfriends> getUsershasfriendsCollection1() {
        return usershasfriendsCollection1;
    }

    public void setUsershasfriendsCollection1(Collection<Usershasfriends> usershasfriendsCollection1) {
        this.usershasfriendsCollection1 = usershasfriendsCollection1;
    }

    public Country getCountryid() {
        return countryid;
    }

    public void setCountryid(Country countryid) {
        this.countryid = countryid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusers != null ? idusers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idusers == null && other.idusers != null) || (this.idusers != null && !this.idusers.equals(other.idusers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infinity.data.jpa.domain.Users[ idusers=" + idusers + " ]";
    }
    
}
