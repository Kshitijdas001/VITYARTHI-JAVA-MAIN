import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SimulatorGUI extends JFrame {

    JSpinner processNumber;
    JPanel processPanel;
    JTextField[][] input;
    JComboBox<String> algorithm;
    JTextArea output;

    public SimulatorGUI() {

        setTitle("CPU Scheduling Simulator");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel main = new JPanel(new BorderLayout(10, 10));
        main.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        JLabel heading = new JLabel(
                "CPU PROCESS SCHEDULING SIMULATOR",
                SwingConstants.CENTER
        );

        heading.setFont(new Font("Arial", Font.BOLD, 20));
        main.add(heading, BorderLayout.NORTH);

        JPanel top = new JPanel();

        top.add(new JLabel("Processes:"));

        processNumber = new JSpinner(
                new SpinnerNumberModel(3, 1, 10, 1)
        );

        top.add(processNumber);

        JButton create = new JButton("Create");
        top.add(create);

        top.add(new JLabel("Algorithm:"));

        algorithm = new JComboBox<>(
                new String[]{
                        "FCFS",
                        "SJF",
                        "SRTF",
                        "Priority"
                }
        );

        top.add(algorithm);

        JButton run = new JButton("Run");
        top.add(run);

        main.add(top, BorderLayout.PAGE_START);

        processPanel = new JPanel();

        main.add(
                new JScrollPane(processPanel),
                BorderLayout.CENTER
        );

        output = new JTextArea();
        output.setEditable(false);
        output.setFont(
                new Font("Monospaced", Font.PLAIN, 13)
        );

        JScrollPane result = new JScrollPane(output);
        result.setPreferredSize(
                new Dimension(800, 200)
        );

        main.add(result, BorderLayout.SOUTH);

        create.addActionListener(e -> makeFields());

        run.addActionListener(e -> runProgram());

        makeFields();

        add(main);
    }

    void makeFields() {

        int n = (Integer) processNumber.getValue();

        processPanel.removeAll();

        processPanel.setLayout(
                new GridLayout(n + 1, 4, 5, 5)
        );

        processPanel.add(new JLabel("Process"));
        processPanel.add(new JLabel("Arrival Time"));
        processPanel.add(new JLabel("Burst Time"));
        processPanel.add(new JLabel("Priority"));

        input = new JTextField[n][3];

        for (int i = 0; i < n; i++) {

            processPanel.add(
                    new JLabel("P" + (i + 1))
            );

            for (int j = 0; j < 3; j++) {

                input[i][j] = new JTextField();

                processPanel.add(input[i][j]);
            }
        }

        processPanel.revalidate();
        processPanel.repaint();
    }

    void runProgram() {

        try {

            int n = input.length;
            Process[] p = new Process[n];

            for (int i = 0; i < n; i++) {

                int at = Integer.parseInt(
                        input[i][0].getText()
                );

                int bt = Integer.parseInt(
                        input[i][1].getText()
                );

                int priority = Integer.parseInt(
                        input[i][2].getText()
                );

                if (at < 0 || bt <= 0 || priority <= 0) {
                    throw new Exception();
                }

                p[i] = new Process(
                        i + 1,
                        at,
                        bt,
                        priority
                );
            }

            String choice =
                    (String) algorithm.getSelectedItem();

            // Take the output from the scheduling class
            PrintStream old = System.out;

            ByteArrayOutputStream data =
                    new ByteArrayOutputStream();

            System.setOut(new PrintStream(data));

            try {

                if (choice.equals("FCFS")) {
                    FCFS.run(p);
                }
                else if (choice.equals("SJF")) {
                    SJF.run(p);
                }
                else if (choice.equals("SRTF")) {
                    SRTF.run(p);
                }
                else if (choice.equals("Priority")) {
                    Priority.run(p);
                }

            } finally {
                System.setOut(old);
            }

            output.setText(data.toString());

        }
        catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );

        }
        catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Check the process values.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {

        new SimulatorGUI().setVisible(true);
    }
}