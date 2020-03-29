package javaStart.task1_OperationsOnVariables.exercise2;

public class TaxRate {
    private boolean basic;
    private boolean decreased;
    private boolean free;

    public TaxRate(boolean basic, boolean decreased, boolean free) {
        this.basic = basic;
        this.decreased = decreased;
        this.free = free;
    }

    public boolean isBasic() {
        return basic;
    }

    public boolean isDecreased() {
        return decreased;
    }

    public boolean isFree() {
        return free;
    }
}
