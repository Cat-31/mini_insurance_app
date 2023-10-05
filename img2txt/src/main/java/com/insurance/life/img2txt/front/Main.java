package com.insurance.life.img2txt.front;

import com.insurance.life.img2txt.remote.ImageDTO;
import com.insurance.life.img2txt.remote.ImageInfoDTO;
import com.insurance.life.img2txt.remote.ImageService;
import com.insurance.life.img2txt.remote.OcrService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("/main")
public class Main extends SplitLayout {

    private List<ImageInfoDTO> imgList;
    private int currentIndex;

    public Main(ImageService imageService, OcrService ocrService) {
        setHeight("100%");
        setSplitterPosition(50);
        VerticalLayout main = new VerticalLayout();
        main.setHeight("100%");
        addToPrimary(main);

        Image image = new Image();
        image.setWidth("100%");

        main.add(image);

        VerticalLayout secondary = new VerticalLayout();
        main.setHeight("100%");

        addToPrimary(main);
        addToSecondary(secondary);


        TextField barCode = new TextField();
        Button button = new Button("Get");
        Button save = new Button("Save & Next");

        button.addClickListener(o -> {
            currentIndex = 0;
            imgList = imageService.getInfo(barCode.getValue());
            ImageDTO dto = imageService.getImg(imgList.get(currentIndex).getId());
            image.setSrc("data:image/png;base64, " + dto.getBase64Image());
            currentIndex++;
            save.setText("Save & Next (%d/%d)".formatted(currentIndex, imgList.size()));
        });

        secondary.add(new HorizontalLayout(barCode, button), new Hr());

        TextField name = new TextField("Name");
        TextField birthDate = new TextField("BirthDate");
        TextField address = new TextField("Address");

        secondary.add(name, birthDate, address);

        secondary.add(new Hr());
        Button ocr = new Button("OCR");
        ocr.addClickListener(o-> {
            List<String> lst = ocrService.ocr(imgList.get(currentIndex).getId());
            // This is just a demo, requires some layout parse.
            name.setValue(lst.get(2));
            birthDate.setValue(lst.get(3));
            address.setValue(lst.get(5));
        });


        save.addClickListener(o-> {
            ImageDTO dto = imageService.getImg(imgList.get(currentIndex).getId());
            image.setSrc("data:image/png;base64, " + dto.getBase64Image());
            currentIndex++;
            if (currentIndex < imgList.size() ) {
                o.getSource().setText("Save & Next (%d/%d)".formatted(currentIndex, imgList.size()));
            }
        });


        secondary.add(new HorizontalLayout(ocr, save));
    }

}
