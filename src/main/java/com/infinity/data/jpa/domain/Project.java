/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.data.jpa.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nicolas
 */
@Entity
@Table(name = "project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findByIdproject", query = "SELECT p FROM Project p WHERE p.idproject = :idproject"),
    @NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p WHERE p.name = :name")})
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproject")
    private Integer idproject;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @JoinTable(name = "usershasproject", joinColumns = {
        @JoinColumn(name = "projectidproject", referencedColumnName = "idproject")}, inverseJoinColumns = {
        @JoinColumn(name = "usersidusers", referencedColumnName = "idusers")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Users> usersCollection;
    @JoinColumn(name = "languagesid", referencedColumnName = "idlanguages")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Languages languagesid;

    public Project() {
    }

    public Project(Integer idproject) {
        this.idproject = idproject;
    }

    public Integer getIdproject() {
        return idproject;
    }

    public void setIdproject(Integer idproject) {
        this.idproject = idproject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    public Languages getLanguagesid() {
        return languagesid;
    }

    public void setLanguagesid(Languages languagesid) {
        this.languagesid = languagesid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproject != null ? idproject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.idproject == null && other.idproject != null) || (this.idproject != null && !this.idproject.equals(other.idproject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infinity.data.jpa.domain.Project[ idproject=" + idproject + " ]";
    }
    
}
