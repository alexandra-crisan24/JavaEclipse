import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Class {

	public static void main(String[] args) {
	Frame frame=new Frame("Demo"); 
	Label label=new Label("LABEL", Label.CENTER); 
	frame.setSize(555, 555);
	label.setFont(new Font("Times New Roman" , Font.PLAIN,12));
	label.setForeground(Color.black);
	label.setBackground(Color.white);
	frame.setLayout(null);
	frame.setSize(200, 300);
	frame.setBackground(Color.PINK); 
	frame.setVisible(true);
	}

}
