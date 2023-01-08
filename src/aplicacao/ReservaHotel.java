package aplicacao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;

public class ReservaHotel {

	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("******************************************");
		System.out.println("************ Reserva de Hotel ************");
		System.out.printf("******************************************\n\n\n");
		
		System.out.print("Digite o número do quarto: ");
		int iNumeroDoQuarto = input.nextInt();
		
		System.out.print("Digite a data de entrada(dd/mm/aaaa): ");
		Date dDataDeEntrada = sdf.parse(input.next());
		
		System.out.print("Digite a data de saída(dd/mm/aaaa): ");
		Date dDataDeSaida = sdf.parse(input.next());
		if(!dDataDeSaida.after(dDataDeEntrada)) {
			System.out.println("Erro na reserva: Data de entrada posterior a data de saída!");
		}else {
			Reserva reserva = new Reserva(iNumeroDoQuarto, dDataDeEntrada, dDataDeSaida);
			System.out.println("Reserva realizada: "+reserva);
			System.out.println();
			
			System.out.println("Atualize a reserva:");
			System.out.print("Digite o número do quarto: ");
			iNumeroDoQuarto = input.nextInt();
			System.out.print("Digite a data de entrada(dd/mm/aaaa): ");
			dDataDeEntrada = sdf.parse(input.next());			
			System.out.print("Digite a data de saída(dd/mm/aaaa): ");
			dDataDeSaida = sdf.parse(input.next());
			Date dHoje = new Date();
			
			if(dDataDeEntrada.before(dHoje)|| dDataDeSaida.before(dHoje)) {
				System.out.println("Erro na reserva: As datas devem ser futuras!");
			}else if(!dDataDeSaida.after(dDataDeEntrada)) {
				System.out.println("Erro na reserva: Data de entrada posterior a data de saída!");
			}else {
				reserva.atualizaDatas(dDataDeEntrada, dDataDeSaida);			
				System.out.println("Reserva realizada: "+reserva);
			}
		}
		
		
		input.close();
	}

}
