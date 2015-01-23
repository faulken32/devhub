/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinityweb.devhub.data.jpa.domain;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author faulken
 */
@Entity
@Table(name = "usershasfriends")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usershasfriends.findAll", query = "SELECT u FROM Usershasfriends u"),
    @NamedQuery(name = "Usershasfriends.findByIdfriends", query = "SELECT u FROM Usershasfriends u WHERE u.idfriends = :idfriends")})
public class Usershasfriends implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfriends")
    private Integer idfriends;
    @JoinColumn(name = "usersidusersfriends", referencedColumnName = "idusers")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Users usersidusersfriends;
    @JoinColumn(name = "usersidusers", referencedColumnName = "idusers")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Users usersidusers;

    public Usershasfriends() {
    }

    public Usershasfriends(Integer idfriends) {
        this.idfriends = idfriends;
    }

    public Integer getIdfriends() {
        return idfriends;
    }

    public void setIdfriends(Integer idfriends) {
        this.idfriends = idfriends;
    }

    public Users getUsersidusersfriends() {
        return usersidusersfriends;
    }

    public void setUsersidusersfriends(Users usersidusersfriends) {
        this.usersidusersfriends = usersidusersfriends;
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
        hash += (idfriends != null ? idfriends.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usershasfriends)) {
            return false;
        }
        Usershasfriends other = (Usershasfriends) object;
        if ((this.idfriends == null && other.idfriends != null) || (this.idfriends != null && !this.idfriends.equals(other.idfriends))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infinityweb.devhub.data.jpa.domain.Usershasfriends[ idfriends=" + idfriends + " ]";
    }
    
}
