package MainPackage;



public interface TripDAO<T> {
	
	public int createTrip(T obj);
	
	public T findTripById(Long id);
	
	boolean removeTrip(T obj);
	
	
}