// COMP2850 Portfolio: Week 5
// BankAccount class

package comp2850.banking

const val MAX_OVERDRAFT = 100

abstract class BankAccount(val holder: String) {
    init {
        require(holder.isNotBlank()) { "Account holder must not be blank" }
    }

    var balance = 0
        protected set(value) {
            field = value
        }

    fun deposit(amount: Int) {
        require(amount > 0) { "Deposit amount must be greater than 0" }
        balance += amount
    }

    abstract fun withdraw(amount: Int)

    abstract fun withdrawalsAllowed(): Boolean
}


class StudentAccount(holder: String) : BankAccount(holder) {
    var overdraft: Int = 0
        set(value) {
            if (value < 0 || value > 100) {
                throw IllegalArgumentException("Overdraft must be in range 0 to 100")
            }
            field = value;
        }
    
    override fun withdraw(amount: Int) {
        if (amount <= 0) {
            throw IllegalArgumentException("Withdrawal amount must be greater than 0")
        }

        if (balance - amount < -overdraft) {
            throw IllegalArgumentException("Insufficient funds for withdrawal")
        }

        balance = balance - amount
    }

    override fun withdrawalsAllowed() : Boolean {
        if (balance > -overdraft) {
            return true
        }
        else {
            return false
        }
    }

    override fun toString() : String {
        return "Account for $holder, balance = $balance (overdraft = $overdraft)"
    }
}