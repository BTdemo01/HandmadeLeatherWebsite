package Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CSDL {
private static Connection getConnection() throws 
ClassNotFoundException, SQLException {
 Class.forName("com.mysql.jdbc.Driver");
 Connection 
conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/banhang","root","180504");
 return conn;
}
public List<Hanghoa> getAllProduct() throws SQLException {
Connection cnn=null;
PreparedStatement ps=null;
ResultSet rs=null;
List<Hanghoa> lsthh=new ArrayList<Hanghoa>();
try 
{
cnn=this.getConnection();
String sql="Select * from hanghoa";
ps=cnn.prepareStatement(sql);
rs=ps.executeQuery();
while (rs.next()) 
	{
	lsthh.add(new Hanghoa(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8)));
	}
	return lsthh;
		
} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		finally {
		 if(ps!=null)
		 ps.close();
		 if(cnn!=null)
		 cnn.close();
		 }
		return null;
		}
		public List<Hanghoa> getTrendingProduct() throws 
		SQLException {
		Connection cnn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Hanghoa> lsthh=new ArrayList<Hanghoa>();
		try {
		cnn=this.getConnection();
		String sql="Select * from hanghoa where xuhuong=1";
		ps=cnn.prepareStatement(sql);
		rs=ps.executeQuery();
		while (rs.next()) {
		lsthh.add(new 
		Hanghoa(rs.getString(1),rs.getString(2),rs.getInt(3),rs.
		getString(4),rs.getString(5),rs.getString(6),rs.getInt(7
		),rs.getInt(8)));
		}
		return lsthh;
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		finally {
		 if(ps!=null)
		 ps.close();
		 if(cnn!=null)
		 cnn.close();
		 }
		return null;
		}
		public List<Hanghoa> getPopularProduct() throws 
		SQLException {
		Connection cnn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Hanghoa> lsthh=new ArrayList<Hanghoa>();
		try {
		cnn=this.getConnection();
		String sql="Select * from hanghoa where phobien=1";
		ps=cnn.prepareStatement(sql);
		rs=ps.executeQuery();
		while (rs.next()) {
		lsthh.add(new 
		Hanghoa(rs.getString(1),rs.getString(2),rs.getInt(3),rs.
		getString(4),rs.getString(5),rs.getString(6),rs.getInt(7
		),rs.getInt(8)));
		}
		return lsthh;
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		finally {
		 if(ps!=null)
		 ps.close();
		 if(cnn!=null)
		 cnn.close();
		 }
		return null;
		}
		public List<Hanghoa> getProductById(String id) 
		throws SQLException {
		Connection cnn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Hanghoa> lsthh=new ArrayList<Hanghoa>();
		try {
		cnn=this.getConnection();
		String sql="Select * from hanghoa where mahh=?";
		ps=cnn.prepareStatement(sql);
		ps.setString(1,id);
		rs=ps.executeQuery();
		while (rs.next()) 
		{
		lsthh.add(new Hanghoa(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8)));
		}
		return lsthh;
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			finally {
			 if(ps!=null)
			 ps.close();
			 if(cnn!=null)
			 cnn.close();
			 }
			return null;
			}
			public int insertProduct(Hanghoa h) throws 
			SQLException {
			int rows=0;
			Connection cnn=null;
			PreparedStatement ps=null;
			try {
			cnn=this.getConnection();
			String sql="insert into Hanghoa(mahh,tenhh,dongia,xuatxu,loaihh,hinh,xuhuong,phobien) values(?,?,?,?,?,?,?,?)";
			ps=cnn.prepareStatement(sql);
			ps.setString(1,h.getMahh());
			ps.setString(2,h.getTenhh());
			ps.setInt(3,h.getDongia());
			ps.setString(4,h.getXuatxu());
			ps.setString(5,h.getLoaihh());
			ps.setString(6,h.getHinh());
			ps.setInt(7,h.getXuhuong());
			ps.setInt(8,h.getPhobien());
			rows= ps.executeUpdate();
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}finally {
			 if(ps!=null)
				 ps.close();
			 if(cnn!=null)
			 cnn.close();
			 }
			return rows;
	}
}
