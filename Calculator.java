import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    private JTextField display;
    private JButton[] numberButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton, perButton;
    private JPanel buttonPanel;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;
    private boolean isNewInput = true;

    public Calculator() {
        setTitle("Java Swing 计算器");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        initComponents();

        setupLayout();

        setVisible(true);
    }

    private void initComponents() {
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 32));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setText("0");

        clrButton = new JButton("C");
        delButton = new JButton("Del");
        perButton = new JButton("%");
        divButton = new JButton("/");

        mulButton = new JButton("*");
        subButton = new JButton("-");
        addButton = new JButton("+");
        equButton = new JButton("=");

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        decButton = new JButton(".");

        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        clrButton.setFont(buttonFont);
        delButton.setFont(buttonFont);
        perButton.setFont(buttonFont);
        divButton.setFont(buttonFont);
        mulButton.setFont(buttonFont);
        subButton.setFont(buttonFont);
        addButton.setFont(buttonFont);
        equButton.setFont(buttonFont);
        decButton.setFont(buttonFont);

        for (JButton button : numberButtons) {
            button.setFont(buttonFont);
        }

        Color redColor = new Color(244, 143, 145); // 红色
        Color grayColor = new Color(193, 193, 193); // 灰色
        Color blueColor = new Color(143, 191, 244); // 蓝色
        Color whiteColor = Color.WHITE; // 白色

        clrButton.setBackground(redColor);
        clrButton.setForeground(Color.WHITE);

        addButton.setBackground(grayColor);
        addButton.setForeground(Color.WHITE);
        subButton.setBackground(grayColor);
        subButton.setForeground(Color.WHITE);
        mulButton.setBackground(grayColor);
        mulButton.setForeground(Color.WHITE);
        divButton.setBackground(grayColor);
        divButton.setForeground(Color.WHITE);
        perButton.setBackground(grayColor);
        perButton.setForeground(Color.WHITE);

        equButton.setBackground(blueColor);
        equButton.setForeground(Color.WHITE);

        delButton.setBackground(whiteColor);
        decButton.setBackground(whiteColor);

        for (JButton button : numberButtons) {
            button.setBackground(whiteColor);
        }

        clrButton.setOpaque(true);
        addButton.setOpaque(true);
        subButton.setOpaque(true);
        mulButton.setOpaque(true);
        divButton.setOpaque(true);
        perButton.setOpaque(true);
        equButton.setOpaque(true);
        delButton.setOpaque(true);
        decButton.setOpaque(true);

        for (JButton button : numberButtons) {
            button.setOpaque(true);
        }

        clrButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        addButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        subButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        mulButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        divButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        perButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        equButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        delButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        decButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        for (JButton button : numberButtons) {
            button.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i].addActionListener(this);
        }

        clrButton.addActionListener(this);
        delButton.addActionListener(this);
        perButton.addActionListener(this);
        divButton.addActionListener(this);
        mulButton.addActionListener(this);
        subButton.addActionListener(this);
        addButton.addActionListener(this);
        equButton.addActionListener(this);
        decButton.addActionListener(this);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        add(display, BorderLayout.NORTH);

        buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.gridy = 0;
        gbc.gridx = 0;
        buttonPanel.add(clrButton, gbc);

        gbc.gridx = 1;
        buttonPanel.add(delButton, gbc);

        gbc.gridx = 2;
        buttonPanel.add(perButton, gbc);

        gbc.gridx = 3;
        buttonPanel.add(divButton, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        buttonPanel.add(numberButtons[7], gbc);

        gbc.gridx = 1;
        buttonPanel.add(numberButtons[8], gbc);

        gbc.gridx = 2;
        buttonPanel.add(numberButtons[9], gbc);

        gbc.gridx = 3;
        buttonPanel.add(mulButton, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        buttonPanel.add(numberButtons[4], gbc);

        gbc.gridx = 1;
        buttonPanel.add(numberButtons[5], gbc);

        gbc.gridx = 2;
        buttonPanel.add(numberButtons[6], gbc);

        gbc.gridx = 3;
        buttonPanel.add(subButton, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        buttonPanel.add(numberButtons[1], gbc);

        gbc.gridx = 1;
        buttonPanel.add(numberButtons[2], gbc);

        gbc.gridx = 2;
        buttonPanel.add(numberButtons[3], gbc);

        gbc.gridx = 3;
        buttonPanel.add(addButton, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        buttonPanel.add(numberButtons[0], gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 2;
        buttonPanel.add(decButton, gbc);

        gbc.gridx = 3;
        buttonPanel.add(equButton, gbc);

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        for (int i = 0; i < 10; i++) {
            if (source == numberButtons[i]) {
                String currentText = display.getText();

                if (isNewInput || currentText.equals("0")) {
                    display.setText(String.valueOf(i));
                    isNewInput = false;
                } else {
                    display.setText(currentText + i);
                }
                return;
            }
        }

        if (source == decButton) {
            String currentText = display.getText();

            if (isNewInput || currentText.equals("0")) {
                display.setText("0.");
                isNewInput = false;
            } else if (!currentText.contains(".")) {
                display.setText(currentText + ".");
            }
            return;
        }

        if (source == clrButton) {
            display.setText("0");
            num1 = 0;
            num2 = 0;
            result = 0;
            isNewInput = true;
            return;
        }

        if (source == delButton) {
            String currentText = display.getText();
            if (currentText.length() > 1) {
                String newText = currentText.substring(0, currentText.length() - 1);
                display.setText(newText);
                isNewInput = false;
            } else {
                display.setText("0");
                isNewInput = true;
            }
            return;
        }

        if (source == perButton) {
            try {
                double value = Double.parseDouble(display.getText());
                value = value / 100;
                display.setText(formatResult(value));
                isNewInput = true;
            } catch (NumberFormatException ex) {
                display.setText("错误");
                isNewInput = true;
            }
            return;
        }

        if (source == addButton || source == subButton ||
                source == mulButton || source == divButton) {

            try {
                num1 = Double.parseDouble(display.getText());

                if (source == addButton) operator = '+';
                else if (source == subButton) operator = '-';
                else if (source == mulButton) operator = '*';
                else if (source == divButton) operator = '/';

                isNewInput = true;
            } catch (NumberFormatException ex) {
                display.setText("错误");
                isNewInput = true;
            }
            return;
        }

        if (source == equButton) {
            try {
                num2 = Double.parseDouble(display.getText());

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            display.setText("除零错误");
                            isNewInput = true;
                            return;
                        }
                        break;
                }

                display.setText(formatResult(result));
                isNewInput = true;
            } catch (NumberFormatException ex) {
                display.setText("错误");
                isNewInput = true;
            }
        }
    }

    private String formatResult(double value) {
        if (value == (long) value) {
            return String.format("%d", (long) value);
        } else {
            String result = String.format("%.8f", value);
            result = result.replaceAll("0*$", "");
            result = result.replaceAll("\\.$", "");
            return result;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator();
            }
        });
    }
}