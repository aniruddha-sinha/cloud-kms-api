package com.aniruddha.kms.client;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.aniruddha.kms.model.PropertyModel;
import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose;
import com.google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionAlgorithm;
import com.google.cloud.kms.v1.CryptoKeyVersionTemplate;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.KeyRingName;

@Component
public class KeyCreationClient {

	@Autowired
	private PropertyModel propertyModel;

	public ResponseEntity<String> createKeySymmetricEncryptDecrypt(String keyRingId, String keyId) throws IOException {
		try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
			KeyRingName keyRingName = KeyRingName.of(propertyModel.getProjectId(), propertyModel.getLocationId(),
					keyRingId);

			
			CryptoKey key = CryptoKey.newBuilder().setPurpose(CryptoKeyPurpose.ENCRYPT_DECRYPT)
					.setVersionTemplate(CryptoKeyVersionTemplate.newBuilder()
							.setAlgorithm(CryptoKeyVersionAlgorithm.GOOGLE_SYMMETRIC_ENCRYPTION))
					.build();

			
			CryptoKey createdKey = client.createCryptoKey(keyRingName, keyId, key);
			System.out.printf("Created symmetric key %s%n", createdKey.getName());

			return ResponseEntity.ok(createdKey.getName());
		}
	}
}
