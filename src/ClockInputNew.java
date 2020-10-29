import java.util.concurrent.Semaphore;

public class ClockInputNew {
    /* mainly the same as ClockInput */
    /* Package attributes, only used by the simulator/hardware. */
    boolean alarmOn; // Alarm activation according to checkbox.
    int choice; // The radio-button choice.
    int lastValueSet; // Value from last clock or alarm set op.
    private Semaphore anyButtonChanged;
    /**
     * For use by device driver; as you explain...
     */
    boolean pending; // Suggestion ...

    public ClockInputNew(){
        anyButtonChanged = new Semaphore(0);
    }
    /**
     * Method to be developed for task 6 a)
     * @return consistent input state, or null for error.
     */
    public InputData getData() throws InterruptedException {
        InputData inputData= new InputData();
        anyButtonChanged.acquire();

        if (pending){
           inputData.alarmOn= alarmOn;
           inputData.choice= choice;
           inputData.lastValueSet= lastValueSet;
           pending= false;
           return inputData;
        }
        else {
            return null;
        }
    }
}
