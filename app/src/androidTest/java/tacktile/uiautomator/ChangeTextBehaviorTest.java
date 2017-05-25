package tacktile.uiautomator;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class ChangeTextBehaviorTest extends UiAutomatorTestCase {

    private static final String BASIC_SAMPLE_PACKAGE
            = "com.ty.followers";
    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String STRING_TO_BE_TYPED = "UiAutomator";

    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = mDevice.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                LAUNCH_TIMEOUT);

        // Launch the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        // Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
                LAUNCH_TIMEOUT);
    }

    @Test
    public void startTest() {
        sleep(5000);
        try {
            new UiObject(new UiSelector().text("FOLLOW")).click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        sleep(4000);
        for (int i = 0; i < 130 ; i++) {
            try {
                new UiObject(new UiSelector().text("FOLLOW +4")).click();
            } catch (UiObjectNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("click count == "+i);

           sleep(6000);
        }


        try {
            new UiObject(new UiSelector().text("PROMOTION")).click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        sleep(2000);
        try {
            new UiObject(new UiSelector().text("GET FOLLOWERS")).click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        sleep(2000);
        try {
            new UiObject(new UiSelector().text("500 coins")).click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        sleep(2000);
        try {
            new UiObject(new UiSelector().text("500 coins")).click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        sleep(2000);
        try {
            new UiObject(new UiSelector().text("Confirm")).click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

    }
}