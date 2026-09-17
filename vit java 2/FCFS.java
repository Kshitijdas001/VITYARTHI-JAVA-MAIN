public class FCFS {

    public static void run(Process[] p) {

        int time = 0;
        boolean[] finished = new boolean[p.length];
        int completed = 0;

        System.out.println("\n--- FCFS Scheduling ---");
        System.out.println("Gantt Chart:");

        while (completed < p.length) {

            int next = -1;

            // Find the process that arrived first
            for (int i = 0; i < p.length; i++) {

                if (!finished[i] && p[i].at <= time) {

                    if (next == -1 || p[i].at < p[next].at) {
                        next = i;
                    }
                }
            }

            
            if (next == -1) {
                time++;
                continue;
            }

            p[next].rt = time - p[next].at;

            System.out.print("| P" + p[next].pid + " ");

            time = time + p[next].bt;

            p[next].ct = time;
            p[next].tat = p[next].ct - p[next].at;
            p[next].wt = p[next].tat - p[next].bt;

            finished[next] = true;
            completed++;
        }

        System.out.println("|");

        showResult(p);
    }

    static void showResult(Process[] p) {

        System.out.println("\nPID\tAT\tBT\tCT\tTAT\tWT\tRT");

        double totalWT = 0;
        double totalTAT = 0;

        for (Process x : p) {

            System.out.println(
                    "P" + x.pid + "\t" +
                    x.at + "\t" +
                    x.bt + "\t" +
                    x.ct + "\t" +
                    x.tat + "\t" +
                    x.wt + "\t" +
                    x.rt
            );

            totalWT += x.wt;
            totalTAT += x.tat;
        }

        System.out.printf("\nAverage Waiting Time    : %.2f",
                totalWT / p.length);

        System.out.printf("\nAverage Turnaround Time : %.2f\n",
                totalTAT / p.length);
    }
}