/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuhd.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Duy Phu
 */
@Entity
@Table(name = "tblProductMark")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProductMark.findAll", query = "SELECT t FROM TblProductMark t")
    , @NamedQuery(name = "TblProductMark.findById", query = "SELECT t FROM TblProductMark t WHERE t.id = :id")
    , @NamedQuery(name = "TblProductMark.findByName", query = "SELECT t FROM TblProductMark t WHERE t.name = :name")
    , @NamedQuery(name = "TblProductMark.findBySingleCore", query = "SELECT t FROM TblProductMark t WHERE t.singleCore = :singleCore")
    , @NamedQuery(name = "TblProductMark.findByMultiCore", query = "SELECT t FROM TblProductMark t WHERE t.multiCore = :multiCore")
    , @NamedQuery(name = "TblProductMark.findByUrl", query = "SELECT t FROM TblProductMark t WHERE t.url = :url")
    , @NamedQuery(name = "TblProductMark.findByProductID", query = "SELECT t FROM TblProductMark t WHERE t.productID = :productID")})
public class TblProductMark implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "SingleCore")
    private Integer singleCore;
    @Column(name = "MultiCore")
    private Integer multiCore;
    @Column(name = "Url")
    private String url;
    @Column(name = "ProductID")
    private Integer productID;

    public TblProductMark() {
    }

    public TblProductMark(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSingleCore() {
        return singleCore;
    }

    public void setSingleCore(Integer singleCore) {
        this.singleCore = singleCore;
    }

    public Integer getMultiCore() {
        return multiCore;
    }

    public void setMultiCore(Integer multiCore) {
        this.multiCore = multiCore;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
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
        if (!(object instanceof TblProductMark)) {
            return false;
        }
        TblProductMark other = (TblProductMark) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "phuhd.entity.TblProductMark[ id=" + id + " ]";
    }
    
}
