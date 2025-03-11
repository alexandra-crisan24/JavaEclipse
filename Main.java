import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		System.out.println(" Introduceti  numarul de obiecte : ");
		int nr = scanner.nextInt(); 
		Cerc [] ob= new Cerc [nr];
		CitireDate(ob,nr); 
		CentruO(ob,nr); 
		Cadran(ob,nr); 
		Dreapta(ob,nr); 
		
	}
	public static void CitireDate( Cerc []  ob , int nr) {
		Scanner scanner = new Scanner(System.in);
		for (int i=0 ; i<nr ; i++) {
			ob[i]= new Cerc ( 0 , 0.0f, 0 ,0);
			System.out.println(" Pentru obiectul : " +( i+1) );
			System.out.println("Culoare: ");
			
			ob[i].setCuloare(scanner.nextInt());
			 System.out.println("Raza: ");
	            float raza = 0.0f;
	            boolean valid = false;
	            while (!valid) {
	                try {
	                    raza = Float.parseFloat(scanner.next());
	                    valid = true;
	                } catch (NumberFormatException e) {
	                    System.out.println("Raza nu este valida");
	                    scanner.next();
	                }
	            }
	            ob[i].setRaza(raza);
			
			System.out.println("Introduceti coordonatele cercului : ");
			ob[i].setX(scanner.nextInt());
			ob[i].setY(scanner.nextInt());
		}
		
	}
	public static void  CentruO (Cerc []  ob , int nr) {
		for (int i=0 ; i<nr; i++) {
			ob[i]= new Cerc ( 0 , 0.0f, 0 ,0); 
			System.out.println("Cercurile cu originea in O ");
			if ( ob[i].getX()==ob[i].getY()) {
				System.out.println(" Cercul cu  raza " + ob[i].getRaza()+" de coordonate "+ ob[i].getX()+" "+ ob[i].getY());
			}
		}
	}
	public static void Cadran (Cerc []  ob , int nr) {
		for (int i=0 ; i<nr; i++) {
			ob[i]= new Cerc ( 0 , 0.0f, 0 ,0); 
			System.out.println(" Datele cercurilor care sunt incluse în întregime într-unul din cele 4 cadrane");
			if ( (ob[i].getX() != ob[i].getY()) &&(  ob[i].getX()==0 | ob[i].getY()==0)){
				System.out.println(" Cercul cu  raza " + ob[i].getRaza()+" de coordonate "+ ob[i].getX()+" "+ ob[i].getY());
			}
		}
	}
	public static void Dreapta (Cerc []  ob , int nr) {
		for (int i=0 ; i<nr; i++) {
			ob[i]= new Cerc ( 0 , 0.0f, 0 ,0); 
			System.out.println("Datele cercurilor care au centrele pe aceeași dreaptă orizontală sau verticală");
			if ( (ob[i].getX()==0  && ob[i].getY()!=0 ) || (  ob[i].getX()!=0 && ob[i].getY()==0)){
				System.out.println(" Cercul cu  raza " + ob[i].getRaza()+" de coordonate "+ ob[i].getX()+" "+ ob[i].getY());
			}
		}
	}
	

}
