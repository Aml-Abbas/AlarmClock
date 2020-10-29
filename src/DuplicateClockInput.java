public class DuplicateClockInput {

    private InputData in;
    private long dataInTime;
    private boolean[] read;

    // add a constructor if you find it necessary,
    public DuplicateClockInput(){
        read= new boolean[2];
    }
     /* Task 6 b): add thread-safe methods provideData(...) and collectData(...)
     * assure they have suitable return values and parameters
     */
    public synchronized void provideData(InputData inputData) throws InterruptedException {
        long now= System.currentTimeMillis();
        long tDiff;

        while ( (!read[0]|| !read[1]) && (tDiff=System.currentTimeMillis()-dataInTime)<1000  ){
            wait(tDiff);
        }
        if( !read[0] || !read[1]) {
            System.out.println( "discarding data set with timestamp" + dataInTime);
            if( !read[0]) System.out.println( "Thread with id 0 did not read");
            if( !read[1]) System.out.println( "Thread with id 1 did not read");
        }
        dataInTime = now;
        in = inputData;
        read[0] = false;
        read[1] = false;

        notifyAll();
    }
    public synchronized InputData collectData(int threadId) throws InterruptedException {
        while (read[threadId]){
            wait();
        }
        InputData toReturn= in;
        read[threadId]= true;
        notifyAll();
        return toReturn;
    }
}
