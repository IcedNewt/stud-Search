
/******************************************************/
/*** Purpose: Test class to illustrate Search class ***/
/***                                                ***/
/*** Author: L. J. Steggles                         ***/
/*** Date: 23/09/2016                               ***/
/******************************************************/

import java.io.*;

public class TestSearch
{
   public static void main(String[] args) 
   {
         
       Search S = new Search(100, 151);
      
       /** Read in test data **/
       S.readFileIn("data1.txt");
    
       /** Display data array **/
       S.displayData(20, "Data Array");
       
       /** Display hash array which will be empty **/
       S.displayHash(20);


       System.out.println();
       System.out.println("Sequential search key found at index: " + S.seqSearch(8));
       System.out.println("Sequential search, number of comparisons are: " + S.compSeq);

       System.out.println("Binary search key found at index: " + S.binSearch(8,0,100));
       System.out.println("Binary search, number of comparisons are: " + S.compBin);
   }
   
}