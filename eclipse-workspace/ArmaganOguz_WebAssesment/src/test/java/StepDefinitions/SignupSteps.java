package StepDefinitions;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupSteps {

	ChromeOptions options;
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	Scanner scanner;
	int dressCount, quantity1, quantity2, totalQuantity;
	String dress1title, dress2title, firstItemName, secondItemName, sc;
	

	@Given("^user is on home page$")
	public void user_is_on_home_page() {

		scanner = new Scanner(System.in);
		System.out.println("Which browser you want to run? (Chrome/Firefox/IE)");
		sc = scanner.nextLine();

		if (sc.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
			options = new ChromeOptions();
			driver = new ChromeDriver(options);
		} else if (sc.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (sc.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.edge.driver", "C:/msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("not a valid browser");
		}

		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action = new Actions(driver);
		System.out.println("Inside step - user is on home page");
	}

	@When("^user is on signup page$")
	public void user_is_on_signup_page() {
		WebElement signin = driver.findElement(By.cssSelector("a[class='login']"));
		signin.click();

		System.out.println("Inside step - user clicks sign in and navigated to singup page");
	}

	@And("^user enters (.*) and navigates to create an account$")
	public void user_enters_email_and_navigates_to_create_an_account(String email) {
		WebElement mail = driver.findElement(By.cssSelector("#email_create"));
		WebElement create = driver.findElement(By.cssSelector("button[id='SubmitCreate'] span"));

		mail.sendKeys(email);
		create.click();

		System.out.println("Inside step - user enters email and navigates to create an account");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#customer_firstname")));
	}

	@And("^user fills the blanks and register$")
	public void user_fills_the_blanks_and_register() {
		WebElement gender = driver.findElement(By.cssSelector("#id_gender1"));
		gender.click();

		WebElement perFirstName = driver.findElement(By.cssSelector("#customer_firstname"));
		WebElement perLastName = driver.findElement(By.cssSelector("#customer_lastname"));
		WebElement perPassword = driver.findElement(By.cssSelector("#passwd"));
		WebElement perDay = driver.findElement(By.cssSelector("#days"));
		WebElement perMonth = driver.findElement(By.cssSelector("#months"));
		WebElement perYear = driver.findElement(By.cssSelector("#years"));
		WebElement addAddress1 = driver.findElement(By.cssSelector("#address1"));
		WebElement addAddress2 = driver.findElement(By.cssSelector("#address2"));
		WebElement addCity = driver.findElement(By.cssSelector("#city"));
		WebElement addState = driver.findElement(By.cssSelector("#id_state"));
		WebElement addPostCode = driver.findElement(By.cssSelector("#postcode"));
		WebElement addPhone = driver.findElement(By.cssSelector("#phone_mobile"));
		WebElement addAlias = driver.findElement(By.cssSelector("#alias"));
		WebElement register = driver.findElement(By.cssSelector("button[id='submitAccount'] span"));

		perFirstName.sendKeys("Armagan");
		perLastName.sendKeys("Oguz");
		perPassword.sendKeys("123456789.");
		perDay.sendKeys("21");
		perMonth.sendKeys("July");
		perYear.sendKeys("1997");
		addAddress1.sendKeys("Mebusevler Mah. Serefli Sokak.");
		addAddress2.sendKeys("No:20/5");
		addCity.sendKeys("Ankara");
		addState.sendKeys("Alabama");
		addPostCode.sendKeys("06570");
		addPhone.sendKeys("5334581727");
		addAlias.clear();
		addAlias.sendKeys("Evim");

		register.click();
		System.out.println("Inside step - user fills the blanks and register");
	}

	@Then("^verify that user is created$")
	public void verify_that_user_is_created() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("a[title='View my customer account'] span")));
		System.out.println("Inside step - verified that user is created");
	}

	@Given("^User selects 'Dresses' > 'Summer Dresses'$")
	public void user_selects_dresses_summer_dresses() {
//		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
//		options = new ChromeOptions();
//		driver = new ChromeDriver(options);
//		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		action = new Actions(driver);

		dressCount = 0;
		WebElement dresses = driver.findElement(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]"));
		action.moveToElement(dresses).perform();
		WebElement summerDresses = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/ul[1]/li[3]/a[1]"));
		summerDresses.click();

		System.out.println("Inside step - User selects 'Dresses' > 'Summer Dresses'");
	}

	@When("^User adds a product in the basket$")
	public void user_adds_a_product_in_the_basket() {
		WebElement firstDress = driver.findElement(By.cssSelector(
				".replace-2x.img-responsive[src='http://automationpractice.com/img/p/1/2/12-home_default.jpg']"));
		dress1title = firstDress.getAttribute("title");
		dressCount++;
		action.moveToElement(firstDress).perform();

		WebElement addToCart = driver.findElement(By.cssSelector(
				"li[class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line hovered'] a[title='Add to cart'] span"));
		addToCart.click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("span[title='Continue shopping'] span:nth-child(1)")));
		WebElement continueShopping = driver
				.findElement(By.cssSelector("span[title='Continue shopping'] span:nth-child(1)"));
		continueShopping.click();

		System.out.println("Inside step - User adds a product in the basket");
	}

	@And("^User search 'Summer'$")
	public void user_search_summer() {
		WebElement search = driver.findElement(By.cssSelector("#search_query_top"));
		search.sendKeys("Summer");
		search.submit();

		System.out.println("Inside step - User search 'Summer'");
	}

	@Then("^User adds a product to cart$")
	public void user_adds_a_product_to_cart() {
		WebElement lastDress = driver.findElement(By.cssSelector("img[title='Faded Short Sleeve T-shirts']"));
		dress2title = lastDress.getAttribute("title");
		dressCount++;

		action.moveToElement(lastDress).perform();

		WebElement addToCart2 = driver.findElement(By.cssSelector(
				"li[class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line last-item-of-tablet-line first-item-of-mobile-line last-mobile-line hovered'] a[title='Add to cart'] span"));
		addToCart2.click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("span[title='Continue shopping'] span:nth-child(1)")));
		WebElement continueShopping2 = driver
				.findElement(By.cssSelector("span[title='Continue shopping'] span:nth-child(1)"));
		continueShopping2.click();

		System.out.println("Inside step - User adds a product to cart");

	}

	@When("^User displays 'Cart' > 'Check Out' to verify products and proceeds the check out$")
	public void user_displays_cart_checkout_to_verify_products_and_proceeds_the_check_out() {
		WebElement cart = driver.findElement(By.cssSelector("a[title='View my shopping cart']"));
		action.moveToElement(cart).perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id='button_order_cart'] span")));
		WebElement checkOut = driver.findElement(By.cssSelector("a[id='button_order_cart'] span"));
		checkOut.click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Printed Summer Dress']")));

		WebElement firstItem = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/p[1]/a[1]"));
		firstItemName = firstItem.getAttribute("innerHTML");

		WebElement secondItem = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[2]/p[1]/a[1]"));
		secondItemName = secondItem.getAttribute("innerHTML");

		if (firstItemName.equals(dress1title) || secondItemName.equals(dress1title)) {
			if (firstItemName.equals(dress2title) || secondItemName.equals(dress2title)) {
				System.out.println("Selected items and the items displayed  on cart are same.");
			} else {
			}
		} else {
			System.out.println("Selected items and the items displayed  on cart are different..");
		}

		WebElement qty1 = driver.findElement(By.xpath("//input[@type='text' and contains(@name,'quantity_1')]"));
		quantity1 = Integer.parseInt(qty1.getAttribute("value"));
		WebElement qty2 = driver.findElement(By.xpath("//input[@type='text' and contains(@name,'quantity_5')]"));
		quantity2 = Integer.parseInt(qty2.getAttribute("value"));
		totalQuantity = quantity1 + quantity2;
		if (dressCount == totalQuantity) {
			System.out.println("Selected dress count  and the quantity displayed  on cart are same.");
		} else {
			System.out.println("Selected dress count  and the quantity displayed  on cart are different.");
		}

		WebElement proceed = driver
				.findElement(By.cssSelector("a[class='button btn btn-default standard-checkout button-medium'] span"));
		proceed.click();

		System.out.println(
				"Inside step - User displays 'Cart' > 'Check Out' to verify products and proceeds the check out");
	}

	@And("^User selects address and proceeds to checkout$")
	public void user_selects_address_and_proceeds_to_checkout() {
		WebElement addressCheck = driver.findElement(By.cssSelector("#id_address_delivery"));
		addressCheck.sendKeys("E");
		WebElement proceed2 = driver.findElement(By.cssSelector("button[name='processAddress'] span"));
		proceed2.click();

		System.out.println("Inside step - User selects address and proceeds to checkout");
	}

	@And("^User accepts terms of service and proceeds to checkout$")
	public void user_accepts_terms_of_service_and_proceeds_to_checkout() {
		WebElement termsCheckbox = driver.findElement(By.cssSelector("#cgv"));
		termsCheckbox.click();

		WebElement proceed3 = driver.findElement(By.cssSelector("button[name='processCarrier'] span"));
		proceed3.click();

		System.out.println("Inside step - User accepts terms of service and proceeds to checkout");
	}

	@Then("^User selects payment method and completes the order$")
	public void user_selects_payment_method_and_completes_the_order() {
		WebElement payByBank = driver.findElement(By.cssSelector("a[title='Pay by bank wire']"));
		payByBank.click();
		
		WebElement confirm = driver
				.findElement(By.cssSelector("button[class='button btn btn-default button-medium'] span"));
		confirm.click();

		System.out.println("Inside step - User selects payment method and completes the order");
	}

	@Then("^User controls the order on 'Menu' > 'Order history and details' screen$")
	public void user_controls_the_order_on_menu_order_history_and_details_screen() {
		WebElement user = driver.findElement(By.cssSelector("a[title='View my customer account'] span"));
		user.click();

		WebElement orderHistory = driver.findElement(By.cssSelector("a[title='Orders'] span"));
		orderHistory.click();

		System.out.println("User controls the order on 'Menu' > 'Order history and details' screen");
		
		System.out.println("Closing driver.");
		
//		driver.close();
		driver.quit();
	}

}
