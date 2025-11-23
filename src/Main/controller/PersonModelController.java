package Main.controller;
import Main.model.PersonModel;

public class PersonModelController {
    private String _name;
    private int _income;
    private int _age;

    // Setters \\
    public void setName(String name) { this._name = name; }
    public void setIncome(int income) { this._income = income; }
    public void setAge(int age) { this._age = age; }

    // Getters \\
    public String getName() { return this._name; }
    public int getIncome() { return this._income; }
    public int getAge() { return this._age; }
}
