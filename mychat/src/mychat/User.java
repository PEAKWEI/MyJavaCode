package mychat;

public class User {


	private String name;
	private String ip;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public User(String name, String ip) {
		super();
		this.name = name;
		this.ip = ip;
	}
	//�޲ι���
	public User() {
         super();
	}
	
	
	
}
