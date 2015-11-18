package com.mongo.java;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class WriteProperty {

	public static void main(String[] args) {
		Properties prop=new Properties();
		OutputStream output =null;
		
		try {
			output=new FileOutputStream("collections.properties");
			
			StringBuilder builder=new StringBuilder();
			builder.append("UTMCollection,");
			builder.append("articlePosition,");
			builder.append("clicksByCat,");
			builder.append("dayActionCount,");
			builder.append("dgrpCount,");
			builder.append("hostDeviceMapColl,");
			builder.append("keyWordCollection,");
			builder.append("locationByCat,");
			builder.append("locationCount,");
			builder.append("refererByCat,");
			builder.append("refererCount,");
			builder.append("responseByCat,");
			builder.append("visitor");
			
			//set properties value
			prop.setProperty("simpleCollection", builder.toString());
			
			builder=new StringBuilder();
			builder.append("timedCount,");
			builder.append("tagsAggrtCount");
			
			prop.setProperty("queryCollection", builder.toString());
			
			prop.store(output, null);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
