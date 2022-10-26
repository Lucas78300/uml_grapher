package fr.lernejo.umlgrapher;

public class MermaidLiaison {
    private final String childClassName;
    private final String parentClassName;
    private final String liaison;

    public MermaidLiaison(Class parentClassName, Class childClassName, String liaison){
        this.childClassName = childClassName.getSimpleName();
        this.parentClassName = parentClassName.getSimpleName();
        this.liaison = liaison;
    }

    public String getChildClassName(){
        return this.childClassName;
    }

    public String getParentClassName(){
        return this.parentClassName;
    }
    public String getLiaison(){
        return this.liaison;
    }

}
