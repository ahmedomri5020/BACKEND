package com.ahmed.pays.entities;

import java.util.Date; // Change from java.sql.Date to java.util.Date
import com.fasterxml.jackson.annotation.JsonFormat; // Import Jackson annotation for date formatting
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Plat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idPlat; 

    private String nomPlat;
    private Double prixPlat; 
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Format for JSON serialization
    @Temporal(TemporalType.DATE)
    private Date dateCreation; // Change to java.util.Date

    @ManyToOne
    @JoinColumn(name = "id_pays") 
    private Pays pays; 

    public Plat() {
        super();
    }

    public Plat(String nomPlat, Double prixPlat, Pays pays, Date dateCreation) {
        super();
        this.nomPlat = nomPlat;
        this.prixPlat = prixPlat;
        this.pays = pays;
        this.dateCreation = dateCreation;
    }

    // Getters and Setters
    public Long getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(Long idPlat) {
        this.idPlat = idPlat;
    }

    public String getNomPlat() {
        return nomPlat;
    }

    public void setNomPlat(String nomPlat) {
        this.nomPlat = nomPlat;
    }

    public Double getPrixPlat() {
        return prixPlat;
    }

    public void setPrixPlat(Double prixPlat) {
        this.prixPlat = prixPlat;
    }

    public Pays getPays() { // Getter for Pays
        return pays;
    }

    public void setPays(Pays pays) { // Setter for Pays
        this.pays = pays;
    }

    public Date getDateCreation() { // Corrected getter method name
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) { // Corrected setter method name
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Plat [idPlat=" + idPlat + ", nomPlat=" + nomPlat + ", prixPlat=" + prixPlat + ", pays=" + pays + ", dateCreation=" + dateCreation + "]";
    }
}
