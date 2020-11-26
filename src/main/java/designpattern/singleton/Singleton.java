package designpattern.singleton;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 10/22/12
 */
public class Singleton {
    private static Singleton _instance;

    //Make the constructor private. It prevents from instantiating objects
    private Singleton() {

    }

    //Public method to retrieve the exposed objects
    public static Singleton getInstance() {
        if (null == _instance) {
            _instance = new Singleton();
        }
        return _instance;
    }
}
