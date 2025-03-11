import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Interfata extends JFrame {
JTextField txt = new JTextField(); 
JButton b1 , b2 ; 
JTextArea at = new JTextArea(); 
JLabel label = new JLabel(); 
ArrayList <Voiaj > voiaj = new ArrayList<>(); 
public Interfata(String Nume) {
	super(Nume); 
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	this.setSize(420, 420);
	this.setLayout(null);
	txt.setBounds(25, 50, 200, 50);
	b1= new JButton("Scrie"); 
	b1.setBounds(25,125 , 100, 50);
	b1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (b1==e.getSource()) {
			String line=txt.getText() ; 
			String temp[]= line.split(" "); 
			try {
				if (temp.length>=3) {
					String destinatie=temp[0]; 
					double pret =Double.parseDouble(temp[1]);
					double calatorie =Double.parseDouble(temp[2]);
					Voiaj v = new Voiaj (destinatie , pret , calatorie);
					voiaj.add(v); 
					at.append(v.toString() + "\n"); 
				
			                if (!destinatie.matches("[a-zA-Z]+")) {
			                    throw new IllegalArgumentException("Numele trebuie să conțină doar litere.");
			              


			                }		
			
			}}
			catch (NumberFormatException ex) {
				System.out.println(ex.getCause());
				label.setText("Format invalid");
			}
			/*String destinatie=temp[0]; 
			double pret =Double.parseDouble(temp[1]);
			double calatorie =Double.parseDouble(temp[2]);
			Voiaj v = new Voiaj(destinatie, pret, calatorie);
            voiaj.add(v); 
            at.append(v.toString() + "\n"); */
			}
		}
	

		
		
	});
	b2=new JButton("Salveaza"); 
	b2.setBounds(120,125 , 100, 50);
	b2.addActionListener(new ActionListener () {

		@Override
		public void actionPerformed(ActionEvent e) {
			  if (e.getSource() == b2) {

		            try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\facultate\\IS\\laboratoare\\pregatire_examen\\ex.txt"))) {
		                for (Voiaj v : voiaj) {
		                    writer.write(v.toString());
		                    writer.newLine();
		                }
		                label.setText("Produsele au fost salvate cu succes.");
		            } catch (IOException ex) {
		                label.setText("Eroare la salvarea fișierului.");
		            }
		        }
		    }
			
		
	});
	
	
	at.setBounds(25, 200, 400, 200);
	at.setBackground(Color.PINK);
	label.setBounds(25 , 300, 100, 20);
	add(b1); 
	add(b2); 
	add(at); 
	add(label); 
     add(txt); 
	this.setVisible(true);
}





public static void main(String[] args) {
	Interfata i = new Interfata("I");

	}

}
