/*<![CDATA[*/
var num = "[[${data.commNo}]]";
/*]]>*/

/*<![CDATA[*/
var num2= "[[${data2.commNo.commNo}]]";
/*]]>*/


//댓글 목록 
function commentList(){
	console.log(num)
    $.ajax({
        url : '/community/ment',
        type : 'get',
        data : {num:num},
        success : function(data){
        	//console.log(data)
            var a =''; 
          	  $.each(data, function(key, value){ 
                a += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
                a += '<div class="commentInfo'+value.cmentNo+'">'+'댓글번호 : '+value.cmentNo+' / 작성자 : '+value.nickname.nickname+'/ '+value.cmentDate;
                a += '<a onclick="commentUpdate('+value.cmentNo+',\''+value.cmentContents+'\');"> 수정 </a>';
                a += '<a onclick="commentDelete('+value.cmentNo+');"> 삭제 </a> </div>';
                a += '<div class="commentContent'+value.cmentNo+'"> <p> 내용 : '+value.cmentContents +'</p>';
                a += '</div></div>';
                console.log(value)
            });

            $(".commentList").html(a);
        }
    });
}

function commentInsert(insertData){
    $.ajax({
        url : '/community/insert',
        type : 'post',
        data : insertData,
        success : function(data){

                commentList(); //댓글 작성 후 댓글 목록 reload
                $('[name=cmentContents]').val('');
          
        }
    });
}

function commentUpdate(cmentNo, cmentContents){
    var a ='';
    
    a += '<div class="input-group">';
    a += '<input type="text" class="form-control" name="content_'+cmentNo+'" value="'+cmentContents+'"/>';
    a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdateProc('+cmentNo+');">수정</button> </span>';
    a += '</div>';
    
    $('.commentContent'+cmentNo).html(a);
    
}

function commentUpdateProc(cmentNo){
    var updateContent = $('[name=content_'+cmentNo+']').val();
    console.log(updateContent)
    $.ajax({
        url : '/community/update',
        type : 'post',
        data : {cmentContents : updateContent, cmentNo : cmentNo},
        success : function(data){
        	console.log(data)
        	console.log(cmentContents)
           commentList(num); //댓글 수정후 목록 출력 
        }
    });
}

function commentDelete(cmentNo){
    $.ajax({
        url : '/community/delete/'+cmentNo,
        type : 'post',
        success : function(data){
            commentList(num); //댓글 삭제후 목록 출력 
        }
    });
}

$(document).ready(function(){
    commentList(); //페이지 로딩시 댓글 목록 출력
    $('[name=commentInsertBtn]').click(function(){ //댓글 등록 버튼 클릭시 
        var insertData = $('[name=commentInsertForm]').serialize(); //commentInsertForm의 내용을 가져옴
        commentInsert(insertData); //Insert 함수호출(아래)
    });
});