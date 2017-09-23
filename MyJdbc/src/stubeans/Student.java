package stubeans;

public class Student {

	/*
	 * `id`  int NOT NULL AUTO_INCREMENT ,
`stu_name`  varchar(255) NOT NULL ,
`stu_age`  varchar(255) NOT NULL ,
`stu_tel`  int(12) NOT NULL ,
`stu_adree`  varchar(255) NOT NULL ,
`stu_bak`  text NOT NULL ,
	 */
	private int id;
	private String stu_name;
	private String stu_age;
	private int stu_tel;
	private String stu_adree;
	private String stu_bak;
	@Override
	public String toString() {
		return "Student [id=" + id + ", stu_name=" + stu_name + ", stu_age=" + stu_age + ", stu_tel=" + stu_tel
				+ ", stu_adree=" + stu_adree + ", stu_bak=" + stu_bak + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_age() {
		return stu_age;
	}
	public void setStu_age(String stu_age) {
		this.stu_age = stu_age;
	}
	public int getStu_tel() {
		return stu_tel;
	}
	public void setStu_tel(int stu_tel) {
		this.stu_tel = stu_tel;
	}
	public String getStu_adree() {
		return stu_adree;
	}
	public void setStu_adree(String stu_adree) {
		this.stu_adree = stu_adree;
	}
	public String getStu_bak() {
		return stu_bak;
	}
	public void setStu_bak(String stu_bak) {
		this.stu_bak = stu_bak;
	}
	
	
}
