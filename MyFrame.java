package com.divya.clock;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {

    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dateLabel;
    JLabel dayLabel;
    String time;
    String day;
    String  date;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clock");
        this.setLayout(new FlowLayout());
        this.setSize(300, 200);
            this.setResizable(false);

        timeFormat = new SimpleDateFormat("hh:mm:ss");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 45));
        timeLabel.setForeground(new Color(0, 255, 255));
        timeLabel.setBackground(new Color(0, 0, 0));
        timeLabel.setOpaque(true);

        time = timeFormat.format(Calendar.getInstance().getTime());
        timeLabel.setText(time);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Agency FB", Font.PLAIN, 40));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Agency FB", Font.PLAIN, 35));

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTime();
    }

    void setTime() {

        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
