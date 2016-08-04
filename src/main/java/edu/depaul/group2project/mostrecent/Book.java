
package edu.depaul.group2project.mostrecent;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByIsbn", query = "SELECT b FROM Book b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
    @NamedQuery(name = "Book.findByCopiesAvailable", query = "SELECT b FROM Book b WHERE b.copiesAvailable = :copiesAvailable"),
    @NamedQuery(name = "Book.findByEditionYear", query = "SELECT b FROM Book b WHERE b.editionYear = :editionYear"),
    @NamedQuery(name = "Book.getCountByIsbn", query = "SELECT count(b) FROM Book b WHERE b.isbn = :isbn")})
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "isbn")
    private Integer isbn;
    @Size(max = 225)
    @Column(name = "title")
    private String title;
    @Column(name = "copies_available")
    private Integer copiesAvailable;
    @Column(name = "edition_year")
    private Integer editionYear;
    @JoinColumn(name = "author_id_fk", referencedColumnName = "author_id")
    @ManyToOne
    private Author authorIdFk;
    @JoinColumn(name = "checkout_duration_id_fk", referencedColumnName = "checkout_duration_id")
    @ManyToOne
    private CheckoutDuration checkoutDurationIdFk;

    public Book() {
    }

    public Book(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(Integer copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public Integer getEditionYear() {
        return editionYear;
    }

    public void setEditionYear(Integer editionYear) {
        this.editionYear = editionYear;
    }

    public Author getAuthorIdFk() {
        return authorIdFk;
    }

    public void setAuthorIdFk(Author authorIdFk) {
        this.authorIdFk = authorIdFk;
    }

    public CheckoutDuration getCheckoutDurationIdFk() {
        return checkoutDurationIdFk;
    }

    public void setCheckoutDurationIdFk(CheckoutDuration checkoutDurationIdFk) {
        this.checkoutDurationIdFk = checkoutDurationIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
       
        String output1="ISBN= " + isbn;
        String output2="Title= " + title;
        String output3="Copies Available= " + copiesAvailable;
        String output4="Edition Year= " + editionYear;
        
        String output5= output1 +"\n" + output2 +"\n" + output3 +"\n" + output4;
        
        return output5;
    }
    
}
