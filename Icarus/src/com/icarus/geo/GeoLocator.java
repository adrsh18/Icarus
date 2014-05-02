package com.icarus.geo;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.LatLng;

public class GeoLocator {

	public static String getAddress(String latitude, String longitude)
	{
		try{
			Geocoder geo = new Geocoder();
			GeocoderRequest request = new GeocoderRequestBuilder().setLocation(new LatLng("13.13", "77.55")).setLanguage("en").getGeocoderRequest();
			GeocodeResponse response = geo.geocode(request);
			String address = response.getResults().get(0).getFormattedAddress();
			return address;
		}catch(Exception e)
		{
			return "Location unavailable. Retry.";
		}
	}
}
