package fr.lernejo.umlgrapher;

public class UmlGraph {

    private final Class<?>[] aClass;

    public UmlGraph(Class<?>... aClass) {
        this.aClass = aClass;
    }

    public String as(GraphType graph){
        String graphSentence = "classDiagram\n";;
        for(Class myClass : aClass) {
            if(graph==GraphType.Mermaid) {
                graphSentence = graphSentence + "class " + myClass.getSimpleName();
                if (myClass.isInterface()) {
                    graphSentence = graphSentence + " {\n" + "    <<interface>>\n" + "}\n";
                }
                else {
                    graphSentence = graphSentence + " {\n" + "    <<class>>\n" + "}\n";
                }
            }
        }
        return graphSentence;
    }
}
