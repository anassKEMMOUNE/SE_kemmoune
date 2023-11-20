package MainPackage;




public class Main {
	public static void main(String args[]) {

        Place place1 = new Place(1, "Fes");
        Place place2 = new Place(2, "Casablanca");
        Trip trip1 = new Trip(1, "Fes", "Casablanca", 150.0);

        
        PlaceDAOImpl placeDao = new PlaceDAOImpl();
        placeDao.createPlace(place1);
        placeDao.createPlace(place2);

        Place retrievedPlace = placeDao.findPlaceById(1L);
        System.out.println("Retrieved Place: " + retrievedPlace);

        retrievedPlace.setName("Fes Prime");
        placeDao.updatePlace(retrievedPlace);

        System.out.println("Updated Place: " + placeDao.findPlaceById(1L));

        placeDao.removePlace(place1);
        System.out.println("Place after removal: " + placeDao.findPlaceById(1L));

        TripDAOImpl tripDao = new TripDAOImpl();
        tripDao.createTrip(trip1);

        Trip retrievedTrip = tripDao.findTripById(1L);
        System.out.println("Retrieved Trip: " + retrievedTrip);

        tripDao.removeTrip(trip1);
        System.out.println("Trip after removal: " + tripDao.findTripById(1L));
		
		
		
	}
}
