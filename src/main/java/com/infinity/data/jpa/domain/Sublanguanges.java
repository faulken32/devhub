/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.data.jpa.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nicolas
 */
@Entity
@Table(name = "sublanguanges")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sublanguanges.findAll", query = "SELECT s FROM Sublanguanges s"),
    @NamedQuery(name = "Sublanguanges.findByIdsublanguanges", query = "SELECT s FROM Sublanguanges s WHERE s.idsublanguanges = :idsublanguanges"),
    @NamedQuery(name = "Sublanguanges.findByName", query = "SELECT s FROM Sublanguanges s WHERE s.name = :name")})
public class Sublanguanges implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsublanguanges")
    private Integer idsublanguanges;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sublanguangesid", fetch = FetchType.EAGER)
    private Collection<Code> codeCollection;
    @JoinColumn(name = "languagesid", referencedColumnName = "idlanguages")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Languages languagesid;

    public Sublanguanges() {
    }

    public Sublanguanges(Integer idsublanguanges) {
        this.idsublanguanges = idsublanguanges;
    }

    public Integer getIdsublanguanges() {
        return idsublanguanges;
    }

    public void setIdsublanguanges(Integer idsublanguanges) {
        this.idsublanguanges = idsublanguanges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Code> getCodeCollection() {
        return codeCollection;
    }

    public void setCodeCollection(Collection<Code> codeCollection) {
        this.codeCollection = codeCollection;
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
        hash += (idsublanguanges != null ? idsublanguanges.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sublanguanges)) {
            return false;
        }
        Sublanguanges other = (Sublanguanges) object;
        if ((this.idsublanguanges == null && other.idsublanguanges != null) || (this.idsublanguanges != null && !this.idsublanguanges.equals(other.idsublanguanges))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infinity.data.jpa.domain.Sublanguanges[ idsublanguanges=" + idsublanguanges + " ]";
    }
    
}
