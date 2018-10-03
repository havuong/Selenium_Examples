package modules;

import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.io.File;

import static supports.CommonFunctions.*;

public class FileUpload {
    public static void main(String[] args) {

        String filename = "file-upload.txt";
        File file = new File(filename);
        String path = file.getAbsolutePath();

        setBrowser("ff");
        visit("http://the-internet.herokuapp.com/upload");
        fill(How.ID,"file-upload",path);
        click(How.ID,"file-submit");
        String text = getText(How.ID,"uploaded-files");
        Assert.assertEquals(text,filename);

    }
}
