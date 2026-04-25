package com.habitrain.utils;

public class Validator {
    public static boolean isValidId(int id){
        return id >0;
    }
    public static boolean isNotEmpty(String text){
        return text != null && !text.trim().isEmpty();
    }
}
