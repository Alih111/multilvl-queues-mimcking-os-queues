/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person_io.bonus;


/**
 *
 * @author User
 */
public class cpuTime {
   private FIFO readyQueue=null;
    private  RR q1;
    private    RR q2;
    private    FIFO q3;
    private    FIFO waitingQ1;
    private     FIFO waitingQ2;
    private     FIFO waitingQ3;
    public cpuTime(FIFO waiting){
       this.q1= new RR(10,8);
       this.q2= new RR(20,16);
       this.q3=new FIFO(30);
       this.readyQueue=waiting;
    }
    
    public void cpuScedulling(){
        long startTime = System.currentTimeMillis();
        long firstQueueTime ,secondQueueTime,thirdQueueTime,now;
        this.waitingQ1=new FIFO(this.readyQueue.getMaxsize());
        this.waitingQ2=new FIFO(this.readyQueue.getMaxsize());
        this.waitingQ3=new FIFO(this.readyQueue.getMaxsize());
        long totalTime=0,totalThirdQueueTime=0,totalFirstQueueTime=0,totalSecondQueueTime=0;
        process p;
        int j=0,m=0;
        int decideQueue13=0;
        // the priorites determined by the percentage size in each queue to the time needed by cpu to spend in each queue
       while(!this.readyQueue.isempty()|| !this.q1.isempty()|| !this.q2.isempty()|| !this.q3.isempty()|| !this.waitingQ1.isempty()|| !this.waitingQ2.isempty()|| !this.waitingQ3.isempty()){ 
       firstQueueTime = System.nanoTime();
        while(!this.readyQueue.isempty()||!waitingQ1.isempty()||!this.q1.isempty()){// do a dequeue or an enqueue then check if cputime ended 
            if(this.q1.isFull()||(this.readyQueue.isempty()&&waitingQ1.isempty()&&!this.q1.isempty())||0.6*(this.q1.getCurrentSize()/this.q1.getMaxsize())>(this.q2.getCurrentSize()/this.q2.getMaxsize()))// do process if q1 is full or the waiting list have no left procces or q1 have a higher percentage of process than q2
            {// give priority to queue 2 according to number of process in q1
                p=this.q1.dequeue();
                for(int i=0;i<q1.timebeforeDeque();i++);
                if(p.getTime()!=0){
                   
                    this.waitingQ2.Enqueue(p);
                    
                }
                else{
                                    
                    System.out.println("process "+p.getPid()  +" original time of the process = "+p.getOrignaltime()+ " queue 1");
                    j++;
                }
                
            }
            else{

             if(!this.waitingQ1.isempty())// decide to take from waiting queue returned from q2 not ready process
             {this.q1.Enqueue(this.waitingQ1.dequeue());
             }
             else{
                 if(!this.readyQueue.isempty())
                 this.q1.Enqueue(this.readyQueue.dequeue());
             }}
            
             now = System.nanoTime();
             totalFirstQueueTime+=now-firstQueueTime;
             totalTime+=now-firstQueueTime;
            if(totalFirstQueueTime>=0.5*(totalTime)){
                break;   
            }
        }
       secondQueueTime = System.nanoTime();
        while(!this.q2.isempty()||!this.waitingQ2.isempty()){// do a dequeue or an enqueue then check if cputime ended
               if(this.q2.isFull()||(this.waitingQ2.isempty()&&!this.q2.isempty())||((0.6*(this.q1.getCurrentSize()/this.q1.getMaxsize())<(this.q2.getCurrentSize()/this.q2.getMaxsize()))&&(0.2*(this.q3.getCurrentSize()/this.q3.getMaxsize())<0.3*(this.q2.getCurrentSize()/this.q2.getMaxsize()))))// do process if q2 is full or waiting q2 have no left procces
                {// spend time in queue 2 according to the number of elements in queue 1 and 3
                p=this.q2.dequeue();
                for(int i=0;i<q2.timebeforeDeque();i++);
                if(p.getTime()!=0){
                    
                    if(decideQueue13==0){//if process didnot end decide what queue to enter RR with quantum=8
                       this.waitingQ1.Enqueue(p); 
                       decideQueue13=1;
                    }
                    else{
                        this.waitingQ3.Enqueue(p); 
                       decideQueue13=0;
                    }
                }
                else{
                    System.out.println("process "+p.getPid()  +" original time of the process = "+p.getOrignaltime()+ " queue 2");
                    j++;
                }
        }else{
      
           if(!this.waitingQ2.isempty())// decide to take from waiting queue returned from q2 not ready process
             {this.q2.Enqueue(this.waitingQ2.dequeue());
             }
                   
          }
           now= System.nanoTime();
           totalSecondQueueTime+=now-secondQueueTime;
           totalTime+=now-secondQueueTime;
            if(totalSecondQueueTime>=0.3*(totalTime)){
                break;   
        } 
    } thirdQueueTime = System.nanoTime();
       while(!this.q3.isempty()||!this.waitingQ3.isempty()){
           if(this.q3.isFull()||(this.waitingQ3.isempty()&&!this.q3.isempty())){
                p=this.q3.dequeue();
                for(int i=0;i<p.getTime();i++);
                System.out.println("process "+p.getPid()  +" original time of the process = "+p.getOrignaltime()+ " queue 3");
                m++;
                j++;
                }
               
        else{
       if(!this.waitingQ3.isempty()){
           this.q3.Enqueue(this.waitingQ3.dequeue());
       }}
          now= System.nanoTime();
           totalTime+=now-thirdQueueTime;
           totalThirdQueueTime+=now-thirdQueueTime;
            if(totalThirdQueueTime>=0.2*(totalTime)){
                break;   
        } 
           
       }
           
       }
       System.out.println("third queue "+totalThirdQueueTime+" second queue "+totalSecondQueueTime+" first queue "+totalFirstQueueTime+" total cpu time "+totalTime);
    }
}
