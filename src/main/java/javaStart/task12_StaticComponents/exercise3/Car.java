package javaStart.task12_StaticComponents.exercise3;

public class Car {
    public static final int OK = 100;
    public static final int ERROR_CHECK_ENGINE = 200;
    public static final int ERROR_NO_FUEL = 300;
    public static final int WARNING_FUEl_FLAP_OPEN = 400;
    public static final int WARNING_DOORS_OPEN = 500;

    private int fuel;
    private boolean engineOk;
    private boolean engineOn;
    private boolean fuelFlapOpen;
    private boolean doorsOpen;

    public Car(int fuel, boolean engineOk, boolean engineOn,
               boolean fuelFlapOpen, boolean doorsOpen) {
        this.fuel = fuel;
        this.engineOk = engineOk;
        this.engineOn = engineOn;
        this.fuelFlapOpen = fuelFlapOpen;
        this.doorsOpen = doorsOpen;
    }

    public static int getErrorCheckEngine() {
        return ERROR_CHECK_ENGINE;
    }

    public int getFuel() {
        return fuel;
    }

    public boolean isEngineOk() {
        return engineOk;
    }

    public boolean isEngineOn() {
        return engineOn;
    }

    public boolean isFuelFlapOpen() {
        return fuelFlapOpen;
    }

    public boolean isDoorsOpen() {
        return doorsOpen;
    }

    public void setFuel(int fuel) {
        if (fuel <= 0)
            engineOn = false;
            this.fuel = fuel;
    }

    public void setEngineOk(boolean engineOk) {
        if (!engineOk)
            engineOk = false;
        this.engineOk = engineOk;
    }

    public void setEngineOn(boolean engineOn) {
        int systemCheck = systemCheck();
        if (systemCheck == ERROR_CHECK_ENGINE || systemCheck == ERROR_NO_FUEL) {
            this.engineOn = false;
        } else {
            this.engineOn = engineOn;
        }
    }

    public void setFuelFlapOpen(boolean fuelFlapOpen) {
        this.fuelFlapOpen = fuelFlapOpen;
    }

    public void setDoorsOpen(boolean doorsOpen) {
        this.doorsOpen = doorsOpen;
    }

    int start() {
        int systemCheck = systemCheck();
        setEngineOn(true);
        return systemCheck;
    }

    private int systemCheck() {
        if (!engineOk) {
            return ERROR_CHECK_ENGINE;
        }
        if (fuel <= 0) {
            return ERROR_NO_FUEL;
        }
        if (fuelFlapOpen) {
            return WARNING_FUEl_FLAP_OPEN;
        }
        if (doorsOpen) {
            return WARNING_DOORS_OPEN;
        } else {
            return OK;
        }
    }

    String status() {
        if (systemCheck() == OK)
            return "All systems are operational, you can drive";
            String status = "Car status \n";
            if (!engineOk)
                status += " > Failure engine \n";
            if (fuel <= 0)
                status += " > No fuel \n";
            if (fuelFlapOpen)
                status += " > Close fuel flap \n";
            if (doorsOpen)
                status += " > Doors or boot are opened \n";
            if (engineOn)
                status += " > Engine on";
            else
                status += " > Engine off";
            return status;
    }
}
