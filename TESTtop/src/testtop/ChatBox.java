/*
 *  TESTtop. Making a better TTS for a happier experience.
 */
package testtop;

/**
 *
 * @author Leone Shamoth
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ChatBox {

    String      appName     = "TESTtop Chat";
    ChatBox     mainGUI;
    JFrame      newFrame    = new JFrame(appName);
    JButton     sendMessage;
    JTextField  messageBox;
    JTextArea   chatBox;
    JTextField  usernameChooser;
    JFrame      preFrame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager
                            .getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ChatBox mainGUI = new ChatBox();
                mainGUI.preDisplay();
            }
        });
    }

    public void preDisplay() {
        newFrame.setVisible(false);
        preFrame = new JFrame(appName);
        usernameChooser = new JTextField(15);
        usernameChooser.addActionListener(new enterServerButtonListener());
        JLabel chooseUsernameLabel = new JLabel("Pick a username:");
        JButton enterServer = new JButton("Enter Chat Server");
        enterServer.addActionListener(new enterServerButtonListener());
        JPanel prePanel = new JPanel(new GridBagLayout());

        GridBagConstraints preRight = new GridBagConstraints();
        preRight.insets = new Insets(0, 0, 0, 10);
        preRight.anchor = GridBagConstraints.EAST;
        GridBagConstraints preLeft = new GridBagConstraints();
        preLeft.anchor = GridBagConstraints.WEST;
        preLeft.insets = new Insets(0, 10, 0, 10);
        // preRight.weightx = 2.0;
        preRight.fill = GridBagConstraints.HORIZONTAL;
        preRight.gridwidth = GridBagConstraints.REMAINDER;

        prePanel.add(chooseUsernameLabel, preLeft);
        prePanel.add(usernameChooser, preRight);
        preFrame.add(BorderLayout.CENTER, prePanel);
        preFrame.add(BorderLayout.SOUTH, enterServer);
        preFrame.setSize(300, 300);
        preFrame.setVisible(true);

    }

    public void display() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.BLUE);
        southPanel.setLayout(new GridBagLayout());

        messageBox = new JTextField(30);
        messageBox.addActionListener (new sendMessageButtonListener());
        messageBox.requestFocusInWindow();

        sendMessage = new JButton("Send Message");
        sendMessage.addActionListener(new sendMessageButtonListener());

        chatBox = new JTextArea();
        chatBox.setEditable(false);
        chatBox.setFont(new Font("Serif", Font.PLAIN, 15));
        chatBox.setLineWrap(true);

        mainPanel.add(new JScrollPane(chatBox), BorderLayout.CENTER);

        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.LINE_START;
        left.fill = GridBagConstraints.HORIZONTAL;
        left.weightx = 512.0D;
        left.weighty = 1.0D;

        GridBagConstraints right = new GridBagConstraints();
        right.insets = new Insets(0, 10, 0, 0);
        right.anchor = GridBagConstraints.LINE_END;
        right.fill = GridBagConstraints.NONE;
        right.weightx = 1.0D;
        right.weighty = 1.0D;

        southPanel.add(messageBox, left);
        southPanel.add(sendMessage, right);

        mainPanel.add(BorderLayout.SOUTH, southPanel);

        newFrame.add(mainPanel);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setSize(470, 300);
        newFrame.setVisible(true);
    }

    class sendMessageButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (messageBox.getText().length() < 1) {
                // do nothing
            } 
            
            else if (messageBox.getText().equals(".clear")) 
            {
                chatBox.setText("Cleared all messages\n");
                messageBox.setText("");
            } 
            
            else if (messageBox.getText().length() > 2 && messageBox.getText().substring(0, 2).equals ("/r"))
            {
                String text = messageBox.getText();
                String[] arrayOfMessage = text.split(" ");
                
                if (arrayOfMessage.length == 2)
                {
                    String[] roll = arrayOfMessage[1].split("d");
                    
                    if (roll.length == 2)
                    {
                        int toDisplayInt = Roll.rollDie (Integer.parseInt(roll[0]), Integer.parseInt(roll[1]));
                        
                        chatBox.append (username + " rolled " + arrayOfMessage[1] + " and got: " + toDisplayInt + "\n");
                    }
                    
                    else
                    {
                        chatBox.append("INVALID ROLL\n");
                    }
                }
                
                else
                {
                    chatBox.append ("INVALID ROLL\n");
                }
                
                messageBox.setText("");
            }
            
            else 
            {
                chatBox.append("<" + username + ">:  " + messageBox.getText()
                        + "\n");
                messageBox.setText("");
            }
            
            messageBox.requestFocusInWindow();
        }
    }

    String  username;

    class enterServerButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            username = usernameChooser.getText();
            if (username.length() < 1) {
                Object[] options = {"OK"};
                JOptionPane.showMessageDialog (null, "Please select a username", "ALERT", JOptionPane.ERROR_MESSAGE);
                
                System.out.println("No!");
            } else {
                preFrame.setVisible(false);
                display();
            }
        }

    }
    
}
