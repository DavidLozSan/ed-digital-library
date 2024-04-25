package com.iesam.library.features.user.presentation;

import com.iesam.library.features.user.data.UserDataRepository;
import com.iesam.library.features.user.data.local.UserFileLocalDataSource;
import com.iesam.library.features.user.domain.*;

import java.util.List;
import java.util.Scanner;

public class UserPresentation {
    public static void save() {
        SaveUserUseCase saveUserUseCase = new SaveUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el codigo del usuario");
        String codigo = sc.nextLine();
        System.out.println("Dame el dni del usuario");
        String dni = sc.nextLine();
        System.out.println("Dame el nombre del usuario");
        String nombre = sc.nextLine();
        System.out.println("Dame el apellidos del usuario");
        String apellidos = sc.nextLine();
        System.out.println("Dame el fecha de expedición del usuario");
        String fechaExped = sc.nextLine();
        System.out.println("Dame el email del usuario");
        String email = sc.nextLine();
        System.out.println("Dame el telefono del usuario");
        String telefono = sc.nextLine();
        User user = new User(codigo, dni, nombre, apellidos, fechaExped, email, telefono);
        saveUserUseCase.execute(user);
    }


    public static void obtainUsers() {
        GetUsersUseCase getUsersUseCase = new GetUsersUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        List<User> users = getUsersUseCase.execute();
        System.out.println(users);
    }

    public static void obtain() {
        GetUserUseCase getUserUseCase = new GetUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el codigo del usuario que quieres encontrar");
        String codigo = sc.nextLine();
        User user = getUserUseCase.execute(codigo);
        System.out.println(user);
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código del usuario a dar de baja");
        String codigo = sc.nextLine();
        DeleteUserUseCase deleteUserUseCase = new DeleteUserUseCase(new UserDataRepository(
                new UserFileLocalDataSource()));
        deleteUserUseCase.execute(codigo);
    }

    public static void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código del usuario a modificar");
        String codigo = sc.nextLine();
        UpdateUserUserCase updateUserUserCase = new UpdateUserUserCase(new UserDataRepository(new UserFileLocalDataSource()));
    }
}
