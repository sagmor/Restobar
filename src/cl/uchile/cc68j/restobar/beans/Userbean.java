package cl.uchile.cc68j.restobar.beans;

import java.sql.Date;
import java.util.Map;
import java.util.Vector;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import cl.uchile.cc68j.restobar.model.User;


public class UserBean {

	User user;
	
	public UserBean(){}
	
	public UserBean(User u){
		this.user = u;
	}
	
	public static Vector<UserBean> getAllUsers() {
		Vector<User> users = User.findAll();
		Vector<UserBean> beans = new Vector<UserBean>();
		
		for (User u : users) {
			
			beans.add(new UserBean(u));
		}
		
		return beans;
	}
	
	public void loadUser(ActionEvent event) {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		this.user = User.find(Long.parseLong(params.get("userId")));
	}
	
	public void newUser(ActionEvent event) {	
		this.user = new User();
	}
	
public void saveUser(ActionEvent event) {	
		
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		if (params.get("user:id") != null) {
			
			this.user = User.find(Long.parseLong(params.get("user:id")));
		} 
		
		else {
			
			this.user = new User();
		}
		
		this.user.setNombre((params.get("user.nombre")));
		this.user.setNombre_usuario(((params.get("user.nombre"))));
		
		Date date2 = null;
		try {
			date2 = Date.valueOf((params.get("user.fecha_expiracion")));
		} catch (IllegalArgumentException ex) {}
		
		this.user.setFecha_expiracion(date2);
		this.user.setPerfil((params.get("user.perfil")));
		this.user.setPassword((params.get("user.password")));
		
		this.user.save();
	}
	
	public void deleteUser(ActionEvent event) {	
		
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		this.user = User.find(Long.parseLong(params.get("user:id")));
		this.user.delete();
		this.user = null;
	}
	
	public String validateUser() {
		if (user.valid())
			return "valid";
		else
			return "invalid";
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User u) {
		this.user = u;
	}
}
