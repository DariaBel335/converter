package model;

import java.util.List;

/**
 * CSV Unit
 */
public class CSVLine {
    private List<Unit> units;

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public List<Unit> getUnits() {
        return units;
    }
}