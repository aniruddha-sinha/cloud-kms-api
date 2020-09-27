package com.aniruddha.kms.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aniruddha.kms.client.SymmetricEncryptionClient;
import com.aniruddha.kms.model.KMSEncryptionRequest;

@Service
public class EncryptionService {

	@Autowired
	private SymmetricEncryptionClient client;
	
	public ResponseEntity<String> encrypt(KMSEncryptionRequest request) throws IOException {
		return client.encryptSymmetric(request);
	}
}
