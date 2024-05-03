package principal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.print("ENTRE COM O SEU CEP: ");
		String cep = scanner.nextLine();

		try {

			// definindo o endereço da API
			URL url = new URL("https://viacep.com.br/ws/" + cep + "/xml/");

			// conectando com a url do viacep
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// tipo de chamada que será feito para a API
			connection.setRequestMethod("GET");

			// lendo a resposta obtida da API
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String resultado;
			while ((resultado = reader.readLine()) != null) {
				System.out.println(resultado);
			}

			reader.close();
		} catch (Exception e) {
			System.out.println("\nERRO: " + e.getMessage());
		}

		scanner.close();
	}

}
