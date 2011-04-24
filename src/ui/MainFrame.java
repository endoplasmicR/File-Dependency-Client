package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * @param args
     */
    public static void main(String[] args) {
        new MainFrame();
    }

    MainFrame() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu settingsMenu = new JMenu("Settings");
        JMenu helpMenu = new JMenu("Help");

        fileMenu.setMnemonic(java.awt.event.KeyEvent.VK_F);
        fileMenu.setDisplayedMnemonicIndex(0);

        settingsMenu.setMnemonic(java.awt.event.KeyEvent.VK_S);
        settingsMenu.setDisplayedMnemonicIndex(0);

        helpMenu.setMnemonic(java.awt.event.KeyEvent.VK_H);
        helpMenu.setDisplayedMnemonicIndex(0);

        JMenuItem exitMenuItem = new JMenuItem("Exit", 'E');
        JMenuItem addFileMenuItem = new JMenuItem("Add New File to Repository", 'A');
        JMenuItem revertAllMenuItem = new JMenuItem("Revert All Changes", 'R');

        JMenuItem accountMenuItem = new JMenuItem("Manage Account", 'M');
        JMenuItem preferenceMenuItem = new JMenuItem("Preference", 'P');

        JMenuItem helpMenuItem = new JMenuItem("Help");
        JMenuItem gettingStartedMenuItem = new JMenuItem("Getting Started");
        JMenuItem troubleShootingMenuItem = new JMenuItem("Trouble Shooting Information");
        JMenuItem feedbackMenuItem = new JMenuItem("Submit Feedback");
        JMenuItem aboutMenuItem = new JMenuItem("About ...");

        //addFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, Event.CTRL_MASK));

        exitMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        fileMenu.add(addFileMenuItem);
        fileMenu.add(revertAllMenuItem);
        fileMenu.add(new JSeparator());
        fileMenu.add(exitMenuItem);

        settingsMenu.add(accountMenuItem);
        settingsMenu.add(preferenceMenuItem);

        helpMenu.add(gettingStartedMenuItem);
        helpMenu.add(new JSeparator());
        helpMenu.add(helpMenuItem);
        helpMenu.add(troubleShootingMenuItem);
        helpMenu.add(feedbackMenuItem);
        helpMenu.add(new JSeparator());
        helpMenu.add(aboutMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(settingsMenu);
        menuBar.add(helpMenu);

        JPanel contentPanel = new JPanel(true);
        contentPanel.setBorder(BorderFactory.createEmptyBorder());

        JPanel fileStatePanel = new JPanel(true);
        JPanel mainPanel = new JPanel(true);

        JPanel commentPanel = new JPanel(true);
        JPanel dependencyPanel = new JPanel(true);

        fileStatePanel.setBackground(Color.LIGHT_GRAY);
        fileStatePanel.setPreferredSize(new Dimension(195, 425));
        fileStatePanel.setBorder(BorderFactory.createEmptyBorder());
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setPreferredSize(new Dimension(430, 425));
        mainPanel.setBorder(BorderFactory.createEmptyBorder());

        commentPanel.setBackground(Color.WHITE);
        commentPanel.setPreferredSize(new Dimension(435, 195));
        commentPanel.setBorder(BorderFactory.createEmptyBorder());
        dependencyPanel.setBackground(Color.WHITE);
        dependencyPanel.setPreferredSize(new Dimension(435, 275));
        dependencyPanel.setBorder(BorderFactory.createEmptyBorder());

        JLabel unstagedLabel = new JLabel("unstaged:");
        unstagedLabel.setPreferredSize(new Dimension(185, 15));

        String unstagedList[] = {"e.plist", "a_long_file_name.docx", "g.docx", "h.docx"};
        JList unstagedBox = new JList(unstagedList);
        unstagedBox.setPreferredSize(new Dimension(185, 185));

        JLabel stagedLabel = new JLabel("staged:");
        stagedLabel.setPreferredSize(new Dimension(185, 15));

        String stagedList[] = {"a.docx", "b.docx", "c.docx", "d.txt"};
        JList stagedBox = new JList(stagedList);
        stagedBox.setPreferredSize(new Dimension(185, 185));

        fileStatePanel.add(unstagedLabel);
        fileStatePanel.add(unstagedBox);
        fileStatePanel.add(stagedLabel);
        fileStatePanel.add(stagedBox);
        mainPanel.add(dependencyPanel, BorderLayout.NORTH);
        mainPanel.add(commentPanel, BorderLayout.CENTER);
        contentPanel.add(fileStatePanel, BorderLayout.WEST);
        contentPanel.add(mainPanel, BorderLayout.CENTER);

        this.add(contentPanel);

        setJMenuBar(menuBar);
        this.setSize(640, 480);
        setVisible(true);
        setResizable(false);
    }
}
