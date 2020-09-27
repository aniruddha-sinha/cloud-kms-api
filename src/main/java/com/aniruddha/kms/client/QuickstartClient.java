package com.aniruddha.kms.client;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aniruddha.kms.model.PropertyModel;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.KeyManagementServiceClient.ListKeyRingsPagedResponse;
import com.google.cloud.kms.v1.KeyRing;
import com.google.cloud.kms.v1.LocationName;

@Component
public class QuickstartClient {
	@Autowired
	private PropertyModel propertyModel;
	
	public void quickstart() throws IOException {
		// TODO(developer): Replace these variables before running the sample.
		String projectId = propertyModel.getProjectId();
		String locationId = propertyModel.getLocationId();
		quickstart(projectId, locationId);
	}

	public void quickstart(String projectId, String locationId) throws IOException {

		try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {

			LocationName parent = LocationName.of(projectId, locationId);

			ListKeyRingsPagedResponse response = client.listKeyRings(parent);

			System.out.println("key rings:");
			for (KeyRing keyRing : response.iterateAll()) {
				System.out.printf("%s%n", keyRing.getName());
			}
		}
	}

}