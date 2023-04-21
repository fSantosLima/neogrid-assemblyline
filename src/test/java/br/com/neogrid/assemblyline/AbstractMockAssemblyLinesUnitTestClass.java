package br.com.neogrid.assemblyline;

public abstract class AbstractMockAssemblyLinesUnitTestClass {
    protected String mockAssemblyLinePrinted() {
        return ("Linha de montagem 1:\n" +
                "09:00 Cutting of steel sheets 60 mins\n" +
                "10:00 Safety sensor assembly 60 mins\n" +
                "11:00 Injection subsystem assembly 60 mins\n" +
                "12:00 Almoço \n" +
                "13:00 Tempering sub-zero (Heat treatment) 45 mins\n" +
                "13:45 Pieces washing 45 mins\n" +
                "14:30 Steel bearing assembly 45 mins\n" +
                "15:15 Nitriding process 45 mins\n" +
                "16:00 Compliance check 30 mins\n" +
                "16:30 Ginástica laboral ").replaceAll("\\n|\\r\\n", System.getProperty("line.separator")).trim();
    }
    protected String mockTwoAssemblyLinesPrinteds() {
        return ("Linha de montagem 1:\n" +
                "09:00 Cutting of steel sheets 60 mins\n" +
                "10:00 Safety sensor assembly 60 mins\n" +
                "11:00 Injection subsystem assembly 60 mins\n" +
                "12:00 Almoço \n" +
                "13:00 Navigation subsystem assembly 60 mins\n" +
                "14:00 Torque converter subsystem calibration 60 mins\n" +
                "15:00 Tempering sub-zero (Heat treatment) 45 mins\n" +
                "15:45 Pieces washing 45 mins\n" +
                "16:30 Ginástica laboral \n" +
                "\n" +
                "Linha de montagem 2:\n" +
                "09:00 Steel bearing assembly 45 mins\n" +
                "09:45 Nitriding process 45 mins\n" +
                "10:30 Setup of lock and control device 45 mins\n" +
                "11:15 Seal installation 45 mins\n" +
                "12:00 Almoço \n" +
                "13:00 Austenpera (Heat treatment) 30 mins\n" +
                "13:30 Axis calibration 30 mins\n" +
                "14:00 Compliance check 30 mins\n" +
                "14:30 Left stabilizer bar alignment 30 mins\n" +
                "15:00 Right stabilizer bar alignment 30 mins\n" +
                "15:30 Application of decals 30 mins\n" +
                "16:00 Monitoring subsystem assembly 30 mins\n" +
                "16:30 Ginástica laboral").replaceAll("\\n|\\r\\n", System.getProperty("line.separator")).trim();
    }

    protected String mockThreeAssemblyLinesPrinteds() {
        return ("Linha de montagem 1:\n" +
                "09:00 Cutting of steel sheets 60 mins\n" +
                "10:00 Safety sensor assembly 60 mins\n" +
                "11:00 Injection subsystem assembly 60 mins\n" +
                "12:00 Almoço \n" +
                "13:00 Navigation subsystem assembly 60 mins\n" +
                "14:00 Torque converter subsystem calibration 60 mins\n" +
                "15:00 Cutting of steel sheets 60 mins\n" +
                "16:00 Safety sensor assembly 60 mins\n" +
                "17:00 Ginástica laboral \n" +
                "\n" +
                "Linha de montagem 2:\n" +
                "09:00 Safety sensor assembly 60 mins\n" +
                "10:00 Navigation subsystem assembly 60 mins\n" +
                "11:00 Tempering sub-zero (Heat treatment) 45 mins\n" +
                "11:45 Pieces washing 45 mins\n" +
                "12:30 Steel bearing assembly 45 mins\n" +
                "13:15 Nitriding process 45 mins\n" +
                "14:00 Setup of lock and control device 45 mins\n" +
                "14:45 Seal installation 45 mins\n" +
                "15:30 Tempering sub-zero (Heat treatment) 45 mins\n" +
                "16:15 Ginástica laboral \n" +
                "\n" +
                "Linha de montagem 3:\n" +
                "09:00 Pieces washing 45 mins\n" +
                "09:45 Steel bearing assembly 45 mins\n" +
                "10:30 Austenpera (Heat treatment) 30 mins\n" +
                "11:00 Axis calibration 30 mins\n" +
                "11:30 Compliance check 30 mins\n" +
                "12:00 Almoço \n" +
                "13:00 Left stabilizer bar alignment 30 mins\n" +
                "13:30 Right stabilizer bar alignment 30 mins\n" +
                "14:00 Application of decals 30 mins\n" +
                "14:30 Monitoring subsystem assembly 30 mins\n" +
                "15:00 Austenpera (Heat treatment) 30 mins\n" +
                "15:30 Axis calibration 30 mins\n" +
                "16:00 Assembly line cooling - maintenance 5 mins\n" +
                "16:05 Ginástica laboral ").replaceAll("\\n|\\r\\n", System.getProperty("line.separator")).trim();
    }

