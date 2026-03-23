
package com.example.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour subtract complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="subtract"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nbr1" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="nbr2" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subtract", propOrder = {
    "nbr1",
    "nbr2"
})
public class Subtract {

    protected double nbr1;
    protected double nbr2;

    /**
     * Obtient la valeur de la propriété nbr1.
     * 
     */
    public double getNbr1() {
        return nbr1;
    }

    /**
     * Définit la valeur de la propriété nbr1.
     * 
     */
    public void setNbr1(double value) {
        this.nbr1 = value;
    }

    /**
     * Obtient la valeur de la propriété nbr2.
     * 
     */
    public double getNbr2() {
        return nbr2;
    }

    /**
     * Définit la valeur de la propriété nbr2.
     * 
     */
    public void setNbr2(double value) {
        this.nbr2 = value;
    }

}
