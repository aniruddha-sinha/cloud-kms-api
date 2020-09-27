package com.aniruddha.kms.client;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.aniruddha.kms.model.KMSEncryptionRequest;
import com.aniruddha.kms.model.PropertyModel;
import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.EncryptResponse;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.protobuf.ByteString;

@Component
public class SymmetricEncryptionClient {

	@Autowired
	private PropertyModel propertyModel;

	public ResponseEntity<String> encryptSymmetric(KMSEncryptionRequest request) throws IOException {

		try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
			CryptoKeyName keyVersionName = CryptoKeyName.of(propertyModel.getProjectId(), propertyModel.getLocationId(),
					request.getKeyRingId(), request.getKeyId());

			EncryptResponse response = client.encrypt(keyVersionName,
					ByteString.copyFromUtf8(request.getTextToEncrypt()));
			byte[] arr = response.getCiphertext().toByteArray();
			String psws = new String(Base64.getUrlEncoder().encode(arr));

			return ResponseEntity.ok(psws);
		}
	}

}
