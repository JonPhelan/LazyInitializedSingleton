public class  LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {}

    public static synchronized LazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}

class SingletonThread extends Thread {
    @Override
    public void run() {
        LazyInitializedSingleton singleton = LazyInitializedSingleton.getInstance();
        System.out.println("Thread " + Thread.currentThread().getId() + ": " + singleton.hashCode());
    }
}

