package singleton_design_pattern;

// SingletonEager class implements the eager initialization Singleton pattern
class SingletonEager {
  private static SingletonEager instance = new SingletonEager();

  private SingletonEager() {
    // Private constructor to prevent external instantiation
  }

  public static SingletonEager getInstance() {
    return instance;
  }
}

// Singleton class implements the lazy initialization Singleton pattern
class Singleton {
  private static Singleton instance;

  private Singleton() {
    // Private constructor to prevent external instantiation
  }

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}

// SingletonSynchronizedMethod class implements the lazy initialization Singleton pattern with synchronized method
class SingletonSynchronizedMethod {
  private static SingletonSynchronizedMethod instance;

  private SingletonSynchronizedMethod() {
    // Private constructor to prevent external instantiation
  }

  public static synchronized SingletonSynchronizedMethod getInstance() {
    if (instance == null) {
      instance = new SingletonSynchronizedMethod();
    }
    return instance;
  }
}

// SingletonSynchronized class implements the lazy initialization Singleton pattern with double-checked locking
class SingletonSynchronized {
  private static SingletonSynchronized instance;

  private SingletonSynchronized() {
    // Private constructor to prevent external instantiation
  }

  public static SingletonSynchronized getInstance() {
    if (instance == null) {
      synchronized (SingletonSynchronized.class) {
        if (instance == null) {
          instance = new SingletonSynchronized();
        }
      }
    }
    return instance;
  }
}

public class SingletonPattern {
  public static void main(String[] args) {
    // Create an instance of SingletonSynchronized
    SingletonSynchronized instance = SingletonSynchronized.getInstance();
    System.out.println(instance);

    // Create another instance of SingletonSynchronized
    SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
    System.out.println(instance1);
  }
}
