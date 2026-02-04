package com.bpi.m4project;

import java.util.logging.*;

public class Main {
	private static final Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		// Configure logging to console
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.ALL);
		logger.addHandler(handler);
		logger.setLevel(Level.ALL);
		logger.setUseParentHandlers(false);

		logger.info("Starting Library Application...");
		try {
			LibraryApplication libraryApplication = new LibraryApplication();
			libraryApplication.start();
		} catch (Exception e) {
			logger.severe("Unexpected error: " + e.getMessage());
		}
	}
}
