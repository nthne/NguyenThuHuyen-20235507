import java.text.DecimalFormat;
import java.time.LocalDate;

public class BankAccount {
	private String  Account_name;
	private double Current_balance = 0;
	private double Monthly_rate;
	public static final int MAX_NUMBERS_TRANSACTION = 100;
	private Transaction Transaction_history[] = new Transaction[MAX_NUMBERS_TRANSACTION];
	public int index = 0;
	public String getAccount_name() {
		return Account_name;
	}
	public void getCurrent_balance() {
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println("Số dư hiện tại: " + df.format(Current_balance) + " VNĐ");
	}
	public double getMonthly_rate() {
		return Monthly_rate;
	}
	public void getBalance_withRate() {
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println("Số dư sau khi cộng lãi: " + df.format(Current_balance + Monthly_rate) + " VNĐ");
	}
	public void getTransaction_history() {
		DecimalFormat df1 = new DecimalFormat("#,###");
		DecimalFormat df2 = new DecimalFormat("###");
		System.out.println("Lịch sử giao dịch:");
		int i;
		if(index <= 100) i = 0;
		else i = index - 100;
		for(; i < index; i++) {
			System.out.println(df2.format((i+1)%100) + ". " + Transaction_history[i%100].getType() + " - " + df1.format(Transaction_history[i%100].getAmount()) + " VNĐ - " + df2.format(Transaction_history[i%100].getYear()) + "-" + df2.format(Transaction_history[i%100].getMonth()) + "-" + df2.format(Transaction_history[i%100].getDay()));
		}
	}
	public BankAccount(String account_name, double initial_balance) {
		super();
		Account_name = account_name;
		Current_balance = initial_balance;
		System.out.println("Tạo tài khoản mới: " + Account_name);
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println("Số dư ban đầu: " + df.format(initial_balance) + " VNĐ");
	}
	
	public void deposit(int money) {
		Current_balance += money;
		Monthly_rate = Current_balance * 0.005;
		LocalDate currentDate = LocalDate.now();
		
		DecimalFormat df = new DecimalFormat("#,###");
	
		Transaction_history[index%100] = new Transaction(money,"Deposit",currentDate.getYear(),currentDate.getMonthValue(),currentDate.getDayOfMonth()); 
		System.out.println("Đã gửi " + df.format(money) + " VNĐ");
		index++;
		
	}
	
	public int max(int a,int b) {
		if(a>b) return a;
		else return b;
	}
	
	public int Number_Withdrawal_InMonth() {
		int currentMonth = LocalDate.now().getMonthValue();
		int count = 0;
		//System.out.println(index);
		for(int i = index-1; i >= max(index - 100,0); i--) {
			if(Transaction_history[i%100].getType() == "Withdrawal") {
				if(Transaction_history[i%100].getMonth() == currentMonth && count < 3) count++;
				else break;	
			}
					
		}
		return count;
	}
	
	public void withdrawal(int money) {
		DecimalFormat df = new DecimalFormat("#,###");
		
		if(Number_Withdrawal_InMonth()==3) {
			System.out.println("Rút " + df.format(money) + " - Lỗi: Bạn đã đạt giới hạn rút tiền tháng này.");
			return;
		}
		
		Current_balance -= money;
		Monthly_rate = Current_balance * 0.005;
		LocalDate currentDate = LocalDate.now();
		Transaction_history[index%100] = new Transaction(money,"Withdrawal",currentDate.getYear(),currentDate.getMonthValue(),currentDate.getDayOfMonth()); 
		System.out.println("Đã rút " + df.format(money) + " VNĐ");
		index++;
	}
}
