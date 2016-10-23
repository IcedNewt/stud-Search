
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

       Search test1 = new Search(100, 151);

       test1.readIntoHash("data1.txt");
       test1.readFileIn("data1.txt");

       populateSearchArray(test1Array,"search1.txt");

       System.out.printf("\nTest 1");
       test1.displayData(20, "Data Array");
       test1.displayHash(20);
       System.out.print("\n\n");

       for(int i=0;i<10;i++){
           System.out.printf("Sequential search for %d found at index: %d. %d comparisons needed.%n",test1Array[i],test1.seqSearch(test1Array[i]),test1.compSeq);
           System.out.printf("Binary search for %d found at index: %d. %d comparisons needed.%n",test1Array[i],test1.binSearch(test1Array[i],0,99),test1.compBin);
           System.out.printf("Hash search for %d found at index: %d. %d comparisons needed.%n%n",test1Array[i],test1.hashSearch(test1Array[i]),test1.compHash);

       }

       System.out.println("Average comparisons for sequential search in this case is: " + (test1.compSeq /10));
       System.out.println("Average comparisons for binary search in this case is: " + (test1.compBin /10));
       System.out.println("Average comparisons for Hash search in this case is: " + (test1.compHash /10));


       Search test2 = new Search(1000, 1499);

       test2.readIntoHash("data2.txt");
       test2.readFileIn("data2.txt");

       populateSearchArray(test2Array,"search2.txt");

       System.out.print("\nTest 2");
       test2.displayData(20, "Data Array");
       test2.displayHash(20);
       System.out.print("\n\n");

       for(int i=0;i<10;i++){
           System.out.printf("Sequential search for %d found at index: %d. %d comparisons needed.%n",test2Array[i],test2.seqSearch(test2Array[i]),test2.compSeq);
           System.out.printf("Binary search for %d found at index: %d. %d comparisons needed.%n",test2Array[i],test2.binSearch(test2Array[i],0,999),test2.compBin);
           System.out.printf("Hash search for %d found at index: %d. %d comparisons needed.%n%n",test2Array[i],test2.hashSearch(test2Array[i]),test2.compHash);

       }

       System.out.println("Average comparisons for sequential search in this case is: " + (test2.compSeq /10));
       System.out.println("Average comparisons for binary search in this case is: " + (test2.compBin /10));
       System.out.println("Average comparisons for Hash search in this case is: " + (test2.compHash /10));

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