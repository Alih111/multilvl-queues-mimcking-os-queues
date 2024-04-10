/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person_io.bonus;

/**
 *
 * @author User
 */
public class FIFO {
       private int maxsize;
    private int currentSize=0;
    private Node head=null;
  
   public FIFO(int maxSize){
       this.maxsize=maxSize;
   }

    public int getCurrentSize() {
        return currentSize;
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
          
           head=head.next;
           this.currentSize--;
           return p;
       }
       System.out.println("this queue is empty\n");
       return null;
       
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
     
}
