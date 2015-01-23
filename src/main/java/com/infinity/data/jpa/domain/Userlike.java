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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nicolas
 */
@Entity
@Table(name = "userlike")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userlike.findAll", query = "SELECT u FROM Userlike u"),
    @NamedQuery(name = "Userlike.findByIduserlike", query = "SELECT u FROM Userlike u WHERE u.iduserlike = :iduserlike")})
public class Userlike implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iduserlike")
    private Integer iduserlike;
    @Lob
    @Size(max = 65535)
    @Column(name = "comments")
    private String comments;
    @JoinColumn(name = "codeidcode", referencedColumnName = "idcode")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Code codeidcode;
    @JoinColumn(name = "usersidusers", referencedColumnName = "idusers")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Users usersidusers;

    public Userlike() {
    }

    public Userlike(Integer iduserlike) {
        this.iduserlike = iduserlike;
    }

    public Integer getIduserlike() {
        return iduserlike;
    }

    public void setIduserlike(Integer iduserlike) {
        this.iduserlike = iduserlike;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Code getCodeidcode() {
        return codeidcode;
    }

    public void setCodeidcode(Code codeidcode) {
        this.codeidcode = codeidcode;
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
        hash += (iduserlike != null ? iduserlike.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userlike)) {
            return false;
        }
        Userlike other = (Userlike) object;
        if ((this.iduserlike == null && other.iduserlike != null) || (this.iduserlike != null && !this.iduserlike.equals(other.iduserlike))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infinity.data.jpa.domain.Userlike[ iduserlike=" + iduserlike + " ]";
    }
    
}
