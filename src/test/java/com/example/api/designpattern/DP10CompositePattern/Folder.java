package com.example.api.designpattern.DP10CompositePattern;

import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

@Alias("designatternVer10Folder")
public class Folder extends Component {
    public Folder(String name) {
        super(name);
    }

    List<Component> children = new ArrayList<>();

    public boolean addComponent(Component component){
        return children.add(component);
    }

    public boolean removeComponet(Component component){
        return children.remove(component);
    }

    public List<Component> getChildren() {
        return children;
    }

}
