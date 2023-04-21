package br.com.neogrid.assemblyline.interfaces;

import br.com.neogrid.assemblyline.to.AssemblyLineProcessStepTO;

import java.io.IOException;
import java.util.List;

public interface AssemblyLineFileReader {
    List<AssemblyLineProcessStepTO> readLinesFromFile (String pathFile) throws IOException;
}
