import java.math.BigInteger;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Fibonacci Sequence with Ratios");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel();
        JLabel label = new JLabel("Enter amount of Fibonacci numbers: ");
        JTextField textField = new JTextField(10);
        JButton button = new JButton("Generate");
        inputPanel.add(label);
        inputPanel.add(textField);
        inputPanel.add(button);

        // Output area
        JTextArea outputArea = new JTextArea();
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Button action
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.setText(""); // Clear previous output
                try {
                    int numb = Integer.parseInt(textField.getText());
                    ArrayList<BigInteger> fib = new ArrayList<>();
                    fib.add(BigInteger.ONE);
                    fib.add(BigInteger.ONE);

                    for (int i = 2; i < (numb + 2); i++) {
                        fib.add(fib.get(i - 1).add(fib.get(i - 2)));
                    }

                    outputArea.append(String.format("%-10s %-50s %-20s\n", "Index", "Fibonacci", "Ratio"));
                    for (int i = 0; i < numb; i++) {
                        String ratio = "-";
                        if (i > 0) {
                            ratio = String.format("%.15f", fib.get(i).doubleValue() / fib.get(i - 1).doubleValue());
                        }
                        outputArea.append(String.format("%-10d %-50s %-20s\n", i + 1, fib.get(i), ratio));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
                }
            }
        });

        frame.setVisible(true);
    }
}