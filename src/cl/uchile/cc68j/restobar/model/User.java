package cl.uchile.cc68j.restobar.model;

import java.sql.*;
import java.util.Vector;

public class User extends Model{
	
	static public String userName = "USUARIOS";
	static private String insertQuery = "INSERT INTO USUARIOS(NOMBRE_USUARIO, NOMBRE, FECHA_CREACION, FECHA_EXPIRACION, PERFIL, PASSWORD) VALUES (?,?,?,?,?,?)";
	static private String updateQuery = "UPDATE MENU SET NOMBRE_USUARIO = ?, NOMBRE = ?,  FECHA_CREACION = ?, FECHA_EXPIRACION, PERFIL = ?, PASSWORD = ?, WHERE ID = ?";
	static private String deleteQuery = "DELETE FROM MENU WHERE ID = ?";
	static private String generatedColumns[] = {"ID"};
	
	private String nombre_usuario;
	private String nombre;
	private Date fecha_creacion;
	private Date fecha_expiracion;
	private String perfil;
	private String password;
	
	public User(){};
	
	public  User(ResultSet row){
		
		super(row);
		
		try {
			id = row.getInt("ID");
			nombre_usuario = row.getString("NOMBRE_USUARIO");
			nombre = row.getString("NOMBRE");
			fecha_creacion = row.getDate("FECHA_CREACION");
			fecha_expiracion = row.getDate("FECHA_EXPIRACION");
			perfil = row.getString("PERFIL");
			password = row.getString("PASSWDRD");
		} 
		catch (SQLException ex) {}
	}
	
	public String getNombre_usuario(){
		
		return nombre_usuario;
	}
	
	public void setNombre_usuario(String n){
		
		nombre_usuario = n;
	}
	
	public String getNombre(){
		
		return nombre;
	}
	
	public void setNombre(String n){
		
		nombre = n;
	}
	
	public Date getFecha_creacion(){
		
		return fecha_creacion;
	}
	
	public void setFecha_creacion(Date d){
		
		fecha_creacion = d;
	}
	
	public Date getFecha_expiracion(){
		
		return fecha_expiracion;
	}
	
	public void setFecha_expiracion(Date d){
		
		fecha_expiracion = d;
	}
	
	public String getPerfil(){
		
		return perfil;
	}
	
	public void setPerfil(String p){
		
		perfil = p;
	}
	
	public String getPassword(){
		
		return password;
	}
	
	public void setPassword(String p){
		
		password = p;
	}

	@Override
	public boolean delete() {
		
		try {
			
			Connection conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(deleteQuery);
		
			st.setInt(1, id);
		
			st.executeUpdate();
		
			return true;
			
		} 
		
		catch (SQLException ex) {
			
			
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	protected boolean insert() {
		
		try{
			
			Connection conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(insertQuery, generatedColumns);
			
			st.setString(2,nombre_usuario);
			st.setString(3,nombre);
			st.setDate(4,fecha_creacion);
			st.setDate(5,fecha_expiracion);
			st.setString(6,perfil);
			st.setString(7,password);
			
			st.executeUpdate();
			
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			this.id = rs.getInt(1);
			
			return true;
		}
		
		catch(SQLException ex){
			
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	protected boolean update() {
		
try{
			
			Connection conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(updateQuery);
			
			st.setString(2,nombre_usuario);
			st.setString(3,nombre);
			st.setDate(4,fecha_creacion);
			st.setDate(5,fecha_expiracion);
			st.setString(6,perfil);
			st.setString(7,password);
			st.setInt(1, id);
			
			System.out.println(st.toString());
			
			st.executeUpdate();
						
			return true;
		}
		
		catch(SQLException ex){
			
			ex.printStackTrace();
			return false;
		}
	}
	
	public static Vector<User> findAll(){
		
		Vector<User> result = new Vector<User>();
		
		try {
			
			Statement st = DB.getConnection().createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM USUARIOS");
			
			while (rs.next()) {
				
				result.add(new User(rs));
			}
		} 
		
		catch (SQLException ex) {}
		
		return result;
	}
	
	public static User find(long id){
		
		try{
			
			PreparedStatement st = DB.getConnection().prepareStatement(
			"SELECT * FROM USUARIOS WHERE ID = ?");
			
			st.setLong(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				
				return new User(rs);
			}
		}
		
		catch(SQLException ex){}
		
		return null;
	}

	@Override
	public boolean valid() {
		
		if(this.fecha_creacion == null || 
				this.fecha_expiracion == null ||
				this.nombre == null || 
				this.nombre_usuario == null || 
				this.perfil == null ||
				this.password == null){
			
			return false;
		}
		
		else{
			
			return true;
		}
	}
}
