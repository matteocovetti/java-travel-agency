package jana60;

import java.time.LocalDate;
import java.time.Period;

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

	private String destinazione;

	private LocalDate dataInizio;
	private LocalDate dataFine;

	// costruttore
	public Vacanza(String destinazione, LocalDate dataInizio, LocalDate dataFine)
			throws NullPointerException, IllegalArgumentException {
		super();
		// prima di assegnare i valori agli attributi li testo
		// prima di tutto controllo che non siano null
//		if (destinazione == null) {
//			throw new NullPointerException("Destinazione non può essere null");
//		}
//		if (dataInizio == null) {
//			throw new NullPointerException("Data inizio non può essere null");
//		}
//		if (dataFine == null) {
//			throw new NullPointerException("Data fine non può essere null");
//		}
//
//		// poi controllo che i valori siano validi
//		// data inizio non passata
//		if (dataInizio.isBefore(LocalDate.now())) {
//			throw new IllegalArgumentException("Data inizio non può essee passata");
//		}
//		// data fine non precedente a data inizio
//		if (dataInizio.isAfter(dataFine)) {
//			throw new IllegalArgumentException("Data fine non può essere precedente a data inizio");
//		}

		validaDestinazione(destinazione);
		validaData(dataInizio);
		validaData(dataFine);
		validaDataInizioDataFine(dataInizio, dataFine);

		// se ho passato le validazioni inizializzo gli attributi dell'oggetto
		this.destinazione = destinazione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	// getter e setter

	public String getDestinazione() {
		return destinazione;
	}

	// se posso modificare il valore di destinazione lo devo prima validare
	public void setDestinazione(String destinazione) throws NullPointerException {
		validaDestinazione(destinazione);
		this.destinazione = destinazione;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) throws NullPointerException, IllegalArgumentException {
		validaData(dataInizio);
		validaDataInizioDataFine(dataInizio, getDataFine());
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) throws NullPointerException, IllegalArgumentException {
		validaData(dataFine);
		validaDataInizioDataFine(this.dataInizio, dataFine);
		this.dataFine = dataFine;
	}

	// metodi public
	public Period getDurata() {
		return Period.between(this.dataInizio, this.dataFine);
	}

	public String getDurataString() {
		Period durata = getDurata();
		String durataString = "";
		if (durata.getYears() > 0) {
			durataString += durata.getYears() + " anni";
		}
		if (durata.getMonths() > 0) {
			durataString += durata.getMonths() + " mesi";
		}
		durataString += durata.getDays() + " giorni";

		return durataString;
	}

	// metodi private
	private void validaDestinazione(String destinazione) throws NullPointerException {
		if (destinazione == null) {
			throw new NullPointerException("Destinazione non può essere null");
		}
	}

	private void validaData(LocalDate data) throws NullPointerException, IllegalArgumentException {
		if (data == null) {
			throw new NullPointerException("Data non può essere null");
		}
		if (data.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("Data non può essee passata");
		}
	}

	private void validaDataInizioDataFine(LocalDate dataInizio, LocalDate dataFine) throws IllegalArgumentException {
		if (dataInizio.isAfter(dataFine)) {
			throw new IllegalArgumentException("Data fine non può essere precedente a data inizio");
		}
	}

}
