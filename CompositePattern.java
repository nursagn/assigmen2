package composite_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Abstract base class for all account types
abstract class Account {
  public abstract float getBalance();
}

// Concrete class for DepositAccount
class DepositAccount extends Account {
  private String accountNo;
  private float accountBalance;

  public DepositAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() {
    return accountBalance;
  }
}

// Concrete class for SavingsAccount
class SavingsAccount extends Account {
  private String accountNo;
  private float accountBalance;

  public SavingsAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() {
    return accountBalance;
  }
}

// CompositeAccount is a composite class that can contain other accounts
class CompositeAccount extends Account {
  private float totalBalance;
  private List<Account> accountList = new ArrayList<Account>();

  public float getBalance() {
    totalBalance = 0;
    for (Account account : accountList) {
      totalBalance += account.getBalance();
    }
    return totalBalance;
  }

  public void addAccount(Account acc) {
    accountList.add(acc);
  }

  public void removeAccount(Account acc) {
    accountList.remove(acc);
  }
}

public class CompositePattern {
  public static void main(String[] args) {
    CompositeAccount compositeAccount = new CompositeAccount();

    // Add DepositAccount and SavingsAccount to the composite
    compositeAccount.addAccount(new DepositAccount("DA001", 100));
    compositeAccount.addAccount(new DepositAccount("DA002", 150));
    compositeAccount.addAccount(new SavingsAccount("SA001", 200));

    float totalBalance = compositeAccount.getBalance();
    System.out.println("Total Balance: " + totalBalance);
  }
}
