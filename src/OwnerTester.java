import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.Car;
import model.ListDetails;
import model.Owner;

public class OwnerTester {

	public static void main(String[] args) {
		Owner james = new Owner("James");
		ListDetailsHelper ldh = new ListDetailsHelper();
		Car bugatti = new Car("Bugatti", "Veyron", 2011);
		Car taurus = new Car("Ford", "Taurus", 1998);
		
		List<Car> jamesCars = new ArrayList<Car>();
		jamesCars.add(bugatti);
		jamesCars.add(taurus);
		
		ListDetails jamesList = new ListDetails("James' Cars", LocalDate.now(), james);
		jamesList.setListOfCars(jamesCars);
		ldh.insertNewListDetails(jamesList);
		
		List<ListDetails> allLists = ldh.getLists();
		for (ListDetails a : allLists) {
			System.out.println(a);
		}
	}

}
