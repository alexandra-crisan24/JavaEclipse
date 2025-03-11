

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private JPanel panel;
    private StringBuilder currentInput;
    private String lastOperator;
    private double result;
private double inputNumber=0; 
    public Calculator() {
      
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

   
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        add(panel, BorderLayout.CENTER);

      
        currentInput = new StringBuilder();
        lastOperator = "";
        result = 0;

      
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 24));
            button.addActionListener(this);
            panel.add(button);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("C")) {
           
            currentInput.setLength(0);
            display.setText("");
            lastOperator = "";
            result = 0;
        } else if (command.equals("=")) {
            
        	  switch (lastOperator) {
              case "":
                  result = inputNumber;
                  break;
              case "+":
                  result += inputNumber;
                  break;
              case "-":
                  result -= inputNumber;
                  break;
              case "*":
                  result *= inputNumber;
                  break;
              case "/":
                  result /= inputNumber;
                  break;
          }

            currentInput.append(command);
            display.setText(currentInput.toString());
        }
    }



    public static void main(String[] args) {
        new Calculator();
    }
}
