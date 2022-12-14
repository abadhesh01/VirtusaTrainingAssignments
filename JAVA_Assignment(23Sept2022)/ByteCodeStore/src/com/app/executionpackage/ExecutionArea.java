package com.app.executionpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.app.model.Customer;
import com.app.model.Movie;
import com.app.model.Prime;
import com.app.model.Product;
import com.app.service.Service;
import com.app.service.ServiceImpl;

public class ExecutionArea {

	public static void main(String[] args) throws Exception {
		
		System.out.println("\nByteCode Electronics Pvt. Ltd. (Estd: 26th June 2022)");
		System.out.println("---------------------------------------------------------\n\n");

		// Scanner object for taking inputs from keyboard.
		java.util.Scanner scanner = new java.util.Scanner(System.in);

		// Service object to perform user operations.
		Service service = new ServiceImpl();

		// Setting up current year.
		service.setCurrentYear(2022);

		// Creating a list of sample customers.
		// All customers with even number ids have premium subscription.
		List<Customer> customers = new ArrayList<Customer>();
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				customers.add(new Customer(i, "Customer " + i, "customer" + i + "@email.com", new Prime(2022)));
				continue;
			}
			customers.add(new Customer(i, "Customer " + i, "customer" + i + "@email.com", null));
		}

		// Creating a list of sample products.
		List<Product> products = new ArrayList<Product>();
		Collections.addAll(products, new Product(1, "Desktop", "DSKT001",
				"Display: 11.6 in\n\t\t\tRAM:2GB\n\t\t\tStorage: 128 GB\n\t\t\tProcessor: Shakti Basic-1", 10_000, 10),
				new Product(2, "Laptop", "LTP001",
						"Display: 11.6 in\n\t\t\tRAM: 2GB\n\t\t\tStorage: 128 GB\n\t\t\tProcessor: Shakti Basic-1",
						13_000, 15),
				new Product(3, "Smartphone", "SMPH001",
						"Display: 3.5 in\n\t\t\tRAM: 2GB\n\t\t\tStorage: 32 GB\n\t\t\tProcessor: HALO-1", 5000, 20),
				new Product(4, "Desktop", "DSKT002",
						"Display: 13 in\n\t\t\tRAM: 4GB\n\t\t\tStorage: 256 GB\n\t\t\tProcessor: Shakti Basic-2",
						20_000, 25),
				new Product(5, "Laptop", "LTP002",
						"Display: 13 in\n\t\t\tRAM: 4GB\n\t\t\tStorage: 256 GB\n\t\t\tProcessor: Shakti Basic-2",
						23_000, 30),
				new Product(6, "Smartphone", "SMPH002",
						"Display: 4 in\n\t\t\tRAM: 4GB\n\t\t\tStorage: 64 GB\n\t\t\tProcessor: HALO-2", 10_000, 35),
				new Product(7, "Desktop", "DSKT003",
						"Display: 17 in\n\t\t\tRAM: 8GB\n\t\t\tStorage: 500 GB\n\t\t\tProcessor: Shakti Ultra", 30_000,
						40),
				new Product(8, "Laptop", "LTP003",
						"Display: 17 in\n\t\t\tRAM: 8GB\n\t\t\tStorage: 500 GB\n\t\t\tProcessor: Shakti Ultra", 33_000,
						45),
				new Product(9, "Smartphone", "SMPH003",
						"Display: 4 in\n\t\t\tRAM: 6GB\n\t\t\tStorage: 128 GB\n\t\t\tProcessor: HALO Ultimate", 15_000,
						50),
				new Product(10, "Headphone", "HDPHNONE", "Wired with wire length 1m.", 500, 100));

		// Creating a list of sample movies.
		List<Movie> movies = new ArrayList<Movie>();
		Collections.addAll(movies, new Movie(1, "John Rambo [First Blood 2]"), new Movie(2, "Rambo 2"),
				new Movie(3, "Rambo 3"), new Movie(4, "Rambo 4"), new Movie(5, "Rambo 5 [The last blood]"));

		// Adding sample customers to database.
		service.setCustomers(customers);

		// Adding sample products to database.
		service.setProducts(products);

		// Adding sample movies to database.
		service.setMovies(movies);

		// Assigning null to lists.
		customers = null;
		products = null;
		movies = null;

		boolean nextIteration = true;
		while (nextIteration) {
			System.out
					.println("\n[1] Show products.\n[2] Show customer's cart.\n[3] Add a product to customer's cart.");
			System.out.println("[4] Remove a product from customer's cart.\n[5] Buy\n[6] Show purchase history.");
			System.out.print("[7] Watch movie.\n[8] Exit\nEnter your choice: ");
			try {
				int choice = Integer.parseInt(scanner.nextLine());
				switch (choice) {
				case 1:
					System.out.print(
							"\n[1] Smartphones\n[2] Laptops\n[3] Desktops \n[4] Headphones\nEnter your choice: ");
					int choice2 = Integer.parseInt(scanner.nextLine());
					if (choice2 == 1)
						service.searchProduct("smartphone");
					else if (choice2 == 2)
						service.searchProduct("laptop");
					else if (choice2 == 3)
						service.searchProduct("desktop");
					else if (choice2 == 4)
						service.searchProduct("headphone");
					else
						throw new Exception("Invalid choice !!!");
					break;

				case 2:
					System.out.print("\nEnter your id: ");
					long customerId = Long.parseLong(scanner.nextLine());
					if (customerId <= 0)
						throw new Exception("Customer id cannot be zero(0) or negative! :(");
					service.displayCart(customerId);
					break;

				case 3:
					System.out.print("\nEnter your id: ");
					customerId = Long.parseLong(scanner.nextLine());
					if (customerId <= 0)
						throw new Exception("Customer id cannot be zero(0) or negative! :(");
					System.out.print("\nEnter product id: ");
					long productId = Long.parseLong(scanner.nextLine());
					if (productId <= 0)
						throw new Exception("Product id cannot be zero(0) or negative! :(");
					System.out.print("\nEnter the number of quantity you want to buy: ");
					int count = Integer.parseInt(scanner.nextLine());
					if (count <= 0)
						throw new Exception("Quantity to be added to your cart cannot be zero(0) or negative! :(");
					service.addProductToCart(customerId, productId, count);
					break;

				case 4:
					System.out.print("\nEnter your id: ");
					customerId = Long.parseLong(scanner.nextLine());
					if (customerId <= 0)
						throw new Exception("Customer id cannot be zero(0) or negative! :(");
					System.out.print("\nEnter product id: ");
					productId = Long.parseLong(scanner.nextLine());
					if (productId <= 0)
						throw new Exception("Product id cannot be zero(0) or negative! :(");
					service.removeProductFromCart(customerId, productId);
					break;

				case 5:
					System.out.print("\nEnter your id: ");
					customerId = Long.parseLong(scanner.nextLine());
					if (customerId <= 0)
						throw new Exception("Customer id cannot be zero(0) or negative! :(");
					String bill[] = service.displayCart(customerId);
					if (bill == null)
						break;
					System.out.print("Enter your payment INR: ");
					Long cashINR = Long.parseLong(scanner.nextLine());
					service.buy(customerId, cashINR, bill);
					break;

				case 6:
					System.out.print("\nEnter your id: ");
					customerId = Long.parseLong(scanner.nextLine());
					if (customerId <= 0)
						throw new Exception("Customer id cannot be zero(0) or negative! :(");
					service.showPurchaseHistory(customerId);
					break;

				case 7:
					System.out.print("\nEnter your id: ");
					customerId = Long.parseLong(scanner.nextLine());
					if (customerId <= 0)
						throw new Exception("Customer id cannot be zero(0) or negative! :(");
					movies = service.getMovies();
					System.out.println();
					for (Movie movie : movies) {
						System.out.println("[" + movie.getId() + "] " + movie.getMovieName());
					}
					System.out.print("Enter your choice: ");
					long movieId = Long.parseLong(scanner.nextLine());
					if (movieId <= 0)
						throw new Exception("Movie id cannot be zero(0) or negative! :(");
					service.watchMovie(customerId, movieId);
					break;

				case 8:
					nextIteration = false;
					scanner.close();
					System.out.println("\nBye! :)");
					break;

				default:
					System.out.println("\nInvalid choice !!!");
				}
			} catch (Exception exception) {
				System.out.println("\n" + exception.getMessage());
			}
		}

	}

}
