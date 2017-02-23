import javax.swing.JFrame;

class App
{
    public static void main(String[] args)
    {
        Frame appFrame = new Frame();
        appFrame.setSize(150, 170);
        appFrame.setResizable(false);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setVisible(true);
    }
}
