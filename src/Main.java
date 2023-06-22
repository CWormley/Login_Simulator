import java.io.*;
import java.util.*;
public class Main {
    static File Library = new File("/Users/cj/IdeaProjects/Login/src/Library");
    static BufferedWriter typ;
    static {
        try {
            typ = new BufferedWriter(new FileWriter(Library, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static BufferedReader scn;
    static {
        try {
            scn = new BufferedReader(new FileReader(Library));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    ;
    static Scanner input = new Scanner(System.in);

    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        File Library = new File("/Users/cj/IdeaProjects/Login/src/Library");
        BufferedWriter typ = new BufferedWriter(new FileWriter(Library,true));
        BufferedReader scn = new BufferedReader(new FileReader(Library));
        Scanner input = new Scanner(System.in);
        System.out.println("press 1 to log in");
        System.out.println("press 2 to add user");
        int option = input.nextInt();
        while (option != 1 && option != 2) {
            System.out.println("invalid input \n try again");
            option = input.nextInt();
        }
        switch (option) {
            case 1:
                if (signIn(reader())) {
                    System.out.println("You are logged in!");
                }else{
                    System.out.println("Login failed");
                }
                break;
            case 2:
                writer();
                break;
        }
    }

    public static boolean duplicate(String name) throws IOException {
        BufferedReader scan = new BufferedReader(new FileReader(Library));
        String line = scan.readLine();
        boolean result = false;
        while(!result && line != null){
            if(name.equals(line)){
                result = true;
            }
            line = scan.readLine();
            line = scan.readLine();

        }
        return result;
    }
    public static void writer() throws IOException {
        System.out.println("enter username");
        String name = input.nextLine();
        while(duplicate(name)){
            System.out.println("username is already taken \n try again");
            name = input.nextLine();
        }
        typ.write(name + "\n");
        System.out.println("enter your password");
        String password = input.nextLine();
        typ.write(password + "\n");
        typ.close();
    }
    public static List<User> reader() throws IOException {
        List<User> index = new ArrayList<>();
        String name = scn.readLine();
        while(name != null){
            String pass = scn.readLine();
            index.add(new User(name,pass));
            name = scn.readLine();
        }
        return index;
    }
    public static boolean signIn(List<User> index){
        boolean check = false;
        String password = null;
        while(!check) {
            System.out.println("enter user name");
            String username = input.nextLine();
            for (User i : index) {
                if (Objects.equals(i.name, username)) {
                    password = i.pass;
                    check = true;
                    break;
                }
            }
        }
        check = false;
        System.out.println("enter password");
        int n = 3;

        while(n>=0){
            String answer = input.nextLine();
            if(Objects.equals(answer, password)){
                check = true;
                break;
            }
            n--;
            System.out.println("incorrect \n" + n + " more tries remaining" );

        }

        return check;

    }

}

