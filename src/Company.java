import java.util.*;

public class Company {
    protected ArrayList<Employee> staff = new ArrayList<>();
    private double companyIncome;

    public Company(double companyIncome) {
        this.companyIncome = companyIncome;
    }

    public Company(double companyIncome, List<Employee> peopleToHire) {
        this(companyIncome);
        staff.addAll(peopleToHire);
    }

    public void hire(Employee person) {
        staff.add(person);

    }

    public void hireAll(List<Employee> peopleToHire) {
        staff.addAll(peopleToHire);

    }

    public boolean fire(int id) {

        if (id >= 0 && id < staff.size()) {
            staff.remove(id);
            return true;
        }

        return false;
    }

    public double getIncome() {
        return companyIncome;
    }

    public void setIncome(double companyIncome) {
        this.companyIncome = companyIncome;
    }

    public List<Employee> getTopSalaryStaff(int count) {

        staff.sort(Comparator.comparing(Employee::getMonthSalary).reversed());
        return getFirstNstaff(count);
    }

    public List<Employee> getLowestSalaryStaff(int count) {

        staff.sort(Comparator.comparing(Employee::getMonthSalary));
        return getFirstNstaff(count);
    }

    private List<Employee> getFirstNstaff(int count) {
        ArrayList<Employee> selected = new ArrayList<>();

        if (count > staff.size()) {
            count = staff.size();
        }

        for (int i = 0; i < count; i++) {
            selected.add(staff.get(i));
        }

        return selected;
    }

    public void printTopWorkersSalary(int count) {
        System.out.println("Топ " + count + " самых высоких зарплат: ");
        ArrayList<Employee> topWorkers = new ArrayList<>(getTopSalaryStaff(count));

        for (Employee employee : topWorkers) {
            System.out.println((int) employee.getMonthSalary() + "руб.");
        }
    }

    public void printLowestWorkersSalary(int count) {
        System.out.println(System.lineSeparator() + "Топ " + count + " самых низких зарплат:");
        ArrayList<Employee> worstWorkers = new ArrayList<>(getLowestSalaryStaff(count));

        for (Employee employee : worstWorkers) {
            System.out.println((int) employee.getMonthSalary() + "руб.");
        }
    }

    public ArrayList<Employee> getStaff() {
        return new ArrayList<>(staff);
    }
}
