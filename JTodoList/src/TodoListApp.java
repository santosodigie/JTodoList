
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TodoListApp {
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JButton button;

    public TodoListApp() {
        frame = new JFrame();
        label = new JLabel("Todo List");

        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Remove Task");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 20, 20));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(addButton);
        panel.add(removeButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Todo App");
        frame.pack();
        frame.setVisible(true);

        
    }

    public static void main(String[] args) {
        new TodoListApp();
    }
}
