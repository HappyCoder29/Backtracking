package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //generateBinarySequence(4);
        //generateMArySequence(2, 3);

       // Combinations("ABCD");

       // generateAllSubsets("ABC");
       // int[] arr = {1,1,5,3,2,4};
       // generateAllSequenceSumEqualToK(arr, 5);

       // permutations("ABC");

//        List<String> list = generateParenthesis(2);
//        for (String str : list) {
//            System.out.println(str);
//
//        }

      //  generateParenthesis1(2);

        System.out.println(fibonacchiRecursive(50));



    }

    public static void generateBinarySequence(int n){

        if(n <= 0)
            return;
        int[] result = new int[n];
        generateBinarySequence(result, 0);


    }

    private static void generateBinarySequence(int[] result, int curr){

        if(curr == result.length){
            // print and return
            printResult(result);
            return;
        }

        for(int i = 0; i < 2; i ++){
            result[curr] = i;
            generateBinarySequence(result, curr+ 1);
        }
    }

    private static  void printResult(int[] result){
        for(int i = 0 ; i < result.length; i ++){
            System.out.print(result[i] +  " ");
        }
        System.out.println();
    }


    public static void generateMArySequence(int n, int m ){

        if(n <= 0 || m <=0 )
            return;
        int[] result = new int[n];
        generateMArySequence(result, 0, m);


    }

    private static void generateMArySequence(int[] result, int curr, int m){

        if(curr == result.length){
            // print and return
            printResult(result);
            return;
        }

        for(int i = 0; i < m; i ++){
            result[curr] = i;
            generateMArySequence(result, curr+ 1, m );
        }
    }


    public static void Combinations(String str){
        if(str.length() == 0)
            return;

        int[] result = new int[str.length()];
        Combinations(str, result, 0);
    }

    public static void Combinations(String str, int[] result,  int current){

        if(current == str.length()){
            printCombinations(str, result);
            // print and return
            return;
        }

        for(int i = 0 ; i < str.length(); i ++){
            result[current] = i;
            Combinations(str, result, current +1);
        }

    }

    public static void Combinations(String str, int size){
        if(str.length() == 0 || size <=0)
            return;

        int[] result = new int[size];
        Combinations(str, result, 0, size);
    }

    public static void Combinations(String str, int[] result,  int current, int size){

        if(current == size){
            printCombinations(str, result);
            // print and return
            return;
        }

        for(int i = 0 ; i < str.length(); i ++){
            result[current] = i;
            Combinations(str, result, current +1, size);
        }

    }

    static void printCombinations(String str, int[] result){
        char[] arr = str.toCharArray();
        for(int i = 0 ; i < result.length ; i ++){
            System.out.print(arr[result[i]] + " ");
        }
        System.out.println();
    }

    static void generateAllSubsets(String str){
        if(str.length() ==0){
            return;
        }

        int[] result = new int[str.length()];
        generateAllSubsets(str, result, 0);

    }

    static void generateAllSubsets(String str, int[] result, int current){

        if(current == result.length){
            // print and return;
            printSubsets(str, result);
            return;
        }

        for(int i = 0; i < 2; i ++){
            result[current] = i;
            generateAllSubsets(str, result, current +1);
        }
    }
    static  void printSubsets(String str, int[] result){
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int i = 0 ; i < result.length; i ++){
            if(result[i] == 1){
                sb.append(arr[i] + ",");
            }
        }
        sb.append("}");
        System.out.println(sb.toString());

    }

    static  void generateAllSequenceSumEqualToK(int[] arr, int k){
        if(arr.length == 0 )
            return;

        int[] result = new int[arr.length];

        generateAllSequenceSumEqualToK(arr, result, 0, k);

    }

    static  void generateAllSequenceSumEqualToK(int[] arr, int[] result, int current, int k){

        if(current == result.length){
            // print and retuyrnl
            printSumEqualToK(arr, result, k);
            return;
        }

        for(int i = 0 ; i < 2; i ++){
            result[current] = i;
            generateAllSequenceSumEqualToK(arr, result, current +1, k);
        }
    }

    static  void printSumEqualToK(int[] arr, int[] result, int k){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        int sum = 0;
        for(int i = 0 ; i < result.length; i ++){
            if(result[i] == 1){
                sum += arr[i];
                sb.append(arr[i] + ",");
            }
        }
        sb.append("}");
        if(sum == k)
            System.out.println(sb.toString());

    }

    public static  void permutations(String str){
        if(str.length() == 0){
            return;
        }

        int[] result = new int[str.length()];

        permutations(str, result, 0);


    }

    static  void permutations(String str, int[] result, int current){

        if(current == result.length){
            printCombinations(str, result);
            return;
        }

        for(int i = 0 ; i < str.length(); i ++){
            if(isValidPermutation(result, current, i)){
                result[current] = i;
                permutations(str, result, current +1);

            }

        }

    }

    static  boolean isValidPermutation(int[] result, int current, int num){

        for(int i = 0 ; i < current; i ++){
            if(result[i] == num )
                return  false;

        }
        return  true;

    }

    public static List<String> generateParenthesis(int n){
        List<String> combinations = new ArrayList<String>();
        char[] arr = new char[n*2];
        generateParenthesis(arr, 0, combinations);
        return  combinations;
    }

    static void generateParenthesis( char[] arr, int current, List<String> result){

        if(current == arr.length){
            // check if this is valid combination
            if(isValidParenthesis(arr))
                result.add(new String(arr));
        }else{
            arr[current] = '(';
            generateParenthesis(arr, current +1, result);
            arr[current] = ')';
            generateParenthesis(arr, current +1, result);
        }

    }
    static  void generateParenthesis1(int n){

        char[] arr = new char[n*2];
        generateParenthesis1(arr, 0);

    }
    static void generateParenthesis1( char[] arr, int current){

        if(current == arr.length) {
            // check if this is valid combination
            if (isValidParenthesis(arr)){
                // Print
                System.out.println(new String(arr));
            }
            return;
        }

        arr[current] = '(';
        generateParenthesis1(arr, current +1);
        arr[current] = ')';
        generateParenthesis1(arr, current +1);
    }


    static  boolean isValidParenthesis(char[] arr){
        int balance = 0;
        for (char ch: arr) {
            if(ch == '(')
                balance ++;
            else
                balance --;

            if(balance <0)
                return  false;

        }
        return  balance == 0;
    }

    static int  fibonacchiRecursive(int n){

        if(n <= 1){
            //System.out.println(n);
            return n;
        }

        return fibonacchiRecursive(n-1) + fibonacchiRecursive(n-2);

    }

    static long fibonacchiIterative(int n){

        if(n <= 1){
            return  n;
        }

        long[] result = new long[n+1];
        result[0] = 0;
        result[1] = 1;

        for(int i = 2; i < result.length; i ++){
            result[i] = result[i-1] + result[i-2];
        }

        return result[n];


    }







}
