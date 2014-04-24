package com.jkt.donateme.client.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "register")

public class ProfileDetailsField implements Serializable {

	private static final long serialVersionUID = 1L;
	private String titleOfYourPagePanel;
	private String donationNeededPanel;
	private String reasonForRaisingFundsPanel;
	private String profileSummaryPanel;
	private String endCollectingMoneyOnPanel;
	private String uploadYourProfilePicturePanel;
	
	public String getTitleOfYourPagePanel() {
		return titleOfYourPagePanel;
	}
	public void setTitleOfYourPagePanel(String titleOfYourPagePanel) {
		this.titleOfYourPagePanel = titleOfYourPagePanel;
	}
	public String getDonationNeededPanel() {
		return donationNeededPanel;
	}
	public void setDonationNeededPanel(String donationNeededPanel) {
		this.donationNeededPanel = donationNeededPanel;
	}
	public String getReasonForRaisingFundsPanel() {
		return reasonForRaisingFundsPanel;
	}
	public void setReasonForRaisingFundsPanel(String reasonForRaisingFundsPanel) {
		this.reasonForRaisingFundsPanel = reasonForRaisingFundsPanel;
	}
	public String getProfileSummaryPanel() {
		return profileSummaryPanel;
	}
	public void setProfileSummaryPanel(String profileSummaryPanel) {
		this.profileSummaryPanel = profileSummaryPanel;
	}
	public String getEndCollectingMoneyOnPanel() {
		return endCollectingMoneyOnPanel;
	}
	public void setEndCollectingMoneyOnPanel(String endCollectingMoneyOnPanel) {
		this.endCollectingMoneyOnPanel = endCollectingMoneyOnPanel;
	}
	public String getUploadYourProfilePicturePanel() {
		return uploadYourProfilePicturePanel;
	}
	public void setUploadYourProfilePicturePanel(
			String uploadYourProfilePicturePanel) {
		this.uploadYourProfilePicturePanel = uploadYourProfilePicturePanel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
