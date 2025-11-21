package Main.model;

public class PersonModel {
    private String _name;
    private int _income;
    private int _age;

    // Setters \\
    public void SetName(String name) { this._name = name; }
    public void SetIncome(int income) { this._income = income;}
    public void SetAge(int age) { this._age = age; }

    // Getters \\
    public String GetName() { return this._name; }
    public int GetIncome() { return this._income; }
    public int GetAge() { return this._age; }

    // Constructors \\
    public PersonModel() { }    // <-- Default constructor

    public PersonModel(String name, int income, int age) {
        this._name = "Patrik";
        this._income = 7000;
        this._age = 48;
    }
}
