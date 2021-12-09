package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServiceNowSteps extends ServiceNowBase {
	String incident;
	List<String> allhandles;

	@Given("Click on Create New Option")
	public void click_on_create_new_option() {
		driver.findElement(By.id("sysverb_new")).click();

	}

	@Given("Get the Incident ID")
	public void get_the_incident_id() throws InterruptedException {
		Thread.sleep(3000);
		incident = driver.findElement(By.id("incident.number")).getAttribute("value");

	}

	@Given("Click on Caller ID")
	public void click_on_caller_id() throws InterruptedException {
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Thread.sleep(2000);
	}

	@Given("Go to the New Window")
	public void go_to_the_new_window() {
		Set<String> allWindows = driver.getWindowHandles();
		allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
	}

	@Given("Go to the Main Window")
	public void go_to_main_window() {
		driver.switchTo().window(allhandles.get(0));
	}

	@Given("Select the Caller")
	public void select_the_caller() {
		driver.findElement(By.className("glide_ref_item_link")).click();
	}

	@Then("Fill the description")
	public void fill_the_mandatory_details() {
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys("Added Description");
	}

	@When("Click on submit")
	public void click_on_submit() {
		driver.findElement(By.id("sysverb_insert_bottom")).click();
	}

	@Then("Verify the incident number")
	public void verify_the_incident_number() throws InterruptedException {

		driver.findElement(By.xpath("(//label[text()='Search']/following::input)[1]")).sendKeys(incident);
		driver.findElement(By.xpath("(//label[text()='Search']/following::input)[1]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String returnIncident = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		Assert.assertEquals(returnIncident, incident);

	}

	@Given("Search with incident {string}")
	public void search_with_incident(String inci) {
		driver.findElement(By.xpath("(//label[text()='Search']/following::input)[1]")).sendKeys(inci);
		driver.findElement(By.xpath("(//label[text()='Search']/following::input)[1]")).sendKeys(Keys.ENTER);

	}

	@Given("Click on the incident")
	public void click_on_the_incident() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//td[@class='vt'])[1]/a")).click();
		;
	}

	@Given("Change the Urgency as High")
	public void change_the_urgency_as_high() {
		WebElement urgency = driver.findElement(By.xpath("//select[@name='incident.urgency']"));
		Select s1 = new Select(urgency);
		s1.selectByVisibleText("1 - High");
	}

	@Given("Change the state to In Progress")
	public void change_the_state_to_in_progress() {
		WebElement state = driver.findElement(By.xpath("//select[@name='incident.state']"));
		Select s2 = new Select(state);
		s2.selectByVisibleText("In Progress");
	}

	@Then("Click on Update")
	public void click_on_update() {
		driver.findElement(By.xpath("//button[@value='sysverb_update']"));
	}

	@When("Click on Delete")
	public void delete_the_incident() throws InterruptedException {
		driver.findElement(By.id("sysverb_delete_bottom")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();

	}

	@Then("Verify incident is deleted")
	public void verify_incident_is_deleted() {

	}

	@Given("Click on group")
	public void click_on_group() {

		driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']/span")).click();

	}
	
	@Then ("Click on Update to complete")
	
	public void click_on_complete() {

		driver.findElement(By.id("sysverb_update_bottom")).click();

	}
	

	@Given("Select Software from the list")
	public void select_software_from_the_list() throws InterruptedException {
		driver.findElement(By.xpath("(//label[@class='sr-only'])[2]/following-sibling::input")).sendKeys("Software");
		driver.findElement(By.xpath("(//label[@class='sr-only'])[2]/following-sibling::input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();

	}

	@Given("Enter the Work notes")
	public void enter_the_work_notes() {
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//textarea[@placeholder='Work notes'])[2]")).sendKeys("Updating the notes");
		driver.findElement(By.xpath("//button[@ng-hide='!false && doesFormHasMandatoryJournalFields()']")).click();

	}

	@Then("Verify Incident is correctly assigned to group")
	public void verify_the_incident_assignment() throws InterruptedException {
		Thread.sleep(2000);
		String group = driver.findElement(By.xpath("(//table[@role='presentation']//tbody)[2]/tr/td[10]")).getText();
		System.out.println(group);
		Assert.assertEquals(group, "Software");

	}
}
