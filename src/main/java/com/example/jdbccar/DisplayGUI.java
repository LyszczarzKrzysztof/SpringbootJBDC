package com.example.jdbccar;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Route
public class DisplayGUI extends VerticalLayout {

    private TextField textFieldMark;
    private TextArea textArea;
    private Button button;
    private CarDao carDao;

    @Autowired
    public DisplayGUI(CarDao carDao) {
        this.button = new Button("Display!");
        this.textFieldMark = new TextField("Mark");
        this.textArea = new TextArea();

        button.addClickListener(x -> {
            List<Map<String, Object>> map = carDao.showByMark(textFieldMark.getValue());
            textArea.setValue(map.toString());
        });

        this.carDao = carDao;

        add(textFieldMark, textArea, button);
    }
}
