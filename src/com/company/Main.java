package com.company;
import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
	    Scanner k = new Scanner(System.in);
        System.out.println("Enter a RGB Triplet");

        int [] dec = new int [3];


        for(int i=0;i<=2;i++)
        {
            dec[i]=Integer.parseInt(k.next());
        }

        System.out.println(Main.check(Main.dectohex(dec)));
    }


    public static String dectohex(int [] a)
    {
       String s= "";
        int b;

        for(int i=0;i<3;i++)
        {
            s+=Main.hex(a[i]/16);
            s+=Main.hex(a[i]%16);
        }
        return s;
    }

    public static String check(String a)
    {
        return a;
    }
    public static char hex(int a)
    {
        if(a<10)
            return (char)a;
        else if(a==10)
            return 'a';
        else if(a==11)
            return 'b';
        else if(a==12)
            return 'c';
        else if(a==13)
            return 'd';
        else if(a==14)
            return 'e';
        else
            return 'f';

    }


}
