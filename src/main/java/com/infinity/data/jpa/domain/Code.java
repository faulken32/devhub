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
import javax.persistence.Lob;
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
@Table(name = "code")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Code.findAll", query = "SELECT c FROM Code c"),
    @NamedQuery(name = "Code.findByIdcode", query = "SELECT c FROM Code c WHERE c.idcode = :idcode"),
    @NamedQuery(name = "Code.findByLike", query = "SELECT c FROM Code c WHERE c.like = :like"),
    @NamedQuery(name = "Code.findBySouscriptiondate", query = "SELECT c FROM Code c WHERE c.souscriptiondate = :souscriptiondate")})
public class Code implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcode")
    private Integer idcode;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "contends")
    private String contends;
    @Column(name = "like")
    private Integer like;
    @Column(name = "souscriptiondate")
    @Temporal(TemporalType.DATE)
    private Date souscriptiondate;
    @JoinColumn(name = "languagesid", referencedColumnName = "idlanguages")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Languages languagesid;
    @JoinColumn(name = "sublanguangesid", referencedColumnName = "idsublanguanges")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Sublanguanges sublanguangesid;
    @JoinColumn(name = "usersidusers", referencedColumnName = "idusers")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Users usersidusers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeidcode", fetch = FetchType.EAGER)
    private Collection<Userlike> userlikeCollection;

    public Code() {
    }

    public Code(Integer idcode) {
        this.idcode = idcode;
    }

    public Integer getIdcode() {
        return idcode;
    }

    public void setIdcode(Integer idcode) {
        this.idcode = idcode;
    }

    public String getContends() {
        return contends;
    }

    public void setContends(String contends) {
        this.contends = contends;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Date getSouscriptiondate() {
        return souscriptiondate;
    }

    public void setSouscriptiondate(Date souscriptiondate) {
        this.souscriptiondate = souscriptiondate;
    }

    public Languages getLanguagesid() {
        return languagesid;
    }

    public void setLanguagesid(Languages languagesid) {
        this.languagesid = languagesid;
    }

    public Sublanguanges getSublanguangesid() {
        return sublanguangesid;
    }

    public void setSublanguangesid(Sublanguanges sublanguangesid) {
        this.sublanguangesid = sublanguangesid;
    }

    public Users getUsersidusers() {
        return usersidusers;
    }

    public void setUsersidusers(Users usersidusers) {
        this.usersidusers = usersidusers;
    }

    @XmlTransient
    public Collection<Userlike> getUserlikeCollection() {
        return userlikeCollection;
    }

    public void setUserlikeCollection(Collection<Userlike> userlikeCollection) {
        this.userlikeCollection = userlikeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcode != null ? idcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Code)) {
            return false;
        }
        Code other = (Code) object;
        if ((this.idcode == null && other.idcode != null) || (this.idcode != null && !this.idcode.equals(other.idcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infinity.data.jpa.domain.Code[ idcode=" + idcode + " ]";
    }
    
}
