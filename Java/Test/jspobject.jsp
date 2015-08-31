<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>JSPの暗黙オブジェクト</title>
</head>
<body>

<h1>JSPの暗黙オブジェクト</h1>

<p>入力されたパラメータ＝<%= request.getParameter("input") %></p>
<p>リクエストスコープのデータ＝<%= request.getAttribute("test1") %></p>

<%
	String data2=(String)session.getAttribute("test2");
	//出力する
	out.println("<p>セッションスコープのデータ＝"+data2+"</p>");

	String data3=(String)application.getAttribute("test3");
	//出力する
	out.println("<p>アプリケーションスコープのデータ＝"+data3+"</p>");
%>

<p>このJSP自身のクラス名＝<%= page.getClass().getName() %></p>

<%
	//JSPの初期化パラメータの取得
	String data4=config.getInitParameter("param1");
	out.println("<p>JSPの初期化パラメータ＝"+data4+"</p>");
%>

<%
	pageContext.setAttribute("test4",new String("データ４"));
%>

<%
	//暗黙オブジェクトの実装するインターフェイスを確認する
	Class[] ints=request.getClass().getInterfaces();

	for(int i=0;i<ints.length;i++){
		String name=ints[i].getName();

		//出力する
		out.println("<p>requestの実装するインターフェイスは"+name+"</p>");
	}
%>

<p>ページスコープのデータ＝<%= pageContext.getAttribute("test4") %></p>

<p>JspWriterを継承する具象クラスの名前＝<%= out.getClass().getName() %></p>

</body>
</html>
