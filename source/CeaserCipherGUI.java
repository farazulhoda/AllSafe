import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CaesarCipherGUI extends JFrame implements ActionListener {

    private JTextField textField;
    private JTextArea textArea;
    private JSpinner spinner;

    public CaesarCipherGUI() {
        // Set up window properties
        setTitle("Caesar Cipher GUI");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create GUI elements
        JLabel label1 = new JLabel("Enter text to encode/decode:");
        textField = new JTextField(20);
        JLabel label2 = new JLabel("Enter shift amount (0-25):");
        spinner = new JSpinner(new SpinnerNumberModel(0, 0, 25, 1));
        JButton encodeButton = new JButton("Encode");
        JButton decodeButton = new JButton("Decode");
        textArea = new JTextArea(10, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Set up layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(label1, constraints);
        constraints.gridy = 1;
        panel.add(textField, constraints);
        constraints.gridy = 2;
        panel.add(label2, constraints);
        constraints.gridy = 3;
        panel.add(spinner, constraints);
        constraints.gridy = 4;
        panel.add(encodeButton, constraints);
        constraints.gridx = 1;
        panel.add(decodeButton, constraints);
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        panel.add(scrollPane, constraints);

        // Add event listeners
        encodeButton.addActionListener(this);
        decodeButton.addActionListener(this);

        // Add panel to window
        add(panel);

        // Show window
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String text = textField.getText();
        int shift = (int) spinner.getValue();
        String result = "";

        if (e.getActionCommand().equals("Encode")) {
            result = encrypt(text, shift);
        } else if (e.getActionCommand().equals("Decode")) {
            result = decrypt(text, shift);
        }

        textArea.setText(result);
    }

    private String encrypt(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    ciphertext.append((char) ('A' + (c - 'A' + shift) % 26));
                } else {
                    ciphertext.append((char) ('a' + (c - 'a' + shift) % 26));
                }
            } else {
                ciphertext.append(c);
            }
        }

        return ciphertext.toString();
    }

    private String decrypt(String ciphertext, int shift) {
        return encrypt(ciphertext, 26 - shift);
    }

    public static void main(String[] args) {
        new CaesarCipherGUI();
    }

}
