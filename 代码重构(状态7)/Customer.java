package �����ع�;

import java.util.*;

class Customer {
		private String _name;
		private Vector<Rental> _rentals = new Vector<Rental>() ;

		public Customer (String name) {
			_name = name;
		}

		public void addRental(Rental arg) {
			_rentals.addElement(arg);
		}

		public String getName() {
			return _name;
		}
		public String statement() {
			int frequentRenterPoints = 0;
			Enumeration<Rental> rentals = _rentals.elements();
			String result = "Rental Record for " + getName() + "\n";
			while (rentals.hasMoreElements()) {
				Rental each = (Rental) rentals.nextElement();
				frequentRenterPoints+=each.getFrequentRenterPoints();
//show figures for this rental
				result += "\t" + each.getMovie().getTitle()+ "\t" +String.valueOf(each.getCharge()) + "\n";
			}

//add footer lines

			result += "Amount owed is "+String.valueOf(getTotalCharge())+ "\n";
			result += "You earned " + String.valueOf(frequentRenterPoints)+
			          "frequent renter points";
			return result;

		}
		private double getTotalCharge(){
			double result=0;
			Enumeration rentals=_rentals.elements();
			while(rentals.hasMoreElements()){
				Rental each=(Rental)rentals.nextElement();
				result+=each.getCharge();
			}
			return result;
		}

}