public class SRTF {

    public static void run(Process[] p) {

        int time = 0;
        int completed = 0;

        int[] remaining = new int[p.length];
        boolean[] started = new boolean[p.length];

        for (int i = 0; i < p.length; i++) {
            remaining[i] = p[i].bt;
        }

        System.out.println("\n--- SRTF Scheduling ---");
        System.out.println("Gantt Chart:");

        while (completed < p.length) {

            int shortest = -1;

            
            for (int i = 0; i < p.length; i++) {

                if (remaining[i] > 0 && p[i].at <= time) {

                    if (shortest == -1 ||
                        remaining[i] < remaining[shortest]) {

                        shortest = i;
                    }
                }
            }

            
            if (shortest == -1) {
                time++;
                continue;
            }

            
            if (!started[shortest]) {
                p[shortest].rt = time - p[shortest].at;
                started[shortest] = true;
            }

            
            remaining[shortest]--;
            time++;

            
            if (remaining[shortest] == 0) {

                p[shortest].ct = time;
                p[shortest].tat =
                        p[shortest].ct - p[shortest].at;

                p[shortest].wt =
                        p[shortest].tat - p[shortest].bt;

                completed++;
            }
        }

        System.out.println("Simulation completed.");

        FCFS.showResult(p);
    }
}