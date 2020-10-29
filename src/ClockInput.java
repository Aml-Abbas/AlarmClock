import java.util.concurrent.Semaphore;

public class ClockInput {

    /**
     * Return values for getChoice.
     */
    public static final int SHOW_TIME = 0;
    public static final int SET_ALARM = 1;
    public static final int SET_TIME = 2;
    /**
     * Construct the interface with semaphore reset.
     */
    public ClockInput() {
        anyButtonChanged = new Semaphore(0);
    }
    /**
     * Semaphore signaling when the user has changed any setting.
     */
    private Semaphore anyButtonChanged;
    /**
     * Get-method to access the semaphore instance directly.
     */
    public Semaphore getSemaphoreInstance() {
        return anyButtonChanged;
    }
    /* Package attributes, only used by the simulator/hardware. */
    boolean alarmOn; // Alarm activation according to checkbox.
    int choice; // The radio-button choice.
    int lastValueSet; // Value from last clock or alarm set op.
    /**
     * Get check-box state.
     */
    public boolean getAlarmFlag() {
        return alarmOn;
    }
    /**
     * Get radio-buttons choice.
     */
    public int getChoice() {
        return choice;
    }
    /**
     * The set-value of the display is returned in the format hhmmss
     * where h, m, and s denote hours, minutes, and seconds digits respectively.
     */
    public int getValue() {
        return lastValueSet;
    }

}
