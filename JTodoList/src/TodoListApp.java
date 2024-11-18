
import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TodoListApp {
    private JLabel label;
    private JFrame frame; //top level container reprasents window with a title bar and buttons for closing and minimising.
    private JTextField taskField;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    //private JPanel panel; // generic container used to group other componants inside a window
    private JButton addButton, removeButton;

    public TodoListApp() {
        initialize();
    }

    public void initialize(){
        //first thing is to initialize the frame
        frame = new JFrame("To-do List"); //makes the frame and adds the title
        frame.setBounds(100,100,400,300); // sets the bounds of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0,0));

         JPanel inputPanel = new JPanel();
         inputPanel.setLayout(new BorderLayout());


        // adding label
        label = new JLabel("Please enter a Task");
        inputPanel.add(label, BorderLayout.NORTH);

        // Task input field
        taskField = new JTextField();
        inputPanel.add(taskField, BorderLayout.CENTER);
        taskField.setColumns(10);

        // Add the input panel to the north region of the frame
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);

        // List model to hold the tasks
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        frame.getContentPane().add(new JScrollPane(taskList), BorderLayout.CENTER);

        //Create a panel to hold the buttons and add it to the south region of the frame
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // create the add button and add an action listener to handle click events
        addButton = new JButton("Add Task");
        addButton.addActionListener(e -> addTask());
        buttonPanel.add(addButton);

        // creating the remove button and adding an event listener to handle click events
        removeButton = new JButton("Remove Task");
        removeButton.addActionListener(e -> removeTask());
        buttonPanel.add(removeButton);

    }

    private void addTask(){
        String task = taskField.getText().trim(); // Get the text from the task field and trim any leading/trailing spaces
        if (!task.isEmpty()) { // Check if the task is not empty
            taskListModel.addElement(task); // Add the task to the task list model
            taskField.setText(""); // Clear the text field for the next input
         } 
    }

    private void removeTask(){
        int selectedIndex = taskList.getSelectedIndex(); // Get the index of the selected task
        if (selectedIndex != -1) { // Check if a task is selected
            taskListModel.remove(selectedIndex); // Remove the selected task from the task list model
        }
    }

    //main method - entry point of the application
    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure the GUI creation runs on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            try {
                // Create an instance of TodoListApp and make the frame visible
                TodoListApp window = new TodoListApp();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace(); // Print any exception that occurs
            }
        });
    }
}
