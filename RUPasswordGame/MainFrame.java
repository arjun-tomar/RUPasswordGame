import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.stream.*;
import java.nio.file.Paths;
import java.nio.file.Files;
public class MainFrame {
    private JFrame frame;
    private JTextArea passwordArea;
    private JLabel characterCounterLabel;
    private JLabel passwordLabel;

    int rulesActive = 1;
    boolean[] rulesBroken = new boolean[29];
    String bad = "";
    String good = "";
    boolean check = true;
    boolean gameOver = false;
    
    public MainFrame() {
        frame = new JFrame("Password Input");
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        passwordLabel = new JLabel("Enter a password:");
        passwordLabel.setFont(new Font("Serif", Font.BOLD, 25));
        passwordArea = new JTextArea(10, 30); // Make the JTextArea bigger
        passwordArea.setLineWrap(true);  // Enable text wrapping
        passwordArea.setFont(new Font("Serif", Font.BOLD, 20));

        JScrollPane scrollPane = new JScrollPane(passwordArea);
        inputPanel.add(passwordLabel, BorderLayout.NORTH);
        inputPanel.add(scrollPane, BorderLayout.CENTER);

        // Create a panel to hold the character counter label
        JPanel counterPanel = new JPanel();
        counterPanel.setLayout(new FlowLayout());
        characterCounterLabel = new JLabel("Characters entered: 0");
        counterPanel.add(characterCounterLabel);

        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(counterPanel, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton enterButton = new JButton("Enter");
        JButton clearButton = new JButton("Clear");

        buttonPanel.add(enterButton);
        buttonPanel.add(clearButton);

        frame.add(buttonPanel, BorderLayout.PAGE_END);

        passwordArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCharacterCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCharacterCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCharacterCount();
            }
        });

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = passwordArea.getText();
                password = password.toLowerCase();
                
                check(rulesActive, rulesBroken, password);
                
                for (int i = 0; i < rulesActive; i++)
                    if (rulesBroken[i] == false)
                        check = false;    
                
                if (check == true)
                    do{
                        rulesActive++;
                        check(rulesActive, rulesBroken, password);
                        if (rulesActive < 29)
                            for (int i = 0; i < rulesActive; i++)
                                if (rulesBroken[i] == false)
                                    check = false;
                    }
                    while(check == true && rulesActive < 29);
                check = true;
                if (rulesActive == 1){
                    try (Stream<String> lines = Files.lines(Paths.get("rules.txt"))) {
                        bad = lines.findFirst().get() + " X";
                    }
                    catch(IOException x){
                        System.out.println(x);
                    }
                }
                else if (rulesActive < 29){
                    for (int i = 0; i < rulesActive; i++){
                        if (rulesBroken[i] == false){
                            check = false;
                            try (Stream<String> lines = Files.lines(Paths.get("rules.txt"))) {
                                bad += lines.skip(i).findFirst().get() + " X" + "\n"; 
                            }
                            catch(IOException x){
                                System.out.println(x);
                            }
                        }
                    }
                }
                if (rulesActive < 29){
                    for (int i = 0; i < rulesActive; i++){
                        if (rulesBroken[i] == true){
                            try (Stream<String> lines = Files.lines(Paths.get("rules.txt"))) {
                                good += lines.skip(i).findFirst().get() + "\n";
                            }
                            catch(IOException x){
                                System.out.println(x);
                            }
                        }
                    }
                }
                check = true;
                System.out.println();
                if (rulesActive >= 29)
                    gameOver = true;
            if (gameOver){
                JOptionPane.showMessageDialog(frame, "password created!!!!!");
            }
            else
                JOptionPane.showMessageDialog(frame, "Unsatisfied Rule:\n" + bad + "\n \n Satisfied Rules: \n" + good);
                good = "";
                bad = "";
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordArea.setText("");
                updateCharacterCount();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void updateCharacterCount() {
        int characterCount = passwordArea.getText().length();
        characterCounterLabel.setText("Characters entered: " + characterCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
    public static void check(int rulesActive, boolean[] rulesBroken, String password){
        rulesBroken[0] = rulechecker.ruleOne(password);
        if (rulesActive >= 5){
            rulesBroken[4] = rulechecker.ruleFive(password);
            if (rulesActive >= 8){
                rulesBroken[7] = rulechecker.ruleEight(password);
                if (rulesActive >= 15){
                    rulesBroken[14] = rulechecker.ruleFifteen(password);
                    if (rulesActive >= 20){
                        rulesBroken[19] = rulechecker.ruleTwenty(password);
                        if (rulesActive >= 22){
                            rulesBroken[21] = rulechecker.ruleTwentyTwo(password);
                        }
                    }
                }
            }
        }
        
        
        if (rulesActive >= 2){
            rulesBroken[1] = rulechecker.ruleTwo(password);
            if (rulesActive >= 3){
                rulesBroken[2] = (rulechecker.ruleThree(password));
                if (rulesActive >= 4){
                    rulesBroken[3] = rulechecker.ruleFour(password);
                    if (rulesActive >= 6){
                        rulesBroken[5] = rulechecker.ruleSix(password);
                        if (rulesActive >= 7){
                            rulesBroken[6] = rulechecker.ruleSeven(password);
                            if (rulesActive >= 9){
                                rulesBroken[8] = rulechecker.ruleNine(password);
                                if (rulesActive >= 10){
                                    rulesBroken[9] = rulechecker.ruleTen(password);
                                    if (rulesActive >= 11){
                                        rulesBroken[10] = rulechecker.ruleEleven(password);
                                        if (rulesActive >= 12){
                                            rulesBroken[11] = rulechecker.ruleTwelve(password);
                                            if (rulesActive >= 13){
                                                rulesBroken[12] = rulechecker.ruleThirteen(password);
                                                if (rulesActive >= 14){
                                                    rulesBroken[13] = rulechecker.ruleFourteen(password);
                                                    if (rulesActive >= 16){
                                                        rulesBroken[15] = rulechecker.ruleSixteen(password, rulesActive);
                                                        if (rulesActive >= 17){
                                                            rulesBroken[16] = rulechecker.ruleSeventeen(password);
                                                            if (rulesActive >= 18){
                                                                rulesBroken[17] = rulechecker.ruleEighteen(password);
                                                                if (rulesActive >= 19){
                                                                    rulesBroken[18] = rulechecker.ruleNineteen(password);
                                                                    if (rulesActive >= 21){
                                                                        rulesBroken[20] = rulechecker.ruleTwentyOne(password);
                                                                        if (rulesActive >= 23){
                                                                            rulesBroken[22] = rulechecker.ruleTwentyThree(password);
                                                                            if (rulesActive >= 24){
                                                                                rulesBroken[23] = rulechecker.ruleTwentyFour(password);
                                                                                if (rulesActive >= 25){
                                                                                    rulesBroken[24] = rulechecker.ruleTwentyFive(password);
                                                                                    if (rulesActive >= 26){
                                                                                        rulesBroken[25] = rulechecker.ruleTwentySix(password);
                                                                                        if (rulesActive >= 27){
                                                                                            rulesBroken[26] = rulechecker.ruleTwentySeven(password);
                                                                                            if (rulesActive >= 28){
                                                                                                rulesBroken[27] = rulechecker.ruleTwentyFive(password);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}