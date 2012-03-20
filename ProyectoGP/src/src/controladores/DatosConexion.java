package controladores;

public class DatosConexion {

    String driver;	
    String server; 		
    String database;	
    String user;
    String password;
    String url;
    
    public DatosConexion(String server, String database, String user, String password) {
	this.driver ="com.mysql.jdbc.Driver";
	this.server = server;
	this.database = database;
	this.user = user;
	this.password = password;
	this.url = "jdbc:mysql://" + server + "/" + database;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
    
}
