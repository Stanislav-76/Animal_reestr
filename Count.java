public class Count implements AutoCloseable{
    
    static int count;
    {
        count = 0;
    }

    public void add() {
        count++;
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'close'");
    }
}