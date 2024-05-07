package com.iesam.library.features.user.presentation;

import com.iesam.library.features.user.data.UserDataRepository;
import com.iesam.library.features.user.data.local.UserFileLocalDataSource;
import com.iesam.library.features.user.domain.*;

import java.util.List;
import java.util.Scanner;

public class UserPresentation {
    public static void userMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n---------------------------------");
        System.out.println("\nMenú usuarios:\n");
        System.out.println("1. Añadir usuario");
        System.out.println("2. Buscar usuario (por su código)");
        System.out.println("3. Mostrar todos los usuarios");
        System.out.println("4. Borrar a un usuario");
        System.out.println("5. Modificar a un usuario");
        System.out.println("0. Salir");
        System.out.println("\n---------------------------------");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                save();
                break;
            case 2:
                obtain();
                break;
            case 3:
                obtainUsers();
                break;
            case 4:
                delete();
                break;
            case 5:
                update();
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Esa opción no es válida");
                break;
        }
    }

    public static void save() {
        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource());
        SaveUserUseCase saveUserUseCase = new SaveUserUseCase(userDataRepository);
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código del usuario");
        String code = sc.nextLine();
        System.out.println("Dame el dni del usuario");
        String dni = sc.nextLine();
        System.out.println("Dame el nombre del usuario");
        String name = sc.nextLine();
        System.out.println("Dame el apellidos del usuario");
        String surnames = sc.nextLine();
        System.out.println("Dame el fecha de expedición del usuario");
        String expeditionDate = sc.nextLine();
        System.out.println("Dame el email del usuario");
        String email = sc.nextLine();
        System.out.println("Dame el telefono del usuario");
        String phone = sc.nextLine();
        User user = new User(code, dni, name, surnames, expeditionDate, email, phone);
        saveUserUseCase.execute(user);
    }


    public static void obtainUsers() {
        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource());
        GetUsersUseCase getUsersUseCase = new GetUsersUseCase(userDataRepository);
        List<User> users = getUsersUseCase.execute();
        System.out.println(users);
    }

    public static void obtain() {
        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource());
        GetUserUseCase getUserUseCase = new GetUserUseCase(userDataRepository);
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código del usuario que quieres encontrar");
        String code = sc.nextLine();
        User user = getUserUseCase.execute(code);
        System.out.println(user);
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código del usuario a dar de baja");
        String code = sc.nextLine();
        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource());
        DeleteUserUseCase deleteUserUseCase = new DeleteUserUseCase(userDataRepository);
        deleteUserUseCase.execute(code);
    }

    public static void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código del usuario a modificar");
        String code = sc.nextLine();
        System.out.println("Dame el dni del usuario");
        String dni = sc.nextLine();
        System.out.println("Dame el nombre del usuario");
        String name = sc.nextLine();
        System.out.println("Dame el apellidos del usuario");
        String surnames = sc.nextLine();
        System.out.println("Dame el fecha de expedición del usuario");
        String expeditionDate = sc.nextLine();
        System.out.println("Dame el email del usuario");
        String email = sc.nextLine();
        System.out.println("Dame el telefono del usuario");
        String phone = sc.nextLine();
        User user = new User(code, dni, name, surnames, expeditionDate, email, phone);
        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource());
        UpdateUserUserCase updateUserUserCase = new UpdateUserUserCase(userDataRepository);
        updateUserUserCase.execute(user);
    }
}
