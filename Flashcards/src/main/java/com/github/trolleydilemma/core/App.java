package com.github.trolleydilemma.core;

import java.util.List;

/**
 * Entry point
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Testing XMLUtility
        List<Word> list = XMLUtility.loadWords("words.xml");
        list.forEach(x -> {
            System.out.println(x);
            System.out.println(x.getEnglish());
            System.out.println(x.getJapanese());
            System.out.println(x.getLevel());
            System.out.println(x.getNote());
        });
    }
}
