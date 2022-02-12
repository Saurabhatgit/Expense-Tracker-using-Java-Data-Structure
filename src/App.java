import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static class food{
        String foodname;
        int amount;
    }
    static class entertainment{
        String purpose;
        int amount;
    }
    static class hng{
        String item;
        int amount;
    }
    static class bills{
        String type;
        int amount;
    }
    static class others{
        String mention;
        int amount;
    }
    static class month{
        String monthname;
        int budget;
        int spent;
        ArrayList<food> fList = new ArrayList<>();
        ArrayList<entertainment> eList = new ArrayList<>();
        ArrayList<hng> hList = new ArrayList<>();
        ArrayList<bills> bList = new ArrayList<>();
        ArrayList<others> oList = new ArrayList<>();
    }
    static month []mList = new month[12];
    static int budgetleft;
    static int sum;
    static int choice;
    static int monthnumber;
    static int cost;
    static String []months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    public static void main(String[] args){
        System.out.println("Welcome to your Personal Expense Tracking System");
        mainframe();
    }
    public static void mainframe() {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1.SELECT THE MONTH TO ADD EXPENSE");
            System.out.println("2.GET YOUR EXPENSE REPORT");
            System.out.println("3.EXIT");
            choice = sc.nextInt();
            if(choice==1){
                callmonth();
            }
            else if(choice==2){
                calculate();
            }
            else if(choice==3){
                System.exit(0);
            }
            else{
                System.out.println("Enter the correct choice");
            }
        }
    }
    public static void callmonth() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number corresponding to your month.For example 3 for March");
        monthnumber=sc.nextInt();
        expenseadder(monthnumber);
    }
    public static void expenseadder(int m){
        Scanner sc = new Scanner(System.in);
        month q = new month();
        sum = 0;
        q.monthname = months[m-1];
        System.out.println("Add your budget for the current month");
        budgetleft = sc.nextInt();
        System.out.println("Select the criteria of your expense");

        while(true){
            System.out.println("1.Food");
            System.out.println("2.Entertainment");
            System.out.println("3.House and Groceries");
            System.out.println("4.Bills");
            System.out.println("5.Others");
            System.out.println("6.Go to Main Dashboard");
            int e = sc.nextInt();
            if(e==1){
                food f = new food();
                System.out.println("Enter the details! for example 'momos'!");
                String s = sc.next();
                f.foodname=s;
                System.out.println("Enter the Expense");
                cost = sc.nextInt();
                f.amount=cost;
                q.fList.add(f);
                sum = sum+cost;
                budgetleft = budgetleft - cost;
                System.out.println("Money left in Wallet "+budgetleft);
            }
            else if(e==2){
                entertainment g = new entertainment();
                System.out.println("Enter the details! for example 'movie'");
                String s = sc.next();
                g.purpose = s;
                System.out.println("Enter the Expense");
                cost = sc.nextInt();
                g.amount=cost;
                q.eList.add(g);
                sum = sum+cost;
                budgetleft = budgetleft-cost;
                System.out.println("Money left in Wallet "+budgetleft);
            }
            else if(e==3){
                hng h = new hng();
                System.out.println("Enter the details! for example 'vegetables'");
                String s = sc.next();
                h.item = s;
                System.out.println("Enter the Expense");
                cost = sc.nextInt();
                h.amount = cost;
                q.hList.add(h);
                sum = sum+cost;
                budgetleft = budgetleft-cost;
                System.out.println("Money left in Wallet "+budgetleft);
            }
            else if(e==4){
                bills b = new bills();
                System.out.println("Enter the details! for example 'electricity bill'");
                String s = sc.next();
                b.type = s;
                System.out.println("Enter the Expense");
                cost = sc.nextInt();
                b.amount = cost;
                q.bList.add(b);
                sum = sum+cost;
                budgetleft = budgetleft-cost;
                System.out.println("Money left in Wallet "+budgetleft);
            }
            else if(e==5){
                others o = new others();
                System.out.println("Enter the details! for example 'Stationery'");
                String s = sc.next();
                o.mention = s;
                System.out.println("Enter the Expense");
                cost = sc.nextInt();
                o.amount = cost;
                q.oList.add(o);
                sum = sum+cost;
                budgetleft = budgetleft-cost;
                System.out.println("Money left in Wallet "+budgetleft);
            }
            else if(e==6){
                break;
            }
            else{
                System.out.println("Enter the correct choice");
            }
        }
        q.spent = sum;
        mList[m-1] = q;
    }
    public static void calculate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Expense Report Portal");
        System.out.println("Choose from the services below:");
        while(true){
            System.out.println("1.Month-wise Expense Report");
            System.out.println("2.Total Expense Report");
            System.out.println("3. Go to Main Dashboard!");
            int q = sc.nextInt();
            if(q==1){
                monthwise();
            }
            else if(q==2){
                totalreport();
            }
            else if(q==3){
                break;
            }
            else{
                System.out.println("Enter Correct Choice");
            }
        }
    }
    public static void monthwise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Month-Wise Report Portal");
        while(true){
            System.out.println("Select the Corresponding Month number! for example 4 for April");
            System.out.println("Press 0 to return to Expense Portal");
            int q = sc.nextInt();
            if(q==0){
                break;
            }
            else if(q>=1 && q<=12){
                report(q);
            }
            else{
                System.out.println("Enter the Correct Choice");
            }
        }
    }
    public static void report(int m) {
        Scanner sc = new Scanner(System.in);
        month q = mList[m-1];
        if(q==null){
            System.out.println("no expense added for this month");
            return;
        }
        String s = months[m-1];
        System.out.println("Your total Expense in "+s+"is "+q.spent);
        while(true){
            System.out.println("Choose your criteria to get this month's expense in that criteria");
            System.out.println("1.Food");
            System.out.println("2.Entertainment");
            System.out.println("3.Household and Groceries");
            System.out.println("4.Bills");
            System.out.println("5.Others");
            System.out.println("6.Press 0 to go Back");
            int n = sc.nextInt();
            if(n==0){
                break;
            }
            else if(n>=1 && n<=5){
                criteriareport(n,m);
            }
            else{
                System.out.println("Please Enter Correct Choice");
            }
        }
    }
    public static void criteriareport(int n, int m) {
        month q = mList[m-1];
        int fsum = 0;
        int esum = 0;
        int hsum = 0;
        int bsum = 0;
        int osum = 0;
        if(n==1){
            System.out.println("Your Expenses on Food in this Month:");
            for(int i=0;i<q.fList.size();i++){
                fsum = fsum+q.fList.get(i).amount;
                System.out.println(q.fList.get(i).foodname+" "+q.fList.get(i).amount);
            }
            System.out.println("Total Expense on food in this month "+fsum);
        }
        if(n==2){
            System.out.println("Your Expenses on Entertainment in this Month:");
            for(int i=0;i<q.eList.size();i++){
                esum = esum+q.eList.get(i).amount;
                System.out.println(q.eList.get(i).purpose+" "+q.eList.get(i).amount);
            }
            System.out.println("Total Expense on entertainment in this month "+esum);
        }
        if(n==3){
            System.out.println("Your Expenses on Household and Groceries in this Month:");
            for(int i=0;i<q.hList.size();i++){
                hsum = hsum+q.hList.get(i).amount;
                System.out.println(q.hList.get(i).item+" "+q.hList.get(i).amount);
            }
            System.out.println("Total Expense on household and groceries in this month "+hsum);
        }
        if(n==4){
            System.out.println("Your Expenses on Bills in this Month:");
            for(int i=0;i<q.bList.size();i++){
                bsum = bsum+q.bList.get(i).amount;
                System.out.println(q.bList.get(i).type+" "+q.bList.get(i).amount);
            }
            System.out.println("Total Expense on bills in this month "+bsum);
        }
        if(n==5){
            System.out.println("Your Other Expenses in this Month:");
            for(int i=0;i<q.oList.size();i++){
                osum = osum+q.oList.get(i).amount;
                System.out.println(q.oList.get(i).mention+" "+q.oList.get(i).amount);
            }
            System.out.println("Total other expenses in this month "+osum);
        }
    }
    public static void totalreport() {
        int totalspent = 0;
        for(int i=0;i<12;i++){
            if(mList[i]==null) continue;
            else{
                month q = mList[i];
                totalspent = totalspent + q.spent;
            }
        }
        System.out.println("Your expenses till date: "+ totalspent);
    }
}
