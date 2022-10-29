package com.jdreamer.studybox.util;

public class BookViewNavigation {
    private GroupedTabs lugatualQuran;
    private GroupedTabs jalalainArabic;
    private GroupedTabs jalalainBengali;

    public BookViewNavigation(GroupedTabs lugatualQuran, GroupedTabs jalalainArabic, GroupedTabs jalalainBengali) {
        this.lugatualQuran = lugatualQuran;
        this.jalalainArabic = jalalainArabic;
        this.jalalainBengali = jalalainBengali;
    }

    public void syncBookViews(int chapter, int verseNo, boolean hide) {
        Index.findIndex(chapter, verseNo).ifPresent(index -> {
            // Hide unused tabs

            // Navigate to starting of relevant page
            lugatualQuran.syncView(index.getLugatulQuran().getBookIndex(),
                    index.getLugatulQuran().getPageRange().getMinimum(), hide);
            jalalainArabic.syncView(index.getJalalainArabic().getBookIndex(),
                    index.getJalalainArabic().getPageRange().getMinimum(), hide);
            jalalainBengali.syncView(index.getJalalainBengali().getBookIndex(),
                    index.getJalalainBengali().getPageRange().getMinimum(), hide);
        });
    }
}
