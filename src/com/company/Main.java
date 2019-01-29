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
       a[0]/16
    }

    public static String check(String a)
    {

    }

}
