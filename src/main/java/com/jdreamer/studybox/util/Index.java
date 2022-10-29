package com.jdreamer.studybox.util;

import org.apache.commons.lang3.Range;

import java.util.Arrays;
import java.util.Optional;

public class Index {
    public static NavIndex[] BOOK_INDICES = {
            new NavIndex(2, Range.between(1, 5),
                    new BookIndex(0, Range.between(1, 30)),
                    new BookIndex(0, Range.between(1, 30)),
                    new BookIndex(0, Range.between(1, 30))),
            new NavIndex(2, Range.between(6, 10),
                    new BookIndex(0, Range.between(30, 40)),
                    new BookIndex(0, Range.between(30, 40)),
                    new BookIndex(0, Range.between(30, 40))),
            new NavIndex(2, Range.between(75, 79),
                    new BookIndex(0, Range.between(63, 64)),
                    new BookIndex(0, Range.between(10, 10)),
                    new BookIndex(0, Range.between(213, 220))),
            new NavIndex(2, Range.between(80, 85),
                    new BookIndex(0, Range.between(64, 66)),
                    new BookIndex(0, Range.between(11, 12)),
                    new BookIndex(0, Range.between(221, 233))),
    };
    
    public static Optional<NavIndex> findIndex(int chapter, int verseNo) {
        return Arrays.stream(Index.BOOK_INDICES)
                .filter(index -> index.getChapter() == chapter && index.getVerseRange().contains(verseNo))
                .findFirst();
    }

    public static class BookIndex {
        int bookIndex;
        Range<Integer> pageRange;

        public BookIndex(int bookIndex, Range<Integer> pageRange) {
            this.bookIndex = bookIndex;
            this.pageRange = pageRange;
        }

        public int getBookIndex() {
            return bookIndex;
        }

        public Range<Integer> getPageRange() {
            return pageRange;
        }
    }

    public static class NavIndex {
        int chapter;
        Range<Integer> verseRange;
        BookIndex lugatulQuran;
        BookIndex jalalainArabic;
        BookIndex jalalainBengali;

        public NavIndex(int chapter, Range<Integer> verseRange, BookIndex lugatulQuran,
                        BookIndex jalalainArabic, BookIndex jalalainBengali) {
            this.chapter = chapter;
            this.verseRange = verseRange;
            this.lugatulQuran = lugatulQuran;
            this.jalalainArabic = jalalainArabic;
            this.jalalainBengali = jalalainBengali;
        }

        public int getChapter() {
            return chapter;
        }

        public Range<Integer> getVerseRange() {
            return verseRange;
        }

        public BookIndex getLugatulQuran() {
            return lugatulQuran;
        }

        public BookIndex getJalalainArabic() {
            return jalalainArabic;
        }

        public BookIndex getJalalainBengali() {
            return jalalainBengali;
        }
    }
}
