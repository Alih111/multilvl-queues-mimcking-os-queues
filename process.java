/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person_io.bonus;
import java.util.Random;
/**
 *
 * @author User
 */
public class process {
     private static Random  rand = new Random();

   private int orignaltime;
    private static int id=0;
    private int pid,time;
    public process(){
        this.pid=id;
        this.time = rand.nextInt(100) + 1;
        this.orignaltime=this.time;
        id++;
    }
       public int getPid() {
        return pid;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getOrignaltime() {
        return orignaltime;
    }
    
}
