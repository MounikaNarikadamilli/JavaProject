
import java.util.Scanner;
class BankAccount{
	String name;
	String userName;
	String password;
	String accountNo;
	float balance = 10000f;
	int transactions = 0;
	String transactionHistory;
	
	public void register() {
		Scanner sc= new Scanner(System.in);
		System.out.println("\nEnter your Name: ");
		this.name =sc.nextLine();
		System.out.println("\nEnter your userName: ");
		this.userName =sc.nextLine();
		System.out.println("\nEnter your password: ");
		this.password =sc.nextLine();
		System.out.println("\nEnter your accountNo: ");
		this.accountNo =sc.nextLine();
		System.out.println("\nRegistration successful. Please log in to your Bank Account");
		
	}
	public boolean login() {
		boolean islogin = false;
		Scanner sc=new Scanner(System.in);
		while( !islogin) {
			System.out.println("\nEnter your userName: ");
			String Username = sc.nextLine();
			if(Username.equals(userName)) {
				while(!islogin) {
					System.out.println("\nEnter your password:");
					String Password = sc.nextLine();
					if(Password.equals(Password)) {
						System.out.println("\nLogin successful");
						islogin = true;
					}
					else {
						System.out.println("\nIncorrect password");
					}
				}
			}else {
				System.out.println("\nUser name not found");
			}
		}
		return islogin;
	}
	public void withdraw() {
		System.out.println("\nEnter Amount to withdraw: ");
		Scanner sc=new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			if(balance >= amount) {
				transactions++;
				balance-=amount;
				System.out.println("\nWithdraw successful.");
				String str = amount + "Rs Withdrawn\n";
				transactionHistory = transactionHistory.concat(str);
			}else {
				System.out.println("Insufficient Balance.");
			}
		}catch(Exception e) {
			
		}
	}
	public void deposit() {
		System.out.println("\nEnter Amount to Deposit: ");
		Scanner sc=new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			if(amount <= 10000f) {
				transactions++;
				balance+=amount;
				System.out.println("\nDeposit successful.");
				String str = amount + "Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}else {
				System.out.println("Sorry. The limt is 10000.");
			}
		}catch(Exception e) {
			
		}
	}
	public void transfer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter Receipent's Name: ");
		String receipent = sc.nextLine();
		System.out.println("\nEnter the amount to transfer: ");
		float amount = sc.nextFloat();
		try {
			if(balance>=amount) {
			if(amount <= 50000f) {
				transactions++;
				balance-=amount;
				System.out.println("\nSuccessfully Transferred to"+receipent);
				String str = amount + "Rs transferred to"+receipent+"\n";
				transactionHistory = transactionHistory.concat(str);
			}else {
				System.out.println("Sorry. The limt is 50000.");
			}
		}else{
			System.out.println("\nInsufficient Balance.");
		}}catch(Exception e) {
		}
			
		}
	public void checkBalance() {
		System.out.println("\n"+balance+"Rs");
	}
	
	public void transHistory() {
		if(transactions == 0) {
			System.out.println("\nNo Transactions happened");
		}else {
			System.out.println("\n"+transactionHistory);
		}
	}
}

public class AtmInterface {
	public static int takenIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		while(!flag) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				if(flag && input>limit || input<1) {
					System.out.println("Choose the number between 1to"+limit);
					flag = false;
				}
			}catch(Exception e) {
				System.out.println("Enter only integer value.");
				flag = false;
			}
		}
		return input;
	}
	public static void main(String[] args) {
		System.out.println("\n*******WELCOME TO ATM INTERFACE*******");
		
		System.out.println("1.Register \n2.Exit");
		System.out.println("Choose one option");
		int choose = takenIntegerInput(2);
		if(choose == 1) {
			BankAccount b= new BankAccount();
			b.register();
			while(true) {
				System.out.println("1.Login \n2.Exit");
				System.out.println("Enter your choice: ");
				int ch = takenIntegerInput(2);
				if(ch==1) {
					if(b.login()) {
						System.out.println("\n******WELCOME BACK"+b.name+"********");
						boolean isFinished = false;
						while(!isFinished) {
							System.out.println("\n1.withdraw \n2.Deposit \n3.Transfer \n4.Check balance \n5.Transaction History \n6.Exit");
							System.out.println("Enter your choice: ");
							int c = takenIntegerInput(6);
							switch(c) {
							case 1:
								b.withdraw();
								break;
							case 2:
								b.deposit();
								break;
							case 3: 
								b.transfer();
								break;
							case 4:
								b.checkBalance();
								break;
							case 5:
								b.transHistory();
								break;
							case 6:
								isFinished = true;
								break;
							}
						}
					}
					
				}else {
					System.exit(0);
				}
			}
		}else {
			System.exit(0);
		}
		
	}

}

