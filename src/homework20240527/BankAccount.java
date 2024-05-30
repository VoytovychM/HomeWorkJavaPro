package homework20240527;

public class BankAccount {
    private int balance;
    private String accountNumber;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance = balance + amount;
        System.out.println(accountNumber + " is top up for " + amount + ". Current balance is: " + balance);
    }

   public void withdraw (int amount) {
         balance = balance - amount;
       System.out.println("The funds from " + accountNumber + " were withdrawn " + amount + ". Current balance is: " + balance);
     }

    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("DE1");
        bankAccount1.setBalance(1000);

        BankAccount bankAccount2 = new BankAccount("DE2");
        bankAccount2.setBalance(500);

        new Thread(() -> {
            synchronized (bankAccount2){
            bankAccount2.deposit(100);
            bankAccount2.withdraw(42);
        }
        }).start();



        new Thread(() -> {

                int amount = 300;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bankAccount1.deposit(amount);

        }).start();

        // deposit
        new Thread(() -> {
            synchronized (bankAccount1) {
                int amount = 1000;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bankAccount1.deposit(amount);
            }
        }).start();


        new Thread(() -> {
            synchronized (bankAccount1) {
                bankAccount1.deposit(100);
                bankAccount1.withdraw(50);
            }
        }).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() ->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(bankAccount1.getBalance());
            System.out.println(bankAccount2.getBalance());
        }).start();


    }

}

