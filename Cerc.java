/*Crisan Maria Alexandra 
 * Grupa 2123
 * 10.Să se implementeze o clasă numită Cerc cu atributele private culoare (int), raza (float), pozitie in plan (2 coordonate intregi).
 Se definesc constructorii și metodele mutator și accesor specifice.
  Valoarea culorii este împărțită în 4 octeți reprezentând transparența, apoi cantitatile de R, G si B.
În metoda main (inclusă într-o altă clasă) se citesc de la tastatură datele aferente unui șir de n obiecte de tip Cerc.
Să se implementeze metodele care primesc ca parametru șirul de obiecte și afișează:
- datele cercurilor a căror centru este inclus într-unul din cele 4 cadrane
- datele cercurilor care sunt incluse în întregime într-unul din cele 4 cadrane
- datele cercurilor care au centrele pe aceeași dreaptă orizontală sau verticală
- datele cercurilor care au cantitatea de R, G sau B într-un anumit interval specificat*/
public class Cerc {
private Integer  culoare ; 
private Float raza ; 
private Integer x ; 
private Integer y ; 
 public Cerc ( Integer culoare , Float raza , Integer x , Integer y ) {
	 culoare=0 ; 
	 raza=0.0f; 
	 x=0 ; 
	 y=0;
	 
 }
 // metode setter si getter
 public void setRaza(Float raza) {
	 this.raza=raza; 
	 
 }
 public void setCuloare(Integer culoare) {
	 this.culoare=culoare; 
 }
 public void setX(Integer x) {
	 this.x=x;
 }
 public void setY(Integer y) {
	 this.y=y;
}
 public Float getRaza() {
	 return raza; 
 }
 public Integer getX() {
	 return x; 
 }
 public Integer  getY() {
	 return y; 
 }
 
public   String getCuloare() {
	int octet = 0;
	String culoare_generata = "Transparent";

	switch (culoare_generata) {
	    case "Transparent":
	        octet = (culoare << 24) & 0xFF;
	        break;
	    case "R":
	        octet = (culoare << 16) & 0xFF;
	        break;
	    case "G":
	        octet = (culoare << 8) & 0xFF;
	        break;
	    case "B":
	        octet = culoare & 0xFF;
	        break;
	}

	String culoare_returnata = "";

	if (octet == ((culoare << 24) & 0xFF)) {
	    culoare_returnata = "Transparent";
	} else if (octet == ((culoare << 16) & 0xFF)) {
	    culoare_returnata = "R";
	} else if (octet == ((culoare << 8) & 0xFF)) {
	    culoare_returnata = "G";
	} else if (octet == (culoare & 0xFF)) {
	    culoare_returnata = "B";
	}

	return culoare_returnata ;

}
public void finalize() {
	System.gc(); 
	
}
}

