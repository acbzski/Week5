import java.util.List;
import java.util.Scanner;

import controller.CarHelper;
import model.Car;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static CarHelper ch = new CarHelper();

		private static void addACar() {
			System.out.print("Enter the make: ");
			String make = in.nextLine();
			System.out.print("Enter the model: ");
			String model = in.nextLine();
			System.out.println("Enter the year: ");
			int year = in.nextInt();
			Car toAdd = new Car(make, model, year);
			ch.insertItem(toAdd);
		}

		private static void deleteACar() {
			System.out.print("Enter the make to delete: ");
			String make = in.nextLine();
			System.out.print("Enter the model to delete: ");
			String model = in.nextLine();
			System.out.println("Enter the year to delete: ");
			int year = in.nextInt();
			Car toDelete = new Car(make, model, year);
			ch.deleteCar(toDelete);
		}

		private static void editACar() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Make");
			System.out.println("2 : Search by Model");
			System.out.println("3 : Search by Year");
			int searchBy = in.nextInt();
			in.nextLine();
			
			List<Car> foundCars;
			if (searchBy == 1) {
				System.out.print("Enter the make: ");
				String makeName = in.nextLine();
				foundCars = ch.searchForCarByMake(makeName);
			} else if (searchBy == 2) {
				System.out.print("Enter the item: ");
				String modelName = in.nextLine();
				foundCars = ch.searchForCarByModel(modelName);
			} else {
				System.out.print("Enter the year: ");
				int year = in.nextInt();
				foundCars = ch.searchForCarByYear(year);
			}

			if (!foundCars.isEmpty()) {
				System.out.println("Found Results.");
				for (Car c : foundCars) {
					System.out.println(c.getId() + " : " + c.returnItemDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Car toEdit = ch.searchForCarById(idToEdit);
				System.out.println("Retrieved " + toEdit.getYear() + " " + toEdit.getMake() + " " + toEdit.getModel());
				System.out.println("1 : Update Make");
				System.out.println("2 : Update Model");
				System.out.println("3 : Update Year");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Make: ");
					String newMake = in.nextLine();
					toEdit.setMake(newMake);
				} else if (update == 2) {
					System.out.print("New Model: ");
					String newModel = in.nextLine();
					toEdit.setModel(newModel);
				} else if (update == 3) {
					System.out.print("New Year: ");
					int newYear = in.nextInt();
					toEdit.setYear(newYear);
				}

				ch.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}
		}

		public static void main(String[] args) {
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("~~~ Welcome to our car showroom! ~~~");
			while (goAgain) {
				System.out.println("*  Select an option:");
				System.out.println("*  1 -- Add a car");
				System.out.println("*  2 -- Edit a car");
				System.out.println("*  3 -- Delete a car");
				System.out.println("*  4 -- View the selection");
				System.out.println("*  5 -- Exit the showroom");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				
				in.nextLine();

				if (selection == 1) {
					addACar();
				} else if (selection == 2) {
					editACar();
				} else if (selection == 3) {
					deleteACar();
				} else if (selection == 4) {
					viewTheList();
				} else {
					ch.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<Car> allCars = ch.showAllCars();
			for(Car singleCar : allCars) {
				System.out.println(singleCar.returnItemDetails());
			}
		}

	}
