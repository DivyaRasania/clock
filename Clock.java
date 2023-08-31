import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Clock extends JFrame {
    private JLabel timeLabel;
    private JLabel dateLabel;
    private JPanel panel;

    public Clock() {
        setTitle("Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(timeLabel, constraints);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dateLabel.setHorizontalAlignment(JLabel.CENTER);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(dateLabel, constraints);

        getContentPane().add(panel);

        pack();
        setLocationRelativeTo(null);
        setSize(500, 300);
        setVisible(true);

        updateTimeAndDate();
    }

    private void updateTimeAndDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM dd yyyy");
        timeLabel.setText(timeFormat.format(calendar.getTime()));
        dateLabel.setText(dateFormat.format(calendar.getTime()));
        panel.setPreferredSize(getPreferredSize());
        timeLabel.setPreferredSize(new Dimension(getWidth(), getHeight() / 2));
        dateLabel.setPreferredSize(new Dimension(getWidth(), getHeight() / 2));
        timeLabel.revalidate();
        dateLabel.revalidate();
        timeLabel.repaint();
        dateLabel.repaint();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateTimeAndDate();
    }

    public static void main(String[] args) {
        new Clock();
    }
}