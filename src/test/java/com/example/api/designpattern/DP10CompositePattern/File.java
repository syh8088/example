package com.example.api.designpattern.DP10CompositePattern;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer10File")
public class File extends Component  {

    public File(String name) {
        super(name);
    }

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}