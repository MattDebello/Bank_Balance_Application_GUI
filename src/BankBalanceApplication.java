
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceApplication extends JFrame {
    private JButton depositButton;
    private JButton withdrawButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel MainPanel;

    private double accountBalance = 0.0;

    public BankBalanceApplication() {
        setContentPane(MainPanel);
        setTitle("Bank of the South");
        setSize(500, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        depositButton.addActionListener((ActionEvent e) -> deposit());
        withdrawButton.addActionListener((ActionEvent e) -> withdraw());
    }

    

    private void deposit() {
        try {
            double depositAmount = Double.parseDouble(textField1.getText());
            accountBalance += depositAmount;
            textField1.setText("");
            JOptionPane.showMessageDialog(this, "Deposit successful!");
            displayBalance();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount for deposit.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void withdraw() {
        try {
            double withdrawAmount = Double.parseDouble(textField3.getText());

            if (withdrawAmount >= 0 && withdrawAmount <= accountBalance) {
                accountBalance -= withdrawAmount;
                textField3.setText("");
                JOptionPane.showMessageDialog(this, "Withdrawal successful!");
                displayBalance();
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient funds or invalid withdrawal amount!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numerical amount for withdrawal.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayBalance() {
        textField2.setText(String.valueOf(accountBalance));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankBalanceApplication::new);
    }
}