package cl.uchile.cc68j.restobar.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

public class Reservation extends Model {
	static private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");

	static public String tableName = "RESERVATIONS";
	static private String insertQuery = "INSERT INTO RESERVATIONS(TABLE_ID, NAME, AT, EXTRAS) VALUES (?, ?, ?, ?)";
	static private String updateQuery = "UPDATE RESERVATIONS SET TABLE_ID = ?, NAME = ?, AT = ?, EXTRAS = ? WHERE ID = ?";
	static private String deleteQuery = "DELETE FROM RESERVATIONS WHERE ID = ?";
	static private String generatedColumns[] = {"ID"};
	
	private String name;
	private String extras;
	private Timestamp at;
	private int tableId;
	private Table table;

	protected Reservation(ResultSet row) {
		super(row);
		try {
			id = row.getInt("id");
			name = row.getString("name");
			extras = row.getString("extras");
			at = row.getTimestamp("at");
			tableId = row.getInt("table_id");
		} catch (SQLException e) {
		}
	}

	public Reservation() {}

	@Override
	protected boolean insert() {
		try {
			
			Connection conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(insertQuery, generatedColumns);
					
			st.setInt(1, tableId);
			st.setString(2, name);
			st.setTimestamp(3, at);
			st.setString(4, extras);
		
			st.executeUpdate();
		
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			this.id = rs.getInt(1);
		
			return true;
		} catch (SQLException ex) {
			return false;
		}	}

	@Override
	protected boolean update() {
		try {
			Connection conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(updateQuery);
		
			st.setInt(1, tableId);
			st.setString(2, name);
			st.setTimestamp(3, at);
			st.setString(4, extras);
			
			st.setInt(5, id);
			
			System.out.println(st.toString());
		
			st.executeUpdate();
		
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean delete() {
		try {
			Connection conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(deleteQuery);
		
			st.setInt(1, id);
		
			st.executeUpdate();
		
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean valid() {
		if (at == null || name == null || name.length() == 0) return false;
			
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public String getAt() {
		if (at == null)
			return "";
		else
			return dateFormat.format(at);
	}

	public void setAt(String at) {
		try {
			this.at = new Timestamp(dateFormat.parse(at).getTime());
		} catch (ParseException e) {
			this.at = null;
		}
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public Table getTable() {
		if (table == null && tableId > 0) {
			table = Table.find(tableId);
		}
		
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
		this.tableId = table.getId();
	}
	
	static public Vector<Reservation> findAll() {
		Vector<Reservation> result = new Vector<Reservation>();
		
		try {
			Statement st = DB.getConnection().createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM RESERVATIONS");
			
			while (rs.next()) {
				result.add(new Reservation(rs));
			}
		} catch (SQLException ex) {}
		
		return result;
	}

	public static Reservation find(long id) {
		try {
			PreparedStatement st = DB.getConnection().prepareStatement(
					"SELECT * FROM RESERVATIONS WHERE ID = ?");
			
			st.setLong(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				return new Reservation(rs);
			}
		} catch (SQLException ex) {}
		
		return null;
	}
	
	public Vector<Table> availableTables() {
		Vector<Table> result = new Vector<Table>();
		
		PreparedStatement st;
		try {
			st = DB.getConnection().prepareStatement(
					"SELECT * FROM TABLES WHERE ID NOT IN ( SELECT TABLE_ID FROM RESERVATIONS WHERE AT BETWEEN ? AND ? ) ");
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(at);
			
			cal.add(Calendar.HOUR,-1);			
			st.setTimestamp(1, new Timestamp(cal.getTimeInMillis()));
			
			cal.add(Calendar.HOUR,-1);			
			st.setTimestamp(2, new Timestamp(cal.getTimeInMillis()));
						
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				result.add(new Table(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

}
