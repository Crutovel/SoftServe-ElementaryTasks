package com.softserve.edu.task4;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		switch (args.length) {
		case 2: {
			int occurences = 0;
			File file = new File(args[0]);
			Scanner scanner;
			try {
				scanner = new Scanner(file);

				scanner.useDelimiter(args[1]);

				while (scanner.hasNext()) {
					scanner.next();
					occurences++;
				}
				scanner.close();
			} catch (IOException e) {
				System.out.println("IOException");
			}
			System.out.println("Occurences = " + occurences);
			break;
		}
		case 3: {
			Charset charset = Charset.forName("cp1251");
			Path path = Paths.get(args[0]);
			try {
				Files.write(path,
						new String(Files.readAllBytes(path), charset).replace(args[1], args[2]).getBytes(charset));
			} catch (IOException e) {
				System.out.println("IOException");
			}
			break;
		}
		default: {
			System.out.println("There must be two or three parameters");
		}
		}

	}

}
