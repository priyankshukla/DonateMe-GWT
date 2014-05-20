package com.jkt.donateme.client.model;

import java.util.Date;

public class ProfileDetailsFields {
	
	private String titleOfYourPagePanel;
	private String donationNeededPanel;
	private String reasonForRaisingFundsPanel;
	private String profileSummaryPanel;
	private Date endCollectingMoneyOnPanel;
	

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
	public Date getEndCollectingMoneyOnPanel() {
		return endCollectingMoneyOnPanel;
	}
	public void setEndCollectingMoneyOnPanel(Date endCollectingMoneyOnPanel) {
		this.endCollectingMoneyOnPanel = endCollectingMoneyOnPanel;
	}
}
