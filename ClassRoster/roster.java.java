package elice;

// For #5 - #8 implementation, 
// Once you correctly implement an iterator (#4),
// you can iterate the list with a foreach loop (refer to the display() method).
// Do not use a longhand version on KLMS>Week 7>Iterator slide #46
//(PDF page may be different).   

public class Roster {
   // instance variables
   private StackNode<Student> list;       // stack of students holds the entire list
   // Do not define other instance variables or methods.
   
   // Constructor initializes an empty list
   // Do not modify the following constructor
   // Do not add other constructors.
   public Roster() {
       list = new StackNode<Student>();
   }
   
   //HW3 #5
   public void add(String name, String num) {
       //implement here
       Student studentVariable = new Student(name,num);
       list.push(studentVariable);
      
   }
   
  
   //HW3 #6
   public String search(String name) {
       //implement here
       StackNode<Student> empty = new StackNode<>();
       Student placeholder = null;

       while (!list.isEmpty()) {
           Student eachstudent = list.pop();


           if (placeholder == null && eachstudent.equals(name)) {
               placeholder = eachstudent;
               break;
           }

           empty.push(eachstudent);



       } 
       while(!empty.isEmpty()) {
           list.push(empty.pop());
       }


       if (placeholder != null) {
           list.push(placeholder);
           return placeholder.getNum();
       } else {
           return null;
       }
       
      
   }
   
   //HW3 #7
   public Student remove(String name) {
       //implement here
       StackNode<Student> empty = new StackNode<>();
       Student placeholder = null;

       while (!list.isEmpty()) {
           Student eachstudent = list.pop();


           if (placeholder == null && eachstudent.equals(name)) {
               placeholder = eachstudent;
               break;
           }

           empty.push(eachstudent);



       } 
       while(!empty.isEmpty()) {
           list.push(empty.pop());
       }


       return placeholder;
       
      
    
   }
   
   //HW3 #8
   public void update(String name, String num) {
       //implement here
       Student updating =  new Student(name,num);
       StackNode<Student> empty = new StackNode<>();
       boolean placeholder = false;

       while (!list.isEmpty()) {
           Student eachstudent = list.pop();


           if (!placeholder && eachstudent.equals(name)) {
               placeholder = true;
               break;
           }

           empty.push(eachstudent);



       } 
       while(!empty.isEmpty()) {
           list.push(empty.pop());
       }


       list.push(updating);
       
     
   }
   
   // In this method, we use a foreach loop.
   // To do so, you must correctly implement the ListIterator in the StackNode class.(#4)
   // DO NOT MODIFY display() method
   public void display() { 
       if (list.isEmpty()) {
           System.out.println("Empty");
           return;
       }
       // iterate the data to display the list, using a foreach loop
       for (Student en : list) {
           System.out.println(en);
       }
   }
}