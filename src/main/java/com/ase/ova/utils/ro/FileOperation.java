package com.ase.ova.utils.ro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileOperation {
	public boolean save(String yourfilename, String content) {
		boolean isSaved = true;
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(yourfilename));
			writer.write(yourfilename);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			isSaved = false;
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				isSaved = false;
			}
		}

		return isSaved;
	}

	public String[] open(String fileName) {
		String[] s = new String[4];

		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		}
		catch (IOException e) {

			// do something
			e.printStackTrace();
		}

		String line = "";
		line  = lines.get(lines.size()-1);
		
		s = line.split("###");
		return s;
	}
}
