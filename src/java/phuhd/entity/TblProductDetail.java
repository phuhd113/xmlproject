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
@Table(name = "tblProductDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProductDetail.findAll", query = "SELECT t FROM TblProductDetail t")
    , @NamedQuery(name = "TblProductDetail.findById", query = "SELECT t FROM TblProductDetail t WHERE t.id = :id")
    , @NamedQuery(name = "TblProductDetail.findByCore", query = "SELECT t FROM TblProductDetail t WHERE t.core = :core")
    , @NamedQuery(name = "TblProductDetail.findByThread", query = "SELECT t FROM TblProductDetail t WHERE t.thread = :thread")
    , @NamedQuery(name = "TblProductDetail.findByFrequency", query = "SELECT t FROM TblProductDetail t WHERE t.frequency = :frequency")
    , @NamedQuery(name = "TblProductDetail.findByTurbo", query = "SELECT t FROM TblProductDetail t WHERE t.turbo = :turbo")
    , @NamedQuery(name = "TblProductDetail.findByMemoryType", query = "SELECT t FROM TblProductDetail t WHERE t.memoryType = :memoryType")
    , @NamedQuery(name = "TblProductDetail.findBySocket", query = "SELECT t FROM TblProductDetail t WHERE t.socket = :socket")
    , @NamedQuery(name = "TblProductDetail.findByOverClocking", query = "SELECT t FROM TblProductDetail t WHERE t.overClocking = :overClocking")
    , @NamedQuery(name = "TblProductDetail.findByTdp", query = "SELECT t FROM TblProductDetail t WHERE t.tdp = :tdp")
    , @NamedQuery(name = "TblProductDetail.findByProductID", query = "SELECT t FROM TblProductDetail t WHERE t.productID = :productID")})
public class TblProductDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Core")
    private Integer core;
    @Column(name = "Thread")
    private Integer thread;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Frequency")
    private Double frequency;
    @Column(name = "Turbo")
    private Double turbo;
    @Column(name = "MemoryType")
    private String memoryType;
    @Column(name = "Socket")
    private String socket;
    @Column(name = "OverClocking")
    private Boolean overClocking;
    @Column(name = "TDP")
    private Integer tdp;
    @Column(name = "ProductID")
    private Integer productID;

    public TblProductDetail() {
    }

    public TblProductDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCore() {
        return core;
    }

    public void setCore(Integer core) {
        this.core = core;
    }

    public Integer getThread() {
        return thread;
    }

    public void setThread(Integer thread) {
        this.thread = thread;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    public Double getTurbo() {
        return turbo;
    }

    public void setTurbo(Double turbo) {
        this.turbo = turbo;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public Boolean getOverClocking() {
        return overClocking;
    }

    public void setOverClocking(Boolean overClocking) {
        this.overClocking = overClocking;
    }

    public Integer getTdp() {
        return tdp;
    }

    public void setTdp(Integer tdp) {
        this.tdp = tdp;
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
        if (!(object instanceof TblProductDetail)) {
            return false;
        }
        TblProductDetail other = (TblProductDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "phuhd.entity.TblProductDetail[ id=" + id + " ]";
    }
    
}
