package fr.lernejo;

import fr.lernejo.umlgrapher.GraphType;
import fr.lernejo.umlgrapher.UmlGraph;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UmlGraphTests {
    @Test
    void empty_interface_with_no_relation() {
        UmlGraph graph = new UmlGraph(Machin.class);
        String output = graph.as(GraphType.Mermaid);
        Assertions.assertThat(output).isEqualTo("""
            classDiagram
            class Machin {
                <<interface>>
            }
            """);
    }

    @Test void empty_class_with_no_relation(){
        UmlGraph graph = new UmlGraph(Truc.class);
        String output = graph.as(GraphType.Mermaid);
        Assertions.assertThat(output).isEqualTo("""
            classDiagram
            class Truc {
                <<class>>
            }
            """);
    }

    interface Machin {
    }
    public class Truc {
    }
}
