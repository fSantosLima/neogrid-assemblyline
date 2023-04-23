package br.com.neogrid.assemblyline.services;

import br.com.neogrid.assemblyline.filereaders.AssemblyLineFileReaderImpl;
import br.com.neogrid.assemblyline.to.AssemblyLineProcessStepTO;
import br.com.neogrid.assemblyline.to.AssemblyLineTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

@TestMethodOrder(MethodOrderer.DisplayName.class)
class AssemblyLineServiceTest {

    private static AssemblyLineService assemblyLineService;
    private static AssemblyLineFileReaderImpl assemblyLineFileReaderTxtImpl;
    @BeforeAll
    static void beforeAll() {
        assemblyLineFileReaderTxtImpl = new AssemblyLineFileReaderImpl();
        assemblyLineService = new AssemblyLineService();
    }

    @Test
    @DisplayName("Should return one assemblyline with success")
    void shouldReadFileThatHaveOneAssemblyLineWithSuccess() {
        List<AssemblyLineProcessStepTO> steps = assemblyLineFileReaderTxtImpl.readLinesFromFile("src/main/resources/input-1-assemblyline.txt");

        List<AssemblyLineTO> assemblyLines = assemblyLineService.getAssemblyLinesOrdinate(steps);

        Assertions.assertThat(assemblyLines)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);
    }

    @Test
    @DisplayName("Should return two assemblylines with success")
    void shouldReadFileThatHaveTwoAssemblyLinesWithSuccess() {
        List<AssemblyLineProcessStepTO> steps = assemblyLineFileReaderTxtImpl.readLinesFromFile("src/test/resources/input.txt");

        List<AssemblyLineTO> assemblyLines = assemblyLineService.getAssemblyLinesOrdinate(steps);

        Assertions.assertThat(assemblyLines)
                .isNotNull()
                .isNotEmpty()
                .hasSize(2);

    }

    @Test
    @DisplayName("Should return three assemblylines with success")
    void shouldReadFileThatHaveThreeAssemblyLinesWithSuccess() {
        List<AssemblyLineProcessStepTO> steps = assemblyLineFileReaderTxtImpl.readLinesFromFile("src/main/resources/input-3-assemblylines.txt");

        List<AssemblyLineTO> assemblyLines = assemblyLineService.getAssemblyLinesOrdinate(steps);

        Assertions.assertThat(assemblyLines)
                .isNotNull()
                .isNotEmpty()
                .hasSize(3);
    }

    @Test
    @DisplayName("Should return four assemblylines with success")
    void shouldReadFileThatHaveFourAssemblyLinesWithSuccess() {
        List<AssemblyLineProcessStepTO> steps = assemblyLineFileReaderTxtImpl.readLinesFromFile("src/main/resources/input-4-assemblylines.txt");

        List<AssemblyLineTO> assemblyLines = assemblyLineService.getAssemblyLinesOrdinate(steps);

        Assertions.assertThat(assemblyLines)
                .isNotNull()
                .isNotEmpty()
                .hasSize(4);
    }

    @Test
    @DisplayName("When fails on make assembly lines should return an empty collection")
    void whenFailsOnNakeAssemblyLinesShouldReturnAnEmptyCollection() {
        List<AssemblyLineTO> assemblyLines = assemblyLineService.getAssemblyLinesOrdinate(Arrays.asList());

        Assertions.assertThat(assemblyLines)
                .isEmpty();
    }
}