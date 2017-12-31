import javax.swing.*; 		// for swing
import java.awt.event.*; 	// for ActionListener
import java.awt.*; 			// for GridLayout

// The Main Class of the App
public class Calculator
{
	// The Entry of this App
	public static void main(String []args)
	{
		// Print Some Welcome Message
		System.out.println("Welcome To Use Simple Calculator");
		System.out.println("Your Choice and the process will show here");
		// Create A CalWindows and display it 
		CalculatorWindow NewWindonw = new CalculatorWindow();
		NewWindonw.SetVisible(true);
	}
}

// the windows class and a actionLinter
class CalculatorWindow implements ActionListener
{
	// just like those name means
	private JFrame PageFrame;
	private JTextField LeftNum, RightNum;
	private JButton Opeartor, Answer, Equal;
	private JButton Add, Sub, Mul, Div, Cal;

	// main func, Intial those Content,and add to Frame
	CalculatorWindow()
	{
		InitialFrame();
		InitialText();
		InitialButton();
		AddAllContent();
	}

	// set size and gridlayout 
	private void InitialFrame()
	{
		PageFrame = new JFrame();
		PageFrame.setSize(500, 200);
		PageFrame.setLayout(new GridLayout(2, 5));
	}

	// inistial all the button
	private void InitialButton()
	{
		Add = new JButton("+");
		Sub = new JButton("-");
		Mul = new JButton("*");
		Div = new JButton("/");
		Cal = new JButton("Ok");

		Equal = new JButton("=");
		Answer = new JButton();
		Opeartor = new JButton();

		Equal.setEnabled(false);
		Answer.setEnabled(false);
		Opeartor.setEnabled(false);

		Add.addActionListener(this);
		Sub.addActionListener(this);
		Mul.addActionListener(this);
		Div.addActionListener(this);
		Cal.addActionListener(this);
	}

	// inistial two textField
	private void InitialText()
	{
		LeftNum = new JTextField("0");
		RightNum = new JTextField("0");
		LeftNum.setHorizontalAlignment(JTextField.CENTER);
		RightNum.setHorizontalAlignment(JTextField.CENTER);

	}

	// Cause the grid can't insert to target cell
	// We Should add them in sequence
	private void AddAllContent()
	{
		// line 1
		PageFrame.add(LeftNum);
		PageFrame.add(Opeartor);
		PageFrame.add(RightNum);
		PageFrame.add(Equal);
		PageFrame.add(Answer);
		// line 2
		PageFrame.add(Add);
		PageFrame.add(Sub);
		PageFrame.add(Mul);
		PageFrame.add(Div);
		PageFrame.add(Cal);
	}

	// set frame visible
	public void SetVisible(boolean status)
	{
		PageFrame.setVisible(status);
	}

	// main part of calculator
	public void actionPerformed(ActionEvent e)
	{
		// store Command
		String ActionCommand = e.getActionCommand();
		// Ok is clicked
		if (Cal.getText().equals(ActionCommand))
		{
			if (!Opeartor.getText().isEmpty())
			{
				// ser ans 
				Answer.setText(String.valueOf(CalculateAns()));
				CalculatorLog();
			}
		// ser operator	
		} else {
			Opeartor.setText(ActionCommand);
		}
	}

	// calculate the ans 
	private double CalculateAns()
	{
		String OpeartorChar = Opeartor.getText();
		double LeftNumValue = Double.parseDouble(LeftNum.getText());
		double RightNumValue = Double.parseDouble(RightNum.getText());
		double AnswerValue = 0;
		
		switch(OpeartorChar)
		{
			case "+": AnswerValue = LeftNumValue + RightNumValue; break;
			case "-": AnswerValue = LeftNumValue - RightNumValue; break;
			case "*": AnswerValue = LeftNumValue * RightNumValue; break;
			case "/": AnswerValue = LeftNumValue / RightNumValue; break;
		}

		return AnswerValue;
	}

	// print the process details
	private void CalculatorLog()
	{
		System.out.printf(
			"%15s %s %-15s = %-15s\n",
			LeftNum.getText(),
			Opeartor.getText(),
			RightNum.getText(),
			Answer.getText());
	}
}