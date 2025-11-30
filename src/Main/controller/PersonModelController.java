package Main.controller;
import Main.model.PersonModel;

public class PersonModelController {
    private PersonModel _model;

    // Setters \\
    public void setName(String name) { 
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty.");
        }
        this._model.setName(name); 
    }

    public void setIncome(int income) { 
        if (income < 0) {
            throw new IllegalArgumentException("Invalid integer value for income.");
        }
        this._model.setIncome(income); 
    }
    
    public void setAge(int age) { 
        if (age < 0 || age > 130) {
            throw new IllegalArgumentException("Invalid integer value for age.");
        }
        this._model.setAge(age); 
    }

    public void setDeduction(int amount) {
        _model.setDeduction(amount);
    }

    // Getters \\
    public String getName() { return this._model.getName(); }
    public int getIncome() { return this._model.getIncome(); }
    public int getAge() { return this._model.getAge(); }

    // Constructor \\
    public PersonModelController() {
        this._model = new PersonModel();
    }
}
