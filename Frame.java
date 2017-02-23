import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

class Frame extends JFrame
{
    private JLabel inputLabel;
    private JTextField inputField;
    private JLabel baseLabel;
    private JTextField baseField;
    private JLabel placesLabel;
    private JTextField placesField;
    private JButton convertButton;

    public Frame()
    {
        super("Dec2Base Converter");

        inputLabel = new JLabel("Number");
        baseLabel = new JLabel("Base");
        placesLabel = new JLabel("Decimal Places");
        inputField = new JTextField(10);
        baseField = new JTextField(10);
        placesField = new JTextField(10);
        convertButton = new JButton("Convert!");

        this.setLayout(new FlowLayout());

        this.add(inputLabel);
        this.add(inputField);
        this.add(baseLabel);
        this.add(baseField);
        this.add(placesLabel);
        this.add(placesField);
        this.add(convertButton);
    }
}
