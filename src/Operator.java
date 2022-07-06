public class Operator implements Employee{

    private double monthSalary;

    public Operator (double basicSalary) {
        monthSalary = basicSalary;
    }

    public void setMonthSalary(double monthSalary) {
        this.monthSalary = monthSalary;
    }

    @Override
    public double getMonthSalary() {
        return monthSalary;
    }
}