    protected String mockFourAssemblyLinesPrinteds() {
        return ("Linha de montagem 1:\n" +
                "09:00 Cutting of steel sheets 60 mins\n" +
                "10:00 Safety sensor assembly 60 mins\n" +
                "11:00 Injection subsystem assembly 60 mins\n" +
                "12:00 Almoço \n" +
                "13:00 Navigation subsystem assembly 60 mins\n" +
                "14:00 Torque converter subsystem calibration 60 mins\n" +
                "15:00 Cutting of steel sheets 60 mins\n" +
                "16:00 Safety sensor assembly 60 mins\n" +
                "17:00 Ginástica laboral \n" +
                "\n" +
                "Linha de montagem 2:\n" +
                "09:00 Safety sensor assembly 60 mins\n" +
                "10:00 Navigation subsystem assembly 60 mins\n" +
                "11:00 Injection subsystem assembly 60 mins\n" +
                "12:00 Almoço \n" +
                "13:00 Navigation subsystem assembly 60 mins\n" +
                "14:00 Torque converter subsystem calibration 60 mins\n" +
                "15:00 Tempering sub-zero (Heat treatment) 45 mins\n" +
                "15:45 Pieces washing 45 mins\n" +
                "16:30 Ginástica laboral \n" +
                "\n" +
                "Linha de montagem 3:\n" +
                "09:00 Steel bearing assembly 45 mins\n" +
                "09:45 Nitriding process 45 mins\n" +
                "10:30 Setup of lock and control device 45 mins\n" +
                "11:15 Seal installation 45 mins\n" +
                "12:00 Almoço \n" +
                "13:00 Tempering sub-zero (Heat treatment) 45 mins\n" +
                "13:45 Pieces washing 45 mins\n" +
                "14:30 Steel bearing assembly 45 mins\n" +
                "15:15 Nitriding process 45 mins\n" +
                "16:00 Setup of lock and control device 45 mins\n" +
                "16:45 Ginástica laboral \n" +
                "\n" +
                "Linha de montagem 4:\n" +
                "09:00 Seal installation 45 mins\n" +
                "09:45 Austenpera (Heat treatment) 30 mins\n" +
                "10:15 Axis calibration 30 mins\n" +
                "10:45 Compliance check 30 mins\n" +
                "11:15 Left stabilizer bar alignment 30 mins\n" +
                "11:45 Right stabilizer bar alignment 30 mins\n" +
                "12:15 Application of decals 30 mins\n" +
                "12:45 Monitoring subsystem assembly 30 mins\n" +
                "13:15 Austenpera (Heat treatment) 30 mins\n" +
                "13:45 Axis calibration 30 mins\n" +
                "14:15 Compliance check 30 mins\n" +
                "14:45 Left stabilizer bar alignment 30 mins\n" +
                "15:15 Right stabilizer bar alignment 30 mins\n" +
                "15:45 Application of decals 30 mins\n" +
                "16:15 Ginástica laboral \n").replaceAll("\\n|\\r\\n", System.getProperty("line.separator")).trim();
    }
}
