package modules;

import org.testng.annotations.Test;

import static supports.CommonFunctions.setBrowser;
import static supports.CommonFunctions.visit;

public class template {
    @Test
    public void methodName() {
        setBrowser("ff");
        visit("");

    }
}
