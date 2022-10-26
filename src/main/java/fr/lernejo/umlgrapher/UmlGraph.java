package fr.lernejo.umlgrapher;

import java.util.*;

public class UmlGraph {
    private final Class<?>[] classes;
    private final Set<UmlType> types = new TreeSet<>(Comparator
        .<UmlType, String>comparing(UmlType::getClassName)
        .thenComparing(UmlType::getPackageName));
    private final Set<MermaidLiaison> liaisons = new TreeSet<>(Comparator
        .<MermaidLiaison, String>comparing(MermaidLiaison::getChildClassName)
        .thenComparing(MermaidLiaison::getParentClassName));

    public UmlGraph(Class... classes){

        this.classes = classes;
    }
    public String as(GraphType graph) {
        List<Class> classList = null;
        for (Class aClass : classes) {
            if(graph==GraphType.Mermaid) {
                classList = new InternalGraphRepresentation(aClass).findRelation();
                for (Class aClass2 : classList) {
                    types.add(new UmlType(aClass2));
                }
            }
        }
        return new MermaidFormatter(types).graphSentence() + new UmlRelation(types).relations(liaisons,types);
    }
}
