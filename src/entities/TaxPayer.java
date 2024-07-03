package entities;

public class TaxPayer {

    public TaxPayer(double capitalIncome, double educationSpending, double healthSpending,
            double salaryIncome, double serviceIncome) {
        this.capitalIncome = capitalIncome;
        this.educationSpending = educationSpending;
        this.healthSpending = healthSpending;
        this.salaryIncome = salaryIncome;
        this.serviceIncome = serviceIncome;
    }

    public double capitalTax() {
        if (this.capitalIncome > 0.00)
            return this.capitalIncome * 0.20;

        return 0.00;
    }

    public double grossTax() {
        return this.capitalTax() + this.salaryTax() + this.servicesTax();
    }

    public double netTax() {
        return this.grossTax() - this.taxRebate();
    }

    public double salaryTax() {
        if (this.salaryIncome / 12 < 3000.00)
            return 0.0;

        if (this.salaryIncome / 12 < 5000.00)
            return this.salaryIncome * 0.10;

        return this.salaryIncome * 0.20;
    }

    public double servicesTax() {
        if (this.serviceIncome > 0.00)
            return this.serviceIncome * 0.15;

        return 0.00;
    }

    public double taxRebate() {
        if (this.educationSpending + this.healthSpending > this.grossTax() * 0.30)
            return this.grossTax() * 0.30;

        return this.educationSpending + this.healthSpending;
    }

    public double getCapitalIncome() {
        return capitalIncome;
    }

    public double getEducationSpending() {
        return educationSpending;
    }

    public double getHealthSpending() {
        return healthSpending;
    }

    public double getSalaryIncome() {
        return salaryIncome;
    }

    public double getServiceIncome() {
        return serviceIncome;
    }

    public void setCapitalIncome(double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public void setEducationSpending(double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public void setHealthSpending(double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public void setSalaryIncome(double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public void setServiceIncome(double serviceIncome) {
        this.serviceIncome = serviceIncome;
    }

    private double capitalIncome;
    private double educationSpending;
    private double healthSpending;
    private double salaryIncome;
    private double serviceIncome;

}
