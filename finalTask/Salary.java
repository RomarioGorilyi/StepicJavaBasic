package finalTask;

/**
 * Created by Roman Horilyi on 07.11.2016.
 */
public class Salary implements Sendable<Integer> {
    private String company;
    private String employee;
    private int amountOfMoney;

    public Salary(String company, String employee, int amountOfMoney) {
        this.company = company;
        this.employee = employee;
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public String getFrom() {
        return company;
    }

    @Override
    public String getTo() {
        return employee;
    }

    @Override
    public Integer getContent() {
        return amountOfMoney;
    }
}
