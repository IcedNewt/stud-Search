 

/************************************************/
/*** Purpose:                                 ***/
/***                                          ***/
/***                                          ***/
/*** Author:                                  ***/
/*** Date:                                    ***/
/***                                          ***/
/*** Note: Based on skeleton code provided by ***/
/*** Jason Steggles 23/09/2016                ***/
/************************************************/

import java.io.*;
import java.text.*;
import java.util.*;

public class Search {

/** Global variables for counting comparisons **/
public int compSeq=0;
public int compBin=0;
public int compHash=0;

/** Array of values to be searched and size **/
private int[] A;
private int size;

/** Hash array and size **/
private int[] H;
private int hSize;

/** Constructor **/
Search(int n, int hn)
{
    /** set size of array **/
    size = n;
    hSize = hn;

    /** Create arrays **/
    A = new int[size];
    H = new int[hSize];

    /** Initialize hash array **/
    /** Assume -1 indicates a location is empty **/
    for (int i=0; i<hSize; i++)
    {
        H[i] = -1;
    }
}


/********************************************/
/*** Read a file of numbers into an array ***/
/********************************************/
public void readFileIn(String file)
{
   try
   {
       /** Set up file for reading **/
       FileReader reader = new FileReader(file);
       Scanner in = new Scanner(reader);

       /** Loop round reading in data **/
       for (int i=0;i<size;i++)
       {
          /** Get net value **/
          A[i] = in.nextInt();
       }
    }
    catch (IOException e)
    {
       System.out.println("Error processing file " + file);
    }
}


/*********************/
/*** Hash Function ***/
/*********************/
public int hash(int key)
{
    return key%hSize;
}


private void addToHash(int value){
    int index = hash(value);
    while(!(H[index]== -1)){
        index+=1;
        System.out.println(value+"   "+index);
        if(index>(hSize-1)){
            index=0;
        }
    }

    H[index] = value;
}

public void readIntoHash(String file){
    try
    {
        /** Set up file for reading **/
        FileReader reader = new FileReader(file);
        Scanner in = new Scanner(reader);

        /** Loop round reading in data **/
        for (int i=0;i<size;i++)
        {
            /** Get net value **/
            addToHash(in.nextInt());
        }
    }
    catch (IOException e)
    {
        System.out.println("Error processing file " + file);
    }
}

public int hashSearch(int key) {
    int index = hash(key);

    compHash+=1;
    if (H[index] == -1){
        return -1;
    }

    compHash+=1;
    if(H[index] == key){
        return index;
    }
    else{
        int oldIndex;
            if(index != 0){
                oldIndex=index-1;}
            else{
                oldIndex = hSize-1;}

        while((index!=oldIndex) &&(index!=(-1))){
            index+=1;
            if(index>(hSize-1)){
                index=0;
            }
            compHash+=1;
            if(H[index] == key){
                return index;
            }
        }
        return -1;
    }
}



/*****************************/
/*** Display array of data ***/
/*****************************/
public void displayData(int line, String header)
{
    /* ** Integer Formatter ** */
    NumberFormat FI = NumberFormat.getInstance();
    FI.setMinimumIntegerDigits(3);

    /** Print header string **/
    System.out.print("\n\n"+header);

    /** Display array data **/
    for (int i=0;i<size;i++)
    {
        /** New line? **/
        if (i%line == 0)
        {
             System.out.println();
        }

        /** Display value **/
        System.out.print(FI.format(A[i])+" ");
    }
}

/**************************/
/*** Display hash array ***/
/**************************/
public void displayHash(int line)
{
    /** Integer Formatter **/
    NumberFormat FI = NumberFormat.getInstance();
    FI.setMinimumIntegerDigits(3);

    /** Print header string **/
    System.out.print("\n\nHash Array of size " + hSize);

    /** Display array data **/
    for (int i=0;i<hSize;i++)
    {
        /** New line? **/
        if (i%line == 0) 
        { 
             System.out.println(); 
        }
   
        /** Display value **/     
        System.out.print(FI.format(H[i])+" ");
    } 
}


public int seqSearch(int key){
    for(int i=0; i<size;i++){
        compSeq+=1;
        if(A[i]>key){
            compSeq+=1;
            if(key==A[i-1]){
                return (i-1);
            }
            else{
                break;
            }
        }
    }
    return -1;
}

public int binSearch (int key, int L, int R){
    int m;
    if(R<L){
        return -1;
    }
    m=(R+L)/2;
    compBin+=1;
    if(key == A[m]){
        return m;
    }
    compBin+=1;
    if(key > A[m]){
        return binSearch(key,m+1,R);
    }
    else{
        return binSearch(key,L,m-1);
    }
}


} /*** End oofooo class Search ***/