import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class Frame extends JFrame
{
    private Core core;
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

        core = new Core();
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

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev)
            {
                int base = 10; // Cause decimal is base 10 which is the usual base system we use.
                int places = 2; // Cause we normally use at least 1-2 decimal places.
                String errorMessage = "Error:";

                try {
                    base = Integer.parseInt(baseField.getText());
                } catch (NumberFormatException ex) {
                    errorMessage += " No base entered, or has letters.";
                }

                if (base > 16) {
                    errorMessage += " Base number must not exceed base 16.";
                }

                try {
                    places = Integer.parseInt(placesField.getText());
                } catch (NumberFormatException ex) {
                    errorMessage += " No places entered, or has letters.";
                }

                if (errorMessage.length() <= 6) {
                    String output = core.decimalToBase(
                        inputField.getText(), base, places
                    );

                    if (output.contains("Error:")) {
                        JOptionPane.showMessageDialog(null, output);
                    } else {
                        inputField.setText(output);
                    }
                } else {
                    // Errors are present in the input.
                    JOptionPane.showMessageDialog(null, errorMessage);
                }
            }
        });
    }
}
