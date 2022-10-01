package com.quiz;

import java.util.Scanner;

public class HomePage {

	private static void quiz() {
		System.out.print("Entered into quiz");
		Start();

	}

	private static void Score_details() {
		System.out.print(" 1 All Student score in Sorted Order\r\n" + " 2 Student Score By Id\r\n" + "\r\n" + "\r\n"
				+ "Enter A choice in number '1' or '2'");
		try (Scanner sc = new Scanner(System.in))
		{
			Score_records sr= new Score_records();
			int i=sc.nextInt();
		if(i==1)
		{
			
			sr.score();
		}
		
		if(i==2)
		{
			
			sr.score_specific();
		}
		}
	}

	static void Start() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Welcome to Quiz\n" + "1.Attempt Quiz\r\n"
					+ "2.Get Score Details\r\n" + "Choose a option by giving number '1' or '2' ");
			int i = sc.nextInt();

			if (i == 1) {
				quiz();
			} else if (i == 2) {
				Score_details();
			} else {
				System.out.print("sorry wrong input");
				Start();
			}
		}
	}

	public static void main(String[] args) {
		
		Start();

	}

}
