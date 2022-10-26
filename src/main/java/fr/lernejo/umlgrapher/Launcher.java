package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command
public class Launcher implements Runnable {
    @Option(names = {"-c", "--classes"}, required = true, description = "Class to analyse")
    private final Class<?>[] aClass = {};
    @Option(names = {"-g", "--graph-type"}, description = "Graph type")
    private final GraphType graphType = GraphType.Mermaid;

    @Override
    public void run() {
        UmlGraph graph = new UmlGraph(aClass);
        String output = graph.as(graphType);
        System.out.println(output);
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new Launcher()).execute(args);
        System.exit(exitCode);
    }
}
