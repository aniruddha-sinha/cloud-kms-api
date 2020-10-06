package com.aniruddha.kms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniruddha.kms.model.PropertyModel;

@RestController
@RequestMapping("/api/secrets/get")
public class SecretController {
	
	@Autowired
	private PropertyModel model;

	@GetMapping("")
	public String getSecrets() {
		return "kmsSecret: " + "\""+ model.getSampleKmsPassword()+ "\"" + "    storageSecret: " + "\""+ model.getSampleStoragePassword();
	}
}
