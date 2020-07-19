/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuhd.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Duy Phu
 */
@Entity
@Table(name = "tblProduct", catalog = "PhuHDShopCPU", schema = "dbo")

@NamedQueries({
    @NamedQuery(name = "TblProduct.findAll", query = "SELECT t FROM TblProduct t ")
    , @NamedQuery(name = "TblProduct.findById", query = "SELECT t FROM TblProduct t WHERE t.id = :id")
    , @NamedQuery(name = "TblProduct.findByName", query = "SELECT t FROM TblProduct t WHERE t.name = :name")
    , @NamedQuery(name = "TblProduct.findByBranch", query = "SELECT t FROM TblProduct t WHERE t.branch = :branch")
    , @NamedQuery(name = "TblProduct.findByType", query = "SELECT t FROM TblProduct t WHERE t.type = :type")
    , @NamedQuery(name = "TblProduct.findByImage", query = "SELECT t FROM TblProduct t WHERE t.image = :image")
    , @NamedQuery(name = "TblProduct.findByIsDelete", query = "SELECT t FROM TblProduct t WHERE t.isDelete = :isDelete")
    , @NamedQuery(name = "TblProduct.findByPrice", query = "SELECT t FROM TblProduct t WHERE t.price = :price")
    , @NamedQuery(name = "TblProduct.findByDateCreated", query = "SELECT t FROM TblProduct t WHERE t.dateCreated = :dateCreated")
    , @NamedQuery(name = "TblProduct.findByNameAndImg", query = "SELECT t FROM TblProduct t WHERE t.name = :name AND t.image = :image")})
@XmlRootElement(name = "cpu")
public class TblProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "Name", length = 500)
    private String name;
    @Column(name = "Branch", length = 50)
    private String branch;
    @Column(name = "Type", length = 50)
    private String type;
    @Column(name = "Image", length = 500)
    private String image;
    @Column(name = "IsDelete")
    private Boolean isDelete;
    @Column(name = "Price")
    private Long price;
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    public TblProduct() {
    }

    public TblProduct(Integer id) {
        this.id = id;
    }

    @XmlElement
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @XmlElement
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlElement
    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @XmlElement
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @XmlElement
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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
        if (!(object instanceof TblProduct)) {
            return false;
        }
        TblProduct other = (TblProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "phuhd.entity.TblProduct[ id=" + id + " ]";
    }    
    
    

}
