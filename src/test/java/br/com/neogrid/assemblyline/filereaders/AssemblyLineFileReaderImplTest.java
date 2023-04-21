package br.com.neogrid.assemblyline.filereaders;

import br.com.neogrid.assemblyline.to.AssemblyLineProcessStepTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.List;


@TestMethodOrder(MethodOrderer.DisplayName.class)
public class AssemblyLineFileReaderImplTest {

    private static AssemblyLineFileReaderImpl assemblyLineFileReaderTxtImpl;

    @BeforeAll
    static void beforeAll() {
        assemblyLineFileReaderTxtImpl = new AssemblyLineFileReaderImpl();
    }

    @Test
    @DisplayName("Should read file with success")
    void shouldReadFileWithSuccess() {
        List<AssemblyLineProcessStepTO> lines = assemblyLineFileReaderTxtImpl.readLinesFromFile("src/test/resources/input.txt");

        Assertions.assertThat(lines).isNotNull()
                .isNotEmpty()
                .hasSize(19);
    }

    @Test
    @DisplayName("When fails on read file should return an empty collection")
    void whenFailsOnReadFileShouldReturnAnEmptyCollection() {
        List<AssemblyLineProcessStepTO> assemblyLineProcessSteps = assemblyLineFileReaderTxtImpl.readLinesFromFile("src/test/resources/not-existent-input.txt");

        Assertions.assertThat(assemblyLineProcessSteps).isEmpty();
    }
}