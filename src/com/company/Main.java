package com.company;
import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Enter a RGB Triplet");
        for(int i=0;i<=2;i++)
            dec[i]=Integer.parseInt(k.next());
        System.out.println(Main.checkhtml(Main.dectohex(dec)));
    }

    private static String dectohex(int [] a)
    {
       for(int i=0;i<3;i++)
       {
           s.append(Main.hex(a[i]/16));
           s.append(Main.hex(a[i]%16));
       }
       return s.toString();
    }

    private static String checkhtml(String a)throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((st = br.readLine()) != null) if(st.toUpperCase().contains(a.toUpperCase())) return st;
        return "#" + a.toUpperCase();
    }

    private static String hex(int a)
    {
        if(a<10) return Integer.toString(a);
        else if(a==10) return "a";
        else if(a==11) return "b";
        else if(a==12) return "c";
        else if(a==13) return "d";
        else if(a==14) return "e";
        else return "f";
    }

    private static Scanner k= new Scanner(System.in);
    private static int [] dec = new int [3];
    private static StringBuilder s = new StringBuilder();
    private static File file = new File("C:\\Users\\bryce_000\\IdeaProjects\\twip-colors-bps24\\src\\com\\company\\html colors");
    private static String st;
}
