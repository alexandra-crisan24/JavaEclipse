import java.awt.Container;
import java.awt.FlowLayout;
//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
@SuppressWarnings("serial")
public class ButtonEvents_05 extends JFrame {
JLabel label; //to be visible
public ButtonEvents_05( ) {
super("ButtonEvents_05");
setSize(200,200);
Container content = getContentPane( );
//content.setBackground(Color.YELLOW);
content.setLayout(new FlowLayout( ));
JButton b1, b2;
//JLabel label; 60
b1 = new JButton("Button 1");
b2 = new JButton("Button 2");
label = new JLabel("apasa un buton");
content.add(b1);
content.add(b2);
content.add(label);
b1.addActionListener(e -> {label.setText("Buton 1apasat");});
//b2.addActionListener(e -> {label.setText("Buton 2 apasat");});
b2.addActionListener(new B2( ));}
public class B2 implements ActionListener {
@Override
public void actionPerformed(ActionEvent e) {
label.setText("Buton 2 apasat"); }
}//B2
public static void main(String[ ] args) {
JFrame frame = new ButtonEvents_05();
frame.setVisible(true); }}//main }
