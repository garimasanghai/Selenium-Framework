package randomUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.github.javafaker.Faker;

public class RandomUtils {

	// fake company by using java faker library in chatgpt

	public String companyName() {
		Faker faker = new Faker();
		// String companyName = faker.company().name();
		return faker.company().name();
	}

	public String contactName() {
		Faker faker = new Faker();
		return faker.name().fullName();
	}

	public String productName() {
		Faker faker = new Faker();
		return faker.commerce().productName();
	}

	public String vendorName() {
		Faker faker = new Faker();
		return faker.company().name();
	}

	public String potentialName() {
		Faker faker = new Faker();
		return faker.company().name();
	}

	
	  
	public static String getPrice() {
		double priceDouble = Math.random() * 1000 + 100; // Generate a random price between 100 and 1100
		int priceCents = (int) (priceDouble * 100); // Convert to cents
		double formattedPrice = priceCents / 100.0; // Convert back to double with two decimal places
		return String.format("%.2f", formattedPrice);
	}
	 
	public String currentDateInFormatted() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // write the format u need date to be displayed as
		String formattedDate = sdf.format(date); // storing it in ref variable and then returning the same
		return formattedDate;
	}
}
