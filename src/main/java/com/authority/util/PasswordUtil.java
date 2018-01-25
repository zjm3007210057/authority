package com.authority.util;

import java.util.Date;
import java.util.Random;

/**
 * 密码生成工具类
 * Created by zjm on 18/01/2018.
 */
public class PasswordUtil {

    /**
     * 定义字母集合，去掉容易混淆的字母
     */
    public static final String[] word = {
            "a", "b", "c", "d", "e", "f", "g",
            "h", "j", "k", "m", "n", "p", "q",
            "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "A", "B", "C", "D", "E",
            "F", "G", "H", "J", "K", "M", "N",
            "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"
    };

    /**
     * 定义数字集合，去掉0和1容易混淆的数字
     */
    public static final String[] num = {
            "2", "3", "4", "5", "6", "7", "8", "9"
    };

    /**
     * 生成8位到10位随机密码
     * @return
     */
    public static final String randomPassword() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random(new Date().getTime());
        //flag 用来确定是选取数字还是字母
        boolean flag = false;
        //密码长度8到10位之间
        int length = random.nextInt(3) + 8;
        for(int i=0; i<length; i++){
            if(flag) {
                sb.append(num[random.nextInt(num.length)]);
            }else {
                sb.append(word[random.nextInt(word.length)]);
            }
            //随机取反
            if(random.nextBoolean()){
                flag = !flag;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            System.out.println(randomPassword());
        }
    }
}
