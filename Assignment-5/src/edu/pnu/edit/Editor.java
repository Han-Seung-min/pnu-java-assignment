package edu.pnu.edit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import edu.pnu.shape.*;

public class Editor {
    private List<Shape> shapes = new ArrayList<>();

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public void clear() {
        shapes.clear();
    }

    public void list() {
        Iterator<Shape> it = shapes.iterator();
        String str = "[";
        while (it.hasNext()){
            Shape shape = it.next();
            str += shape.toString();

            if(it.hasNext()){
                str += ", ";
            }
        }
        str += "]";

        System.out.println(str);
    }
}
