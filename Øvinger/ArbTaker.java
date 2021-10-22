package oving8;
import java.util.GregorianCalendar;

public class ArbTaker{
    private final Person persona;
    private final long workNr;
    private final int hiringYear;
    private long monthlySalary;
    private float tax;
    GregorianCalendar calendar = new java.util.GregorianCalendar();


    public ArbTaker(Person persona, long workNr, int hiringYear, long monthlySalary, float tax){
        this.persona = persona;
        this.workNr = workNr;
        this.hiringYear = hiringYear;
        this.monthlySalary = monthlySalary;
        this.tax = tax;
        }

    public Person getPersona() {
        return persona;
    }

    public long getworkNr() {
        return workNr;
    }

    public int getHiringYear(){
        return hiringYear;
    }

    public long getMonthlySalary(){
        return monthlySalary;
    }

    public float getTax(){
        return tax;
    }

    public void setMonthlySalary(long newSalary){
        this.monthlySalary = newSalary;
    }

    public void setTax(float newTax){
        this.tax = newTax;
    }

    public float getTaxPerMonth(){
        return this.monthlySalary*this.tax/100;
    }

    public long getgrossYearlyIncome(){
        return this.monthlySalary*12;
    }

    public double getYearlyTax(){
        return this.getTaxPerMonth()*10 + this.getTaxPerMonth()*0.5;
    }

    public String getName(){
        return this.getPersona().getLastName() + ", " + this.getPersona().getFirstName();
    }

    public int getAge(){
        int yearNow = calendar.get(java.util.Calendar.YEAR);
        return yearNow - this.getPersona().getBirthYear();
    }

    public int getWorkYears() {
        int yearNow = calendar.get(java.util.Calendar.YEAR);
        return yearNow - this.getHiringYear();
    }

    public boolean getMorethan(int number){
        boolean moreThan = false;
        if (this.getWorkYears() >= number){
            moreThan = true;
        }
        return moreThan;
    }
}
