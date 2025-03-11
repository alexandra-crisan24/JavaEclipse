import java.io.Serializable;

public class Cerc  implements Serializable{
private int x ; 
private int y ; 
private int r ; 
public Cerc (int x , int y , int r ) {
	this.x=x ; 
	this.y=y; 
	this.r=r ; 
}
public void setX ( int x ) {
	this.x=x; 
}
public void setY(int y ) {
	this.y=y; 
}
public void setR( int r ) {
	this.r=r; 
}
public int getR() {
	return r ; 
}
public int getX() {
	return x ; 
}
public int getY( ) {
	return y ; 
}
public double aria() {
	return 3.14*r*r; 
}
public String toString() {
	return " Cercul cu raza : " + r +"are aria : "+aria(); 
}
}
