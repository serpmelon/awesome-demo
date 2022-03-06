package com.togo;

import java.util.Scanner;

/**
 * @author : taiyn
 * Date    : 2021/4/20
 * Time    : 8:27 上午
 * ---------------------------------------
 * Desc    :
 */
public class Money {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("每年投入: ");
        double money = in.nextDouble();
        System.out.println("投资多少年? ");
        int year = in.nextInt();
        System.out.println("年利率: ");
        double r = in.nextDouble();

        double sum = 0;
        for (int i = 0; i < year; i++) {
            sum = (money + sum) * (1 + r);
            int tmp = i + 1;
            System.out.println(tmp + "年后, 一共有 " + sum);
        }
    }

}
