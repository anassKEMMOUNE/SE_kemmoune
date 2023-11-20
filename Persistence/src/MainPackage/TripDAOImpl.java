package MainPackage;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class TripDAOImpl extends AbstractDAOA implements TripDAO<Trip> {
	
	
	
	
	@Override
	public int createTrip(Trip obj) {
		PreparedStatement pst = null;
        String sql = "insert into Trip (id,departure,destination,price) values (?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setLong(1, obj.getId());
            pst.setString(2, obj.getDeparture());
            pst.setString(3, obj.getDestination());
            pst.setDouble(4, obj.getPrice());
      

            pst.executeUpdate();
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }
		return 0;
	}

	

	@Override
	public boolean removeTrip(Trip obj) {
		PreparedStatement pst = null;
        String sql = "delete *from Place where id= ?";
        try {
            pst = connection.prepareStatement(sql);	
            pst.setLong(1, obj.getId());
            pst.executeUpdate();
            return true;
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
            return false;
        }
	}

	@Override
	public Trip findTripById(Long id) {
		PreparedStatement pst = null;
        ResultSet rs;
        String sql = "select *from produit where id= ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setLong(1, id);
            rs = pst.executeQuery();
            
            return new Trip(rs.getLong("id"), rs.getString("departure"), rs.getString("destination"),rs.getDouble("price"));
            
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }
        return null;
	}

	
	
}
