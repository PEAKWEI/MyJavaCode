package card.entiy;

public class Card {
	
	private String ID;
	private String UID;
	private String Status;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Card(String iD, String uID, String status) {
		ID = iD;
		UID = uID;
		Status = status;
	}
	@Override
	public String toString() {
		return "Card [ID=" + ID + ", UID=" + UID + ", Status=" + Status + "]";
	}

}
