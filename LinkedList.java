public class LinkedList{
  public Node head;
 
  /* First Constructor:
   * Creates a linked list using the values from the given array. head will refer
   * to the Node that contains the element from a[0]
   */ 
  public LinkedList(Object [] a){
    //Node tail= new Node(a[0],null);
    //head=tail; 
   head=new Node(a[0],null);
   Node tail= head;
  
    for(int i=1;i<a.length;i++){
      Node x=new Node (a[i],null);
      tail.next=x; //connecting tail and x
      tail=tail.next;//or=x; //making x the new tail
    }
  }
  
  /* Second Constructor:
   * Sets the value of head. head will refer
   * to the given LinkedList
   */
  public LinkedList(Node h){
    head= h;
  }
  
  /* Counts the number of Nodes in the list */
  public int countNode(){
    int count=0;
    for(Node n=head; n!=null; n=n.next){
      count++;
    }
    return count; 
  }
  
  /* prints the elements in the list */
  public void printList(){
    for(Node n=head; n!=null; n=n.next){
      if(n==head){
        System.out.print(n.element);
      }else{
        System.out.print(", "+n.element);
      }
    }
    System.out.print(".");
    System.out.println();
  }
  
  // returns the reference of the Node at the given index. For invalid index return null.
  public Node nodeAt(int idx){
//    int i=0;
//    Node n1=null;
//    int count=countNode();
//    if(idx>=0 && idx<count){
//    for(Node n=head; n!=null; n=n.next){
//      if(i==idx){
//        n1= n;
//      }
//      i++; 
//    }
//   }
//   return n1;
//  }
     Node n1=null;
    int count=0;
   
    for(Node n=head; n!=null; n=n.next){
      if(count==idx){
        n1= n;
      }
      count++; 
    }
   
   return n1;
  }
    
  
  
// returns the element of the Node at the given index. For invalid idx return null.
  public Object get(int idx){
    int i=0;
    Node n1=null;
     int count=countNode();
    if(idx>=0 && idx<count){
    for(Node n=head; n!=null; n=n.next){
      if(i==idx){
        n1= n;
      }
      i++;
     }
    return n1.element; 
    }else{
      return null;
    }
  } 
  
  
  /* updates the element of the Node at the given index. 
   * Returns the old element that was replaced. For invalid index return null.
   * parameter: index, new element
   */
  public Object set(int idx, Object elem){
    int i=0;
    Node n1=null;
     int count=countNode();
    if(idx>=0 && idx<count){
    for(Node n=head; n!=null; n=n.next){
      if(i==idx){
        n1= n;
      }
      i++; 
  }
    n1.element=elem;
    return n1.element; 
    }else{
      return null;
    }
  }
  
  
  /* returns the index of the Node containing the given element.
   if the element does not exist in the List, return -1.
   */
  public int indexOf(Object elem){
    int index=0;
    boolean boo=false;
    for(Node n=head; n!=null; n=n.next){
      if(n.element==elem){
        boo=true;
        break;
      }
      index++;
    }
    if(boo==true){
    return index; 
    }else{
      return -1;
    }
  }
  
  // returns true if the element exists in the List, return false otherwise.
  public boolean contains(Object elem){
    boolean boo=false;
    for(Node n=head; n!=null; n=n.next){
      if(n.element==elem){
        boo=true;
        break;
      }
    }
    return boo;
  }
  
  // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
  public Node copyList(){
    Node nTail=head;
    for(Node n=head.next; n!=null ; n=n.next){
      Node x=new Node (n.element,null);
      nTail.next=x; //connecting tail and x
      nTail=x;//or=x; //making x the new tail
    } 
    return head;
  }
  
  // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
  public Node reverseList(){
     Node nTail=head;
    for(Node n=head.next; n!=null ; n=n.next){
      Node x=new Node (n.element,null);
      x.next=nTail; //connecting tail and x
      nTail=x;//or=x; //making x the new tail
    } 
     head.next=null;
    return nTail;
  }
  
  /* inserts Node containing the given element at the given index
   * Check validity of index.
   */
  public void insert(Object elem, int idx){
    int x=countNode();
    if (idx>=0 && idx<=x){
      if(idx==0){
        Node n=new Node(elem, head);
        head=n;
      }else{
        Node n=new Node(elem, null);
        Node y= nodeAt(idx-1);
        n.next=y.next;
        y.next=n;
      }
    }else{
      System.out.println("Inavlid index. Insertion not possible.");
    }
  }
  
  
  /* removes Node at the given index. returns element of the removed node.
   * Check validity of index. return null if index is invalid.
   */
  public Object remove(int index){
     int x=countNode();
    if (index>=0 && index<x){
      Object o;
      if(index==0){
        o=head.element;
        Node y=head;
        head=head.next;
        y.next=null;
        y.element=null;
        y=null;
      }else{
        Node y= nodeAt(index-1);
        Node z= nodeAt(index);
        o=z.element;
        y.next=z.next;
        z.next=null;
        z.element=null;
        z=null;
      }
      return o; 
    }else{
      System.out.println("Inavlid index. Removal not possible.");
      return null; 
    }
    
  }
  
  // Rotates the list to the left by 1 position.
  public void rotateLeft(){
    int x=countNode();
    if(x>=2){
    Node y=head;
    Node z=nodeAt(x-1);
    z.next=head; //=y
    head=head.next;
    y.next=null;
    }
  }
  
  // Rotates the list to the right by 1 position.
  public void rotateRight(){
    int x=countNode();
    if(x>=2){
    Node z=nodeAt(x-2);
    z.next.next=head; 
    head=z.next;
    z.next=null;
    }
  }
  
}