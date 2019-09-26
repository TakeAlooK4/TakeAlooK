//드래그앤 드롭
$(document).ready(function(){
	//상품사진
	 $("#mainImg").on("change",function(event){
		event.preventDefault();
		console.log(event);
		//드래그 앤 드랍인 경우
		//var files = event.originalEvent.dataTransfer.files;
		//input의 정보
		var files = event.originalEvent.target.files;
		//첫번째 파일
		var file = files[0];
		//콘솔에서 파일정보 확인
		/* 			console.log("콘솔");
			console.log(file);
		 */
		//이미지파일만 받기
		var fileN = file.name;	
		var ext = fileN.slice(fileN.lastIndexOf(".") + 1).toLowerCase(); 

		if (!(ext == "jpg" || ext == "png")) { 
			alertify.set('notifier','position', 'top-center');
			alertify.set('notifier','delay', 2);
			alertify.error("이미지파일 ( '.jpg' , '.png' )만 업로드 가능합니다.");
			return false; 

		}


		//ajax로 전달한 폼 객체
		var formData = new FormData();

		//폼 객체에 파일추가 append("변수명",값)
		formData.append("file",file); 

		//$("#dd *").prop("disabled", true);

		$.ajax({
			url: '/upload/uploadAjaxPro',
			data: formData,
			dataType:'text',
			processData:false,
			contentType:false,
			type: 'POST',

			success: function(data){
			
				var str = "";
				

				//이미지 파일이면 썸네일 이미지 출력
				if(checkImageType(data)){
					
					$("#productUpload").empty();
					str = "<div><input type='text' hidden='false' required='required' name='mainImg01' value="+getImageLink(data)+">";
					str += "<a href='/upload/displayFilePro?fileName="+getImageLink(data)+"'>";
					str += "<img src='/upload/displayFilePro?fileName="+data+"'></a>";
					$(".fileDrop").css('background-color','#FFFFFF');
					

				}
				str += "<span data-src="+data+"  name='mainImg' >[삭제]</span></div>";
				$("#productUpload").append(str);
				//리스

			}      
		}); 
		

	});
	//설명사진
	 $("#detailImg").on("change",function(event){
		event.preventDefault();
		console.log(event);
		//드래그 앤 드랍인 경우
		//var files = event.originalEvent.dataTransfer.files;
		//input의 정보
		var files = event.originalEvent.target.files;
		
		var file = files[0];
		var fileN = file.name;	
		var ext = fileN.slice(fileN.lastIndexOf(".") + 1).toLowerCase(); 

		if (!(ext == "jpg" || ext == "png")) { 
			alertify.set('notifier','position', 'top-center');
			alertify.set('notifier','delay', 2);
			alertify.error("이미지파일 ( '.jpg' , '.png' )만 업로드 가능합니다.");
			return false; 

		}


		//ajax로 전달한 폼 객체
		var formData = new FormData();

		//폼 객체에 파일추가 append("변수명",값)
		formData.append("file",file); 

		//$("#dd *").prop("disabled", true);

		$.ajax({
			url: '/upload/uploadAjaxPro',
			data: formData,
			dataType:'text',
			processData:false,
			contentType:false,
			type: 'POST',

			success: function(data){
			
				var str = "";
				

				//이미지 파일이면 썸네일 이미지 출력
				if(checkImageType(data)){
					
					$("#infotUpload").empty();
					str = "<div><input type='text' hidden='false' required='required' name='detailImg01' value="+getImageLink(data)+">";
					str += "<a href='/upload/displayFilePro?fileName="+getImageLink(data)+"'>";
					str += "<img src='/upload/displayFilePro?fileName="+data+"'></a>";
					$(".fileDrop").css('background-color','#FFFFFF');
					

				}
				str += "<span data-src="+data+"  name='mainImg' >[삭제]</span></div>";
				$("#infotUpload").append(str);
				//리스

			}      
		}); 
		

	});
	$(".uploadedList").on("click","span",function(event){
		alert("이미지 삭제")
		//this : 클릭한 <span>
		var that = $(this);
		$.ajax({
			url:"/upload/deleteFilePro",
			type: "post",
			//json방식
			data: {fileName:$(this).attr("data-src")},
			dataType: "text",
			success: function(result){
				//클릭한 span태그가 속한 div를 제거
				that.parent("div").remove();
			}
		});
	});
});
//원본파일이름을 목록에 출력하기위해
function getOriginalName(fileName){
	//이미지파일

	if(checkImageType(fileName)){
		return;

	}
	//uuid를 제외한 원라파일 이름을 리턴
	var idx = fileName.indexOf("-")+1;

	return fileName.substr(idx);
}
//이미지파일 링크 - 클릭하면 원본 이미지를 출력해주기 위해
function getImageLink(fileName){
	//이미지파일이 아니면
	if(!checkImageType(fileName)){
		return;

	}
	//이미지파일이면(썸네일이 아닌 원본이미지를 가져오기 위해)
	//년월일 경로 추출
	var front = fileName.substr(0,12);
	//년월일 경로와 s_를 제거한 원본 파일명을 추출
	var end = fileName.substr(14);
	console.log(front);
	console.log(end);
	console.log("DB저장명 :"+front+end);
	return front+end;
}

function checkImageType(fileName){
	var pattern = /jpg|gif|png|jpeg/i;
	return fileName.match(pattern);
}

$(document).ready(function(){
	$("select[id=pCodeS]").change(function(){
		
		var animalType = $("#animalType").val();
		var pCode =  $(this).val();
		/* alert(animalType+" "+pCode); */
		
		//this : 클릭한 <span>
		
		$.ajax({
			url:"/pCodeSelect",
			type:"GET",		
			data: { "pCode" : pCode,
					"animalType":animalType},	
			success: function(pCodeList){
				var str = "";
				console.log(pCodeList);
				str += "<option value='0' required='required'> 선택하세요. </option>";
				for(var i=0 in pCodeList){	
					str += "<option value="+pCodeList[i].pcode+">"+pCodeList[i].pname+"</option>";				
				}
				$("#pCode option").remove();
				$("#pCode").append(str);			
			}
		
		});
		if(pCode=='op'){
			
			$("#fp").hide();
			$("#mrm").hide();
		}
		if(pCode=='sn'||pCode=='fc'){
			$("#mrm").show();
			$("#fp").hide();
		};
		if(pCode=='ba'){
			$("#fp").show();
			$("#mrm").hide();
		};
		
		
	});
});
$(document).ready(function(){
	$("#cencelBtn").click(function(){
			location.href = "/";
	});
});