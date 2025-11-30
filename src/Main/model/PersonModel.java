package Main.model;

import java.util.ArrayList;
import java.util.List;

public class PersonModel {
    private String _name;
    private int _income;
    private int _age;
    private List<Integer> _deductions = new ArrayList<>();

    // Setters \\
    public void setName(String name) { this._name = name; }
    public void setIncome(int income) { this._income = income; }
    public void setAge(int age) { this._age = age; }
    
    public void setDeduction(int amount) { 
        if (amount < 0)
            throw new IllegalArgumentException("Deduction cannot be newgative");
        _deductions.add(amount);
    }

    // Getters \\
    public String getName() { return this._name; }
    public int getIncome() { return this._income; }
    public int getAge() { return this._age; }

    public int getTotalDeduction() {
        return _deductions.stream().mapToInt(Integer::intValue).sum();
    }

    // Constructors \\
    public PersonModel() { }    // <-- Default constructor

    public PersonModel(String name, int income, int age) {
        setName(name);
        setIncome(income);
        setAge(age);
    }
}
