<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form>
        <div class="form-group">
            <label for="username">username</label>
            <input type="text" class="form-control" placeholder="Enter username" id="username">
        </div>

        <div class="form-group">
            <label for="email">Email address:</label>
            <input type="email" class="form-control" placeholder="Enter email" id="email">
        </div>

        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" placeholder="Enter password" id="pwd">
        </div>
    </form>
        <button id="save-btn" class="btn btn-primary">회원가입</button>
</div>
<%@ include file="../layout/footer.jsp" %>

