package adapter_design_pattern;

// Define the WebDriver interface with two methods
interface WebDriver {
	public void getElement();
	public void selectElement();
}

// Implement the WebDriver interface in the ChromeDriver class
class ChromeDriver implements WebDriver {
	@Override
	public void getElement() {
		System.out.println("Get element from ChromeDriver");
	}

	@Override
	public void selectElement() {
		System.out.println("Select element from ChromeDriver");
	}
}

// Create a separate class IEDriver
class IEDriver {
	// Define methods to find and click elements in Internet Explorer
	public void findElement() {
		System.out.println("Find element from IEDriver");
	}

	public void clickElement() {
		System.out.println("Click element from IEDriver");
	}
}

// Create an adapter class that implements the WebDriver interface
class WebDriverAdapter implements WebDriver {
	IEDriver ieDriver;

	// Constructor that takes an IEDriver object
	public WebDriverAdapter(IEDriver ieDriver) {
		this.ieDriver = ieDriver;
	}

	// Implement the getElement method by delegating to IEDriver's findElement
	@Override
	public void getElement() {
		ieDriver.findElement();
	}

	// Implement the selectElement method by delegating to IEDriver's clickElement
	@Override
	public void selectElement() {
		ieDriver.clickElement();
	}
}

// Main class to demonstrate the Adapter Pattern
public class AdapterPattern {
	public static void main(String[] args) {
		// Create an instance of ChromeDriver and use its methods
