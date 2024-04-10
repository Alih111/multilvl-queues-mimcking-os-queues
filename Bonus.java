/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package person_io.bonus;

/**
 *
 * @author User
 */
public class Bonus {
    
    public static void main(String[] args) {
       FIFO ready=new FIFO(1000);
       for(int i=0;i<100;i++){
           ready.Enqueue(new process());
    }
       cpuTime c =new cpuTime(ready);
       c.cpuScedulling();

}}
   
