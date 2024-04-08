<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <%@page import="com.example.secondhandMarkets.vo.UserVo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Secondhand Markets</title>
<link rel="stylesheet" href="${path}/resources/css/SpringBoardStyle.css">
<script src="${path}/resources/js/SpringBoardJavascript.js"></script>

<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"/>
<!-- head 안에 추가 -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"/>

    <!-- include summernote css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"/>

</head>
<body>
<%
// 세션값 가져오기
UserVo userInfo = (UserVo) session.getAttribute("loginUser");
%>
<div align="center">
<h1>Secondhand Markets</h1>
<form action="/formOk.do" method="post">
<input id = 'sno' type=hidden name=sno size=1 value="${msno.sno}" readonly>
<table border=1>
<tr><td> <input type=text id=sname name=sname class="fm" value="<%=userInfo.getId()%>"> </td></tr>
<tr><td colspan=2> <input type=text id=title name=title class="fm" placeholder="제목을 입력해 주세요." size=130> </td></tr>
<tr><td colspan=2>* 음란물, 차별, 비하, 혐오 및 초상권, 저작권 침해 게시물은 민, 형사상의 책임을 질 수 있습니다. [저작권법 안내] [게시물 활용 안내]</td></tr>
<tr><td colspan=2> <textarea name=contents class="fm" id="contents" rows="10" cols="100"> </textarea>
    <script>
        $('#contents').summernote({

            // 에디터 크기 설정
            height: 800,
            // 에디터 한글 설정
            lang: 'ko-KR',
            // 에디터에 커서 이동 (input창의 autofocus라고 생각하시면 됩니다.)
            toolbar: [
                // 글자 크기 설정
                ['fontsize', ['fontsize']],
                // 글자 [굵게, 기울임, 밑줄, 취소 선, 지우기]
                ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
                // 글자색 설정
                ['color', ['color']],
                // 표 만들기
                ['table', ['table']],
                // 서식 [글머리 기호, 번호매기기, 문단정렬]
                ['para', ['ul', 'ol', 'paragraph']],
                // 줄간격 설정
                ['height', ['height']],
                // 이미지 첨부
                ['insert',['picture']]
            ],
            // 추가한 글꼴
            fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
            // 추가한 폰트사이즈
            fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72','96'],
            // focus는 작성 페이지 접속시 에디터에 커서를 위치하도록 하려면 설정해주세요.
            focus : true,
            // callbacks은 이미지 업로드 처리입니다.
            callbacks : {
                onImageUpload : function(files, editor, welEditable) {
                    // 다중 이미지 처리를 위해 for문을 사용했습니다.
                    for (var i = 0; i < files.length; i++) {
                        imageUploader(files[i], this);
                    }
                }
            }

        });

        function imageUploader(file, el) {
            var formData = new FormData();
            formData.append('file', file);

            $.ajax({
                data : formData,
                type : "POST",
                // url은 자신의 이미지 업로드 처리 컨트롤러 경로로 설정해주세요.
                url : '/post/image-upload',
                contentType : false,
                processData : false,
                enctype : 'multipart/form-data',
                success : function(data) {
                    $(el).summernote('insertImage', "${path}/resources/assets/images/upload/"+data, function($image) {
                        $image.css('width', "100%");
                        $image.attr('data-filename', 'retriever');
                    });
                    // 값이 잘 넘어오는지 콘솔 확인 해보셔도됩니다.
                    console.log(data);
                }
            });
        }
    </script>
</td></tr>

<tr><td colspan=2 align="center"><input type=submit onclick="save()" value="등록">
&emsp;<input type=button onclick="goBack()" value="취소"></td></tr>
</table>
</form>

</div>
</body>
</html>

