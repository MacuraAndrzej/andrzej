package macura.andrzej;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GraphicalInterface implements  ActionListener {
    public  JTextField inputText;
    public  JTextField outputText;
    private CalculatorFacade calculator;
    public GraphicalInterface(CalculatorFacade calc) {
        calculator = calc;
        JFrame ramka = new JFrame();
        ramka.setSize(400,600);
        ramka.setVisible(true);
        ramka.setLayout(null);
        inputText = new JTextField();
        inputText.setBounds(0 ,50,300,45);
        outputText = new JTextField();
        outputText.setBounds(0 ,150,300,45);
        JButton start = new JButton("calculate");
        start.setBounds(0 ,300,300,45);
        start.addActionListener(this);
        ramka.add(inputText);
        ramka.add(start);
        ramka.add(outputText);
        ramka.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
         String text = inputText.getText();
         String output = calculator.calculate(text);
         outputText.setText(output);

    }





}
