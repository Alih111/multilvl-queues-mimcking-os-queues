# multilevel-queue-mimcking-the-movement-of-process-between-OS-queues

README
# CPU Time Scheduling Simulator
This project is a CPU time scheduling simulator implemented in Java. It simulates three different scheduling queues: Round Robin (RR) with two different time slices, and First-In-First-Out (FIFO) scheduling. The scheduler prioritizes processes based on the number of processes in each queue and their respective time slices.

Features
Three Queues: Simulates three different queues for CPU scheduling:

Queue 1 (RR): Processes with shorter time slices.
Queue 2 (RR): Processes with longer time slices.
Queue 3 (FIFO): Processes with the longest time slices.
Dynamic Prioritization: Prioritizes processes dynamically between the three queues based on the number of processes in each queue and their time slices.

Time Slicing: Each queue has a different time slice, allowing for a diverse range of processes to be executed efficiently.

Implementation Details
Class cpuTime: This class represents the CPU scheduler. It contains methods for CPU scheduling and manages the three queues along with waiting queue.

Queue Classes (FIFO and RR): These classes implement FIFO and RR scheduling algorithms, respectively, with functionalities for enqueueing, dequeueing, and managing processes.

# How to Use
Setup: Initialize the CPU scheduler with a waiting queue and set up the queues with appropriate time slices.

Run Scheduler: Call the cpuScedulling() method to start the CPU scheduler and simulate the scheduling of processes.
