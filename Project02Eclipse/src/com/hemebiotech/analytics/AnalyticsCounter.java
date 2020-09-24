package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	

	public static void main(String args[]) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;

		List<String> sympList = new ArrayList<String>();

		while (line != null) {
			i++;
			sympList.add(line);
			line = reader.readLine(); // get another symptom
		}

		
		Map<String, Integer> nbSymptoms = new HashMap<String, Integer>();
		List<String> lst = new ArrayList<String>();

		String n = null;
		int count = 0;
		for (String name : sympList) {
			n = name;
			count = Collections.frequency(sympList, name);
			nbSymptoms.put(n, count);
		}

		// generate output
		FileWriter writer = new FileWriter("result.out");
		
		for(Map.Entry<String, Integer> entry : nbSymptoms.entrySet()){
			lst.add((entry.getKey() +" : " + entry.getValue()));
		}
		
		Collections.sort(lst);
		for (String ls : lst) {
			writer.write(ls + "\n");
		}

		writer.close();
	}
}
