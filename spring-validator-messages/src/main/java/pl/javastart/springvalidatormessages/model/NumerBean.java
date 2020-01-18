package pl.javastart.springvalidatormessages.model;

import pl.javastart.springvalidatormessages.constraint.Divided;

import javax.validation.constraints.Min;

public class NumerBean {

    @Divided(by = 3)
    @Min(value = 3)
    private Integer number;

    public NumerBean(@Min(value = 3) Integer number) {
        this.number = number;
    }

    public NumerBean() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
