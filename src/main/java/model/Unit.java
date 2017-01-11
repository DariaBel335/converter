package model;

/**
 * CSV Unit
 */
public class Unit {
    private String field;

    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}