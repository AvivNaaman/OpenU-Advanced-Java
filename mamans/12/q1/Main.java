package avivn.mmn12.q1;

import java.util.Calendar;

public class Main {
    // Entry point - tester
    public static void main(String[] args) {
	    Employee[] employees = {
                new SalariedEmployee("John", "Smith", "111-11-1111",
                        new BirthDate(1,1,1978), 800.00),
                new HourlyEmployee("Karen", "Price", "222-22-2222",
                        new BirthDate(7,2,1999), 16.75, 40),
                new CommissionEmployee(
                        "Sue", "Jones", "333-33-3333",
                        new BirthDate(19,12,1984), 10000, .06),
                new BasePlusCommissionEmployee(
                        "Bob", "Lewis", "444-44-4444",
                        new BirthDate(24,9,1994), 5000, .04, 300),
                // ----------------------------- New Employee type -----------------------------
                new PieceWorker("Mary", "Williams", "555-55-5555",
                        new BirthDate(9, 7, 1967), 0.12, 5700)
        };
        // get today
        int currentDayOfMonth = Calendar.getInstance().get(Calendar.MONTH);
        // iterate, calculate and print info
        for (Employee e: employees) {
            System.out.print(e);
            double totalEarnings = e.earnings();
            // This is the employee's birthday! Add the bonus:
            if (currentDayOfMonth == e.getBirthDate().getMonth()) {
                totalEarnings += 200; // add bonus
            }
            // print the total amount
            System.out.printf("%nearnings this month: %.2f$%n%n", totalEarnings);
        }
    }
}
