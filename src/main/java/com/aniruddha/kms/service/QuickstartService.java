package com.aniruddha.kms.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aniruddha.kms.client.QuickstartClient;

@Service
public class QuickstartService {
	
	@Autowired
	private QuickstartClient client;
	
	public void quickStart() throws IOException {
		client.quickstart();
	}
}
