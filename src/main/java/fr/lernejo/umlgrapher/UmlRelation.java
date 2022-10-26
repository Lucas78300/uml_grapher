package fr.lernejo.umlgrapher;

import java.util.Set;

public class UmlRelation {
    private final Set<UmlType> types;

    UmlRelation(Set<UmlType> types){
        this.types = types;

    }

    public Set<MermaidLiaison> relation(Set<MermaidLiaison> liaisons){
        String relation;
        for(UmlType type : types){
            Class[] classes = type.getMyClass().getInterfaces();
            for(Class aClass : classes){
                if(type.getMyClass().getSuperclass()==null){
                    relation = aClass.getSimpleName()+" <|-- " + type.getMyClass().getSimpleName() + " : extends";
                }
                else{
                    relation = aClass.getSimpleName()+" <|.. " + type.getMyClass().getSimpleName() + " : implements";
                }
                relation +="\n";
                liaisons.add(new MermaidLiaison(aClass,type.getMyClass(),relation));
            }
        }
        return liaisons;
    }
    public String relations(Set<MermaidLiaison> liaisons, Set<UmlType> types){
        String relation = "";
        liaisons = new UmlRelation(types).relation(liaisons);
        for (MermaidLiaison liaison : liaisons) {
            relation += liaison.getLiaison();
        }
        return relation;
    }
}
