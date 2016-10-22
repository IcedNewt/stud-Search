
/******************************************************/
/*** Purpose: Test class to illustrate Search class ***/
/***                                                ***/
/*** Author: L. J. Steggles                         ***/
/*** Date: 23/09/2016                               ***/
/******************************************************/

import java.io.*;
import java.util.Scanner;

public class TestSearch
{
   public static void main(String[] args) 
   {

       int[] test1Array = new int[10];
       int[] test2Array = new int[10];

       /**Search S = new Search(100, 151);

       S.readIntoHash("data1.txt");


       S.readFileIn("data1.txt");
    

       S.displayData(20, "Data Array");
       

       S.displayHash(20);


       System.out.println();
       System.out.println("Sequential search key found at index: " + S.seqSearch(8));
       System.out.println("Sequential search, number of comparisons are: " + S.compSeq);

       System.out.println("Binary search key found at index: " + S.binSearch(8,0,100));
       System.out.println("Binary search, number of comparisons are: " + S.compBin);

       System.out.println("Hash search key found at index: " + S.hashSearch(490));
       System.out.println("Binary search, number of comparisons are: " + S.compHash);

       **/


       Search test1 = new Search(100, 151);

       test1.readIntoHash("data1.txt");
       test1.readFileIn("data1.txt");

       populateSearchArray(test1Array,"search1.txt");

       for(int i=0;i<10;i++){
           System.out.println("Sequential search for "+test1Array[i]+" found at index: " + test1.seqSearch(test1Array[i]));
           System.out.println("Sequential search, number of comparisons are: " + test1.compSeq);

           System.out.println("Binary search for "+test1Array[i]+" found at index: " + test1.binSearch(test1Array[i],0,99));
           System.out.println("Binary search, number of comparisons are: " + test1.compBin);

           System.out.println("Hash search for "+test1Array[i]+" found at index: " + test1.hashSearch(test1Array[i]));
           System.out.println("Hash search, number of comparisons are: " + test1.compHash);

       }

       System.out.println("Average comparisons for sequential search in this case is: " + (test1.compSeq /10));
       System.out.println("Average comparisons for binary search in this case is: " + (test1.compBin /10));
       System.out.println("Average comparisons for Hash search in this case is: " + (test1.compHash /10));

   }

   public static void populateSearchArray(int[] array, String file){
       try
       {
           /** Set up file for reading **/
           FileReader reader = new FileReader(file);
           Scanner in = new Scanner(reader);

           /** Loop round reading in data **/
           for (int i=0;i<10;i++)
           {
               /** Get net value **/
               array[i] = in.nextInt();
           }
       }
       catch (IOException e)
       {
           System.out.println("Error processing file " + file);
       }
   }
   
}