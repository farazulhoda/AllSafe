import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CeasarCipher extends JFrame implements ActionListener {

    private JLabel inputLabel, outputLabel, shiftLabel;
    private JTextField inputText, outputText, shiftText;
    private JButton encryptButton, clearButton;

    public CeasarCipher() {
        setTitle("Ceasar Cipher");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        inputLabel = new JLabel("Input:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        panel.add(inputLabel, constraints);

        inputText = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        panel.add(inputText, constraints);

        outputLabel = new JLabel("Output:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(outputLabel, constraints);

        outputText = new JTextField(20);
        outputText.setEditable(false);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        panel.add(outputText, constraints);

        shiftLabel = new JLabel("Shift:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        panel.add(shiftLabel, constraints);

        shiftText = new JTextField(3);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        panel.add(shiftText, constraints);

        encryptButton = new JButton("Encrypt");
        encryptButton.addActionListener(this);
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        panel.add(encryptButton, constraints);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        panel.add(clearButton, constraints);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CeasarCipher();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == encryptButton) {
            String plaintext = inputText.getText();
            int shift = Integer.parseInt(shiftText.getText());
            String ciphertext = encrypt(plaintext, shift);
            outputText.setText(ciphertext);
        } else if (e.getSource() == clearButton) {
            inputText.setText("");
            outputText.setText("");
            shiftText.setText("");
        }
    }

    private static String encrypt(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    c = (char) ((c + shift - 65) % 26 + 65);
                } else {
                    c = (char) ((c + shift - 97) % 26 + 97);
                }
            }
            ciphertext.append(c);
        }
        return ciphertext.toString();
    }
}