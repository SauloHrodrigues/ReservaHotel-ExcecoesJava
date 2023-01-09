package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;
import model.excecoes.DominioExcecoes;

public class ReservaHotel {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("******************************************");
		System.out.println("************ Reserva de Hotel ************");
		System.out.printf("******************************************\n\n\n");
		try {
			System.out.print("Digite o número do quarto: ");
			int iNumeroDoQuarto = input.nextInt();
	
			System.out.print("Digite a data de entrada(dd/mm/aaaa): ");
			Date dDataDeEntrada = sdf.parse(input.next());
	
			System.out.print("Digite a data de saída(dd/mm/aaaa): ");
			Date dDataDeSaida = sdf.parse(input.next());
	
			Reserva reserva = new Reserva(iNumeroDoQuarto, dDataDeEntrada, dDataDeSaida);
			System.out.println("Reserva realizada: " + reserva);
	
			System.out.println();
			System.out.println("Atualize a reserva:");
			System.out.print("Digite a data de entrada(dd/mm/aaaa): ");
			dDataDeEntrada = sdf.parse(input.next());
			System.out.print("Digite a data de saída(dd/mm/aaaa): ");
			dDataDeSaida = sdf.parse(input.next());
			
			reserva.atualizaDatas(dDataDeEntrada, dDataDeSaida);
			System.out.println("Reserva: " + reserva);
		}
		catch(ParseException e){
			System.out.println("Formato da data inválida");
		}
		catch(DominioExcecoes e) {
			System.out.println("Erro na reserva: "+ e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado.");
		}
		input.close();
	}

}
