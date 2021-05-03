package com.company;

import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
	// write your code here
        String str1 = "Cats are great pets.";
        String str2 = "Tom got a small piece of pie.";
        String str3 = "He told us a very exciting tale.";
        Test main = new Test();


        System.out.println(main.doRemake(str1));
        System.out.println(main.doRemake(str2));
        System.out.println(main.doRemake(str3));
    }

    public String doRemake(String str){
        String[] splitStr = str.split("(?<=\\b|[^\\p{L}])");
        for (int i = 0; i < splitStr.length; i++) {
            splitStr[i] = applyRules(splitStr[i]);
        }
        String result = "";
        for (String e: splitStr) {
            result += e;
        }
        return result;
    }

    public String applyRules(String str){
        if(!Pattern.matches("(\\s+)|([\\p{P}\\p{S}])", str)) {
            if(startWithVowel(str)){
                str = vowelRule(str);
            }else{
                str = nonVowelRule(str);
            }

        }
        return str;
    }
    boolean startWithVowel(String word) {

        switch(word.charAt(0)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }

    public String vowelRule(String str){

        return str + "way";
    }

    public String nonVowelRule(String str){
        if(checkIfCapital(str)){
            str = str.substring(0,2).toUpperCase()+str.substring(2);
        }

        return str.substring(1)+str.substring(0,1).toLowerCase()+"ay";
    }

    public boolean checkIfCapital(String str){
        return Character.isUpperCase(str.charAt(0));

    }
}
