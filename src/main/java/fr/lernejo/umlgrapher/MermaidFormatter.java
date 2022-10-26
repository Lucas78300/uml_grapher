package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;
import java.util.Set;

public class MermaidFormatter {
    private final Set<UmlType> types;

    MermaidFormatter(Set<UmlType> types){
        this.types = types;
    }

    public String graphSentence(){
        String sentence = "classDiagram\n";
        for(UmlType type: types){
            sentence += "class " + type.getClassName();
            if(Modifier.isInterface(type.getMyClass().getModifiers())){
                sentence += " {\n    <<interface>>\n}";
            }
            sentence += "\n";
        }
        return sentence;
    }
}
