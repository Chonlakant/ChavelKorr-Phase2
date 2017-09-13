package com.twentyfour.chavel.Event;

public class Events {


	public static class ActivityFragmentMessage {

		private String message;

		public ActivityFragmentMessage(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}
}
