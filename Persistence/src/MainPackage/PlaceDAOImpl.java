package MainPackage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaceDAOImpl extends AbstractDAOA implements PlaceDAO<Place> {
	
	
	

	@Override
	public int createPlace(Place obj) {
		PreparedStatement pst = null;
        String sql = "insert into Place (id,name) values (?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setLong(1, obj.getId());
            pst.setString(2, obj.getName());
      

            pst.executeUpdate();
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }
		return 0;
	}

	@Override
	public boolean updatePlace(Place obj) {
		PreparedStatement pst = null;
		String sql = "update Place set name=? where id=?";
		
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, obj.getName());
			pst.setLong(2, obj.getId());
			pst.executeUpdate();
			return true;
			
		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
			return false;
		}
			
		
		
	}

	@Override
	public boolean removePlace(Place obj) {
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
	public Place findPlaceById(Long id) {
		PreparedStatement pst = null;
        ResultSet rs;
        String sql = "select *from produit where id= ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setLong(1, id);
            rs = pst.executeQuery();
            
            return new Place(rs.getLong("id"), rs.getString("name"));
            
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }
        return null;
	}

	@Override
	public List<Place> getAll() {
		List<Place> list = new ArrayList<Place>();
        PreparedStatement pst = null;
        ResultSet rs;
        String sql = "select *from Place";
        try {
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                // System.out.println(rs.getLong("id") + "" + rs.getString("designation"));
                list.add(new Place(rs.getLong("id"), rs.getString("name")));
            }
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }
        return list;		
	}

	

	
}
