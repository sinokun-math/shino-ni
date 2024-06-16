# 1
javaServlet jspを用いた開発を想定して次のentityとdaoとmodel のコードを生成してほしい。
1. database名: book_manage
2.テーブル名: book_collection
3.クラス名dataaccess.entity.BookCollectionEntity.java, dataaccess.dao.BookCollectionEntity.java, businesslogic.model.BookCollection.java
4.book_collectionの属性と型
* id_book: int autoincrement 
* isbn: varchar(13)
* nm_book: varchar(50)
* kn_book: varchar(100)
* publisher: varchar(50)
* note: text
* flg_lending: char(1)
* id_update: int
* date_update: timestamp
5. field名はそれぞれの属性名をアンダースコアなしでキャメルケースで書いたものとする
6. ResultSetからentityへの変換とmodelからentityへの変換を行うメソッドentity convirtFrom(entity|dao)とentityからmodelを作るcreateBookCollection(entity)およびcreateBookCollectionをList<BookCollectionEntity>にmapしたcreateBookCollectionListを作る。

＃2
javaServlet jspを用いた開発を想定して次のentityとdaoとmodel のコードを生成してほしい。
1. database名: book_manage
2.テーブル名: employee
3.クラス名dataaccess.entity.EmployeeEntity.java, dataaccess.dao.EmployDao.java, businesslogic.model.employee.java
4.employeeの属性と型
* id_employee: int autoincrement 
* nm_employee: varchar(50)
* kn_employee: varchar(100)
* mail_address: varchar(256)
* password: varchar(256)
* flg_addmin: char(1)
* flg_retirement: char(1)
* id_update: int
* date_update: timestamp
5. 各クラスのfield名はそれぞれの属性名をアンダースコアなしでキャメルケースで書いたものとする
6. businesslogic.model.Employee.javaにおいては各fieldはprivate finalで宣言し、constructorで初期化する。
7. dataaccess.entity.EmployeeEntity.javaに自然な変換メソッドEmployeeEntity convertFrom(ResultSet resultSet)を定義する(setterを使って定義)。
8. dataaccess.entity.EmployeeEntity.javaに自然な変換メソッドEmployeeEntity convertFrom(Employee model)を定義(Constructorを使って定義)
9. dataaccess.entity.EmployeeEntity.javaに自然な変換メソッドEmployee createEmployee(EmployeeEntity entity)および、そのList<EmployeeEntity>へのmapであるメソッドcreateEmployeeListを定義。

＃3
javaServlet jspを用いた開発を想定して次のentityとdaoとmodel のコードを生成してほしい。
1. database名: borrow_books
2.テーブル名: employee
3.クラス名dataaccess.entity.BorrowBooksEntity.java, dataaccess.dao.BorrowBooksDao.java, businesslogic.model.BorrowBooks.java
4.borrow_booksの属性と型
* id_request: int autoincrement 
* id_applicant: int
* id_book: int
* date_request: date
* status: char(1)
* id_approval: int
* date_approval: date
* date_borrow: date
* date_scheduled_return: date
* date_return: date
* id_update: int
* date_update: timestamp
5. 各クラスのfield名はそれぞれの属性名をアンダースコアなしでキャメルケースで書いたものとする
6. businesslogic.model.BorrowBooks.javaにおいては各fieldはprivate finalで宣言し、constructorで初期化する。
7. dataaccess.entity.BorrowBooks.javaに自然な変換メソッドBorrowBooksEntity convertFrom(ResultSet resultSet)を定義する(setterを使って定義)。
8. dataaccess.entity.BorrowBooksEntity.javaに自然な変換メソッドBorrowBooksEntity convertFrom(BorrowBooks model)を定義(Constructorを使って定義)
9. dataaccess.entity.BorrowBooksEntity.javaに自然な変換メソッドBorrowBooks createBorrowBooks(BorrowBooksEntity entity)および、そのList<BorrowBooksEntity>へのmapであるメソッドcreateBorrowBooksListを定義。


# 4
table borrow_booksはid_applicantでemployee.id_employeeを, id_bookでbook_collection.id_bookを参照している。
1. 結合テーブル用に次のクラスを作って
* businesslogic.model.BookCollectionBorrowBooksEmployee.java
* dataaccess.entity.BookCollectionBorrowBooksEmployeeEntity.java
* dataaccess.dao.BookCollectionBorrowBooksEmployeeDao.java
2. entityのクラスには自然な変換のメソッドBorrowBooksEntity convertFrom(ResultSet resultSet) throws SQLExceptionを定義する。

# 各テーブルの情報
## employee
* id_employee
    * int autoincrement 
* nm_employee
    * varchar(50)
* kn_employee
    * varchar(100)
* mail_address
    * varchar(256)
* password
    * varchar(256)
* flg_addmin
    * char(1)
* flg_retirement
    * char(1)
* id_update
    * int
* date_update
    * timestamp
## book_collection
* id_book
    * int autoincrement 
* isbn
    * varchar(13)
* nm_book
    * varchar(50)
* kn_book
    * varchar(100)
* publisher
    * varchar(50)
* note
    * text
* flg_lending
    * char(1)
* id_update
    * int
* date_update
    * timestamp
## borrow_books
* id_request
    * int autoincrement 
* id_applicant
    * int
* id_book
    * int
* date_request
    * date
* status
    * char(1)
* id_approval
    * int
* date_approval
    * date
* date_borrow
    * date
* date_scheduled_return
    * date
* date_return
    * date
* id_update
    * int
* date_update
    * timestamp

# 必要ならば作成済みクラスおよびtable情報を見せるので自己判断せず要求してほしい。

### 作成済みのクラス
* businesslogic.model
    * BookCollection.java
    * BorrowBooks.java
    * BookCollectionBorrowBooksEmployee.java
    * Employee.java
* dataaccess.entity
    * BookCollectionBorrowBooksEmployeeEntity.java
    * BorrowBooksEntity.java
    * BookCollectionEntity.java
    * EmployeeEntity.java
* BookCollectionBorrowBooksEmployeeDao.java
    * BorrowBooksDao.java
    * BookCollectionDao.java
    * EmployeeDao.java
    * util
        * DatabaseConnection.java
### これから実装するクラス
* login.jsp (ログイン画面)
    * 入力form
        * mail_address
        * password
    * 「ログイン」ボタン (align right)
* LoginController.java (/login)
    * menu.jspへforward処理
* menu.jsp
    * ログイン者名, 「ログアウト」ボタン (align right)
    * 「書籍一覧」ボタン
    * 「書籍貸出申請一覧」ボタン
* 
