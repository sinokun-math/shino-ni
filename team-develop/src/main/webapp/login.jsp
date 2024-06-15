<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="UTF-8">
	<!-- CSSの読み込み -->
	<link rel="stylesheet" href=".css/style.css">
	<link rel="stylesheet" href=".css/all.min.css">
	<title>ログイン画面</title>
</head>

<body>
	<form action="menu.jsp">
		<h1>ログイン</h1>
		<table>
			<tr>
				<th class="header">メールアドレス</th>
				<td style="width: 250px;"><input type="email" placeholder="メールアドレス" style="width: 100%;" required /></td>
			</tr>
			<tr>
				<th style="text-align: right;">パスワード</th>
				<td><input type="password" placeholder="パスワード" style="width: 100%;" required /></td>
			</tr>
			<tr>
				<td colspan="2" class="btnArea"><input type="submit" value="ログイン" /></td>
			</tr>
		</table>
	</form>
</body>

</html>
