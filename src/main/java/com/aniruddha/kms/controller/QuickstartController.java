package com.aniruddha.kms.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniruddha.kms.service.QuickstartService;

@RestController
@RequestMapping("/quick")
public class QuickstartController {

	@Autowired
	private QuickstartService quick;
	
	@GetMapping
	public void quick() throws IOException {
		quick.quickStart();
	}
}
