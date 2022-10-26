package fr.lernejo.umlgrapher;

import java.util.ArrayList;
import java.util.List;

public class InternalGraphRepresentation {
    private final Class aClass;
    InternalGraphRepresentation(Class aClass){
        this.aClass = aClass;
    }

    public List<Class> buildRelationList(List<Class> classList, Class... classes){
        for(Class i : classes){
            if(!classList.contains(i)) {
                classList.add(i);
                classList = buildRelationList(classList,i.getInterfaces());
            }
        }
        return classList;
    }
    public List<Class> findRelation(){
        List<Class> classList = new ArrayList<>();
        classList = buildRelationList(classList,this.aClass);
        return classList;
    }
}
