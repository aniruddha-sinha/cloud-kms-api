package com.aniruddha.kms.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniruddha.kms.model.KMSDecryptionRequest;
import com.aniruddha.kms.model.KMSEncryptionRequest;
import com.aniruddha.kms.service.DecryptionService;
import com.aniruddha.kms.service.EncryptionService;
import com.aniruddha.kms.service.KeyCreationService;

@RestController
@RequestMapping("/api/crypto")
public class CryptoController {
	
	@Autowired
	private EncryptionService encService;
	
	@Autowired
	private DecryptionService decService;

	@Autowired
	private KeyCreationService keyCreationService;
	
	@PostMapping("/key/{keyring-id}/create/{key-id}")
	public ResponseEntity<String> createKey(@PathVariable("keyring-id") String keyRingId,
			@PathVariable("key-id") String keyId) throws IOException {
		return keyCreationService.createKey(keyRingId, keyId);
	}
	
	@PostMapping("/encrypt")
	public ResponseEntity<String> encryptData(@RequestBody KMSEncryptionRequest request) throws IOException {
		return encService.encrypt(request);
	}
	
	
	@PostMapping("/decrypt")
	public ResponseEntity<String> decryptData(@RequestBody KMSDecryptionRequest request) throws IOException {
		return decService.decrypt(request);
	}
}
