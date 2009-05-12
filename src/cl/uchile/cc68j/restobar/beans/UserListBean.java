package cl.uchile.cc68j.restobar.beans;

import java.util.Vector;

import cl.uchile.cc68j.restobar.model.User;

public class UserListBean {

	 Vector<User> users;
	    
	    public Vector<User> getUsers(){
	    	
	            if (users == null) {
	            	users = User.findAll();
	            }
	            
	            return users;
	    }
	            
	    
	    public void setUsers(Vector<User> users) {
	    	
	            this.users= users;
	    }      
	    
	    
}
