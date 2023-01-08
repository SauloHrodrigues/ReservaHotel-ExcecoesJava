package model.entidades;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer iNumeroDoQuarto;
	private Date dDataEntrada;
	private Date dDataSaida;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// Construtor
	public Reserva(Integer iNumeroDoQuarto, Date dDataEntrada, Date dDataSaida) {
		this.iNumeroDoQuarto = iNumeroDoQuarto;
		this.dDataEntrada = dDataEntrada;
		this.dDataSaida = dDataSaida;
	}

	

	// Gets and Seters
	public Integer getiNumeroDoQuarto() {
		return iNumeroDoQuarto;
	}

	public void setiNumeroDoQuarto(Integer iNumeroDoQuarto) {
		this.iNumeroDoQuarto = iNumeroDoQuarto;
	}

	public Date getdDataEntrada() {
		return dDataEntrada;
	}

	public Date getdDataSaida() {
		return dDataSaida;
	}

	// Metodos
	public long duracao() {
		long diferenca = dDataSaida.getTime() - dDataEntrada.getTime();// calcula diferencas em mileSegundos
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS); // converte Milesegundos em dias
	}

	public void atualizaDatas(Date dDataEntrada, Date dDataSaida) {
		this.dDataEntrada = dDataEntrada;
		this.dDataSaida = dDataSaida;
	}

	@Override
	public String toString() {
		return "Quarto " + iNumeroDoQuarto + ", entrada: " + sdf.format(dDataEntrada) + ", saída: "
				+ sdf.format(dDataSaida)+ ", "+duracao()+" noites.";
	}

}
