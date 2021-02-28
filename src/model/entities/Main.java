package model.entities;

import java.util.Locale;
import java.util.Scanner;

import model.exceptions.DomainException;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
		
			System.out.println("Enter account data:");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			sc.nextLine();
			System.out.print("Initial Balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withDrawLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, balance, withDrawLimit);
			
			System.out.print("\nEnter the amount for withdraw: ");
			Double withDraw = sc.nextDouble();
			
			account.withDraw(withDraw);
			
			System.out.println(account);
		}catch (DomainException e) {
			
			System.out.println("\n" + e.getMessage());
		}
		
		
		
		sc.close();
	}

}
