package com.example.hoangdang.firstapp;

//import stack and array list package
import java.util.Arrays;
import java.util.Stack;

//class Binary Process
public class BinaryProcess {
    private int input;

    //Constructor - take in an int to initialize the input variable
    public BinaryProcess(int input){
        this.input = input;
    }

    //Class accessor
    public String getInput(){
        return Integer.toString(input);
    }

    /*
    Method convert decimal to binary number.
    This method take the class's variable "input" mod 2 to get remainder
    Then the new divider will be "input" / 2
    repeat process until divider is 0
    This method use a stack to push result of mod to the end of the stack.
    As we know, binary result from dividing by 2 goes backward, that's why we
    use stack
    */
    public String convertBin(){
        Stack binArr = new Stack();
        int result = input;
        int remain;
        int count = 0;

        //This loop calculate binary by divide by 2
        while(result != 0) {
            remain = result % 2;
            result = result / 2;
            binArr.push(remain);    //push remainder to stack
            count++;
        }

        String temp = "";
        //pop stack from top to bottom. Stacks are LIFO.
        //After we push until stack empty, add those value and convert them to a string.
        //add all string value together in a loop to make a long string.
        while(!binArr.empty()){
            temp += binArr.pop().toString();
        }
        return temp;
    }


    /*
    Method convert decimal to hexadecimal number.
    This method take the class's variable "input" mod 16 to get remainder
    Then the new divider will be "input" / 16
    repeat process until divider is 0
    This method use a stack to push result of mod to the end of the stack.
    If the remainder is from 10-15 we push a letter corresponding to the value of hexadecimal,
    otherwise, push number inthe stack normally if remainder is from 0-9
    */
    public String convertHex(){
        Stack hexArr = new Stack();
        int result = input;
        int remain;
        int count = 0;
        while(result != 0){
            remain = result % 16;
            result = result / 16;

            //If remainder fall from range 10-15 push letter into stack accordingly
            if (remain == 10)
                hexArr.push("A");
            else if(remain == 11)
                hexArr.push("B");
            else if(remain == 12)
                hexArr.push("C");
            else if(remain == 13)
                hexArr.push("D");
            else if(remain == 14)
                hexArr.push("E");
            else if(remain == 15)
                hexArr.push("F");
            else
                hexArr.push(remain);    //else push the number in normally

            count++;
        }

        String temp = "";
        while(!hexArr.empty()){
            temp+= hexArr.pop().toString();
        }
        return temp;
    }

    /*
    Method convert decimal to octal number.
    This method take the class's variable "input" mod 8 to get remainder
    Then the new divider will be "input" / 8
    repeat process until divider is 0
    This method use a stack to push result of mod to the end of the stack.
    */
    public String convertOcta(){
        Stack octaArr = new Stack();
        int result = input;
        int remain;
        int count = 0;
        while(result != 0){
            remain = result % 8;
            result = result / 8;
            octaArr.push(remain);
            count++;
        }

        String temp = "";
        while(!octaArr.empty()){
            temp+= octaArr.pop().toString();
        }
        return temp;
    }
}
