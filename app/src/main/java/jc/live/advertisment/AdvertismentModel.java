package jc.live.advertisment;


public class AdvertismentModel {

	private String adContent;

	private String adUrl;

	private Integer adSwitch;

	private Integer adTime;

	private Integer adtype;

	private String name;

	private String title;

	public AdvertismentModel() {
		super();
	}

	public String getAdContent() {
		return adContent;
	}

	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}

	public String getAdUrl() {
		return adUrl;
	}

	public void setAdUrl(String adUrl) {
		this.adUrl = adUrl;
	}

	public Integer getAdSwitch() {
		return adSwitch;
	}

	public void setAdSwitch(Integer adSwitch) {
		this.adSwitch = adSwitch;
	}

	public Integer getAdTime() {
		return adTime;
	}

	public void setAdTime(Integer adTime) {
		this.adTime = adTime;
	}

	public Integer getAdtype() {
		return adtype;
	}

	public void setAdtype(Integer adtype) {
		this.adtype = adtype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}