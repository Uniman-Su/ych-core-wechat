package com.ych.core.wechat.mp.message;

import java.util.List;

import com.ych.core.wechat.mp.Button;

/**
 * 创建按钮的请求
 */
public class CreateMenuRequest {

    public CreateMenuRequest() {
    }

    public CreateMenuRequest(List<Button> button) {
        this.button = button;
    }

    /**
     * 要创建的按钮
     */
    private List<Button> button;

    /**
     * @return 要创建的按钮
     */
    public List<Button> getButton() {
        return button;
    }

    /**
     * @param button
     *         要创建的按钮
     */
    public void setButton(List<Button> button) {
        this.button = button;
    }
}
