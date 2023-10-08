import java.util.HashSet;
import java.util.Set;

public class rulechecker{

    //Your password must be at least 6 characters (NOT one you already use!)
    public static boolean ruleOne(String str){
        return !(str.length() < 6);
    }

    //Your password must include a number
    public static boolean ruleTwo(String str){
        for (Character c : str.toCharArray()){
            if (Character.isDigit(c) == true){
                return true;
            }
        }
        return false;
    }

    //Your password must include a special character
    public static boolean ruleThree(String str){
        for (Character c : str.toCharArray()){
            if (isSpecialCharacter(c)){
                return true;
            }
        }
        return false;
    }
    public static boolean isSpecialCharacter(char c){
        if (!Character.isLetter(c) && !Character.isDigit(c) && !Character.isWhitespace(c)){
            return true;
        }
        return false;
    }
    //Your password must not have special characters next to a number
    public static boolean ruleFour(String str){
        char[] chars = str.toCharArray();
        int i = 0; 
        while (i < str.length()-1){
            int j = i + 1;
            if ((isSpecialCharacter(chars[i]) && Character.isDigit(chars[j])) || (isSpecialCharacter(chars[j]) && Character.isDigit(chars[i]))){
                return false;
            }
            i++;
        }
        return true;
        
    }

    //Your password has to be greater than 20 characters
    public static boolean ruleFive(String str){
        return (str.length() > 20);
    }
    
    //Some mysterious bird has emerged from its slumber, wave to it with o/ o7
    public static boolean ruleSix(String str){
        return (str.indexOf("o7") != -1 || str.indexOf("o/") != -1);
    }

    //The numbers in your password must add to 33 
    public static boolean ruleSeven(String str) {
    int sum = 0;

    for (char c : str.toCharArray()) {
        if (Character.isDigit(c)) {
            sum += Character.getNumericValue(c);
        }
    }

    return sum == 33;
}


    //The second and second to last character in your password must be the same. 
    public static boolean ruleEight(String str){
        return str.substring(1, 2).equals(str.substring(str.length() - 2, str.length() - 1));
    }
    
    //The password must contain the number 561
    //condor foreshadowing POG
    public static boolean ruleNine(String str){
        return (str.indexOf("561") != -1);
    }

    //ensure smiley is in it :)
    public static boolean ruleTen(String str){
        return (str.indexOf(":)") != -1 || str.indexOf("(:") != -1 || str.indexOf(":D") != -1);
    }
    // check if every vowel is in it
    public static boolean ruleEleven(String str){
        return (str.indexOf("a") != -1 && str.indexOf("e") != -1 && str.indexOf("i") != -1 && str.indexOf("o") != -1 && str.indexOf("u") != -1);
    }
    // CONDOR BEGINS
    //Your password is being held hostage by a giant number condor. The condor is only scared of 7...cause...
    public static boolean ruleTwelve(String str){
        return (str.indexOf("7") != -1);

        
    }
    
    
    
    public static boolean isNumberRemoved(String str, String original){
        if (!str.equals(original)){
            return true;
        }
        return false;
    }
    
    //Your password must have EXACTLY 20 vowels (a, e , i, o, u)
    public static boolean ruleThirteen(String str){
    
        int counter = 0;
        for (int i = 0; i < str.length(); i++)
        {
            char x = str.charAt(i);
            if (isVowel(x)){
                counter++;
            }
        }
        if (counter == 20)
        {
            return true;
        }
        return false;
        
    }

