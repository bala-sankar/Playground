package educative.twoheaps;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

public class ScheduleTasks {
    public static int tasks(List<List<Integer>> tasksList) {
        int optimalMachines = 0;

        PriorityQueue<int[]> machinesAvailable = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> tasksQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (List<Integer> task: tasksList) {
            tasksQueue.add(new int[] {
                    task.get(0), task.get(1)
            });
        }

        while (!tasksQueue.isEmpty()) {
            int[] task = tasksQueue.poll();
            while (!machinesAvailable.isEmpty() && machinesAvailable.peek()[0] <= task[0]) {
                machinesAvailable.poll();
            }
            if (machinesAvailable.isEmpty()) {
                optimalMachines++;
            } else {
                machinesAvailable.poll();
            }
            machinesAvailable.add(new int[] {
                    task[1], task[0]
            });
        }

        return optimalMachines;
    }
}
