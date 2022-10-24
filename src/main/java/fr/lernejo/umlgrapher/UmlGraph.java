package fr.lernejo.umlgrapher;

public class UmlGraph {

    public UmlGraph(Class<?>...classes) {
    }
    public String as(GraphType graph){
        if (graph == GraphType.Mermaid){
            return """
            classDiagram
            class Machin {
                <<interface>>
            }
            """;
        }
        return  null;
    }
}
