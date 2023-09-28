package com.play.playground;

import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class HelloApplicationTest extends ApplicationTest {
    @BeforeAll
    public static void setup() throws Exception {
        launch(HelloApplication.class);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.show();
    }
    @Test
    public void TestWelcomeBtn() {
        clickOn("#textBox").write("Joe");
        clickOn("#helloBtn");
        verifyThat("#helloText", LabeledMatchers.hasText("Hello Joe!"));
    }

    @Test
    public void TestWelcomeError() {
        clickOn("#textBox").eraseText(3);
        clickOn("#helloBtn");
        verifyThat("#helloText", LabeledMatchers.hasText(""));
        verifyThat("#errorText", LabeledMatchers.hasText("Name not specified"));
    }

    @Test
    public void TestTextFieldKeyPressed() {
        clickOn("#textBox").write("mama");
        press(KeyCode.ENTER);
        verifyThat("#helloText", LabeledMatchers.hasText("Hello mama!"));
    }
}