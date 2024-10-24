import java.text.DecimalFormat;

public class main {

	public static void main(String[] args) {
		
		BankAccount acc1 = new BankAccount("Nguyễn Văn A", 5000000);
		System.out.println("");
		acc1.deposit(1000000);
		acc1.withdrawal(100000);
		acc1.withdrawal(200000);
		acc1.withdrawal(200000);
		acc1.withdrawal(500000);
		System.out.println("");
		acc1.getCurrent_balance();
		acc1.getBalance_withRate();
		System.out.println("");
		acc1.getTransaction_history();
		
	}

}
