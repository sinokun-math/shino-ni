package businesslogic.model;

import java.sql.Timestamp;

public final class BookCollection {
    private final int id;
    private final String isbn;
    private final String nmBook;
    private final String knBook;
    private final String publisher;
    private final String note;
    private final boolean isLendable;
    private final int updatedBy;
    private final Timestamp updatedAt;

    private BookCollection(Builder builder) {
        this.id = builder.id;
        this.isbn = builder.isbn;
        this.nmBook = builder.nmBook;
        this.knBook = builder.knBook;
        this.publisher = builder.publisher;
        this.note = builder.note;
        this.isLendable = builder.isLendable;
        this.updatedBy = builder.updatedBy;
        this.updatedAt = builder.updatedAt;
    }

    // Gettersのみを提供し、フィールドを変更するsetterは提供しない
    public int getId() { return id; }
    public String getIsbn() { return isbn; }
    public String getName() { return nmBook; }
    public String getKanaName() { return knBook; }
    public String getPublisher() { return publisher; }
    public String getNote() { return note; }
    public boolean isLendable() { return isLendable; }
    public int getUpdatedBy() { return updatedBy; }
    public Timestamp getUpdatedAt() { return updatedAt; }

    // ビルダークラス
    public static class Builder {
        private int id;
        private String isbn;
        private String nmBook;
        private String knBook;
        private String publisher;
        private String note;
        private boolean isLendable;
        private int updatedBy;
        private Timestamp updatedAt;

        // 必須フィールド用のコンストラクタ
        public Builder(int id, String isbn, String name, boolean isLendable, int updatedBy, Timestamp updatedAt) {
            this.id = id;
            this.isbn = isbn;
            this.nmBook = name;
            this.isLendable = isLendable;
            this.updatedBy = updatedBy;
            this.updatedAt = updatedAt;
        }

        // オプションフィールドのためのメソッド
        public Builder knBook(String knBook) {
            this.knBook = knBook;
            return this;
        }

        public Builder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder note(String note) {
            this.note = note;
            return this;
        }

        // ビルドメソッド
        public BookCollection build() {
            return new BookCollection(this);
        }
    }
}
