/*Scrieți o aplicație Java care definește o cheie de autentificare de tipul: XXXXX-XXXXX-XXXXX-XXXXX, 
 * unde X reprezintă un caracter ce poate fi cifră sau literă. 
 *Scrieți un program care verifică dacă această cheie are exact 4 grupuri de caractere a câte 5 caractere fiecare și separate prin caracterul ‘-‘.
 *De asemenea, calculați numărul de cifre și litere din cheia de autentificare.
 *  Numărul de cifre trebuie să fie mai mare decât numărul de litere, iar numărul de litere nu poate să fie 0.
 *  În cazul în care nu este îndeplinită cel puțin o condiție din cele menționate anterior, afișați mesajul: ”Cheie de autentificare incorectă!”*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import com.sun.net.httpserver.Authenticator.Result;

public class Autentificare {
	public static  void Verifica( boolean verifica ,  String s1 ,String s2 , String s3 ,String s4 , String result) {
		if ( s1.length()==5  && s2.length()==5  && s3.length() ==5 && s4.length()==5) {
			verifica=true  ; 
			System.out.println(" Parola de autentificare este : "+result);
			}
			else 
				verifica=false; 
		
	}
	 public static void  nrCifLit(String cheie){
		/// calcul numar cifre :
			int nr_cifre =0 ; 
			int nr_litere=0 ; 
			for ( char c: cheie.toCharArray()) {
				if (Character.isDigit(c))
				{
					nr_cifre++; 
			}
				else if (Character.isLetter(c)) {
					nr_litere++;
				}
				if ( nr_cifre>nr_litere || nr_litere!=0) {
					System.out.println(" Autentificare reusita !! ");
				}
				else System.out.println("Cheie de autentificare incorecta");
	 }
			
	 }
	 
	public static void main(String[] args) {
		String s1 = new String (); 
		String s2= new String ();
		String s3= new String ();
		String s4= new String ();
		Scanner scan = new Scanner ( System.in); 
		System.out.println(" Introduceti cheia de autentificare : ");
		s1=scan.next(); 
		s2=scan.next();
		s3=scan.next(); 
		s4=scan.next(); 
		//String [] result= {s1. , "-" , s2 , "-",s3 , "-",s4};
		//XXXXX-XXXXX-XXXXX-XXXXX, 
		String result1=s1.concat("-");
		String result2=result1.concat(s2);
		String result3=result2.concat("-");
		String result4=result3.concat(s3);
		String result5=result4.concat("-");
		String rez=result5.concat(s4);
		boolean verifica=true ; 
	Verifica(verifica ,s1 ,s2,s3,s4,rez); 
	nrCifLit(rez);
	}
	
		
	
}