    public static boolean isVowel(Character c){
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
    //Your password must contain the last name of one of the first ten US presidents
    public static boolean ruleFourteen(String str){
        if (str.indexOf("washington") != -1 || str.indexOf("adams") != -1 ||
         str.indexOf("jefferson") != -1 || str.indexOf("madison") != -1 || str.indexOf("monroe") != -1
          || str.indexOf("jackson") != -1 || str.indexOf("buren") != -1 || str.indexOf("harrison") != -1 || str.indexOf("tyler") != -1){
            return true;
          }
        else
            return false;
    }

    //Your password is an extreme radiation zone. Give it a shield with “(“ and “)”;
    public static boolean ruleFifteen(String str){
        if (str.indexOf("(") == 0 && str.lastIndexOf(")") == str.length()-1){
            return true;
        }
        return false;
    }
    //The password must contain the number of rules currently active
    public static boolean ruleSixteen(String str, int rulesActive){
        return (str.indexOf(Integer.toString(rulesActive)) != -1);
    }
    //The password must have one of my favorite colors (red) (orange) (blue) (brown) (pink) (yellow) (green) (purple)
    public static boolean ruleSeventeen(String str){
        return (str.indexOf("red") != -1 || str.indexOf("orange") != -1 ||str.indexOf("yellow") != -1 || str.indexOf("green") != -1 || str.indexOf("blue") != -1 || str.indexOf("purple") != -1);
    }   
    //The password must contain the answer to this riddle: I have four arms but no hands. I have four legs but no feet. I have four feet, but no legs. What am I? Answer: Paradox, contradiction, liar
    public static boolean ruleEighteen(String str){
        return (str.indexOf("paradox") != -1 || str.indexOf("contradiction") != -1 || str.indexOf("liar") != -1);
    }
    //The password must have all letters of the alphabet at least once
   public static boolean ruleNineteen(String str) {
    Set<Character> letters = new HashSet<>();
    
    for (char ch : str.toCharArray()) {
        if (Character.isLetter(ch)) {
            letters.add(Character.toLowerCase(ch));
        }
    }

    return letters.size() == 26;
}

    
    //Your password must have at most 100 characters
    public static boolean ruleTwenty(String str){
        return !(str.length() > 100);
    }

    //Your password should not have any connected repeating letters
    public static boolean ruleTwentyOne(String str){
        char[] chars = str.toCharArray();
        int i = 0; 
        while (i < str.length() - 1){
            int j = i + 1;
                if (Character.isLetter(j) && Character.isLetter(i) && chars[i] == chars[j]){
                    return false;
                }
            i++;
        }
        return true;
        
    }
    //Your password must have a number in the first five characters
    public static boolean ruleTwentyTwo(String str){
        for (int i = 0; i < 5; i++)
            if (Character.isDigit(str.charAt(i))){
                return true;
            }
        return false;
    }
    //Your password must include the name of a Rutgers campus (including Newark and Camden)
    public static boolean ruleTwentyThree(String str){
        return (str.indexOf("newark") != -1 || str.indexOf("camden") != -1 || str.indexOf("collegeave") != -1 || str.indexOf("livi") != -1 || str.indexOf("busch") != -1 || str.indexOf("cook") != -1 || str.indexOf("doug") != -1);
    }
    //Your password must contain an element abbreviation in the periodic table group 18 (He, Ne, Ar, Kr, Xe, Rn)
    public static boolean ruleTwentyFour(String str){
        return (str.indexOf("he") != -1 || str.indexOf("ne") != -1 || str.indexOf("ar") != -1 || str.indexOf("kr") != -1 || str.indexOf("xe") != -1 || str.indexOf("rn") != -1);
    }
    //Your password must contain the name of a continent where a condor lives. (america)
    public static boolean ruleTwentyFive(String str){
        return (str.indexOf("america") != -1);
    }    
    //Your password must contain a perfect square between 200 and 600. (225, 256, 289, 324, 361, 400, 441, 484, 529, 576)
    public static boolean ruleTwentySix(String str){
        return (str.indexOf("225") != -1 || str.indexOf("256") != -1 || str.indexOf("289") != -1 || str.indexOf("324") != -1 || str.indexOf("361") != -1|| str.indexOf("400") != -1 || str.indexOf("441") != -1 || str.indexOf("484") != -1|| str.indexOf("529") != -1 || str.indexOf("576") != -1);  
    }
    //Your password must contain the answer to this riddle: I am always around, but never seen. I’ve been where you have been. I can cause pain or bring joy. What am I? (Memories, memory, thoughts, flashbacks, nostalgia)
    public static boolean ruleTwentySeven(String str){
        return (str.indexOf("memories") != -1 || str.indexOf("memory") != -1 || str.indexOf("thoughts") != -1 || str.indexOf("flashbacks") != -1 || str.indexOf("nostalgia") != -1);
    }
    //The condor is still pretty upset, communicate with it one last time by putting a “caw” somewhere in your password. 
    public static boolean ruleTwentyEight(String str){
        return (str.indexOf("caw") != -1);
    }
}
