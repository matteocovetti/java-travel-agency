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
	private String destinazione;

	private LocalDate dataInizio;
	private LocalDate dataFine;

	// costruttore
	public Vacanza(String destinazione, LocalDate dataInizio, LocalDate dataFine)
			throws NullPointerException, IllegalArgumentException {
		super();
		// prima di assegnare i valori agli attributi li testo
		// prima di tutto controllo che non siano null
		if (destinazione == null) {
			throw new NullPointerException("Destinazione non può essere null");
		}
		if (dataInizio == null) {
			throw new NullPointerException("Data inizio non può essere null");
		}
		if (dataFine == null) {
			throw new NullPointerException("Data fine non può essere null");
		}

		// poi controllo che i valori siano validi
		// data inizio non passata
		if (dataInizio.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("Data inizio non può essee passata");
		}
		// data fine non precedente a data inizio
		if (dataInizio.isAfter(dataFine)) {
			throw new IllegalArgumentException("Data fine non può essere precedente a data inizio");
		}

		// se ho passato le validazioni inizializzo gli attributi dell'oggetto
		this.destinazione = destinazione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	// getter e setter

}
