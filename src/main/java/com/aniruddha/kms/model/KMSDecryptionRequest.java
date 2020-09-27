package com.aniruddha.kms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KMSDecryptionRequest {
	@JsonProperty("key-ring-name")
	private String keyRingId;

	@JsonProperty("key-name")
	private String keyId;

	@JsonProperty("cipher-text")
	private String textToDecrypt;

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

	public String getTextToDecrypt() {
		return textToDecrypt;
	}

	public void setTextToDecrypt(String textToDecrypt) {
		this.textToDecrypt = textToDecrypt;
	}

}
