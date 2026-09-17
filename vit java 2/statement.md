# Project Statement

## 1. Problem Statement

CPU scheduling is one of the important functions of an Operating System. When
several processes are waiting for the CPU, the operating system has to decide
which process should be executed first.

Different scheduling algorithms make this decision in different ways. For
example, FCFS uses the arrival order, SJF selects a process with a shorter
burst time, SRTF considers the remaining burst time, and Priority Scheduling
uses the priority of the process.

Doing the calculations manually for different processes can take time and
can also lead to mistakes. Therefore, this project aims to provide a simple
CPU scheduling simulator where users can enter process details, select an
algorithm and directly view the scheduling results.

The project is mainly developed as a learning application to make CPU
scheduling concepts easier to understand and experiment with.

## 2. Objectives

The main objectives of this project are:

- To understand the basic concept of CPU process scheduling.
- To implement commonly used CPU scheduling algorithms using Java.
- To understand the difference between non-preemptive and preemptive
  scheduling.
- To calculate important process scheduling parameters.
- To provide a simple graphical interface for entering process information.
- To allow users to test different process combinations.
- To make the study of CPU scheduling more interactive instead of depending
  only on manual calculations.
- To organize the project into separate Java classes so that each scheduling
  algorithm can be understood and maintained easily.

## 3. Functional Requirements

The system should be able to perform the following functions:

1. Allow the user to select the number of processes.
2. Support between 1 and 10 processes.
3. Accept Arrival Time for every process.
4. Accept Burst Time for every process.
5. Accept Priority for every process.
6. Allow the user to select a scheduling algorithm.
7. Implement First Come First Serve (FCFS).
8. Implement Shortest Job First (SJF).
9. Implement Shortest Remaining Time First (SRTF).
10. Implement Priority Scheduling.
11. Calculate Completion Time (CT).
12. Calculate Turnaround Time (TAT).
13. Calculate Waiting Time (WT).
14. Calculate Response Time (RT).
15. Calculate average Waiting Time.
16. Calculate average Turnaround Time.
17. Display the scheduling output through the GUI.
18. Show an error message when the user enters invalid values.

## 4. Non-Functional Requirements

The project should also satisfy the following requirements:

### Usability

The interface should be simple enough for a student to enter process
information and run a simulation without needing complicated instructions.

### Performance

The simulator should provide the results quickly for the supported range of
1 to 10 processes.

### Reliability

For valid input, the simulator should produce consistent scheduling results
when the same input and algorithm are used.

### Maintainability

Different scheduling algorithms are kept in separate Java classes. This
makes the code easier to understand, modify and test.

### Input Validation

The system should check the entered values before starting the simulation.
Arrival Time should not be negative, while Burst Time and Priority should be
greater than zero.

## 5. Scope

The project focuses on demonstrating four CPU scheduling algorithms:

- FCFS
- SJF
- SRTF
- Priority Scheduling

The simulator currently supports up to 10 processes. It can be used to enter
different process values and observe how the selected scheduling algorithm
handles them.

The project is intended for educational purposes and focuses on understanding
CPU scheduling rather than simulating a complete real operating system.

## 6. System Inputs

The main inputs required by the simulator are:

- **Number of Processes:** Number of processes to be included in the
  simulation.
- **Arrival Time (AT):** Time at which a process arrives and becomes ready.
- **Burst Time (BT):** Amount of CPU time required by a process.
- **Priority:** Priority value used by the Priority Scheduling algorithm.

## 7. System Outputs

After the simulation is completed, the system displays the scheduling
information for each process.

The output includes:

- Process ID
- Arrival Time
- Burst Time
- Completion Time
- Turnaround Time
- Waiting Time
- Response Time
- Average Waiting Time
- Average Turnaround Time

## 8. Expected Outcome

The expected outcome is a working Java application that can take process
information from the user and apply the selected CPU scheduling algorithm.

The simulator should correctly calculate and display the scheduling
parameters and provide an easy way to observe the execution behaviour of
different algorithms.

The project should also help students understand how process arrival time,
burst time and priority can affect CPU scheduling results.

## 9. Limitations

The current version of the project is limited to four scheduling algorithms
and a maximum of 10 processes.

It is a simulation for educational purposes and does not interact with the
actual CPU or process scheduler of the operating system.

## 10. Future Enhancements

Some possible improvements for future versions are:

- Adding a graphical Gantt chart.
- Adding more CPU scheduling algorithms.
- Adding a comparison between different algorithms.
- Adding graphs for Waiting Time and Turnaround Time.
- Improving the visual design of the GUI.
- Allowing users to save or export simulation results.