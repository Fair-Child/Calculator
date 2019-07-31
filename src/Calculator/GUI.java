package Calculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class GUI implements ActionListener {

    private final JFrame frame;
    private final JPanel panel;
    private final JTextArea text;


    private final JButton but[], butSquare, butSquareRoot, butPlus, butMinus, butMultiply, butDivide, butCos, butCosh,
            butEPower, butPiPower, butStd, butComma, butCancel, butEqual;

    private final Functions func;

    private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9" };


    /**
     *The Constructor that construct the GUI interface and buttons
     *
     * @author Hong Fei Liang
     */
    public GUI() {
        frame = new JFrame("Calculator");
        frame.setResizable(false);
        panel = new JPanel(new FlowLayout());

        text = new JTextArea(3, 25);
        but = new JButton[10];
        for (int i = 0; i < 10; i++) {
            but[i] = new JButton(String.valueOf(i));
        }

        butPlus= new JButton("+");
        butMinus = new JButton("-");
        butMultiply = new JButton("*");
        butDivide = new JButton("/");

        butSquare = new JButton("x^2");
        butSquareRoot = new JButton("√");

        butCos = new JButton("Cos");
        butCosh = new JButton("Cosh");

        butEPower = new JButton("e^x");
        butPiPower = new JButton("pi^x");
        butStd = new JButton("std");
        butComma = new JButton(",");

        butCancel = new JButton("C");
        butEqual = new JButton("=");
        func = new Functions();
    }

    /**
     * The method to initiate the buttons of GUI
     *
     * @author Hong Fei Liang
     */
    public void init() {
        frame.setVisible(true);
        frame.setSize(350, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.add(text);

        panel.add(but[1]);
        but[1].addActionListener(this);

        panel.add(but[2]);
        but[2].addActionListener(this);

        panel.add(but[3]);
        but[3].addActionListener(this);

        panel.add(butPlus);
        butPlus.addActionListener(this);



        panel.add(but[4]);
        but[4].addActionListener(this);

        panel.add(but[5]);
        but[5].addActionListener(this);

        panel.add(but[6]);
        but[6].addActionListener(this);

        panel.add(butMinus);
        butMinus.addActionListener(this);



        panel.add(but[7]);
        but[7].addActionListener(this);

        panel.add(but[8]);
        but[8].addActionListener(this);

        panel.add(but[9]);
        but[9].addActionListener(this);

        panel.add(butMultiply);
        butMultiply.addActionListener(this);



        panel.add(but[0]);
        but[0].addActionListener(this);

        panel.add(butSquare);
        butSquare.addActionListener(this);

        panel.add(butSquareRoot);
        butSquareRoot.addActionListener(this);

        panel.add(butDivide);
        butDivide.addActionListener(this);



        panel.add(butEPower);
        butEPower.addActionListener(this);

        panel.add(butCos);
        butCos.addActionListener(this);

        panel.add(butCosh);
        butCosh.addActionListener(this);

        panel.add(butCancel);
        butCancel.addActionListener(this);



        panel.add(butPiPower);
        butPiPower.addActionListener(this);

        panel.add(butStd);
        butStd.addActionListener(this);

        panel.add(butComma);
        butComma.addActionListener(this);

        panel.add(butEqual);
        butEqual.addActionListener(this);


    }

    @Override
    /**
     * The method to active the functions that related with the buttons
     *
     * @author Hong Fei Liang
     * @param e the button that has been clicked
     */
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();

        for (int i = 0; i < 10; i++) {
            if (source == but[i]) {
                text.replaceSelection(buttonValue[i]);
                return;
            }
          
        }

        if (source == butPlus) {
            writer(func.SimpleCalculation(Functions.SimpleCal.plus, reader()));
        }

        if (source == butMinus) {
            writer(func.SimpleCalculation(Functions.SimpleCal.minus, reader()));
        }

        if (source == butMultiply) {
            writer(func.SimpleCalculation(Functions.SimpleCal.multiply, reader()));
        }

        if (source == butDivide) {
            writer(func.SimpleCalculation(Functions.SimpleCal.divide, reader()));
        }



        if (source == butSquare) {
            writer(func.ComplexCalculation(Functions.ComplexCal.square, reader()));
        }

        if (source == butSquareRoot) {
            writer(func.ComplexCalculation(Functions.ComplexCal.squareRoot, reader()));
        }



        if (source == butCos) {
            writer(func.ComplexCalculation(Functions.ComplexCal.cos, reader()));
        }

        if (source == butCosh) {
            writer(func.ComplexCalculation(Functions.ComplexCal.cosh, reader()));
        }



        if (source == butEPower) {
            writer(func.ComplexCalculation(Functions.ComplexCal.ePower, reader()));
        }

        if (source == butPiPower) {
            writer(func.ComplexCalculation(Functions.ComplexCal.piPower, reader()));
        }



        if (source == butStd) {
            writer(func.ComplexCalculation(Functions.ComplexCal.std, reader()));
        }

        if (source == butComma) {
            func.addToNumSet(reader());
            text.setText("");

        }



        if (source == butCancel) {
            writer(func.reset());
        }

        if (source == butEqual) {

            writer(func.EqualCalculation(reader()));

        }

        text.selectAll();
        
    }

    /**
     * The method to read the input from user
     *
     * @author Hong Fei Liang
     * @return number that user input
     */
    public Double reader() {
        Double num = null;
        String str;
        str = text.getText();
        if(!str.isEmpty())
            num = Double.valueOf(str);

        return num;
    }

    /**
     * The method that read a list of numbers
     *
     * @author Tahar Mustapha
     * @return the list of numbers
     */
    public List<Double> setReader() {
        Double num;
        String str;
        str = text.getText();
        String[] terms = str.split(",");
        List<Double> numbers = new ArrayList<Double>();
        
        for (String term : terms) {
                numbers.add(Double.parseDouble(term));
        }
        return numbers;
    }

    /**
     * The method to output the result of calculation to the text board
     *
     * @author Hong Fei Liang
     * @param num the result of calculation
     */
    public void writer(final Double num) {
        if (Double.isNaN(num)) {
            text.setText("");
        } else {
            text.setText(Double.toString(num));
        }
    }

}
