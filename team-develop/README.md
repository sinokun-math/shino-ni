# Java Web programing

## 各テーブルの情報

### employee

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

### book_collection

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

### borrow_books

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

## 要求

* 「これから実装するクラス」を実装してほしい。
* 必要ならば作成済みクラスおよびtable情報を見せるのであまり自己判断せず要求してほしい。
* 三層構造を意識して
* 必要なクラスは追加で作って良い

### 作成済みのクラス

#### businesslogic.model

* BookCollection.java
* BookCollectionBorrowBooksEmployee.java
* BorrowBooks.java
* Employee.java
* LoginInfo.java
  * ログインを試みる人を表現するクラス。
  * フィールドはfinalでmailaddressとpassword
* LoginUser.java
  * ログイン者を表現するクラス。
  * employeeのfinalフィールドとコンストラクタ

#### businseelogic.service

* BookService.java
* Login.java
  * ログイン型の機能を集約させるクラス。

#### dataaccess.entity

* BookCollectionBorrowBooksEmployeeEntity.java
* BookCollectionEntity.java
* BorrowBooksEntity.java
* EmployeeEntity.java

#### dataaccess.dao

* BookCollectionBorrowBooksEmployeeDao.java
* BookCollectionDao.java
* BorrowBooksDao.java
* EmployeeDao.java

#### dataaccess.dao.util
  
* DatabaseConnection.java

#### presentation.controller
  
* BookListController.java
* BookRegistInputController.java
* BookUpdateConfirmController.java
* BookUpdateController.java
* BookUpdateInputController.java
* LoginController.java
  * menu.jspへforward処理

#### presentation.form
  
* LoginUserForm
  * 自然な変換のstaticメソッド LoginUserForm convertFrom(LoginUser model)を定義
  * ログインユーザが管理者かをflgAdminで識別するメソッドboolean isAdminUser()

#### webapp

* bookList.jsp (書籍一覧画面)
* bookRegistInput.jsp (書籍登録画面)
* bookUpdateComplete.jsp (書籍編集完了画面)
* bookUpdateConfirm.jsp (書籍編集確認画面)
* bookUpdateInput.jsp (書籍編集画面)
* login.jsp (ログイン画面)
* menu.jsp (メニュー画面)

### これから実装するクラス

#### bookList.jsp (書籍一覧画面) (変更)

* ログアウトボタン
* 入力フォーム (同ページで条件検索をかける、最初は全件検索の状態になっている)
  * 書籍名 : nm_book
  * 出版社 : publisher
  * 特記事項 : note
  
  * 「検索」ボタン
* メニューに戻る
* 検索結果(h2)
* header : data
  * 蔵書ID : id_book
  * ISBN : isbn
  * 書籍名 : nm_book
  * 書籍名読み : kn_book
  * 出版社 : publisher
  * 特記事項 : note
  * 操作 : 「貸出申請」ボタン, 「編集」ボタン(「編集」ボタンは管理者のみ表示, (->UpdateInputController.java(実装済)) )

#### presentation.controller.ApplicationInputContoller.java
  
* 書籍一覧画面から「貸出申請」ボタンを押下するとフォームが送信される。
* 書籍貸出申請画面へforward処理。

#### application.jsp (書籍貸出申請画面)

* ログイン者名「ログアウト」ボタン (align right)
* 入力フォーム
  * 蔵書ID : id_book (readonly)
  * 書籍名 : nm_book (readonly)
  * 貸出日 : date_borrow
  * 返却予定日 : date_scheduled_return
  * 「申請確認」ボタン
* 「書籍一覧に戻る」リンク(書籍一覧画面へ)

#### presentation.controller.ApplictionConfirmController.java

* 書籍貸出申請画面で「申請確認」ボタンを押下。
* 書籍貸出申請確認画面へforward処理。

#### applicationConfirm.jsp (書籍貸出申請確認画面)

