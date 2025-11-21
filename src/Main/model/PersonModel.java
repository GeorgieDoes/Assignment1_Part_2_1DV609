package Main.model;

public class PersonModel {
    private String _name;
    private int _income;
    private int _age;

    // Setters \\
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this._name = name;
    }

    public void setIncome(int income) {
        if (income < 0 || income > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Invalid intager value for income");
        }
        this._income = income;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this._age = age;
    }

    // Getters \\
    public String getName() { return this._name; }
    public int getIncome() { return this._income; }
    public int getAge() { return this._age; }

    // Constructors \\
    public PersonModel() { }    // <-- Default constructor

    public PersonModel(String name, int income, int age) {
        setName(name);
        setIncome(income);
        setAge(age);
    }
}
