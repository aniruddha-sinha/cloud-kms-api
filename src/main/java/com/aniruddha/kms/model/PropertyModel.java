package com.aniruddha.kms.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class PropertyModel {

	private String projectId;
	private String locationId;

	@Value("${app.secret.kms.sample.password}")
	private String sampleKmsPassword;

	@Value("${app.secret.gs.sample.password}")
	private String sampleStoragePassword;

	public String getSampleKmsPassword() {
		return sampleKmsPassword;
	}

	public void setSampleKmsPassword(String sampleKmsPassword) {
		this.sampleKmsPassword = sampleKmsPassword;
	}

	public String getSampleStoragePassword() {
		return sampleStoragePassword;
	}

	public void setSampleStoragePassword(String sampleStoragePassword) {
		this.sampleStoragePassword = sampleStoragePassword;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
}
