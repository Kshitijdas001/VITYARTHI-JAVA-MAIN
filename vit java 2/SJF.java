public class SJF {

    public static void run(Process[] p) {

        int time = 0;
        int completed = 0;
        boolean[] done = new boolean[p.length];

        System.out.println("\n--- SJF Scheduling ---");
        System.out.println("Gantt Chart:");

        while (completed < p.length) {

            int shortest = -1;

            
            for (int i = 0; i < p.length; i++) {

                if (!done[i] && p[i].at <= time) {

                    if (shortest == -1 ||
                        p[i].bt < p[shortest].bt) {

                        shortest = i;
                    }
                }
            }

            
            if (shortest == -1) {
                time++;
                continue;
            }

            
            p[shortest].rt = time - p[shortest].at;

            System.out.print("| P" + p[shortest].pid + " ");

            
            time = time + p[shortest].bt;

            p[shortest].ct = time;
            p[shortest].tat = p[shortest].ct - p[shortest].at;
            p[shortest].wt = p[shortest].tat - p[shortest].bt;

            done[shortest] = true;
            completed++;
        }

        System.out.println("|");

        FCFS.showResult(p);
    }
}