/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person_io.bonus;

/**
 *
 * @author User
 */
public class RR {
          private int maxsize;
    private int currentSize=0;
    private Node head=null;

    public int getCurrentSize() {
        return currentSize;
    }
    private int quantum;
    private int timebeforeDeq=0;
   public RR(int maxSize,int quantum){
       this.maxsize=maxSize;
       this.quantum=quantum;
   }
    private static class Node {
        
         Node next = null;
         process data;
        Node(process data){
            this.data=data;
        }

        public process getData() {
            return data;
        }   
    }

   public void Enqueue(process p){
       if(this.currentSize<this.maxsize){
               if(this.head==null){
           this.head=new Node(p);
            }else{
           Node c =head;
           while(c.next!=null){
               c=c.next;
           }
           c.next=new Node(p);}
           this.currentSize++;
      }else{
           System.out.println("this queue is full \n");
       }
   }
   public process dequeue(){
       if(this.head!=null){
           process p=this.head.getData();
           if(p.getTime()>this.quantum){
           p.setTime(p.getTime()-this.quantum);
           this.timebeforeDeq=this.quantum;}
           else{
               this.timebeforeDeq=p.getTime();
               p.setTime(0);
           }
           head=head.next;
           this.currentSize--;
           return p;
       }
       System.out.println("this queue is empty\n");
       return null;
       
   }
   public int timebeforeDeque(){
       return this.timebeforeDeq;
   }
      public boolean isempty(){
    return this.currentSize==0;

}
  public boolean isFull(){
    return this.currentSize==this.maxsize;

}  
      public int getMaxsize() {
        return maxsize;
    }

    public int getQuantum() {
        return quantum;
    }
}
