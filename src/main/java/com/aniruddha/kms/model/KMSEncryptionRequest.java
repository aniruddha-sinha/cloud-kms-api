package com.aniruddha.kms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KMSEncryptionRequest {
	@JsonProperty("key-ring-name")
	private String keyRingId;
	
	@JsonProperty("key-name")
	private String keyId;
	
	@JsonProperty("plain-text")
	private String textToEncrypt;

	public String getKeyRingId() {
		return keyRingId;
	}

	public void setKeyRingId(String keyRingId) {
		this.keyRingId = keyRingId;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public String getTextToEncrypt() {
		return textToEncrypt;
	}

	public void setTextToEncrypt(String textToEncrypt) {
		this.textToEncrypt = textToEncrypt;
	}
}
