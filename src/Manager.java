public class Manager implements Employee{

    private double monthSalary;
    private double basicSalary;
    public static final double BONUS_PERCENT = 0.05;

    public Manager(double basicSalary, double companyProfitFromPerson) {
        this.basicSalary = basicSalary;
        calcMonthSalary(companyProfitFromPerson);
    }

    public void calcMonthSalary(double companyProfitFromPerson) {
        monthSalary = basicSalary + companyProfitFromPerson * BONUS_PERCENT;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public double getMonthSalary() {
        return monthSalary;
    }
}
