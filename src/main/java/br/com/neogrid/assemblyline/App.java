package br.com.neogrid.assemblyline;

import br.com.neogrid.assemblyline.controllers.AssemblyLineController;

public class App {

    public static void main(String[] args) {
        try {
            String fileName = getFilenameByArgs(args);
            new AssemblyLineController().readInputFile(fileName);
        } catch (Exception e) {
            System.err.println(String.format("Failed to read a file %s", e.getCause()));
        }
    }

    private static String getFilenameByArgs(String[] args) {
        String fileName;
        final String fileDefault = "src/main/resources/input.txt";
        if(args.length == 0) {
            return fileDefault;
        }
        final int fileIndicator = Integer.parseInt(args[0]);
        final String rootDirectory = "src/main/resources/";
        switch (fileIndicator) {
            case 1:
                fileName = rootDirectory + "input-1-assemblyline.txt";
                break;
            case 2:
                fileName = rootDirectory + "input.text";
                break;
            case 3:
                fileName = rootDirectory + "input-3-assemblylines.text";
                break;
            case 4:
                fileName = rootDirectory + "input-4-assemblylines.text";
                break;
            default:
                fileName = fileDefault;
                break;
        }
        return fileName;
    }
}
