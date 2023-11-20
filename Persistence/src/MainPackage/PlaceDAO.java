package MainPackage;

import java.util.List;

public interface PlaceDAO<T> {
	
	public int createPlace(T obj);
	
	public T findPlaceById(Long id);
	
	boolean updatePlace(T obj);
	
	boolean removePlace(T obj);
	
	public List<T> getAll();



	
}


