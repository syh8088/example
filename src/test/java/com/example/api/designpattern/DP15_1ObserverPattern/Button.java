package com.example.api.designpattern.DP15_1ObserverPattern;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer15Button")
public class Button {

    public void onClick(){
        //이벤트 처리
        if(onClickListener !=null)
            onClickListener.onClick(this);
    }

    public interface OnClickListener {
        public void onClick(Button button);
    }

    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

}