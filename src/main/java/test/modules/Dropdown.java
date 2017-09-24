package test.modules;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static test.supports.CommonFunctions.*;

public class Dropdown {

    @Test
    public void DropdownSelect(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/dropdown");
        Select selectList = new Select(getElement(How.ID,"dropdown"));
//        selectList.selectByVisibleText("Option 1");
//        selectList.selectByValue("1");
        selectList.selectByIndex(1);
        Assert.assertEquals(selectList.getFirstSelectedOption().getText(),"Option 1");
    }

    @Test(enabled = false)
    public void DropdownList(){
        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdownList = getElement(How.ID,"dropdown");
        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++){
            if (options.get(i).getText().equals("Option 1")){
                options.get(i).click();
            }
        }
        String selectedOption = "";
        for (int i = 0;i < options.size();i++){
            if (options.get(i).isSelected()){
                selectedOption = options.get(i).getText();
            }
        }
        Assert.assertEquals(selectedOption,"Option 1");
    }
}
