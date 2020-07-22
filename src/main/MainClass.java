package main;

import java.util.ArrayList;
import java.util.Scanner;

import db.DBClass;
import dto.FoodTB;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("hello db");
		// food_tb 라는 이름으로 DB에 테이블이 만들어져 있고
		// food_tb 에 음식 이름과 가격을 넣어야 함
		
		// 사용자에게 음식이름과 가격을 입력을 받는 기능
		Food fd = new Food();
//		FoodTB dto2 = new FoodTB();
//		System.out.println("dto2: " + dto2);
		FoodTB dto = fd.inputData();
		System.out.println("dto: " + dto);
		
		System.out.println("음식: " + dto.getName());
		System.out.println("가격: " + dto.getPrice());
		
//		DBClass.conTest();'
		DBClass.insert(dto.getName(), dto.getPrice());
//		ArrayList<FoodTB> list = new ArrayList<FoodTB>();
		
		ArrayList<FoodTB> list = DBClass.select();
		for (FoodTB tb : list) {
			System.out.println(tb.getNum());
			System.out.println(tb.getName());
			System.out.println(tb.getPrice());
		}
		
//		String name = fd.food();
//		int pri = fd.price();
		// 자바와 DB와 연결
		// 입력 받은 데이터를 food_tb에 넣는 기능
		// food_tb 데이터를 보여 주는 기능
	}

}
