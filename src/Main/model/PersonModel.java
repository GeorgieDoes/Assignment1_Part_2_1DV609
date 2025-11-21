package Main.model;

public class PersonModel {
    private String _name;

    // Setters \\
    public void SetName(String name) { this._name = name; }
    public void SetIncome(int income) { }
    public void SetAge(int age) { }

    // Getters \\
    public String GetName() { return this._name; }
    public int GetIncome() { return 50000; }
    public int GetAge() { return 30; }
}
