package jana60;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vacanza {
	/*
	 * Nel progetto java-travel-agency, creare la classe Vacanza caratterizzata da:
	 * - destinazione - data inizio - data fine Quando viene creata una nuova
	 * Vacanza vanno effettuati dei controlli: - destinazione, data inizio e data
	 * fine non possono essere null - la data inizio non può essere già passata - la
	 * data fine non può essere prima della data inizio Se fallisce la validazione
	 * vanno sollevate opportune eccezioni La classe Vacanza espone un metodo per
	 * calcolare la durata della vacanza (in giorni, mesi, anni).
	 */

	// attributi
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private String destinazione, dataInizio, dataFine;

	private LocalDate dataInizioForm = LocalDate.parse(dataInizio, format);
	private LocalDate dataFineForm = LocalDate.parse(dataFine, format);

	// costruttore
	public Vacanza(String destinazione, String dataInizio, String dataFine)
			throws IllegalArgumentException, NullPointerException {
		super();

		validaDestinazione(destinazione);
		validaDataInizio(dataInizio);
		validaDataFine(dataFine);

		this.destinazione = destinazione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	// getter e setter
	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String destinazione) throws NullPointerException {
		validaDestinazione(destinazione);
		this.destinazione = destinazione;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) throws IllegalArgumentException, NullPointerException {
		validaDataInizio(dataInizio);
		this.dataInizio = dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) throws IllegalArgumentException, NullPointerException {
		validaDataFine(dataFine);
		this.dataFine = dataFine;
	}

	// metodi di validazione
	private void validaDataInizio(String dataInizioInput) throws IllegalArgumentException, NullPointerException {
		LocalDate oggi = LocalDate.now();
		if (dataInizioInput == null) {
			throw new NullPointerException("Data inizio non può essere null");
		}
		if (LocalDate.parse(dataInizioInput, format).isBefore(oggi)) {
			throw new IllegalArgumentException("La data di partenza non può essere precendente alla data odierna");
		}
	}

	private void validaDataFine(String dataFineInput) throws IllegalArgumentException, NullPointerException {
		if (dataFineInput == null) {
			throw new NullPointerException("Data fine non può essere null");
		}
		if (LocalDate.parse(dataFineInput, format).isBefore(LocalDate.parse(dataInizio, format))) {
			throw new IllegalArgumentException("La data di ritorno non può essere precedente alla data di partenza");
		}
	}

	private void validaDestinazione(String destinazioneInput) {
		if (destinazioneInput == null) {
			throw new NullPointerException("La destinazione non può essere null");
		}
	}

}
