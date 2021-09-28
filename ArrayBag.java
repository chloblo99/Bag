public final class ArrayBag<T> implements BagInterface<T>{

    private T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    private boolean initialised = false;
    private static final int MAX_CAPACITY = 10000;

    private boolean isArrayFull(){
        return(bag.length == numberOfEntries);
    }

    private void checkInitialisation(){
        if (!initialised)
            throw new SecurityException("ArrayBag object is not initialised properly");
    }

    public ArrayBag(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayBag(int capacity) {
        if (capacity <= MAX_CAPACITY) {
            T[] tempBag = (T[]) new Object[capacity];
            bag = tempBag;
            numberOfEntries = 0;
            initialised = true;
        } else throw new IllegalStateException("Attempt to create a bag where the capacity exceeds the maximum");
    }
    public int getCurrentSize(){
        return 0;
    }

    public boolean isEmpty(){
        return false;
    }

    public boolean addNewEntry(T newEntry){
        checkInitialisation();
        if(isArrayFull()) return false;
        else{
            bag[numberOfEntries++] = newEntry;
            return true;
        }
    }

    public T remove(){
        return null;
    }

    public boolean remove(T anEntry){
        return false;
    }

    public void clear(){

    }

    public int getFrequencyOf(T anEntry){
        return 0;
    }

    public boolean contains(T anEntry){
        return false;
    }

    public T[] toArray(){
        T[] resultArray = (T[]) new Object[numberOfEntries];
        System.arraycopy(bag, 0, resultArray, 0, numberOfEntries);
        return resultArray;
    }

    public static void main(String[] args){
        ArrayBag<String> bagOfNames = new ArrayBag<>(5);

        System.out.println("Adding Chloe ... " + bagOfNames.addNewEntry("Chloe"));
        System.out.println("Adding Tilly ... " + bagOfNames.addNewEntry("Tilly"));
        System.out.println("Adding Bonnie ... " + bagOfNames.addNewEntry("Bonnie"));

        Object[] arrayOfNames = bagOfNames.toArray();
        for(Object name : arrayOfNames) System.out.print(name + "...");
        System.out.println();

        System.out.println("Adding Sean ... " + bagOfNames.addNewEntry("Sean"));
        System.out.println("Adding Azur ... " + bagOfNames.addNewEntry("Azur"));
        System.out.println("Adding Colin ... " + bagOfNames.addNewEntry("Colin"));

        Object[] arrayOfNames2 = bagOfNames.toArray();
        for(Object name : arrayOfNames2) System.out.print(name + "...");
        System.out.println();
    }
}
