$(function(){
	
	$("#salary2").blur(function(){
//		alert("dss");
		if($("#salary2").val().length==0){alert("薪水为空")}
	});
	
	$("#workYear2").blur(function(){
		if($("#workYear2").val().length==0){alert("工作年份为空")}
	});
	$("#education2").blur(function(){
		if($("#education2").val().length==0){alert("学历为空")}
	});
	$("#city2").blur(function(){
		if($("#city2").val().length==0){alert("工作城市为空")}
	});
	$("#nums2").blur(function(){
		if($("#nums2").val().length==0){alert("招聘人数为空")}
	});
	$("#positionDetail2").blur(function(){
		if($("#positionDetail2").val().length==0){alert("招聘细节为空")}
	});
	$("#contacts2").blur(function(){
		if($("#contacts2").val().length==0){alert("联系人为空")}
	});
	$("#contactPhone2").blur(function(){
		if($("#contactPhone2").val().length==0){alert("招聘电话为空")}
	});	
//预览点击 

	$("#yul").hide();

//预览点击 
	
	$("#prev").click(function(){
		
//		alert("d2d"+$("#city2").val())
		$("#salary3").val($("#salary2").val());
		$("#positionName3 ").val($("#positionName").val());
		$("#jobNature3 ").text($("#jobNature2").val());
		$("#workYear3 ").val($("#workYear2").val());
		$("#education3").val($("#education2").val());
		$("#city3").val($("#place").val());
		$("#nums3").val($("#nums2").val());
		$("#positionDetail3").text($("#positionDetail2").val());
		$("#contacts3").val($("#contacts2").val());
		$("#contactPhone3").val($("#contactPhone2").val());
		$("#yul").show();
		
		$("#jobForm").hide();
		
	});
	$("#closde").click(function(){
		$("#jobForm").show();
		$("#yul").hide();
	});
	
	
	
	$("#jobname li").click(function(){
		var id= $(this).attr("id");
		
		$("#jnid").val(id);
	});
});
	function checs(){
	if($("#salary2").val().length==0){alert("薪水为空");return false}
	if($("#workYear2").val().length==0){alert("工作年份为空");return false}
	if($("#education2").val().length==0){alert("学历为空");return false}
	if($("#nums2").val().length==0){alert("招聘人数为空");return false}
	if($("#positionDetail2").val().length==0){alert("招聘细节为空");return false}
	if($("#contacts2").val().length==0){alert("联系人为空");return false}
	if($("#contactPhone2").val().length==0){alert("招聘电话为空");return false}
//	alert("d1")
	alert("dd"+document.getElementById("#jobForm").elements.length);
	}
 		
	