* ログイン者名「ログアウト」ボタン (align right)
* 入力フォーム
  * 蔵書ID : id_book (readonly)
  * 書籍名 : nm_book (readonly)
  * 貸出日 : date_borrow (readonly)
  * 返却予定日 : date_scheduled_return (readonly)
  * 「申請」ボタン
* 「申請情報入力に戻る」リンク(書籍貸出申請画面へ)

#### presentation.controller.ApplicationController.java

* 書籍貸出申請確認画面で「申請」ボタンを押下。
* 貸出申請から、以下の書籍貸出申請(model)を作り、書籍貸出申請リストに追加する(管理者が操作できるセッションに保存)。
  * request_id
  * nm_employee
  * nm_book
  * date_request
  * date_borrow
  * date_scheduled_return
* 書籍貸出申請完了画面にforward処理。

#### applicationComplete.jsp (書籍貸出申請完了画面)

* ログイン者名「ログアウト」ボタン (align right)
* 貸出退出申請が完了しました。(h2)
* (同じ行)
  * 「書籍一覧に戻る」リンク(書籍一覧画面へ)
  * 「メニューに戻る」リンク(メニュー画面へ)

続けてこちらも作成する。

#### menu.jsp (メニュー画面)

* ログイン者名, 「ログアウト」ボタン (align right)
* 「書籍一覧」ボタン (書籍一覧画面へ)
* 「書籍貸出申請一覧」ボタン (管理者でログインしたときのみ表示)

#### presentation.controller.ApplicationListController.java

* メニュー画面にて書籍貸出申請一覧を押下。
* セッションから書籍貸出申請リストを取得。
* 書籍貸出届けで申請一覧画面にforward

#### applicationList.jsp (書籍貸出申請一覧画面)

* ログイン者名, 「ログアウト」ボタン (align right)
* 「メニューに戻る」リンク (メンニュー画面へ)
* 検索結果 (h2)
* header : data
  * 申請者名 : nm_employee
  * 書籍名 : nm_employee
  * 貸出日 : date_borrow
  * 返却予定日 : date_scheduled_return
  * 操作 : 「承認」 ボタン

#### presentation.controller.ApprovalConfirmController.java

* 書籍貸出申請一覧画面で「承認」ボタンを押下。
* 書籍貸出承認確認画面へforward

#### approvalConfirm.jsp (書籍貸出承認確認画面)

* ログイン者名, 「ログアウト」ボタン (align right)
* 確認用フォーム
  * 申請ID : id_request
  * 申請者名 : nm_employee
  * 申請日 : date_request
  * ISBN : isbn
  * 書籍名 : nm_book
  * 出版社 : publisher
  * 特記事項 : note
  * 貸出日 : date_borrow
  * 返却予定日 : date_scheduled_return

#### 備考1

関連して、書籍貸出申請リストや承認用の(書籍貸出確認画面における)書籍貸出申請情報のためのformないしmodelがあった方が良いと思う。presentation.controller.ApplicationController.javaも書き換える必要が出てくる。

また、bookList.jspがjspで書籍一覧表示を行っていてよろしくない。
presentation.controller.SelectBookController.javaをつくって機能を分割する。

## 書式貸出申請の承認却下

### approvalConfirm.jsp (書籍貸出承認確認画面の変更)

* ログイン者名, 「ログアウト」ボタン (align right)
* 確認用フォーム
  * 申請ID : id_request
  * 申請者名 : nm_employee
  * 申請日 : date_request
  * ISBN : isbn
  * 書籍名 : nm_book
  * 出版社 : publisher
  * 特記事項 : note
  * 貸出日 : date_borrow
  * 返却予定日 : date_scheduled_return
  * 「承認」ボタン, 「却下ボタン」
* 「承認待ち一覧へ戻る」リンク (書籍貸出申請一覧画面(approval.jsp)へ)

### presentation.controller.ApprovalController.java

