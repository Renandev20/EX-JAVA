import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    private static final List<User> users = new ArrayList<>();
    private static int idCounter = 1;

    private Main() {
        // Construtor privado para evitar instanciação externa
    }

    // Implementar o padrão Singleton para garantir que haja apenas uma instância do gerenciador de usuários
    private static Main instance;

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    public static void addUser(String name) {
        users.add(new User(idCounter++, name));
    }

    public static void listUsers() {
        for (User user : users) {
            System.out.println(user.getId() + " - " + user.getName());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha após a leitura do número

        for (int i = 0; i < quantity; i++) {
            String name = scanner.nextLine();
            addUser(name);
        }
         
        listUsers();
    }
}
