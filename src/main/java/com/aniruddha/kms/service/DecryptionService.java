package com.aniruddha.kms.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aniruddha.kms.client.SymmetricDecryptionClient;
import com.aniruddha.kms.model.KMSDecryptionRequest;

@Service
public class DecryptionService {
	
	@Autowired
	private SymmetricDecryptionClient client;

	public ResponseEntity<String> decrypt(KMSDecryptionRequest request) throws IOException {
		return client.decryptSymmetric(request);
	}

}
