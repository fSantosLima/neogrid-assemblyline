package br.com.neogrid.assemblyline.controllers;

import br.com.neogrid.assemblyline.AbstractMockAssemblyLinesUnitTestClass;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@TestMethodOrder(MethodOrderer.DisplayName.class)
class AssemblyLineControllerTest extends AbstractMockAssemblyLinesUnitTestClass {
    private static AssemblyLineController assemblyLineController;
    @BeforeEach
    void beforeEach() {
        assemblyLineController = new AssemblyLineController();
    }

    @Test
    @DisplayName("Should read file and make one assembly line with success")
    void shouldPrintOneAssemblyLineWithSuccess() {

        ByteArrayOutputStream content = new ByteArrayOutputStream();
        System.setOut(new PrintStream(content));

        assemblyLineController.readInputFile("src/test/resources/input-1-assemblyline.txt");

        final String assemblyLinesMock = super.mockAssemblyLinePrinted();

        Assertions.assertThat(content.toString().trim())
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(assemblyLinesMock);
    }

    @Test
    @DisplayName("Should read file and make two assembly lines and print with success")
    void shouldReadFileAndMakeTwoAssemblyLinesAndPrintResult() {

        ByteArrayOutputStream content = new ByteArrayOutputStream();
        System.setOut(new PrintStream(content));

        assemblyLineController.readInputFile("src/test/resources/input.txt");

        final String assemblyLinesMock = super.mockTwoAssemblyLinesPrinteds();
        Assertions.assertThat(content.toString().trim())
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(assemblyLinesMock);
    }

    @Test
    @DisplayName("Should read file and make three assembly lines and print with success")
    void shouldReadFileAndMakeThreeAssemblyLinesAndPrintResult() {

        ByteArrayOutputStream content = new ByteArrayOutputStream();
        System.setOut(new PrintStream(content));

        assemblyLineController.readInputFile("src/main/resources/input-3-assemblylines.txt");

        final String assemblyLinesMock = super.mockThreeAssemblyLinesPrinteds();
        Assertions.assertThat(content.toString().trim())
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(assemblyLinesMock);
    }

    @Test
    @DisplayName("Should read file and make four assembly lines and print with success")
    void shouldReadFileAndMakeFourAssemblyLinesAndPrintResult() {

        ByteArrayOutputStream content = new ByteArrayOutputStream();
        System.setOut(new PrintStream(content));

        assemblyLineController.readInputFile("src/main/resources/input-4-assemblylines.txt");

        final String assemblyLinesMock = super.mockFourAssemblyLinesPrinteds();
        Assertions.assertThat(content.toString().trim())
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(assemblyLinesMock);
    }


    @Test
    @DisplayName("Should read file and return a blank result")
    void shouldReadFileAndReturnABlankResult() {

        ByteArrayOutputStream content = new ByteArrayOutputStream();
        System.setOut(new PrintStream(content));

        assemblyLineController.readInputFile("src/test/resources/not-existent-input.txt");

        Assertions.assertThat(content.toString().trim())
                .isBlank();
    }
}