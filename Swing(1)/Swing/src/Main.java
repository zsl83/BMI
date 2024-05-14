

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

        // create new frame
        JFrame f = new JFrame("Calculate BMI");

        // create first panel
        JPanel firstPanel = new JPanel(new GridBagLayout());
        GridBagConstraints order = new GridBagConstraints();
        order.insets = new Insets(10, 10, 10, 10);

        // Setting the front page photo
        JLabel labelImage = new JLabel();
        ImageIcon image1 = new ImageIcon("BMI3.png");
        labelImage.setIcon(image1);
        order.gridx = 0;
        order.gridy = 0;
        order.gridwidth = 2;
        firstPanel.add(labelImage, order);

        // word of weight
        JLabel labelWeight = new JLabel("Weight(Kg)");
        labelWeight.setFont(new Font("Arial", Font.PLAIN, 24));
        labelWeight.setForeground(Color.white);
        order.gridx = 0;
        order.gridy = 1;
        order.gridwidth = 1;
        firstPanel.add(labelWeight, order);

        // word of Height
        JLabel labelHeight = new JLabel("Height(m)");
        labelHeight.setFont(new Font("Arial", Font.PLAIN, 26));
        labelHeight.setForeground(Color.white);
        order.gridx = 0;
        order.gridy = 2;
        order.gridwidth = 1;
        firstPanel.add(labelHeight, order);

        // Icon at the top of the page
        ImageIcon image = new ImageIcon("bmi.png");
        f.setIconImage(image.getImage());

        //Calculate button
        JButton calc = new JButton("Calculate");
        calc.setBackground(new Color(50 , 90,120));
        calc.setForeground(Color.WHITE);
        calc.setFont(new Font("Arial", Font.PLAIN, 25));
        order.gridx = 1;
        order.gridy = 5;
        order.gridwidth = 2;
        firstPanel.add(calc, order);

        // textField of height
        JTextField tfHeight = new JTextField(8);
        tfHeight.setFont(new Font("Arial", Font.BOLD, 25));
        order.gridx = 1;
        order.gridy = 2;
        firstPanel.add(tfHeight, order);

        // textField of weight
        JTextField tfWeight = new JTextField(8);
        tfWeight.setFont(new Font("Arial", Font.BOLD, 25));
        order.gridx = 1;
        order.gridy = 1;
        firstPanel.add(tfWeight, order);

        // Activate the calculate button
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // create second panel
                JPanel secondPanel = new JPanel();

                // color and picture of second panel
                secondPanel.setBackground(new Color(60 , 50 , 100));
                JLabel labelImage2= new JLabel();
                ImageIcon image4 = new ImageIcon("BMI5.png");
                labelImage2.setIcon(image4);
                secondPanel.add(labelImage2);

                // calculate BMI
                double w = Double.parseDouble(tfWeight.getText());
                double h = Double.parseDouble(tfHeight.getText());
                double c = w / (h*h);

                // write BMI : c , font , color and position  of it
                JLabel bmi = new JLabel();
                bmi.setText("BMI:  " + String.format("%.1f", c));
                bmi.setFont(new Font("Arial" ,Font.PLAIN , 30));
                bmi.setForeground(Color.white);
                GridBagConstraints order1 = new GridBagConstraints();
                order1.gridx = 0;
                order1.gridy = 0;
                order1.gridwidth = 2;
                secondPanel.add(bmi , order1);

                //create label for body condition and color and font of it
                JLabel labelBmi = new JLabel();
                labelBmi.setForeground(Color.white);
                labelBmi.setFont(new Font("Arial", Font.PLAIN, 30));
                order1.gridx = 0;
                order1.gridy = 1;
                order1.gridwidth = 2;
                secondPanel.add(labelBmi,order1);

                // write body condition
                if (w == 0 || h == 0 || (w == 0 && h == 0)){
                    if (w == 0)
                        labelBmi.setText(" weight can't be 0 ");
                    if (h == 0)
                        labelBmi.setText(" height can't be 0 ");
                    if (w == 0 && h == 0)
                        labelBmi.setText(" height can't be 0 \n weight can't be 0");
                }
                    else {
                    if (c < 16.0)
                        labelBmi.setText("      Underweight (severe thinness)");
                    if (c <= 16.9 && c >= 16.0)
                        labelBmi.setText("      Underweight (Moderate thinness");
                    if (c <= 18.4 && c >= 17.0)
                        labelBmi.setText("      Underweight (Mild thinness)");
                    if (c <= 24.9 && c >= 18.5)
                        labelBmi.setText("      Normal range");
                    if (c <= 29.9 && c >= 25)
                        labelBmi.setText("      Overweight (Pre-obese)");
                    if (c <= 34.9 && c >= 30)
                        labelBmi.setText("      Obese (Class I)");
                    if (c >= 39.9 && c <= 35)
                        labelBmi.setText("      Obese (Class II)");
                    if (c >= 40)
                        labelBmi.setText("      Obese (Class III)");
                }

                // create back button
                JButton back = new JButton("برگشت");
                back.setFont(new Font("Arial", Font.BOLD, 30));
                back.setFocusable(false);
                back.setForeground(Color.WHITE);
                back.setBackground(new Color(80,90,150));
                order1.gridx = 0;
                order1.gridy = 2;
                order1.gridwidth =2;
                secondPanel.add(back,order1);

                // Activate the back button
                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        f.remove(secondPanel);
                        f.add(firstPanel);
                        f.revalidate();
                        f.repaint();
                    }
                });

                secondPanel.setBounds(firstPanel.getBounds());
                f.remove(firstPanel);
                f.add(secondPanel);
                f.revalidate();
                f.repaint();
            }
        });

        //color , size and settings of first page
        firstPanel.setBackground(new Color(30, 85, 100));
        f.setSize(500, 500);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(firstPanel);
        f.setVisible(true);

    }


}
