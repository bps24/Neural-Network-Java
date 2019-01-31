package com.company;
import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
	    Scanner k = new Scanner(System.in);
        System.out.println("Enter a RGB Triplet");

        int [] dec = new int [3];

        for(int i=0;i<=2;i++) dec[i]=Integer.parseInt(k.next());

        System.out.println(Main.check(Main.dectohex(dec)));
    }


    public static String dectohex(int [] a)
    {
       StringBuilder s = new StringBuilder();
        for(int i=0;i<3;i++)
        {
            s.append(Main.hex(a[i]/16));
            s.append(Main.hex(a[i]%16));
        }
        return s.toString();
    }

    public static String check(String a)
    {
       return a;
    }
    public static String hex(int a)
    {
        if(a<10) return Integer.toString(a);
        else if(a==10) return "a";
        else if(a==11) return "b";
        else if(a==12) return "c";
        else if(a==13) return "d";
        else if(a==14) return "e";
        else return "f";
    }

    public static int [][] scanColors()
    {
        Scanner k = new Scanner("C:\\Users\\bryce_000\\IdeaProjects\\twip-colors-bps24\\src\\com\\company\\html colors");
        int index=0;
        int colors [][] = new int[140][2];
        while(k.hasNext())
        {

        }
    }



}
