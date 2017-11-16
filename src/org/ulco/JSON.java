package org.ulco;

import java.lang.reflect.Constructor;

public class JSON {
    static public GraphicsObject parse(String json) {
        Object o = null;
        String str = json.replaceAll("\\s+", "");
        String type = str.substring(str.indexOf("type") + 5, str.indexOf(","));

        type = "org.ulco." + type.substring(0, 1).toUpperCase() + type.substring(1);

        try {
            Class<?> newClasse = Class.forName(type);
            Constructor<?> constructor = newClasse.getConstructor(String.class);
            o = constructor.newInstance(str);
        }catch (Exception e){
            System.out.println(e);
        }
        return (GraphicsObject) o;
    }

    static public Group parseGroup(String json) {
        return new Group(json);
    }

    static public Layer parseLayer(String json) {
        return new Layer(json);
    }

    static public Document parseDocument(String json) {
        return new Document(json);
    }
}
