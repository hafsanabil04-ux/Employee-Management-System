import java.util.Scanner;

public class assignment1 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // المرحله الخامسه
        while (true) {
            showMenu();
            int choise = input.nextInt();

            if (choise == 1) {

                // المرحله السادسه
                System.out.print("How many employees? ");
                int count = input.nextInt();

                // المرحله السابعه
                int[] employeeIds = new int[count];
                String[] employeeNames = new String[count];
                int[] departmentCodes = new int[count];
                String[] departments = new String[count];
                double[] basicSalaries = new double[count];
                double[] bonuses = new double[count];
                double[] grossSalaries = new double[count];
                double[] taxPercentages = new double[count];
                double[] taxAmounts = new double[count];
                double[] netSalaries = new double[count];
                boolean[] marriedStatuses = new boolean[count];


                for (int i = 0; i < count; i++) {

                    // المرحله الاولى
                    System.out.print("Enter Employee ID: ");
                    employeeIds[i] = input.nextInt();

                    System.out.print("Enter Employee Name: ");
                    employeeNames[i] = input.next();

                    System.out.print("Enter Department Code: ");
                    departmentCodes[i] = input.nextInt();

                    // المرحله الثالثه
                    departments[i] = getDepartmentName(departmentCodes[i]);

                    System.out.print("Enter Basic Salary: ");
                    basicSalaries[i] = input.nextDouble();

                    System.out.print("Enter Bonus: ");
                    bonuses[i] = input.nextDouble();

                    grossSalaries[i] = calculateGrossSalary(basicSalaries[i], bonuses[i]);

                    System.out.print("Enter Tax Percentage: ");
                    taxPercentages[i] = input.nextDouble();

                    taxAmounts[i] = calculateTax(grossSalaries[i], taxPercentages[i]);

                    netSalaries[i] = calculateNetSalary(grossSalaries[i], taxAmounts[i]);

                    System.out.print("Is Married? (true/false): ");
                    marriedStatuses[i] = input.nextBoolean();
                }

                // المرحله السابعه والثامنة
                printAllEmployees(count, employeeIds, employeeNames, departments, grossSalaries, taxAmounts, netSalaries, marriedStatuses);

            } else if (choise == 2) {
                exitProgram();
                break;
            } else {
                System.out.println("Invalid choise");
                System.out.println();
            }
        }

        input.close();
    }


    //المرحله الثامنه
    public static void showMenu() {
        System.out.println("=======MENU======");
        System.out.println("1-Add Employee");
        System.out.println("2-Exit");
        System.out.print("choose: ");
    }

    public static double calculateGrossSalary(double basicSalary, double bonus) {
        return basicSalary + bonus;
    }

    public static double calculateTax(double grossSalary, double taxPercentage) {
        return grossSalary * taxPercentage;
    }

    public static double calculateNetSalary(double grossSalary, double taxAmount) {
        return grossSalary - taxAmount;
    }

    public static String getDepartmentName(int departmentCode) {
        // التأكد من أن الكود بين 1 و 5 فقط
        while (departmentCode < 1 || departmentCode > 5) {
            System.out.println("Invalid Department Code! Please enter a number between 1 and 5.");
            System.out.print("Enter Department Code again: ");
            departmentCode = input.nextInt();
        }

        switch (departmentCode) {
            case 1:
                return "IT";
            case 2:
                return "HR";
            case 3:
                return "Finance";
            case 4:
                return "Sales";
            case 5:
                return "Marketing";
            default:
                return "Unknown Department";
        }
    }

    public static void printEmployee(int id, String name, String dept, double gross, double tax, double net, boolean married) {
        System.out.println("=======================");
        System.out.println("Employee ID :" + id);
        System.out.println("Employee Name :" + name);
        System.out.println("Department :" + dept);
        System.out.println("Gross Salary :" + gross);
        System.out.println("Tax :" + tax);
        System.out.println("Net Salary :" + net);
        System.out.println();

        // المرحله الثانيه
        if (net >= 30000) {
            System.out.println("Income Level:High Income");
        } else if (net >= 15000) {
            System.out.println("Income Level:Medium Income");
        } else {
            System.out.println("Income Level:Low Income");
        }

        if (married) {
            System.out.println("Family Insurance:Eligible");
        } else {
            System.out.println("Family Insurance:Not Eligible");
        }
    }

    public static void printAllEmployees(int count, int[] ids, String[] names, String[] depts, double[] gross, double[] tax, double[] net, boolean[] married) {
        for (int i = 0; i < count; i++) {
            System.out.println("\nEmployee #" + (i + 1));
            printEmployee(ids[i], names[i], depts[i], gross[i], tax[i], net[i], married[i]);
        }
    }

    public static void exitProgram() {
        System.out.println("Exit");
    }
}