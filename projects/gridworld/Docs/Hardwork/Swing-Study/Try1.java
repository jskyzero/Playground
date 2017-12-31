import javax.swing.*; // for swing
import java.awt.event.*;

public class Try1 implements WindowListener, ActionListener
{
    private JFrame PageFrame;
    JTextField Text;
    private int ClickTimes;
    Try1 ()
    {
        PageFrame = new JFrame();
        
        JButton ClickButton = new JButton("Click");
        ClickButton.setBounds(0, 0, 100, 100);
        ClickButton.addActionListener(this);

        Text = new JTextField();
        Text.setBounds(100,0,400,100);

        PageFrame.add(ClickButton);
        PageFrame.add(Text);
        PageFrame.setSize(500, 200);
        PageFrame.setLayout(null);
        PageFrame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        ClickTimes++;
        Text.setText("Button Clicked " + ClickTimes + " times");
    }


    public void windowClosing(WindowEvent e) {
                PageFrame.dispose();
                System.exit(0);
    }
    public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}
    public static void main(String[] args) {
        new Try1();
    }
}
