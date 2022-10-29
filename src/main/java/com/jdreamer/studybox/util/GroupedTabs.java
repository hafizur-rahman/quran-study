package com.jdreamer.studybox.util;

import javafx.scene.control.Pagination;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GroupedTabs {
    private Pagination[] paginations;
    private Tab[] tabs;
    private String[] files;

    public GroupedTabs(Tab[] tabs, Pagination[] paginations, String[] files) {
        this.tabs = tabs;
        this.paginations = paginations;
        this.files = files;

        initialize();
    }

    public void initialize() {
        for (int i = 0; i < paginations.length; i++) {
            new BookView(files[i], paginations[i]);
        }
    }

    public void syncView(int tabIndex, int pageIndex, boolean hide) {
        Image checkedIcon = new Image(getClass().getClassLoader().getResourceAsStream("checked.png"));

        for (int i = 0; i < paginations.length; i++) {
            if (tabIndex == i) {
                paginations[i].setCurrentPageIndex(pageIndex);
                tabs[i].setGraphic(new ImageView(checkedIcon));
            } else {
                if (hide) {
                    tabs[i].setGraphic(null);
                }
            }
        }
    }
}
