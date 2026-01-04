package main.arrayshashing;

public class SimpleBankSystem_2043 {

    class Bank {
        private long[] balance;
        private int n;

        public Bank(long[] balance) {
            this.balance = balance;
            this.n = balance.length;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (!isValid(account1) || !isValid(account2) || balance[account1 - 1] < money) {
                return false;
            }

            balance[account2 - 1] += money;
            balance[account1 - 1] -= money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if (!isValid(account))
                return false;
            balance[account - 1] += money;
            return true;
        }

        private boolean isValid(int account) {
            if (account < 1 || account > n) {
                return false;
            }
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (!isValid(account) || balance[account - 1] < money)
                return false;
            balance[account - 1] -= money;
            return true;
        }
    }


    public static void main(String[] args) {
        Bank bank = new SimpleBankSystem_2043().new Bank(new long[]{10, 100, 20, 50, 30});
        System.out.println(bank.withdraw(3, 10));
        System.out.println(bank.transfer(5, 1, 20));
        System.out.println(bank.transfer(3, 4, 15));
        System.out.println(bank.withdraw(10, 50));
    }
}
