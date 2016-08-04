
package edu.depaul.group2project.mostrecent;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "checkout_duration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CheckoutDuration.findAll", query = "SELECT c FROM CheckoutDuration c"),
    @NamedQuery(name = "CheckoutDuration.findByCheckoutDurationId", query = "SELECT c FROM CheckoutDuration c WHERE c.checkoutDurationId = :checkoutDurationId"),
    @NamedQuery(name = "CheckoutDuration.findByDays", query = "SELECT c FROM CheckoutDuration c WHERE c.days = :days"),
    @NamedQuery(name = "CheckoutDuration.findByMaxRenewals", query = "SELECT c FROM CheckoutDuration c WHERE c.maxRenewals = :maxRenewals")})
public class CheckoutDuration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "checkout_duration_id")
    private Integer checkoutDurationId;
    @Column(name = "days")
    private Integer days;
    @Column(name = "max_renewals")
    private Integer maxRenewals;
    @OneToMany(mappedBy = "checkoutDurationIdFk")
    private Collection<Book> bookCollection;

    public CheckoutDuration() {
    }

    public CheckoutDuration(Integer checkoutDurationId) {
        this.checkoutDurationId = checkoutDurationId;
    }

    public Integer getCheckoutDurationId() {
        return checkoutDurationId;
    }

    public void setCheckoutDurationId(Integer checkoutDurationId) {
        this.checkoutDurationId = checkoutDurationId;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getMaxRenewals() {
        return maxRenewals;
    }

    public void setMaxRenewals(Integer maxRenewals) {
        this.maxRenewals = maxRenewals;
    }

    @XmlTransient
    public Collection<Book> getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(Collection<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checkoutDurationId != null ? checkoutDurationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CheckoutDuration)) {
            return false;
        }
        CheckoutDuration other = (CheckoutDuration) object;
        if ((this.checkoutDurationId == null && other.checkoutDurationId != null) || (this.checkoutDurationId != null && !this.checkoutDurationId.equals(other.checkoutDurationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.depaul.group2project.mostrecent.CheckoutDuration[ checkoutDurationId=" + checkoutDurationId + " ]";
    }
    
}
