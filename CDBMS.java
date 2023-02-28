//DBMS using java
//Using collection frameworks(inbuilt Linked List)
//Agrigate function : SUm 
import java.util.*;

class Student
{
    public String Sname;
    public int Marks;
    public int Rollno;

    public static int Generator;

    static      //Static block
    {
        Generator = 0;
    }

    
    public Student(String str, int no)//Paremeterised Constructor
    {
        this.Sname = str;
        this.Marks = no;
        Generator++;
        this.Rollno = Generator;
    }
    
    public void Display()
    {
        System.out.println("Roll no : "+Rollno+" Name : "+Sname+" Marks : "+Marks);
    }
}

class DBMS
{
    public LinkedList <Student> lobj;

    public DBMS()
    {
        lobj = new LinkedList();
    }

    public void  StartDBMS()
    {
        System.out.println("Marvellous Customised DBMS started successfully...");

        Scanner sobj = new Scanner(System.in);
        String Query = " ";
        int QuerySize = 0;

        while(true)
        {
            System.out.print("Marvellous DBMS : >");
            Query = sobj.nextLine();

            String Tokens[] = Query.split(" ");
            QuerySize = Tokens.length;

            if(QuerySize == 1)
            {
                if("help".equals(Tokens[0]))
                {
                    System.out.println("This application is used to demonstrate the features of customised DBMS");
                    System.out.println("Display all data : select * from Student");
                    System.out.println("Insert new Record : Insert into student values Name Marks");
                    System.out.println("Terminate the project : exit");
                }
                else if("exit".equals(Tokens[0]))
                {
                    System.out.println("Thank you for using our customised DBMS");
                    break;
                }
            }
            else if(QuerySize == 2)
            {

            }
            else if(QuerySize == 3)
            {

            }
            else if(QuerySize == 4)
            {
                if("select".equals(Tokens[0]))
                {
                    if("*".equals(Tokens[1]))
                    {
                        DisplayAll();
                    }
                }
            }
            else if(QuerySize == 6)
            {
                if("insert".equals(Tokens[0]))
                {
                    if("student".equals(Tokens[2]))
                    {
                        Insert(Tokens[4],Integer.parseInt(Tokens[5]));
                    }
                    
                }
            }
        }//end of while
    }//end of startdbms

    //All queries should be implemented here

    //insert into student values(______,______);
    public void Insert(String str, int no)        //To insert data in the table
    {
        Student sobj = new Student(str,no);
        lobj.add(sobj);
    }

    //select * from student
    public void DisplayAll()
    {
        for(Student sref : lobj)
        {
            sref.Display();
        }
    }
    //Selet * from student where roll no = 3
    public void DisplaySpecific(int value)
    {
        for(Student sref : lobj)
        {
            if(sref.Rollno == value)
            {
                sref.Display();
                break;
            }
        }
    }

    //Select * from student where Name = 'Rutuja'
    public void DisplaySpecific(String str)
    {
        for(Student sref : lobj)
        {
            if(str.equals(sref.Sname))
            {
                sref.Display();
                break;
            }
        }
    }

    //delete from student where Rollno = 3
    public void Delete(int no)
    {
        int index = 0;

        for(Student sref : lobj)
        {
            if(sref.Rollno == no)
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

    //delete from student where Sname = 'Ram'
    public void Delete(String str)
    {
        int index = 0;

        for(Student sref : lobj)
        {
            if(str.equals(sref.Sname))
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

    //Select *
    public void Sum()
    {
        int iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + (sref.Marks);
        }

        System.out.println("Summation of marks :"+iSum);
    }

    public void Max()
    {
        int iMax = 0;

        for(Student sref : lobj)
        {
            if(iMax < sref.Marks)
            {
                iMax = sref.Marks;
            }
        }
        System.out.println("The maximum marks are : "+iMax);
    }

    public void Min()
    {
        Student s = lobj.get(0);     //Return the data of first element
        int iMin = s.Marks;

        for(Student sref : lobj)
        {
            if(iMin > sref.Marks)
            {
                iMin = sref.Marks;
            }
        }
        System.out.println("The minimum marks are : "+iMin);
    }

    public void Average()
    {
        int iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + (sref.Marks);
        }

        System.out.println("Average of marks :"+(iSum / lobj.size()));
    }
}

class CDBMS
{
    public static void main(String a[])
    {
        DBMS dobj = new DBMS();

        dobj.StartDBMS();
        
    }
}