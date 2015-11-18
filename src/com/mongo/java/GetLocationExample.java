package com.mongo.java;

import java.io.File;
import java.io.IOException;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

public class GetLocationExample {

	public static void main(String[] args) {
		GetLocationExample obj = new GetLocationExample();
		ServerLocation location = obj.getLocation("27.97.15.7");
		System.out.println(location);
	}

	public ServerLocation getLocation(String ipAddress) {
		File file = new File("resourse\\GeoLiteCity.dat");
		return getLocation(ipAddress, file);
	}

	public ServerLocation getLocation(String ipAddress, File file) {
		ServerLocation serverLocation = new ServerLocation();

		try {
			LookupService lookup = new LookupService(file,
					LookupService.GEOIP_MEMORY_CACHE);
			Location locationServices = lookup.getLocation(ipAddress);

			serverLocation.setCountryCode(locationServices.countryCode);
			serverLocation.setCountryName(locationServices.countryName);
			serverLocation.setRegion(locationServices.region);
			serverLocation.setCity(locationServices.city);
			serverLocation.setPostalCode(String.valueOf(locationServices.postalCode));
			serverLocation.setLatitude(locationServices.latitude);
			serverLocation.setLongitude(locationServices.longitude);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return serverLocation;
	}

}
