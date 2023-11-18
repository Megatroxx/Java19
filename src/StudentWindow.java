import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StudentWindow {
    public static void main(String[] args) {
        // Создание окна
        JFrame frame = new JFrame("Student List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Создание кнопок
        JButton sortButton = new JButton("Sort");
        JButton searchButton = new JButton("Search");

        // Создание панели для кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(sortButton);
        buttonPanel.add(Box.createHorizontalStrut(10));
        buttonPanel.add(searchButton);
        buttonPanel.add(Box.createHorizontalGlue());


        // Создание списка студентов
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 10));
        students.add(new Student("Json", 20));
        students.add(new Student("Ramil", 30));

        DefaultListModel<Student> model = new DefaultListModel<>();
        for (Student student : students) {
            model.addElement(student);
        }

        JList<Student> studentList = new JList<>(model);

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(students);
                Collections.reverse(students);
                model.clear();
                for (Student student : students) {
                    model.addElement(student);
                }
            }
        });

        JDialog searchDialog = new JDialog(frame, "Search Student", true);
        searchDialog.setSize(300, 200);
        searchDialog.setLocationRelativeTo(frame);

        JLabel label = new JLabel("Enter Student's Name:");
        JTextField textField = new JTextField(20);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                Student foundStudent = null;

                for (Student student : students) {
                    if (student.getName().equals(name)) {
                        foundStudent = student;
                        break;
                    }
                }
                if (foundStudent != null) {
                    JOptionPane.showMessageDialog(searchDialog, "Found student: " + foundStudent.getName() + ", Score: " + foundStudent.getGPA());
                }
                else{
                    try{
                        throw new StudentNotFoundException("Student not found");
                    }
                    catch (StudentNotFoundException ex){
                        JOptionPane.showMessageDialog(searchDialog, ex.getMessage());
                    }
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(searchButton);
        searchDialog.add(panel);

        searchDialog.setVisible(true);

        // Добавление кнопок и списка в окно
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(studentList), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
