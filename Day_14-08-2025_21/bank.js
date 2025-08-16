class BankAccount {
    constructor(accountNumber, balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    deposit(amount) {
        this.balance += amount;
        return `Deposited ${amount}. New balance: ${this.balance}`;
    }

    withdraw(amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            return `Withdrew ${amount}. New balance: ${this.balance}`;
        } else {
            return "Insufficient balance!";
        }
    }
}

const account = new BankAccount(12345, 1000);
