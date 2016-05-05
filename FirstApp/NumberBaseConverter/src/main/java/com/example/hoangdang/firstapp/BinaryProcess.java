package com.example.hoangdang.firstapp;

import java.util.Arrays;
import java.util.Stack;

public class BinaryProcess {
    private int input;

    public BinaryProcess(int input){
        this.input = input;
    }

    public String getInput(){
        return Integer.toString(input);
    }

    public String convertBin(){
        Stack binArr = new Stack();
        int result = input;
        int remain;
        int count = 0;
        while(result != 0) {
            remain = result % 2;
            result = result / 2;
            binArr.push(remain);
            count++;
        }

        String temp = "";
        while(!binArr.empty()){
            temp += binArr.pop().toString();
        }
        return temp;
    }


    public String convertHex(){
        Stack hexArr = new Stack();
        int result = input;
        int remain;
        int count = 0;
        while(result != 0){
            remain = result % 16;
            result = result / 16;
            hexArr.push(remain);
            count++;
        }

        String temp = "";
        while(!hexArr.empty()){
            temp+= hexArr.pop().toString();
        }
        return temp;
    }

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
