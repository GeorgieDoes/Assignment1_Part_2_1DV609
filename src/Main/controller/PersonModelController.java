package Main.controller;
import Main.model.PersonModel;

public class PersonModelController {
    private PersonModel _model;

    // Setters \\
    public void setName(String name) { this._model.setName(name); }
    public void setIncome(int income) { this._model.setIncome(income); }
    public void setAge(int age) { this._model.setAge(age); }

    // Getters \\
    public String getName() { return this._model.getName(); }
    public int getIncome() { return this._model.getIncome(); }
    public int getAge() { return this._model.getAge(); }

    // Constructor \\
    public PersonModelController() {
        this._model = new PersonModel();
    }
}
