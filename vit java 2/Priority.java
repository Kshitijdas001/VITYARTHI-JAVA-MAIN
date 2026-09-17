public class Priority {

    public static void run(Process[] p) {

        int time = 0;
        int completed = 0;
        boolean[] done = new boolean[p.length];

        System.out.println("\n--- Priority Scheduling ---");
        System.out.println("Gantt Chart:");

        while (completed < p.length) {

            int selected = -1;

            
            
            for (int i = 0; i < p.length; i++) {

                if (!done[i] && p[i].at <= time) {

                    if (selected == -1 ||
                        p[i].priority < p[selected].priority) {

                        selected = i;
                    }
                }
            }

            
            if (selected == -1) {
                time++;
                continue;
            }

            p[selected].rt = time - p[selected].at;

            System.out.print("| P" + p[selected].pid + " ");

            
            time = time + p[selected].bt;

            p[selected].ct = time;
            p[selected].tat =
                    p[selected].ct - p[selected].at;

            p[selected].wt =
                    p[selected].tat - p[selected].bt;

            done[selected] = true;
            completed++;
        }

        System.out.println("|");

        FCFS.showResult(p);
    }
}