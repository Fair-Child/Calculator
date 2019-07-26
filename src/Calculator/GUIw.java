package Calculator;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class GUIw implements ActionListener{

    private final JFrame frame;
    private final JPanel panel;
    private final JTextArea text;


    private final JButton but[], butSquare, butSquareRoot, butPlus, butMinus, butMultiply, butDivide, butCos, butCosh,
            butEPower, butPiPower, butStd, butComma, butCancel, butEqual;

    private final Functions func;

    private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9" };


    public GUIw() {
        frame = new JFrame("Calculator-w");
        frame.setResizable(false);
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
     
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
        butSquareRoot = new JButton("xˆsqrt");

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



    public void init() {
    	GridBagConstraints c = new GridBagConstraints();
        frame.setVisible(true);
        frame.setSize(350, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth= 4;
        c.gridx= 0;
        c.gridy= 0;
        panel.add(text, c);

        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5 ;
        c.gridwidth= 1;
        c.gridx = 0 ;
        c.gridy = 1;
        panel.add(but[1],c);
        but[1].addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
   //     c.weightx = 0.5 ;
        c.gridx = 1 ;
        c.gridy = 1;
        panel.add(but[2],c);
        but[2].addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
    //    c.weightx = 0.5 ;
        c.gridx = 2 ;
        c.gridy = 1;
        panel.add(but[3],c);
        but[3].addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
   //     c.weightx = 0.5 ;
        c.gridx = 3 ;
        c.gridy = 1;
        panel.add(butPlus,c);
        butPlus.addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
   //     c.weightx = 0.5 ;
        c.gridx = 0 ;
        c.gridy = 2;
        panel.add(but[4],c);
        but[4].addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
    //    c.weightx = 0.5 ;
        c.gridx = 1 ;
        c.gridy = 2;
        panel.add(but[5],c);
        but[5].addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
    //    c.weightx = 0.5 ;
        c.gridx = 2 ;
        c.gridy = 2;
        panel.add(but[6],c);
        but[6].addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
   //     c.weightx = 0.5 ;
        c.gridx = 3 ;
        c.gridy = 2;
        panel.add(butMinus,c);
        butMinus.addActionListener(this);


        c.fill = GridBagConstraints.HORIZONTAL;
    //    c.weightx = 0.5 ;
        c.gridx = 0 ;
        c.gridy = 3;
        panel.add(but[7],c);
        but[7].addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
    //    c.weightx = 0.5 ;
        c.gridx = 1 ;
        c.gridy = 3;
        panel.add(but[8],c);
        but[8].addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.5 ;
        c.gridx = 2 ;
        c.gridy = 3;
        panel.add(but[9],c);
        but[9].addActionListener(this);

        
        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.5 ;
        c.gridx = 3 ;
        c.gridy = 3;
        panel.add(butMultiply,c);
        butMultiply.addActionListener(this);


        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.5 ;
        c.gridx = 0 ;
        c.gridy = 4;
        panel.add(but[0],c);
        but[0].addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
     //   c.weightx = 0.5 ;
        c.gridx = 1 ;
        c.gridy = 4;
        panel.add(butSquare,c);
        butSquare.addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
      //  c.weightx = 0.5 ;
        c.gridx = 2 ;
        c.gridy = 4;
        panel.add(butSquareRoot,c);
        butSquareRoot.addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
     //   c.weightx = 0.5 ;
        c.gridx = 3 ;
        c.gridy = 4;
        panel.add(butDivide,c);
        butDivide.addActionListener(this);


        c.fill = GridBagConstraints.HORIZONTAL;
 //       c.weightx = 0.5 ;
        c.gridx = 0 ;
        c.gridy = 5;
        panel.add(butEPower,c);
        butEPower.addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
  //      c.weightx = 0.5 ;
        c.gridx = 1 ;
        c.gridy = 5;
        panel.add(butCos,c);
        butCos.addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
  //      c.weightx = 0.5 ;
        c.gridx = 2 ;
        c.gridy = 5;
        panel.add(butCosh,c);
        butCosh.addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
    //    c.weightx = 0.5 ;
        c.gridx = 3 ;
        c.gridy = 5;
        panel.add(butCancel,c);
        butCancel.addActionListener(this);


        c.fill = GridBagConstraints.HORIZONTAL;
    //    c.weightx = 0.5 ;
        c.gridx = 0 ;
        c.gridy = 6;
        panel.add(butPiPower,c);
        butPiPower.addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
   //     c.weightx = 0.5 ;
        c.gridx = 1 ;
        c.gridy = 6;
        panel.add(butStd,c);
        butStd.addActionListener(this);

        
        c.fill = GridBagConstraints.HORIZONTAL;
   //     c.weightx = 0.5 ;
        c.gridx = 2 ;
        c.gridy = 6;
        panel.add(butComma,c);
        butComma.addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
    //    c.weightx = 0.5 ;
        c.gridx = 3 ;
        c.gridy = 6;
        panel.add(butEqual,c);
        butEqual.addActionListener(this);


    }



    @Override
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

    public Double reader() {
        Double num = null;
        String str;
        str = text.getText();
        if(!str.isEmpty())
            num = Double.valueOf(str);

        return num;
    }
    
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

    public void writer(final Double num) {
        if (Double.isNaN(num)) {
            text.setText("");
        } else {
            text.setText(Double.toString(num));
        }
    }
}
