import java.util.*;
class OnlineExam
{
    Scanner obj = new Scanner(System.in);
    HashMap<String, Integer> ms = new HashMap<String, Integer>();

        public void Slogin()
        {
            ms.put("surabhi", 12345);
            System.out.println("\nThis is the Online Examination Portal!!");
            String Uname;
            System.out.println("Enter your Username:");
            Uname = obj.next();
            int pssd;
            System.out.println("Enter your Password:");
            pssd = obj.nextInt();
             if(ms.get(Uname)==pssd)
             {
                System.out.println("\n Welcome!!");
                Options_Menu();
             }
             else
             {
                System.out.println("Invalid username or password...Please try again!!");
             }
        }
        public void Options_Menu()
        {
            int Choice;
            System.out.println("Menu");
            System.out.println("\n\n1. Profile Update \n2. Start Exam \n3.Logout");
            System.out.println("Enter Your Choice:");
            Choice = obj.nextInt();
            switch(Choice)
            {
                case 1:
                    ms = Update_Details();
                    Options_Menu();
                    break;
                case 2:
                    Examination();
                    Options_Menu();
                    break;
                case 3:
                    System.out.println("You have successfully Logged Out!!");
                    System.exit(0);
                    break;
                default:
                System.out.println("Invalid Choice!!..Please Choose Again from the menu!");
            }
        }
        public HashMap<String, Integer> Update_Details()
        {
            String update_name;
            int update_pwd;
            System.out.println("Update your Profile Details");
            System.out.println("Enter Username");
            update_name = obj.next();
             if(ms.containsKey(update_name))
             {
                System.out.println("Enter New Password");
                update_pwd = obj.nextInt();
                ms.replace(update_name, update_pwd);
                System.out.println("Your credentials have been successfully updated!!");
             }
             else
             {
                System.out.println("Incorrect Username or Password!!");
             }
             return ms;
        }

        public void Examination()
        {
           // Calendar cr = Calendar.getInstance();
            long StartTime = System.currentTimeMillis();
            long EndTime = StartTime+30;
            int AnsweredQueries = 0;
            int UserAnswer, MarksSecured;
            System.out.println("You can begin you examination!");
            System.out.println("Please Follow the Instructions Carefully!!");
            System.out.println("You will have 30 seconds to answer 5 questions!");
            System.out.println("Each question carries a total of 10 marks!");
            System.out.println("There will also be a negative marking(-5) for every wrong answer!");
            HashMap<String, ArrayList<String>> queries = new HashMap<String, ArrayList<String>>();

            ArrayList<String> Ques1 = new ArrayList<String>();
            Ques1.add("O(n)");
            Ques1.add("O(1)");
            Ques1.add("O(logn)");
            Ques1.add("O(n-1)");
            Ques1.add("1");
            queries.put("state the time complexity of an ordered array ?",Ques1);
            
            ArrayList<String> Ques2 = new ArrayList<String>();
            Ques2.add("Set");
            Ques2.add("HashMap");
            Ques2.add("List");
            Ques2.add("Collection");
            Ques2.add("1");
            queries.put("HashSet Internally uses ?",Ques2);

            ArrayList<String> Ques3 = new ArrayList<String>();
            Ques3.add("Generics");
            Ques3.add("Abstract Classes");
            Ques3.add("Interfaces");
            Ques3.add("Collection");
            Ques3.add("1");
            queries.put("What gurantees type-safety in a collection ?",Ques3);

            ArrayList<String> Ques4 = new ArrayList<String>();
            Ques4.add("Treeset");
            Ques4.add("LinkedHashSet");
            Ques4.add("HashSet");
            Ques4.add("None");
            Ques4.add("1");
            queries.put("Which does not permit to store a null value ?",Ques4);

            ArrayList<String> Ques5 = new ArrayList<String>();
            Ques5.add("ArrayList");
            Ques5.add("LinkedList");
            Ques5.add("AbstractList");
            Ques5.add("None");
            Ques5.add("3");
            queries.put("Vector extends which of these ?",Ques5);

            int sno = 0;
            Set<String> set = queries.keySet();
            ArrayList<String> al = new ArrayList<>(set);
            int x = al.size();

            while(System.currentTimeMillis()< EndTime || sno < x)
            {
                String i =  al.get(sno);
                System.out.println("\n \n Q." + (sno+1)+")" +i);
                System.out.println("\n(1)" +queries.get(i).get(0)+"\t"+"(2)"+queries.get(i).get(1)+"\t"+"(3) "+queries.get(i).get(2)+"\t"+"(4) "+queries.get(i).get(3)+" ");
                System.out.println("Enter options!");
                UserAnswer = obj.nextInt();
                System.out.println("Your Test has been submitted successfully and cannot be changed!!");
                 if(UserAnswer == Integer.parseInt(queries.get(i).get(4)))
                 {
                    AnsweredQueries++;
                 }
                 sno++;
            }
            System.out.println("You have completed the online examination!!");
            MarksSecured = AnsweredQueries * 10-((5-AnsweredQueries)*5);
            System.out.println("Your total score is: " + " "+MarksSecured+ " out of 50");
        }

        public static void main(String[] args)
        {
            OnlineExam oe = new OnlineExam();
            oe.Slogin();
        }
}