package jana60;

import java.time.LocalDate;
import java.util.Scanner;

public class Agenzia {

	public static void main(String[] args) {
		/*
		 * Aggiungere una classe Agenzia con metodo main, dove chiediamo all’operatore
		 * se vuole inserire una nuova vacanza o uscire. Se vuole proseguire con
		 * l’inserimento va chiesta la destinazione, il giorno, mese e anno di partenza
		 * e il giorno, mese anno di ritorno. Con questi dati va generata una nuova
		 * vacanza e in console verrà stampato un messaggio del tipo: “Hai prenotato una
		 * vacanza di [durata della vacanza] a [destinazione] dal [data inizio
		 * formattata] al [data fine formattata]“. Se la creazione della vacanza genera
		 * un errore, il programma non deve interrompersi ma va gestito con dei messaggi
		 * di errore che permettono all’utente di capire cosa è andato storto e di
		 * ripetere l’inserimento.
		 */

		Scanner scan = new Scanner(System.in);
		System.out.println("Benvenuto a Java Travel");

		// destinazione
		System.out.println("Dove vuoi andare?");
		String destinazioneInput = scan.nextLine();

		// data inizio
		System.out.println("Quando vuoi partire?");
		System.out.print("Giorno: ");
		int giornoPartenza = scan.nextInt();
		System.out.print("Mese: ");
		int mesePartenza = scan.nextInt();
		System.out.print("Anno: ");
		int annoPartenza = scan.nextInt();
		LocalDate dataPartenza = null;
		try {
			dataPartenza = LocalDate.of(annoPartenza, mesePartenza, giornoPartenza);
		} catch (Exception e) {
			System.out.println("Data non valida");
		}

		// data fine
		System.out.println("Quando vuoi tornare?");
		System.out.print("Giorno: ");
		int giornoRitorno = scan.nextInt();
		System.out.print("Mese: ");
		int meseRitorno = scan.nextInt();
		System.out.print("Anno: ");
		int annoRitorno = scan.nextInt();
		LocalDate dataRitorno = null;
		try {
			dataRitorno = LocalDate.of(annoRitorno, meseRitorno, giornoRitorno);
		} catch (Exception e) {
			System.out.println("Data non valida");
		}

		// con i dati utente creo la vacanza
		try {
			Vacanza nuovaVacanza = new Vacanza(destinazioneInput, dataPartenza, dataRitorno);
			System.out.println("Hai prenotato una nuova vacanza di " + nuovaVacanza.getDurataString() + " a "
					+ nuovaVacanza.getDestinazione());
		} catch (NullPointerException e) {
			System.out.println("Tutti i dati devono essere compilati");
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Dati non validi");
			System.out.println(e.getMessage());
		}

		scan.close();
	}

}
