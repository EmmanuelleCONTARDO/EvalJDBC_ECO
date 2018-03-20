import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Application {

	private static void updateShoes(Connection c, String model, String material, String color, double price,
			double shoe_size) throws SQLException {
	
		System.out.println("UPDATE SHOES");
		String query = "UPDATE shoes SET  model=?, material=?, color=?, price=?, shoe_size=? WHERE model=?";
	
		
		try (PreparedStatement state =c.prepareStatement(query)){

			
			state.setString(1, model);
			state.setString(2, material);
			state.setString(3, color);
			state.setDouble(4, price);
			state.setDouble(5, shoe_size);
			state.setString(6, model);
			//state.executeUpdate(); exécuté en dessous
			int rowsUpdated = state.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Tu as mis à jour ta liste de chaussures !");
			}
		} catch (SQLException e) {
			System.out.println("connexion update shoes KO");
		}

	}

	private static void addShoes(Connection c, String model, String material, String color, double price,
			double shoe_size) {
		String query = "INSERT INTO shoes (model, material, color, price, shoe_size) " + "VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement state = c.prepareStatement(query)) {
			
			state.setString(1, model);
			state.setString(2, material);
			state.setString(3, color);
			state.setDouble(4, price);
			state.setDouble(5, shoe_size);
			state.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}

	public static boolean ifExistModel(Connection c, String model) throws SQLException {
		Statement state = c.createStatement();
		ResultSet rs = state.executeQuery("SELECT * FROM shoes WHERE model = '" + model + "' order by model;" );
		int cpt = 0;
		while (rs.next()) {
			cpt++;
		}
		return cpt > 0 ? true : false;
	}

	private static void printShoes(Connection c) throws SQLException {
		
		try {

			// Création d'un objet Statement
			Statement state1 = c.createStatement();
			// L'objet ResultSet contient le résultat de la requête SQL
			ResultSet result = state1.executeQuery("SELECT * FROM shoes order by model");
			// On récupère les MetaData
			ResultSetMetaData resultMeta = result.getMetaData();

			System.out.println("\n**********************************");
			// On affiche le nom des colonnes
			for (int i = 1; i <= resultMeta.getColumnCount(); i++)
				System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

			System.out.println("\n**********************************");

			while (result.next()) {
				for (int i = 1; i <= resultMeta.getColumnCount(); i++)
					System.out.print("\t" + result.getObject(i).toString() + "\t |");

				System.out.println("\n---------------------------------");
			}
			result.close();
			state1.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("null")
	public static void deleteShoes(Connection c, String model, String material, String color, double price,
			double shoe_size) throws SQLException {
		String query = "DELETE FROM shoes WHERE model = ?;";

		try (PreparedStatement state = c.prepareStatement(query)) {
			state.setString(1, model);
			int i = state.executeUpdate();
			System.out.println("------");
			if (i > 0) {
				System.out.println("Cette paire est bien supprimée. Tu peux t'en racheter une autre paire !!!");
			} else {
				System.out.println("cette paire n'existe pas/plus");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}

	public static void main(String[] args) throws SQLException, IOException {

		Scanner sc = new Scanner(System.in);
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://baasu.db.elephantsql.com:5432",
				"tlsrvyik", "GWKAf0uVvl67lknatUenJbiLBLm-yb6R"); Statement state = conn.createStatement()) {
			System.out.println("connexion APP OK");

			String choice = "";

			do {
				// Display menu in console
				System.out.println();
				System.out.println("Bonjour et bienvenue dans l'application Mon dressing");
				System.out.println("------------------------------------------------------");
				System.out.println("0- Quitter le programme");
				System.out.println("1- Ajouter une paire de chaussures.");
				System.out.println("2- Modifier une paire de chaussures.");
				System.out.println("3- Supprimer une paire de chaussures.");
				System.out.println("4- Afficher la liste des chaussures.");

				Shoes shoes = new Shoes();
				try {
					// Get menu choice from console
					choice = sc.nextLine();
					switch (choice) {
					case "1": // Ajout d'une paire de chaussures
						System.out.println("Ajouter un model : ");
						shoes.setModel(sc.nextLine());

						System.out.println("Ajouter un material : ");
						shoes.setMaterial(sc.nextLine());

						System.out.println("Ajouter un color : ");
						shoes.setColor(sc.nextLine());

						System.out.println("Ajouter un price : ");
						shoes.setPrice(sc.nextDouble());
						System.out.println("Ajouter une shoe_size : ");
						shoes.setShoe_size(sc.nextDouble());

						addShoes(conn, shoes.getModel(), shoes.getMaterial(), shoes.getColor(), shoes.getPrice(),
								shoes.getShoe_size());
						System.out.println("Ta nouvelle paire a bien été créée !");

						break;

					case "2": //Mise à jour d'une paire de chaussures
						System.out.println("Le model : ");
						shoes.setModel(sc.nextLine());

						if (ifExistModel(conn, shoes.getModel())) {

							System.out.println("Le material : ");
							shoes.setMaterial(sc.nextLine());

							System.out.println("La color : ");
							shoes.setColor(sc.nextLine());

							System.out.println("Le price : ");
							shoes.setPrice(sc.nextDouble());
							System.out.println();
							System.out.println("La shoe_size : ");
							shoes.setShoe_size(sc.nextDouble());
							System.out.println();

							updateShoes(conn, shoes.getModel(), shoes.getMaterial(), shoes.getColor(), shoes.getPrice(),
									shoes.getShoe_size());
							System.out.println("Ta paire de chaussures a été modifiée.");

						} else {
							System.out.println("Model inexistant !");
						}
						break;

					case "3": //Suppression d'une paire de chaussures (pour en ajouter une autre !!)

						System.out.println("Quel model veux tu supprimer ?");
						shoes.setModel(sc.nextLine());
						deleteShoes(conn, shoes.getModel(), shoes.getMaterial(), shoes.getColor(), shoes.getPrice(),
								shoes.getShoe_size());
						break;

					case "4":// affiche sous forme de liste toutes les paires de chaussures

						printShoes(conn);
						System.out.println("Et voilà toutes tes chaussures !!!");
						
						break;

					case "0":
						System.out.println("bye bye!");
						break;

					}

				} catch (IndexOutOfBoundsException e) {
					System.out.println(e);
					System.out.println("Fermeture du programme.");
					choice = "0";
				}

				// while menu choice is not "0" we keep printing the menu
			} while (!choice.equals("0"));

			ResultSet rs = state.executeQuery("SELECT * FROM shoes order by sh_id");

			while (rs.next()) {
				// Retrieve by column name
				int sh_id = rs.getInt("sh_id");
				String model = rs.getString("model");
				String material = rs.getString("material");
				String color = rs.getString("color");
				Double price = rs.getDouble("price");
				Double shoe_size = rs.getDouble("shoe_size");
				// int id_favouritestore = rs.getInt("id_favouritestore");

				// Display values quand je sélectionne "0".
				System.out.print("ID: " + sh_id);
				System.out.print(", Model : " + model);
				System.out.print(", Material : " + material);
				System.out.print(", Color : " + color);
				System.out.print(", Price : " + price);
				System.out.println(", Shoe size : " + shoe_size);
				// System.out.println(", id_favouritestore : " + id_favouritestore);

			}

			System.out.println("Tout ça !!!");
		}
	}
}
