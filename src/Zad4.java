import java.lang.String;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Zad4 {

	private static Scanner scanner;
	public static void main(String[] args) {
		ArrayList<InVoice> inVoice = new ArrayList<InVoice>();
		
		boolean exit = true,	ifID=true;
		int		parmID,			parmAmount;			double parmPrice;	String parmDescription;
		int 	menu = 9,		printProduct = 0;
		Scanner scanner = new Scanner(System.in);	
		
		do{	
			System.out.println("MENU:");
			System.out.println("\tWcisnij \"1\" aby dodac nowy przedmiot.");
			System.out.println("\tWcisnij \"2\" aby wyswietlic przedmiot.");
			System.out.println("\tWcisnij \"3\" aby usunac przedmiot." );
			System.out.println("\tWcisnij \"4\" aby wyœwietliæ wszystkie przdmioty");
			System.out.println("\tWcisnij \"9\" aby Zakoñczyæ program." );
			
			System.out.println("Size of Array: " + inVoice.size());
			menu=ScannerInt();
		
			switch(menu){
			case 1:{
				System.out.println("Podaj ID nowego produktu: ");
				do{
					parmID = ScannerInt();
					ifID=false;
					for (int i = 0; i < inVoice.size();i++){
						if(inVoice.get(i).ID == parmID){
							System.out.println("Jest ju¿ produkt z takim ID\nPodaj inne ID:");
							ifID=true;	break;
						}
					}
				}while(ifID);	ifID=true;
				
				System.out.println("Wprowadz opis przedmiotu");
				parmDescription = scanner.nextLine();
								
				System.out.println("Wprowadz ilosc kupionych sztuk");
				parmAmount = ScannerInt();
				
				System.out.println("Wprowadz cene za sztukê.");
				parmPrice = ScannerDouble();
				
				inVoice.add(new InVoice(parmID,parmDescription,parmAmount,parmPrice));	
				break;
			}
			case 2:{
				
				if(inVoice.isEmpty()){
					System.out.println("Lista jest pusta");
					break;
				}

				System.out.println("Wybierz ID przedmiotu ktory chcesz wyswietlic");
			
				do{
					printProduct = ScannerInt();
					ifID=false;
					for (int i = 0; i < inVoice.size();i++){
						if(inVoice.get(i).ID == printProduct){
							printProduct = i;
							ifID=true;	break;
						}else if( (i + 1) == inVoice.size() ){
							System.out.println("Nie ma przedmiotu z takim ID, wybierz prawid³owe.");						
						}
					}
				}while(!ifID);	ifID=true;
				//System.out.println("Lista to: " + inVoice.get(printProduct));
				System.out.println("ID to: " + inVoice.get(printProduct).getID());
				System.out.println("Opis to: " + inVoice.get(printProduct).getDescription());
				System.out.println("Ilosc to: " + inVoice.get(printProduct).getAmount());
				System.out.println("Cena to: " + inVoice.get(printProduct).getPrice());
				System.out.println("Wartoœæ wszystkich produktów: " + inVoice.get(printProduct).getInVoiceAmount(inVoice.get(printProduct).getAmount(),inVoice.get(printProduct).getPrice()));
				break;
			}
			case 3:{
				System.out.println("Wybierz ID przedmiotu który chcesz usun¹æ");
				
				do{
					printProduct = ScannerInt();
					ifID=false;
					for (int i = 0; i < inVoice.size();i++){
						if(inVoice.get(i).ID == printProduct){
							printProduct = i;
							ifID=true;	break;
						}else if( (i + 1) == inVoice.size() ){
							System.out.println("Nie ma przedmiotu z takim ID, wybierz prawid³owe.");						
						}
					}
				}while(!ifID);	ifID=true;
				
				inVoice.remove(printProduct);
				
				break;
			}
			case 4:{
				for(int i=0;i<inVoice.size();i++){
					
					System.out.println("ID \t" + (i+1) + ".go przedmiotu to: " + inVoice.get(i).getID());
					System.out.println("Opis \t" + (i+1) + ".go przedmiotu to: " + inVoice.get(i).getDescription());
					System.out.println("Ilosc \t" + (i+1) + ".go przedmiotu to: " + inVoice.get(i).getAmount());
					System.out.println("Cena \t" + (i+1) + ".go przedmiotu to: " + inVoice.get(i).getPrice());
					System.out.println("Wartoœæ wszystkich przedmiotów o tym ID to: " + inVoice.get(i).getInVoiceAmount(inVoice.get(i).getAmount(),inVoice.get(i).getPrice()) + "\n");
					
				}
				break;
			}
			case 9:{
				exit = false;
				System.out.println("Do widzenia :)");
				break;
			}
			default:{
				System.out.println("Z³y wybór, popraw siê!");
				break;
			}
			}
		}while(exit);			
		scanner.close();
	}
	
	public static int ScannerInt(){
		 scanner = new Scanner(System.in);	
		do{	
			try{
				return scanner.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Podany argument nie jest liczb¹.\nPodaj jeszcze raz.");
				scanner.next();
			}
		}while(true);
		
	};
	public static double ScannerDouble(){
		scanner = new Scanner(System.in);	
		do{	
			try{
				return scanner.nextDouble();
			}catch(InputMismatchException e){
				System.out.println("Podany argument nie jest liczb¹.\nPodaj jeszcze raz.");
				scanner.next();
			}
		}while(true);		
	};	
}
