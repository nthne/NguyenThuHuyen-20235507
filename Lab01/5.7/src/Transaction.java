
public class Transaction {
	private int amount;
	private String type;
	private int year;
	private int month;
	private int day;
	
	public int getMonth() {
		return month;
	}
	
	public int getAmount() {
		return amount;
	}

	public int getYear() {
		return year;
	}

	public int getDay() {
		return day;
	}

	public String getType() {
		return type;
	}
	

	public Transaction(int amount, String type, int year, int month, int day) {
		super();
		this.amount = amount;
		this.type = type;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
}
