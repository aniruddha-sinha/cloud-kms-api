package com.aniruddha.kms.client;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.aniruddha.kms.model.KMSDecryptionRequest;
import com.aniruddha.kms.model.PropertyModel;
import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.DecryptResponse;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.protobuf.ByteString;

@Component
public class SymmetricDecryptionClient {

	@Autowired
	private PropertyModel propertyModel;

	public ResponseEntity<String> decryptSymmetric(KMSDecryptionRequest request) throws IOException {
		try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
			CryptoKeyName keyName = CryptoKeyName.of(propertyModel.getProjectId(), propertyModel.getLocationId(),
					request.getKeyRingId(), request.getKeyId());
			DecryptResponse response = client.decrypt(keyName,
					ByteString.copyFrom(Base64.getUrlDecoder().decode(request.getTextToDecrypt().getBytes())));

			return ResponseEntity.ok(response.getPlaintext().toStringUtf8());
		}
	}
}
