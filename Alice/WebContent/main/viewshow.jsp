<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table table-stripped" id="reviews">
    <thead>
        <tr>
            <th>Rating</th> <!-- 평점 -->
            <th>User</th>
            <th>Text</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="review" items="${ reviews }" varStatus="status">
            <!-- 평점 기준 별표시 출력 -->
            <tr>
                <td><c:forEach var="rating" items="${ ratingOptions }" varStatus="status" begin="1" end="${ review.rating }">★</c:forEach></td>
                <td>익명</td>
                <td>${ review.text }</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>