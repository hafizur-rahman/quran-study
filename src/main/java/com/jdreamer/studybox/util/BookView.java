package com.jdreamer.studybox.util;

import com.jdreamer.studybox.pdf.PdfModel;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;

import java.nio.file.Paths;

public class BookView {
    private String filePath;
    private Pagination pagination;
    private PdfModel model;

    public BookView(String filePath, Pagination pagination) {
        this.filePath = filePath;
        this.pagination = pagination;

        initialize();
    }

    private void initialize() {
        model = new PdfModel(Paths.get(filePath));

        pagination.setPageCount(model.numPages());
        pagination.setPageFactory(index -> {
            ImageView view = new ImageView(model.getImage(index));
            view.setFitHeight(1600);
            view.setFitWidth(1200);

            ScrollPane scroll = new ScrollPane();
            scroll.setPrefHeight(1600);
            scroll.setPrefWidth(1200);
            scroll.setContent(view);

            return scroll;
        });
    }
}