* 書籍貸出確認画面で「承認」ボタンを押下。
* borrow_books.statusがステータスが 2: 「貸出中」になる。
* borrow_books.id_approvalおよびborrow_books.id_updateを承認を行った管理者ユーザのemployee.id_employeeに変更する。
* borrow_books.date_updateをその当日の日付と時刻に変更する。
* 書籍貸出承認完了画面にforward

### presentation.controller.ApprovalRejectController.java

* 書籍貸出確認画面で「却下」ボタンを押下。
* borrow_books.statusがステータスが 9: 「却下」になる。
* borrow_books.id_updateを却下を行った管理者ユーザのemployee.id_employeeに変更する。
* borrow_books.date_updateをその当日の日付と時刻に変更する。
* table.flg_lendingを'0':「貸出可」にする。
* 書籍貸出却下画面にforward

### approvalConplete.jsp (書籍貸出承認完了画面)

* ログイン者名, 「ログアウト」ボタン (align right)
* 書籍貸出申請を承認しました (h2)
* 「承認待ち一覧に戻る」リンク (書籍貸出申請一覧画面へ), 「メニューに戻る」リンク (メニュー画面へ)

### approvalRejected.jsp　(書籍貸却下画面)

* ログイン者名, 「ログアウト」ボタン (align right)
* 書籍貸出申請を却下しました (h2)
* 「承認待ち一覧に戻る」リンク (書籍貸出申請一覧画面へ), 「メニューに戻る」リンク (メニュー画面へ)

### 備考

* borrow_books.statusのとりうる値は'0': 返済済み, '1': 承認待ち, '2':貸出中 '9': 却下の四つ。デフォルトは'1'
* table.flb_lendingのとりうる値は'0':「貸出可」, '1':「貸出不可」。デフォルトは'0'
* 上二つの情報はdata定義や活用する上で何か加えた方が良いか？
* できるだけformやmodel, serviceを活用してjspやservletを簡潔に

## 後から加える

* login.jsp (ログイン画面)
  * 入力form
    1. mail_address
    2. password
  * 「ログイン」ボタン (align right)

* menu.jsp
  * ログイン者名, 「ログアウト」ボタン (align right)
  * 「書籍一覧」ボタン
  * 「書籍貸出申請一覧」ボタン

* bookList.jsp
  * 「ログアウト」ボタン (align right)
  * 条件検索のための入力フォーム
    1. 書籍(nm_book)
    2. 出版(publisher)
    3. 突起事項(note)
  * 「メニューに戻る」リンク (menu.jspへ)
  * 「書籍新規登録」ボタン
  * 検索結果(上の絞り込みに何も入力しなければ全件検索の結果)
    * 各カラムのheader : data
      1. 蔵書ID : id_book
      2. ISBN : isbn
      3. 書籍名 : nm_book
      4. 書籍名よみ : kn_book
      5. 出版社 : publisher
      6. 特記事項 : note
      7. 捜査 : 「編集」 BookRegistInputContoller.javaへbook_collectionの情報を持ってformする。 管理者としてログインしたときのみ表示される。

* bookUpdateConfirm.jsp
  * ログイン者名(align right)
  * 確認用フォーム header : value
    1. ISBN : isbn (readonly)
    2. 書籍名 : nm_book (readonly)
    3. 書籍名よみ : kn_book (readonly)
    4. 出版社 : publisher (readonly)
    5. 特記事項 : note (readonly)
  * 「書籍情報入力に戻る」リンク
    * bookUpdateInput.jspに戻り、各フォームには打ち込んだ内容が入っている

* bookUpdateInput.jsp (修正を加える)
  * それぞれの入力情報に, 編集前の情報がヒントテキストとして表示される

BookUpdateController.javaでbookList.jspに戻るのではなく、次の画面に遷移してほしい。

* bookUpdateComplete.jsp(書籍編集完了画面)
  * ログイン者名 , 「ログアウト」ボタン(align right)
  * 書籍編集が完了しました(h2)
  * (同じ行に横並びで)
    1. 「書籍一覧に戻る」リンク(bookList.jsp)
    2. 「メニューに戻る」リンク(menu.jsp)
 -->
