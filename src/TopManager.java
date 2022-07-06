public class TopManager implements Employee{
    public static final double BONUS_COEFFICIENT = 2.5;
    public static final int MINIMUM_COMPANY_EARNINGS = 10_000_000;
    private double basicSalary;
    private double monthSalary;
    private Company companyName;


    public TopManager (double basicSalary, Company companyName) {

        this.basicSalary = basicSalary;

        this.companyName = companyName;

    }

    @Override
    public double getMonthSalary() {
        monthSalary = basicSalary;

        if (companyName.getIncome() >= MINIMUM_COMPANY_EARNINGS) {
            monthSalary = basicSalary * BONUS_COEFFICIENT;
        }

        return monthSalary;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }
}
