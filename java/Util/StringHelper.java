package Util;

import java.util.Random;

public class StringHelper {

    static Random random = new Random();
    static String atoZ = "qwertyuiopasdfghjklzxvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    static String zeroto9 = "1234567890";

    public static String getRandomString(int len){

        String str = "";
        for(int i=0 ;i< len;i++){

            str = str + atoZ.charAt(random.nextInt(atoZ.length()));
        }
        return str;
    }


    public static String getRandomInt(int len){

        String integer ="";

        for(int i=0;i<len;i++){

            integer = integer + zeroto9.charAt(random.nextInt(zeroto9.length()));
        }
        return integer;
    }



}
