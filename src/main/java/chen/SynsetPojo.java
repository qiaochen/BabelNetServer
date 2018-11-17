package chen;

import java.util.List;
import chen.SensePojo;

public class SynsetPojo {
	List<SensePojo> senses;
	List<String> grosses;
	String bnid;
	List<String> wnids;
	String main_sense;
	String main_gross;
	List<String> categories;
	List<String> examples;
	String Type;
	String POS;

	public SynsetPojo(List<SensePojo> senses, List<String> grosses, String bnid, List<String> wnids, String main_sense,
			String main_gross, List<String> categories, List<String> examples, String type, String pOS) {
		super();
		this.senses = senses;
		this.grosses = grosses;
		this.bnid = bnid;
		this.wnids = wnids;
		this.main_sense = main_sense;
		this.main_gross = main_gross;
		this.categories = categories;
		this.examples = examples;
		Type = type;
		POS = pOS;
	}

	public List<SensePojo> getSenses() {
		return senses;
	}

	public void setSenses(List<SensePojo> senses) {
		this.senses = senses;
	}

	public List<String> getGrosses() {
		return grosses;
	}

	public void setGrosses(List<String> grosses) {
		this.grosses = grosses;
	}

	public String getBnid() {
		return bnid;
	}

	public void setBnid(String bnid) {
		this.bnid = bnid;
	}

	public List<String> getWnids() {
		return wnids;
	}

	public void setWnids(List<String> wnids) {
		this.wnids = wnids;
	}

	public String getMain_sense() {
		return main_sense;
	}

	public void setMain_sense(String main_sense) {
		this.main_sense = main_sense;
	}

	public String getMain_gross() {
		return main_gross;
	}

	public void setMain_gross(String main_gross) {
		this.main_gross = main_gross;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<String> getExamples() {
		return examples;
	}

	public void setExamples(List<String> examples) {
		this.examples = examples;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getPOS() {
		return POS;
	}

	public void setPOS(String pOS) {
		POS = pOS;
	}

}
