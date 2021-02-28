package model.entities;

import model.exceptions.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawLimit;
	
	public Account() {}
	
	public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithDrawLimit() {
		return withDrawLimit;
	}
	
	public void deposit(Double amount) throws DomainException{
		
		this.balance += amount;
	}
	
	public void withDraw(Double amount) throws DomainException{
		
		if(amount > withDrawLimit) {
			throw new DomainException("Withdraw error: Amount requested higher than withdraw limit.");	
		}
		else if (amount > balance) {
			throw new DomainException("Withdraw error: Not enough balance.");
		}
		else {
			this.balance -= amount;
		}
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("New Balance: ");
		sb.append(String.format("%.2f", this.balance));
		
		return sb.toString(); 
	}
	
	
}
