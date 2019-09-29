package com.common.email;

import java.util.Map;

public class Email {


	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Map<String, String> getImagesMap() {
		return imagesMap;
	}
	public void setImagesMap(Map<String, String> imagesMap) {
		this.imagesMap = imagesMap;
	}
	public String[] getToEmails() {
		return toEmails;
	}
	public void setToEmails(String[] toEmails) {
		this.toEmails = toEmails;
	}
	public String[] getBccEmails() {
		return bccEmails;
	}
	public void setBccEmails(String[] bccEmails) {
		this.bccEmails = bccEmails;
	}
	public String[] getCcEmails() {
		return ccEmails;
	}
	public void setCcEmails(String[] ccEmails) {
		this.ccEmails = ccEmails;
	}
	public String[] getAttachments() {
		return attachments;
	}
	public void setAttachments(String[] attachments) {
		this.attachments = attachments;
	}
	private String[] toEmails;
	private String subject;
	private String content;
	private Map<String, String> imagesMap; 
	private String[] bccEmails;
	private String[] ccEmails;
	private String[] attachments;
}
