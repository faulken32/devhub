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
@Table(name = "languages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Languages.findAll", query = "SELECT l FROM Languages l"),
    @NamedQuery(name = "Languages.findByIdlanguages", query = "SELECT l FROM Languages l WHERE l.idlanguages = :idlanguages"),
    @NamedQuery(name = "Languages.findByName", query = "SELECT l FROM Languages l WHERE l.name = :name")})
public class Languages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlanguages")
    private Integer idlanguages;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languagesid", fetch = FetchType.EAGER)
    private Collection<Code> codeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languagesid", fetch = FetchType.EAGER)
    private Collection<Sublanguanges> sublanguangesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languagesid", fetch = FetchType.EAGER)
    private Collection<Project> projectCollection;

    public Languages() {
    }

    public Languages(Integer idlanguages) {
        this.idlanguages = idlanguages;
    }

    public Integer getIdlanguages() {
        return idlanguages;
    }

    public void setIdlanguages(Integer idlanguages) {
        this.idlanguages = idlanguages;
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

    @XmlTransient
    public Collection<Sublanguanges> getSublanguangesCollection() {
        return sublanguangesCollection;
    }

    public void setSublanguangesCollection(Collection<Sublanguanges> sublanguangesCollection) {
        this.sublanguangesCollection = sublanguangesCollection;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlanguages != null ? idlanguages.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Languages)) {
            return false;
        }
        Languages other = (Languages) object;
        if ((this.idlanguages == null && other.idlanguages != null) || (this.idlanguages != null && !this.idlanguages.equals(other.idlanguages))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infinity.data.jpa.domain.Languages[ idlanguages=" + idlanguages + " ]";
    }
    
}
