
//드래그앤 드롭
$(document).ready(function(){
	//드래그앤드롭 작동
	$(".fileDrop").on("dragenter dragover", function(event){
		//기본효과를 막음 - a tag 이동막음
		event.preventDefault();
		$(".fileDrop").css('background-color','#FFFFFF');

	});

	$(".fileDrop").on("drop", function(event){
		event.preventDefault();
		console.log(event);
		$(".fileDrop").css('border','#FFFFFF');
		$(".fileDrop").css('background-color','#E3F2FC');

		//드래그된 파일의 정보
		var files = event.originalEvent.dataTransfer.files;
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
			url: '/upload/uploadAjax',
			data: formData,
			dataType:'text',
			processData:false,
			contentType:false,
			type: 'POST',

			/*
				//시큐security를 적용했을때 ajax를쓰면 에러난당403
				beforeSend : function(xhr)
                 {  
                     xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");

                 },  
			 */
			success: function(data){
				/* alert("썸네일명 : "+data); */
				var str = "";
				//str = "<div><input type='text' hidden='true' name='petImg' value="+getImageLink(data)+">";
				//$(".uploadedList").append(str);

				//이미지 파일이면 썸네일 이미지 출력
				if(checkImageType(data)){
					/* alert(getImageLink(data)); */
					$(".uploadedList").empty();
					str = "<div><input type='text' hidden='true' required='required' name='petImg' value="+getImageLink(data)+">";
					str += "<a href='/upload/displayFile?fileName="+getImageLink(data)+"'>";
					str += "<img src='/upload/displayFile?fileName="+data+"'></a>";
					$(".fileDrop").css('background-color','#FFFFFF');
					//$("#dd").attr("disabled", true);
					//$("#dd").unbind("mouseenter mouseleave" );

				}
				str += "<span data-src="+data+"  name='petImg' >[삭제]</span></div>";
				$(".uploadedList").append(str);
				//리스

			}      
		}); 
		//alert("ddddddddddddddddd");
		//$("#dd *").attr('disabled', true);
		//$("#dd").find("div").prop("disabled", true);
		//$("#dd").unbind("mouseenter mouseleave" );

	});
	$(".uploadedList").on("click","span",function(event){
		
		//this : 클릭한 <span>
		var that = $(this);
		$.ajax({
			url:"/upload/deleteFile",
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

//제이쿼리로 강아지인지 고양이인지 값 넣기기
$(document).ready(function(){
	$("input:radio[name=petCode]").click(function(){
		var petCodeData = $(this).val();
		$.ajax({
			url:"/petCode",
			type:"GET",
			data: { petCode :petCodeData},

			success: function(selBreed){
				var str = "<option value='' selected='selected' >--품종 선택--</option>";
				for(var i=0 in selBreed){
					str += "<option value="+selBreed[i].breedCode+">"+selBreed[i].breedName+"</option>";
				}
				$(".breedCode option").remove();
				$(".breedCode").append(str);
			}
		});
	});

	//제이쿼리로 진단명 추출

	$("select[class=fClinic]").change(function(){
		var fCode =  $(this).val();
		$.ajax({
			url:"/sClinic",
			type:"GET",
			data: { "fCode" : fCode},
			success: function(sclinic){
				var str = "";

				str += "<option value='' required='required'> --중분류 -- </option>";
				for(var i=0 in sclinic){	
					str += "<option value="+sclinic[i].scode+">"+sclinic[i].sname+"</option>";
				}
				/* var str2 = "";
					for(var i=0 in sclinic){			
						str2 += "<option value="+sclinic[i].tcode+">"+sclinic[i].tname+"</option>";				
					} */
				$(".sClinic option").remove();
				$(".sClinic").append(str);	
				/* $("#tClinic option").remove();
					$("#tClinic").append(str2);	 */



			}
		});
	});
	$("select[class=sClinic]").change(function(){
		var sCode =  $(this).val();
		$.ajax({
			url:"/tClinic",
			type:"GET",		
			data: { "sCode" : sCode},	
			success: function(tclinic){
				var str = "";

				str += "<option value='' required='required'> --소분류 -- </option>";
				for(var i=0 in tclinic){	
					str += "<option value="+tclinic[i].tcode+">"+tclinic[i].tname+"</option>";				
				}
				$(".tClinic option").remove();
				$(".tClinic").append(str);				
			}
		});
	}); 

});

//의료기록 각자거 나오게-----------------------------------------------------------------------------------------------------------
$(document).ready(function(){
	$("h3").click(function(){
		var petId = $(this).attr("id");

		$.ajax({
			url:"/petMedicalList",
			type:"GET",

			data: { "petId" : petId},

			success: function(medicalList){
				var  str = "";
				var  money = 0;
				var i = 0;
				if(medicalList!=null){

					for( i in medicalList){


						str += "<tr><td>"+medicalList[i].clinicHos+"</td>";
						str += "<td><a href='javascript:void(0);' class='mSelectOpner' id="+ medicalList[i].medicalNo+"><span>"+medicalList[i].tcode.tname+"</span></a></td>";
						str += "<td>"+medicalList[i].medicalDate+"</td>";
						str += "<td>"+medicalList[i].medicalCost.toLocaleString()+"</td></tr>";
						money += +medicalList[i].medicalCost;

					}

				}else{
					str += "<tr><td>r</td><td>r</td><td>r</td><td>d</td></tr>";
				}

				i++;
				if(money == 0){
					i=0;
				}
				money = ""+i+"(건) / "+money.toLocaleString()+"(원)"+"";


				$(".medicalList tr").remove();
				$(".medicalList").append(str);
				//$(".money ").remove() 
				$(".money").text(money);

			}
		});		



		//에이젝스 2번 ok?-------------------------------------------------------------------------------------------

		$.ajax({
			url:"/petCycle",
			type:"GET",

			data: { "petId" : petId},

			success: function(cycle){

				var str2 = "<div><span style='color: red;'>"+cycle.lifeCycleNo.tcode.tname+"</span><br>";
				str2 += "<span style='color: red;'>("+cycle.clinicDate +")</span></div>";

				$(".petCycle div").remove();

				$(".petCycle").append(str2);

			}

		});		

		//ajax 3번째 예에~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
		$.ajax({
			url:"/petCycleList",
			type:"GET",

			data: { "petId" : petId},

			success: function(cycle){
				var  str = "<div>";
						
				for( i in cycle){		
					str += "<span>"+cycle[i].lifeCycleNo.tcode.tname+"  ("+cycle[i].clinicDate +")</span><br>";
				}
				
				str +="</div>";
				$("#cycleList div").remove();	
				$("#cycleList").append(str);	

			}
		});	
		//ajax 4번째 얼쑤!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
		$.ajax({
			url:"/petUCycleList",
			type:"GET",

			data: { "petId" : petId},

			success: function(cycle){
				
				var  str = "<div>";
				if(cycle!=""){
				for( i in cycle){
					
					str += "<span>"+cycle[i].lifeCycleNo.tcode.tname+"  ("+cycle[i].clinicDate +")</span><br>";

				}
				}else{
					str += "<span>지난 의료진단일이 없습니다.</span>";
				}
				str +="</div>";
				
				$("#ucycleList div").remove();	
				$("#ucycleList").append(str);	

			}
		});	
	
	});
});  


$(document).ready(function(){
	$("button[id=petDelete]").click(function(){
		var deletePet = $(this).val();

		
		if(confirm("삭제하시겠습니까?")){
			$.ajax({
				url:"/petDelete",
				type:"GET",

				data: { "deletePet" : deletePet},

				success: function(){
					
					location.reload();		
				}
			});					
		}
	});

	$("button[id=medicalDelete]").click(function(){
		var deleteMedical = $(this).val();

		if(confirm("삭제하시겠습니까?")){
			$.ajax({
				url:"/medicalDelete",
				type:"GET",

				data: { "deleteMedical" : deleteMedical},

				success: function(){
					
					location.reload();		
				}
			});					
		}
	});
}); 
//아코디언
$(function() {
	$("#accordion").accordion({
		collapsible : true,
		header : "> div > h3 ",

	})
});
/* 	.sortable({

			axis : "y",
			handle : "h3",
			stop : function(event, ui) {

				ui.item.children("h3").triggerHandler("focusout");
				$(this).accordion("refresh");
			}
		}); */
$(document).ready(function(){
	//데이터 피커
	$.datepicker.regional['kr'] = {
			monthNames: ['1 월','2 월','3 월','4 월','5 월','6 월','7 월','8 월','9 월','10 월','11 월','12 월'],
			//monthNamesShort: ['1 월','2 월','3 월','4 월','5 월','6 월','7 월','8 월','9 월','10 월','11 월','12 월'],	     
			monthNamesShort: ['1','2 ','3','4','5','6','7','8','9','10','11','12'],
			dayNamesMin: ['월','화','수','목','금','토','일'],
			dateFormat: 'yy-mm-dd'
	};

	$.datepicker.setDefaults($.datepicker.regional['kr']);

	$( ".datepicker" ).datepicker({ 
		yearRange: "-100:+0",
		showOn: "button",
		buttonImage: "image/calendar.png",
		buttonImageOnly: true,
		buttonText: "Select date",
		changeMonth: true,
		changeYear: true
	});

});

/*$(document).ready(function(){
	//모달
	$( ".openModal" ).dialog({
		autoOpen: false,
		modal:true,
		resizable: false,
		width: 600,
		height: 500,
		show: {
			effect: "Drop",
			duration: 500
		},
		hide: {
			effect: "Drop",
			duration: 1000
		}
	});
	$( ".opener" ).on( "click", function() {
		var thisPet = $(event.target).attr("id");
		var keyword = thisPet.substr(thisPet.indexOf("r")+1);
		var id;
		alert(thisPet);
		if(thisPet.match("update")){

			id = "#petUpdate"+keyword;

		}else if(thisPet.match("medical")){

			id = "#medicalInsert"+keyword;

		}
		$(id).dialog("open");

	});    	

	$( ".InsertOpener" ).on( "click", function() {


		$("#petInsert").dialog("open");
	});    	

	// $( ".mSelectOpner" ).on( "click", function() {
	$(document).on("click",".mSelectOpner",function(event) {
		var select = $(this).attr("id");
		var s = "#medicalUpdate"+select;
		$(s).dialog("open");
		//alert("됐닝?");
	});    	

});*/
$(document).ready(function(){
	
	//펫등록
	$(document).on("click", ".insertOpener", function(event) {
		$(".modal").show();
	});
	
	$(document).on("click", "#insertClose", function() {
		$(".modal").hide();
	});
	
	
	//펫수정
	$(document).on("click", ".updateOpener", function(event) {
		$(".petModal").show();
	});
	
	$(document).on("click", "#updateClose", function() {
		$(".petModal").hide();
	});
	
	//병원기록 등록
	$(document).on("click", ".medicalOpener", function(event) {
		$(".medicalModal").show();
	});
	
	$(document).on("click", "#medicalClose", function() {
		$(".medicalModal").hide();
	});
	
	//병원기록 수정
	$(document).on("click", ".mSelectOpner", function(event) {
		
		var key = "#mSelectModal"+$(this).attr("id");
		$(key).show();
	});
	
	$(document).on("click", "#mSelectClose", function() {
		$(".mSelectModal").hide();
	});
	
	//생애주기
	$(document).on("click", ".cycleOpener", function(event) {
		$(".cycleModal").show();
	});
	
	$(document).on("click", "#cycleClose", function() {
		$(".cycleModal").hide();
	});
	
	$(document).on("click", ".ucycleOpener", function(event) {
		$(".ucycleModal").show();
	});
	
	$(document).on("click", "#ucycleClose", function() {
		$(".ucycleModal").hide();
	});
	
	
	
});

