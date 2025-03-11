import java.awt.Component;
import java.io.Serializable;

public class Voiaj extends Calatorie implements Serializable {
protected double cazare;
	public Voiaj(String destinatie, double pret , double cazare ) {
		super(destinatie, pret);
		this.cazare=cazare; 
	
	}
public void setCazare(double cazare) {
	this.cazare=cazare;
}
public Double getCazare() {
	return cazare;
}
public String toString() {
	return "Destinatia "+destinatie+" pretul "+pret+" cazare pret : "+cazare; 
}
}
