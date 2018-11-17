package chen;

public class SensePojo {
	private String name;
	private boolean isKeySense;
	private String pos;
	private String senseKey;
	private int idSense;

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getSenseKey() {
		return senseKey;
	}

	public void setSenseKey(String senseKey) {
		this.senseKey = senseKey;
	}

	public int getIdSense() {
		return idSense;
	}

	public void setIdSense(int idSense) {
		this.idSense = idSense;
	}

	public SensePojo(String name, boolean isKeySense, String pos, String senseKey, int idSense) {
		this.name = name;
		this.isKeySense = isKeySense;
		this.pos = pos;
		this.senseKey = senseKey;
		this.idSense = idSense;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsKeySense() {
		return isKeySense;
	}

	public void setIsKeySense(Boolean isKeySense) {
		this.isKeySense = isKeySense;
	}
}
