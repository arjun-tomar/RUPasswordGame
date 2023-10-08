import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileReader;
import java.util.stream.*;
public class IO{
    public static void main(String[] args){
        String password = "";
        Scanner pass = new Scanner(System.in);
        boolean gameOver = false;
        int rulesActive = 1;
        boolean check = true;
        boolean[] rulesBroken = new boolean[29];

        while (!gameOver){
            System.out.println("Type your password: ");
            password = pass.nextLine();
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
            
            if (rulesActive < 29){
                for (int i = 0; i < rulesActive; i++){
                    if (rulesBroken[i] == false){
                        check = false;
                        try (Stream<String> lines = Files.lines(Paths.get("rules.txt"))) {
                            System.out.println(lines.skip(i).findFirst().get() + " X");
                        }
                        catch(IOException e){
                            System.out.println(e);
                        }
                    }
                }
            }
            if (rulesActive < 29){
                System.out.println("Satisfied Rules:");
                for (int i = 0; i < rulesActive; i++){
                    if (rulesBroken[i] == true){
                        try (Stream<String> lines = Files.lines(Paths.get("rules.txt"))) {
                            System.out.println(lines.skip(i).findFirst().get());
                        }
                        catch(IOException e){
                            System.out.println(e);
                        }
                    }
                }
            }
            check = true;
            System.out.println();
            if (rulesActive >= 29)
                gameOver = true;
        }
        if (gameOver){
            System.out.println("password created");
        }
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
   