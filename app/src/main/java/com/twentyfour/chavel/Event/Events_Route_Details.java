package com.twentyfour.chavel.Event;

import com.twentyfour.chavel.model.DetailsRoute;
import com.twentyfour.chavel.model.Location;

public class Events_Route_Details {


	public static class Events_RoutDetails {

		private DetailsRoute message;

		public Events_RoutDetails(DetailsRoute message) {
			this.message = message;
		}

		public DetailsRoute getMessage() {
			return message;
		}
	}
}
