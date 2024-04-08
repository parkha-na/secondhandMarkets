
function del(str){
	alert("확인:" +str);
	location.href="/del.do?sno="+str ;
}

function goBack(){
	window.history.back();
}
  
function goPage(){
	window.location.href = "/form.do";
}

function btnGo() {
	location.href="/signup.do";
}
	
function btnLogOut() {
	location.href="/logout.do";
}

window.onload = function() {
	var link = document.querySelector('#link');
	link.removeAttribute('href');
}

function loginCheck() {
	var btnLogout = document.getElementById('btnLogout');
	var loginForm = document.getElementById('loginForm');
	var posting = document.getElementById('posting');
	var id = $('#loginForm').find("input[name='id']").val();	
	var sno = document.getElementById('link');
    var password1 = $('#loginForm').find("input[name='password1']").val();
    var link = document.getElementById('link');
	$.ajax({
	    url: '/loginCheck.do',
	    method: 'post',
	    data : {"id": id, "password1": password1},
	    dataType : 'json',
	    success: function (data) {
	    	if (data.status) {
	    		
	    		alert("로그인 성공");
	    		btnLogout.style.visibility = 'visible';
	    		loginForm.style.visibility = 'hidden';
	    		posting.style.visibility = 'visible';
	    		if (sno != null) {
					sno = document.getElementById('link').textContent;
	    			link.setAttribute('href', "/detail.do?sno="+sno);
	    		}
	    	} else {
	    		alert("로그인이 실패하였습니다.");
	    	}
	    }
	});
}

link.addEventListener("click", function(n){
					location.href = "/detail.do?sno="+n;
				});

function mvEdit(sno){
	location.href="/edit.do?sno=" + sno;
}

function delCom(sno) {
	$.ajax({
	    type: "POST",
                url: '/deleteComments.do',
                data: {sno: sno},
                success: function (response) {
                    window.location.reload();
                }
            });
        }

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