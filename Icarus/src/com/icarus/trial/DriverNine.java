package com.icarus.trial;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.LatLng;
public class DriverNine {

	public static void main(String [] args)
	{
		Geocoder geo = new Geocoder();
		GeocoderRequest request = new GeocoderRequestBuilder().setLocation(new LatLng("13.13", "77.55")).setLanguage("en").getGeocoderRequest();
		GeocodeResponse response = geo.geocode(request);
		System.out.println(response.getResults());
	}
}
