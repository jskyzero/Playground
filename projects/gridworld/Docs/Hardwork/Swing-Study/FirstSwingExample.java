import javax.swing.*;   // for swing

public class FirstSwingExample
{
    public static void main(String[] args) {
        JFrame f = new JFrame(); // Creating instance of JFrame

        JButton b = new JButton(); // A Button 
        b.setBounds(130,100,100,40); // x y width height

        f.add(b);
        f.setSize(400, 500); // width height
        f.setLayout(null); // no layout managers
        f.setVisible(true); // make visible
    }
}