package pl.stormit;

import java.util.Date;

public final class Transaction {

	private final Date date;
	private final String from;
	private final String to;
	private final int amount;

	public Transaction(Date date, String from, String to, int amount) {
		this.date = date;
		this.from = from;
		this.to = to;
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public int getAmount() {
		return amount;
	}

	public boolean isSpecial() {
		return "SPECIAL".equals(from);
	}
}