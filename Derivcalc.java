// needed imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class declaration with JFrame extension
public class Derivcalc  extends JFrame {

// jframe attriubutes (text field and text area)
    private JTextField functionField;
    private JTextArea resultArea;

// constructor method
    public Derivcalc() {
    //window setup
        // title
        setTitle("Derivative Calculator");
        // size
        setSize(450, 300);
        // close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // layout
        setLayout(new FlowLayout());
        // icon
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asus\\OneDrive\\Desktop\\icon.png"));
        // adding example
        add(new JLabel("Enter Polynomial Function (example: 3x^3 + 2x^2 - 5x + 7):"));
        // input field
        functionField = new JTextField(30);
        add(functionField);
        // button
        JButton calculateButton = new JButton("Calculate Derivative");
        add(calculateButton);
        // result area
        resultArea = new JTextArea(6, 35);
        resultArea.setEditable(false);
        add(resultArea);
        // button action listener
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        // make window visible
        setVisible(true);
    }

// calculation part 
    private void calculate() {
        try {
            String function = functionField.getText();
            Polynomial poly = new Polynomial(function);

            resultArea.setText(
                    "Original Function:\n" + function +
                    "\n\nDerivative:\n" + poly.getDerivative()
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid format.\nUse simple polynomials only.");
        }
    }
// main method to run the program
    public static void main(String[] args) {
        new Derivcalc();
    }
}


