package br.com.neogrid.assemblyline;

import br.com.neogrid.assemblyline.controllers.AssemblyLineController;

public class App {
    public static void main(String[] args) {
        try {
            new AssemblyLineController().readInputFile(args[0]);
        } catch (Exception e) {
            System.err.println(String.format("Failed to read a file %s", e.getCause()));
        }
    }
}
