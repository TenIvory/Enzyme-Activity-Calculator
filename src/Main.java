import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main  implements ActionListener {

    JFrame frame;
    JTextField slopefield, epsilonfield, volumefield, resultfield;

    JLabel slopelabel, epsilonlabel, volumelabel, resultlabel, unitlabel;
    JButton calbutton, aboutbutton, clearbutton;
    JPanel panel;
    Font myFont = new Font("Ink Free", Font.BOLD, 15);
    double slope = 0, epsilon = 0, volume = 0, result = 0;

    Main() {
        frame = new JFrame("Activity Calculator");

        //Frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);

        //slope field operations
        slopefield = new JTextField();
        slopefield.setBounds(120, 10, 200, 30);
        slopefield.setFont(myFont);
        slopefield.setEditable(true);

        //epsilon field operations
        epsilonfield = new JTextField();
        epsilonfield.setEditable(true);
        epsilonfield.setBounds(120, 90, 200, 30);
        epsilonfield.setFont(myFont);

        //volume field operations
        volumefield = new JTextField();
        volumefield.setBounds(120, 180, 200, 30);
        volumefield.setEditable(true);
        volumefield.setFont(myFont);

        //result field operations
        resultfield = new JTextField();
        resultfield.setFont(myFont);
        resultfield.setBounds(120, 250, 200, 30);
        resultfield.setEditable(false);

        //calbutton operations
        calbutton = new JButton();
        calbutton.setFont(myFont);
        calbutton.setText("Calculate");
        calbutton.setBounds(100, 360, 100, 25);
        calbutton.addActionListener(this);

        //about button operations
        aboutbutton = new JButton();
        aboutbutton.addActionListener(this);
        aboutbutton.setText("About");
        aboutbutton.setFont(myFont);
        aboutbutton.setBounds(360, 420, 100, 20);

        //clear button operations
        clearbutton = new JButton();
        clearbutton.setBounds(250, 360, 100, 25);
        clearbutton.setFont(myFont);
        clearbutton.setText("Clear");
        clearbutton.addActionListener(this);


        //slope label operations
        slopelabel = new JLabel();
        slopelabel.setFont(myFont);
        slopelabel.setBounds(30, -10, 60, 80);
        slopelabel.setText("Activity");

        //epsilon label operations
        epsilonlabel = new JLabel();
        epsilonlabel.setText("Epsilon(E)");
        epsilonlabel.setFont(myFont);
        epsilonlabel.setBounds(30, 65, 80, 80);

        //volume label operations
        volumelabel = new JLabel();
        volumelabel.setBounds(15, 160, 100, 80);
        volumelabel.setText("Volume (in ml)");
        volumelabel.setFont(myFont);

        //result label operations
        resultlabel = new JLabel();
        resultlabel.setFont(myFont);
        resultlabel.setText("Result");
        resultlabel.setBounds(30, 230, 80, 90);

        //unit label operations
        unitlabel = new JLabel();
        unitlabel.setFont(myFont);
        unitlabel.setText("nmoles/sec");
        unitlabel.setBounds(340, 230, 80,80);

        frame.add(slopefield);
        frame.add(epsilonfield);
        frame.add(calbutton);
        frame.add(volumefield);
        frame.add(slopelabel);
        frame.add(epsilonlabel);
        frame.add(volumelabel);
        frame.add(resultfield);
        frame.add(resultlabel);
        frame.add(unitlabel);
        frame.add(aboutbutton);
        frame.add(clearbutton);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        Main main = new Main();
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == calbutton) {

            if(slopefield.getText().equals("") || epsilonfield.getText().equals("") || volumefield.getText().equals("")) {
                resultfield.setText("Enter valid values");
            } else {
                slope = Double.parseDouble(slopefield.getText());
                epsilon = Double.parseDouble(epsilonfield.getText());
                volume = Double.parseDouble(volumefield.getText());

                result = ((slope / epsilon) * (volume / 1000) * 1000000000);
                resultfield.setText(String.valueOf(result));
            }

        }

        if(ae.getSource() == aboutbutton) {
            About about = new About();
            about.setVisible(true);

        }

        if(ae.getSource() == clearbutton) {
            slopefield.setText("");
            epsilonfield.setText("");
            volumefield.setText("");
            resultfield.setText("");
        }

        }
       }





