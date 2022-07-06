import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static final int OPERATOR_MIN_SALARY = 20_000; // in rub
    public static final int OPERATOR_MAX_SALARY = 26_000; // in rub

    public static final int MANAGER_MIN_SALARY = 35_000; // in rub
    public static final int MANAGER_MAX_SALARY = 45_000; // in rub
    public static final int MANAGER_MIN_COMPANY_PROFIT = 115_000; // in rub
    public static final int MANAGER_MAX_COMPANY_PROFIT = 140_000; // in rub

    public static final int TOP_MANAGER_MIN_SALARY = 48_000; // in rub
    public static final int TOP_MANAGER_MAX_SALARY = 55_000; // in rub

    public static void main(String[] args) {
        double monthCompanyIncome = 10_000_000d;
        int topSalariesRatingCount = 15;
        int lowestSalariesRatingCount = 30;

        Company myCompany = new Company(monthCompanyIncome);
        myCompany.hireAll(generateOperators(180, OPERATOR_MIN_SALARY, OPERATOR_MAX_SALARY));
        myCompany.hireAll(generateManagers(80, MANAGER_MIN_SALARY, MANAGER_MAX_SALARY));
        myCompany.hireAll(generateTopManagers(10, TOP_MANAGER_MIN_SALARY, TOP_MANAGER_MAX_SALARY, myCompany));

        myCompany.printTopWorkersSalary(topSalariesRatingCount);

        myCompany.printLowestWorkersSalary(lowestSalariesRatingCount);

        System.out.println("Количество сотрудников компании - " + myCompany.getStaff().size());

        if (russianRoulette(myCompany.getStaff().size()/2, myCompany)) {
            System.out.println("Уволено 50% сотрудников");
        }

        System.out.println("Количество сотрудников компании - " + myCompany.getStaff().size());

        myCompany.printTopWorkersSalary(topSalariesRatingCount);

        myCompany.printLowestWorkersSalary(lowestSalariesRatingCount);

    }

    public static List<Employee> generateOperators (int count, int minSalary, int maxSalary) {

        if (count <=0) {
            return new ArrayList<>();
        }

        ArrayList<Employee> operatorsList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            double basicSalary = new Random().nextInt(minSalary/10, maxSalary/10) * 10;
            operatorsList.add(new Operator(basicSalary));
        }

        return operatorsList;
    }

    public static List<Employee> generateManagers (int count, int minBasicSalary, int maxBasicSalary) {

        if (count <=0) {
            return new ArrayList<>();
        }

        ArrayList<Employee> managersList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            double basicSalary = new Random().nextInt(minBasicSalary/10, maxBasicSalary/10) * 10;
            double personalCompanyProfit = new Random().nextInt(
                    MANAGER_MIN_COMPANY_PROFIT/10, MANAGER_MAX_COMPANY_PROFIT/10) * 10;

            managersList.add(new Manager(basicSalary, personalCompanyProfit));
        }


        return managersList;
    }

    public static List<Employee> generateTopManagers (int count, int minSalary, int maxSalary, Company companyName) {

        if (count <=0) {
            return new ArrayList<>();
        }

        ArrayList<Employee> topManagersList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            double basicSalary = new Random().nextInt(minSalary/10, maxSalary/10) * 10;
            topManagersList.add(new TopManager(basicSalary, companyName));
        }

        return topManagersList;
    }

    public static boolean russianRoulette (int count, Company companyName) {

        if (count <=0) {
            return false;
        }

        for (int i = 0; i < count; i++) {
            int victim = new Random().nextInt(companyName.getStaff().size() - 1);
            companyName.fire(victim);
        }
        return true;
    }


}
