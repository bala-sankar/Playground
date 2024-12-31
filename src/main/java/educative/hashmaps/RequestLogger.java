package educative.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class RequestLogger {
    private int timeLimit;
    private Map<String, Integer> requestMap = new HashMap<>();
    public RequestLogger(int timeLimit) {
        // Initialize your data structure here
        this.timeLimit = timeLimit;
    }

    public boolean messageRequestDecision(int timestamp, String request) {
        // Replace this placeholder return statement with your code
        if (requestMap.containsKey(request)) {
            if (timestamp - requestMap.get(request) < timeLimit) {
                return false;
            } else {
                requestMap.put(request, timestamp);
            }
        } else {
            requestMap.put(request, timestamp);
        }
        return true;
    }
}
