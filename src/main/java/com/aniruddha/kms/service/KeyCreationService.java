package com.aniruddha.kms.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aniruddha.kms.client.KeyCreationClient;

@Service
public class KeyCreationService {
	
	@Autowired
	private KeyCreationClient client;

	public ResponseEntity<String> createKey(String keyRingId, String keyId) throws IOException {
		return client.createKeySymmetricEncryptDecrypt(keyRingId, keyId);
	}

}
