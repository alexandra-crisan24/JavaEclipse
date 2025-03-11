import javax.swing.*;
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
import java.util.OptionalDouble;
import java.util.Random;
public class Interfata extends JFrame {
/* creez o interfata  care are 3 butoane : 
 * - citire fisier 
 * - desenare cerc 
 * -scriere in fisier cercul cu aria cea mai mare
 * - un txt area unde afisez datele pe care le citesc din fisier  */
JButton b1 = new JButton ("Deseneaza"); 
JButton b2 = new JButton("Save"); 
JButton b3 = new JButton ("Read ") ; 
JTextField txt = new JTextField (); // screie poz cerc , raza 
JTextArea area = new JTextArea(); 
JLabel label = new JLabel("Label");// aici afisez mesaje daca scrierea in fisier nu a functionat
ArrayList <Cerc> cerc = new ArrayList<>(); 
Random random = new Random(); 
Color myColor= new Color(random.nextInt(256),random.nextInt(256), random.nextInt(256) ); 
public Interfata() {
	super("Interfata"); 
	this.setSize(600, 600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(null);
	txt.setBounds(25 , 30, 200, 50);
	b1.setBounds(250 , 30, 100, 50);
	b2.setBounds(350 , 30, 100, 50);
	b3.setBounds(450 , 30, 100, 50);
	label.setBounds(25 , 90 , 400, 30);
	area.setBounds(25 , 110, 400, 20);
	Canvas canvas = new Canvas() {
		  @Override
          public void paint(Graphics g) {
              super.paint(g);
              for (Cerc c : cerc) {
                  g.setColor(myColor);
                  g.fillOval(c.getX(), c.getX(), c.getR()*2, c.getR()*2);
                  g.setColor(Color.BLACK);
                  g.drawOval(c.getX(), c.getX(), c.getR()*2, c.getR()*2);
              }
          }

	}; 
	canvas.setBounds(0 , 150 , 600 , 400);
	b1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==b1 ) {
				String line = txt.getText(); 
				String [] temp = line.split(" "); 
				try {
					int x = Integer.parseInt(temp[0]); 
					int y = Integer.parseInt(temp[1]); 
					int r = Integer.parseInt(temp[2]); 
					// verific daca x si y depasesc dimensiunile canvasului 
					 try {
						 if (x > canvas.getWidth() || y > canvas.getHeight() || x < 0 || y < 0) {
							 throw new Exception(); 
						 }
					 } 
					 catch(Exception ex ) {
						 label.setText("Ati depasit valorile canvasului");
					 }
					 Cerc c = new Cerc (x , y , r); 
					 cerc.add(c); 
					 canvas.repaint();
				}
				catch (NumberFormatException ex ) {
					label.setText("Format invalid!!"); 
				}
			}
			
		}
		
	});
	b2.addActionListener(new ActionListener() {
// salvez intr-un fisier creat cercul cu aria ce  mai mare 
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==b2 ) {
				  try (BufferedWriter writer = new BufferedWriter(new FileWriter("Produse.txt"))) {
		                for (Cerc  c : cerc) {
		                	if (!cerc.isEmpty()) {
		    					OptionalDouble max=cerc.stream().mapToDouble(Cerc::aria).max();
		    					 writer.write(max.toString());
			                    writer.newLine();	
		    			}

		                   
		                }
		                label.setText("Produsele au fost salvate cu succes.");
		            } catch (IOException ex) {
		                label.setText("Eroare la salvarea fișierului.");
		            }
			}
			
		}
		
	});
	b3.addActionListener( new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b3) {
			  String fileIn = "Produse.txt";
	            String line;

	            try (BufferedReader br = new BufferedReader(new FileReader(fileIn))) {
	                while ((line = br.readLine()) != null) {
	                   
	                area.setText("");
	                Random rand = new Random();
	                for (Cerc  c : cerc) {
	                    area.setForeground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
	                    area.append(c.toString() + "\n");
	                }}
	            } catch (IOException ex) {
	                label.setText("Eroare la citirea fișierului: " + ex.getMessage());

		}
			
		}}});
	

	add(area); 
	add(canvas);
	add(txt);
	add(b1); 
	add(b2); 
	add(b3); 
	add(label); 
	this.setVisible(true);
	
}
public static void main(String...args) {
	 new Interfata (); 
}
}
