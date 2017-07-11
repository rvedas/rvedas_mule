package com.rvedas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class Tracking {

	//private static final String FILENAME = "/Users/sivaji/Desktop/rvedas/logs/rvedas_beats.log";
	private static final String FILENAME = "/opt/mule/logs/rvedas_beats.log";

	public String writeToRvedasLog(String application_id, 
			String application_name, 
			String application_host,
			String transaction_uuid, 
			String transaction_time, 
			String transaction_log_identifier,
			String transaction_status, 
			String client_id) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

//			{
//			    "application_id": "1001",
//			    "application_name": "loan",
//			    "application_host": "host1.rvedas.com",
//			    "transaction_uuid": "f52531a6-0fa2-4ba9-c0b4-3cef43727310",
//			    "transaction_time": "1978-04-18T00:00:00.001Z",
//			    "transaction_log_identifier": "loan_entry",
//			    "transaction_status": "200",
//			    "client_id": "2001"
//			}

			String jsonString = new JSONObject()
					.put("application_id", application_id)
					.put("application_name", application_name)
					.put("application_host", application_host)
					.put("transaction_uuid", transaction_uuid)
					.put("transaction_time", transaction_time)
					.put("transaction_log_identifier", transaction_log_identifier)
					.put("transaction_status", transaction_status)
					.put("client_id", client_id).toString();

			//System.out.println(jsonString);
			
			//{"test1":"value1","test2":{"id":0,"name":"testName"}}
			//{"test2":{"id":0,"name":"testName"}}
			//{"index":{"_index":"rvedas_acad","_type":"acad_locations"}}
			//test2<-index, id<-_index, name<-_type
			
			
			//String index_message;
			JSONObject index_json = new JSONObject();

			JSONObject index_jsonObj = new JSONObject();

			index_jsonObj.put("_index", "rvedas_acad");
			index_jsonObj.put("_type", "acad_locations");
			index_json.put("index", index_jsonObj);

			//index_message = index_json.toString();
			//System.out.println(index_message);
			
			File file = new File(FILENAME);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			
			//bw.newLine();
			//bw.write(index_message);
			
			bw.write(jsonString);
			bw.newLine();

			//System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();
			//String writeStatus = "failure";

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();
				//String writeStatus = "success";

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

		String writeStatus = "success";
		return String.format(writeStatus);

	}

}
