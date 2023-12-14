package ex4.Helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class SeedData {
	static enum Entities {
		TODO, USER, PHOTO, ALBUM, COMMENT, POST
	};

	public static String callHttpRequestByHttpClient(String url) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		String res = "";
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			if (response.statusCode() == HttpURLConnection.HTTP_OK) {
				res = response.body();
			}
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public SeedData() {
		// TODO Auto-generated constructor stub
		super();
	}

	public static String createInsertPostQuery(JSONObject post) {
		String query = "INSERT INTO post (user_id, title, body) " + "VALUES ( %d, '%s', '%s');\n";
		return String.format(query, post.getInt("userId"), escapeString(post.getString("title")),
				escapeString(post.getString("body")));
	}

	public static String createInsertUserQuery(JSONObject user) {
		String query = "INSERT INTO user (name, username, email, street, suite, city, zipcode, lat, lng, phone, website, company_name, catch_phrase, bs) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', %f, %f, '%s', '%s', '%s', '%s', '%s');\n";
		JSONObject address = user.getJSONObject("address");
		JSONObject geo = address.getJSONObject("geo");
		JSONObject company = user.getJSONObject("company");

		return String.format(query, escapeString(user.getString("name")), escapeString(user.getString("username")),
				escapeString(user.getString("email")), escapeString(address.getString("street")),
				escapeString(address.getString("suite")), escapeString(address.getString("city")),
				escapeString(address.getString("zipcode")), geo.getDouble("lat"), geo.getDouble("lng"),
				escapeString(user.getString("phone")), escapeString(user.getString("website")),
				escapeString(company.getString("name")), escapeString(company.getString("catchPhrase")),
				escapeString(company.getString("bs")));
	}

	public static String createListInsertTodoQuery(JSONArray todos) {
		StringBuilder query = new StringBuilder("");
		for (Object object : todos) {
			query.append(createInsertTodoQuery((JSONObject) object));
		}
		return query.toString();

	}

	public static String createListInsertUserQuery(JSONArray users) {
		StringBuilder query = new StringBuilder("");
		for (Object object : users) {
			query.append(createInsertUserQuery((JSONObject) object));
		}
		return query.toString();

	}

	public static String createListInsertPhotoQuery(JSONArray photos) {
		StringBuilder query = new StringBuilder("");
		for (Object object : photos) {
			query.append(createInsertPhotoQuery((JSONObject) object));
		}
		return query.toString();

	}

	public static String createListInsertPostQuery(JSONArray posts) {
		StringBuilder query = new StringBuilder("");
		for (Object object : posts) {
			query.append(createInsertPostQuery((JSONObject) object));
		}
		return query.toString();

	}

	public static String createListInsertCommentQuery(JSONArray comments) {
		StringBuilder query = new StringBuilder("");
		for (Object object : comments) {
			query.append(createInsertCommentQuery((JSONObject) object));
		}
		return query.toString();

	}

	public static String createListInsertAlbumQuery(JSONArray albums) {
		StringBuilder query = new StringBuilder("");
		for (Object object : albums) {
			query.append(createInsertAlbumQuery((JSONObject) object));
		}
		return query.toString();

	}

	public static String createInsertAlbumQuery(JSONObject album) {
		String query = "INSERT INTO album (user_id,title) " + "VALUES (%d, '%s');\n";

		return String.format(query, album.getInt("userId"), escapeString(album.getString("title")));
	}

	public static String createInsertCommentQuery(JSONObject comment) {
		String query = "INSERT INTO comment (post_id, name, email, body) " + "VALUES (%d, '%s', '%s', '%s');\n";

		return String.format(query, comment.getInt("postId"), escapeString(comment.getString("name")),
				escapeString(comment.getString("email")), escapeString(comment.getString("body")));
	}

	public static String createInsertPhotoQuery(JSONObject photo) {
		String query = "INSERT INTO photo (album_id, title, url, thumbnail_url) " + "VALUES (%d, '%s', '%s', '%s');\n";

		return String.format(query, photo.getInt("albumId"), escapeString(photo.getString("title")),
				escapeString(photo.getString("url")), escapeString(photo.getString("thumbnailUrl")));
	}

	public static String createInsertTodoQuery(JSONObject todo) {
		String query = "INSERT INTO todo (user_id, title, completed) " + "VALUES (%d, '%s', %s);\n";

		return String.format(query, todo.getInt("userId"), escapeString(todo.getString("title")),
				todo.getBoolean("completed"));
	}

	// Helper method to escape single quotes in strings for SQL
	private static String escapeString(String input) {
		return input.replace("'", "''").replace("\n", "\\n");
	}

	private static String createListInsertQuery(JSONArray dataArray, Entities entityType) {
		StringBuilder query = new StringBuilder("");
		switch (entityType) {
		case TODO:
			query.append(createListInsertTodoQuery(dataArray));
			break;
		case USER:
			query.append(createListInsertUserQuery(dataArray));
			break;
		case PHOTO:
			query.append(createListInsertPhotoQuery(dataArray));
			break;
		case ALBUM:
			query.append(createListInsertAlbumQuery(dataArray));
			break;
		case COMMENT:
			query.append(createListInsertCommentQuery(dataArray));
			break;
		case POST:
			query.append(createListInsertPostQuery(dataArray));
			break;
		}
		return query.toString();
	}

	private static String createListInsertQueryFromURL() {
		StringBuilder query = new StringBuilder("");
		String todoApiUrl = "https://jsonplaceholder.typicode.com/todos";
		String userApiUrl = "https://jsonplaceholder.typicode.com/users";
		String photoApiUrl = "https://jsonplaceholder.typicode.com/photos";
		String albumApiUrl = "https://jsonplaceholder.typicode.com/albums";
		String commentApiUrl = "https://jsonplaceholder.typicode.com/comments";
		String postApiUrl = "https://jsonplaceholder.typicode.com/posts";
		query.append(createListInsertQuery(new JSONArray(callHttpRequestByHttpClient(userApiUrl)), Entities.USER));
		query.append(createListInsertQuery(new JSONArray(callHttpRequestByHttpClient(albumApiUrl)), Entities.ALBUM));
		query.append(createListInsertQuery(new JSONArray(callHttpRequestByHttpClient(postApiUrl)), Entities.POST));
		query.append(createListInsertQuery(new JSONArray(callHttpRequestByHttpClient(photoApiUrl)), Entities.PHOTO));
		query.append(
				createListInsertQuery(new JSONArray(callHttpRequestByHttpClient(commentApiUrl)), Entities.COMMENT));
		query.append(createListInsertQuery(new JSONArray(callHttpRequestByHttpClient(todoApiUrl)), Entities.TODO));
		return query.toString();
	}

	public static Map<String, String> readConfig() {
		Map<String, String> config = new HashMap<>();
		try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/application.yml"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.trim().startsWith("hostname :")) {
					config.put("hostname", line.trim().substring("hostname :".length()).trim());
				} else if (line.trim().startsWith("username :")) {
					config.put("username", line.trim().substring("username :".length()).trim());
				} else if (line.trim().startsWith("password :")) {
					config.put("password", line.trim().substring("password :".length()).trim());
				}
				// Add more properties as needed
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return config;
	}

	public static void run() throws IOException {
		try {
			Map<String, String> config = readConfig();

			// Access the properties
			String host = config.get("hostname");
			String username = config.get("username");
			String password = config.get("password");

			Path path = Paths.get("src/main/resources/initdb.sql");
			Path temp = Paths.get("src/main/resources/temp.sql");
			String query = Files.readString(path);
			Files.writeString(temp, query.concat(createListInsertQueryFromURL()));
			System.out.println("Crawl data successfully");
			String os = System.getProperty("os.name").toLowerCase();

			try {
				String command = "mysql -h %s -u %s %s < src//main//resources//temp.sql";
				command = String.format(command, host, username, password.isEmpty() ? "" : "-p " + password);
				if (os.contains("win")) {
					// Windows
					command = "cmd.exe%/c%" + command;
				} else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
					// Unix-like systems (Linux, MacOS)
					command = "/bin/bash%-c%" + command;
				} else {
					System.out.println("Unsupported operating system: " + os);
					return;
				}

				// Run the command
				ProcessBuilder processBuilder = new ProcessBuilder(command.split("%"));
				processBuilder.redirectErrorStream(true);

				Process process = processBuilder.start();

				// Wait for the process to finish
				int exitCode = process.waitFor();

				if (exitCode == 0) {
					System.out.println("Command executed successfully.");
				} else {
					System.out.println("Error executing command. Exit code: " + exitCode);
				}

			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
			Files.delete(temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Now calling Files.readString() method to
		// read the file

	}

	public static void main(String[] args) throws IOException {
		System.out.println("Seedding data");
		run();
		System.out.println("Successfull");
	}

}
