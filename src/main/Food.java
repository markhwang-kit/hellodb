package main;

import java.util.Scanner;

import dto.FoodTB;


public class Food {
	// 사용자에 음식 이름 입력
	public FoodTB inputData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("음식이름입력: ");
		String name = sc.next();
		System.out.print("음식가격입력: ");
		int price = sc.nextInt();
		
		FoodTB dto = new FoodTB();
		System.out.println(dto);
		dto.setName(name);
		dto.setPrice(price);
		
		return dto;
	}
	
	// 가격을 전달 하는 매소드
	public int price() {
		int [] ar = new int[2];
		int price = 4000;
		int num = 11;
		return price;
	}
	
	// 음식을 전단 하는 매소드
	public String food() {
		String name = "피자";
		return name;
	}
}
