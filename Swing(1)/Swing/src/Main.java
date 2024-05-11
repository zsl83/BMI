


/* References
swing Doc
فایل کارگاه 2 برای label H
https://www.javatpoint.com/java-swing
 https://youtu.be/Kmgo00avvEw?si=9iVCwkqxjYi_NHap
https://www.javatpoint.com/java-jbutton
https://www.javatpoint.com/java-jlabel
https://www.javatpoint.com/java-jtextfield
https://www.javatpoint.com/java-gridbaglayout
https://www.sarthaks.com/3500018/how-to-change-the-color-of-a-label-in-java-awt
https://coderanch.com/t/392326/java/TEXTFIELDS-INT
https://www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
https://stackoverflow.com/questions/14169240/getting-integer-values-from-textfield
https://mahmouddehghanpour.com/%D9%86%D9%85%D8%A7%DB%8C%D8%B4-%D8%AA%D8%B5%D9%88%DB%8C%D8%B1-%D8%A8%D8%A7-%D8%A7%D8%B3%D8%AA%D9%81%D8%A7%D8%AF%D9%87-%D8%A7%D8%B2-%DA%A9%D9%84%D8%A7%D8%B3-jlabel-%D8%AF%D8%B1-%D8%AC%D8%A7%D9%88%D8%A7/
https://javapro.ir/%D8%AC%D9%84%D8%B3%D9%87-%D8%A8%DB%8C%D8%B3%D8%AA-%D9%88-%D8%B4%D8%B4%D9%85-%D9%86%D9%85%D8%A7%DB%8C%D8%B4-%D8%AA%D8%B5%D9%88%DB%8C%D8%B1-%D8%AF%D8%B1-Swing-
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    public static void main(String[] args) {

        JFrame f = new JFrame("Calculate BMI");

        JPanel j = new JPanel(new GridBagLayout());

        GridBagConstraints order = new GridBagConstraints();
        order.insets = new Insets(10, 10, 10, 10);

        /* Setting the front page photo*/
        JLabel label1 = new JLabel();
        ImageIcon image1 = new ImageIcon("BMI3.png");
        label1.setIcon(image1);
        order.gridx = 0;
        order.gridy = 0;
        order.gridwidth = 2;
        j.add(label1, order);

        /* word of weight*/
        JLabel label2 = new JLabel("Weight(Kg)");
        label2.setFont(new Font("Arial", Font.PLAIN, 20));
        label2.setForeground(Color.white);
        order.gridx = 0;
        order.gridy = 1;
        order.gridwidth = 1;
        j.add(label2, order);

        /* word of Height*/
        JLabel label3 = new JLabel("Height(m)");
        label3.setFont(new Font("Arial", Font.PLAIN, 21));
        label3.setForeground(Color.white);
        order.gridx = 0;
        order.gridy = 2;
        order.gridwidth = 1;
        j.add(label3, order);

        /* Icon at the top of the page*/
        ImageIcon image = new ImageIcon("bmi.png");
        f.setIconImage(image.getImage());

        /*Calculate button*/
        JButton d = new JButton("Calculate");
        order.gridx = 1;
        order.gridy = 5;
        order.gridwidth = 2;
        j.add(d, order);

        /* textfield of weight*/
        JTextField t2 = new JTextField(10);
        order.gridx = 1;
        order.gridy = 2;
        j.add(t2, order);

        /* textfield of Height*/
        JTextField t1 = new JTextField(10);
        order.gridx = 1;
        order.gridy = 1;
        j.add(t1, order);

        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JPanel K = new JPanel();

                /* color and picture of panel k */
                K.setBackground(new Color(60 , 50 , 100));
                ImageIcon image3 = new ImageIcon();
                JLabel label4= new JLabel();
                ImageIcon image4 = new ImageIcon("BMI5.png");
                label4.setIcon(image4);
                K.add(label4);

                JLabel H= new JLabel();

                /* calculate BMI */
                double a = Double.parseDouble(t1.getText());
                double b = Double.parseDouble(t2.getText());
                double c = a / (b*b);

                /* write BMI : c , font , color and position  of it*/
                JLabel bmi = new JLabel();
                K.add(bmi);
                bmi.setText("BMI:  " + String.format("%.1f", c));
                bmi.setFont(new Font("Arial" ,Font.PLAIN , 30));
                bmi.setForeground(Color.white);
                GridBagConstraints order1 = new GridBagConstraints();
                order1.gridx = 0;
                order1.gridy = 1;
                order1.gridwidth = 1;
                K.add(bmi , order1);

                /* write body condition*/
                if (c < 16.0)
                    H.setText("      Underweight (severe thinness)");
                if (c <= 16.9 && c >= 16.0)
                    H.setText("      Underweight (Moderate thinness");
                if ( c <= 18.4 && c >= 17.0)
                    H.setText("      Underweight (Mild thinness)");
                if ( c <= 24.9 && c >= 18.5)
                    H.setText("      Normal range");
                if ( c <= 29.9 && c >= 25)
                    H.setText("      Overweight (Pre-obese)");
                if ( c <= 34.9 && c >= 30)
                    H.setText("      Obese (Class I)");
                if ( c <= 35 && c >= 39.9)
                    H.setText("      Obese (Class II)");
                if ( c >= 40 )
                    H.setText("      Obese (Class III)");

                /* color and font of body condition*/
                H.setForeground(Color.white);
                H.setFont(new Font("Arial", Font.PLAIN, 30));



                K.setBounds(j.getBounds());
                K.add(H);
                f.remove(j);
                f.add(K);
                f.revalidate();
                f.repaint();
            }
        });

        /* color , size and settings of first page (panel j)*/
        j.setBackground(new Color(30, 85, 100));
        f.setSize(500, 500);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(j);
        f.setVisible(true);

    }


}
