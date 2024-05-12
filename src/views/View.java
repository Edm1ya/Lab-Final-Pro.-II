package views;

import java.util.ArrayList;
import java.util.Scanner;
import controllers.AuthorController;
import controllers.EmployeeController;
import controllers.JobController;
import controllers.StoreController;
import controllers.TitleController;
import data.Store;

public class View {

    AuthorController authorController = new AuthorController();
    TitleController titleController = new TitleController();
    JobController jobController = new JobController();
    EmployeeController employeeController = new EmployeeController();
    StoreController storeController = new StoreController();

    public void ScreemConsumer() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Lista de tablas demográficas");
            System.out.println("2. Consumidor transaccional");
            System.out.println("3. Salir");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showDemographicTables();

                    break;
                case 2:
                    performTransactionalOperations();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 3);
        scanner.close();
    }

    public void showDemographicTables() {

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Lista de tablas demográficas:");
            System.out.println("[1] - Title");
            System.out.println("[2] - Authors / TitleAuthor");
            System.out.println("[3] - Job");
            System.out.println("[4] - Employee");
            System.out.println("[0] - Salir");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    TitleActions();
                    break;
                case 2:
                    AuthorActions();
                    break;
                case 3:
                    JobActions();
                    break;
                case 4:
                    EmployeeActions();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 0);
        scanner.close();
    }

    public void AuthorActions() {

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Autores:");
            System.out.println("[1] - Listar todos los autores");
            System.out.println("[2] - Buscar un autor");
            System.out.println("[0] - Salir");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Lista de Autores");
                    authorController.allAuthor();
                    break;
                case 2:
                    System.out.println("Ingresa un criterio para buscar al autor");
                    System.out.println("[Nombre o Apellido]\n");

                    scanner.nextLine();
                    authorController.SearchAuthor(scanner);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 0);
        scanner.close();
    }

    public void TitleActions() {

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Titulos:");
            System.out.println("[1] - Listar todos los titulos");
            System.out.println("[2] - Buscar un titulo");
            System.out.println("[0] - Salir");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Lista de Titulos");
                    titleController.allTitle();
                    break;
                case 2:
                    System.out.println("Ingresa un criterio para buscar al titulo");
                    System.out.println("[Titulo, Tipo, Preccio]\n");

                    scanner.nextLine();
                    titleController.SearchTitle(scanner);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 0);
        scanner.close();
    }

    public void JobActions() {

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Trabajos:");
            System.out.println("[1] - Listar todos los trabajos");
            System.out.println("[2] - Buscar un trabajo");
            System.out.println("[0] - Salir");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Lista de Trabajos");
                    jobController.allJob();
                    break;
                case 2:
                    System.out.println("Ingresa un criterio para buscar al trabajo");
                    System.out.println("[Desc, min, max]\n");

                    scanner.nextLine();
                    jobController.SearchJob(scanner);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 0);
        scanner.close();
    }

    public void EmployeeActions() {

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Empleados:");
            System.out.println("[1] - Listar todos los Empleados");
            System.out.println("[2] - Buscar un empleado");
            System.out.println("[0] - Salir");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Lista de Empleados");
                    employeeController.allEmployee();
                    break;
                case 2:
                    System.out.println("Ingresa un criterio para buscar al empleado");
                    System.out.println("[Nombre, Apellido]\n");

                    scanner.nextLine();
                    employeeController.SearchEmployee(scanner);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 0);
        scanner.close();
    }

    public void performTransactionalOperations() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ventas de libros por tienda");
            System.out.println("0. Salir");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    StoresList();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 0);
        scanner.close();
    }

    public void StoresList() {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Store> stores = new ArrayList<Store>();
        System.out.println("Lista de Tiendas");
        stores = storeController.NameStore();
        System.out.println("Seleccione una tienda");
        int indiceSeleccionado = scanner.nextInt();

        if (indiceSeleccionado >= 0 && indiceSeleccionado < stores.size()) {
            storeController.getStore(stores.get(indiceSeleccionado));
        } else {
            System.out.println("El índice ingresado no es válido.");
        }

    }

}
