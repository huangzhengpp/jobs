$(function(){
	var pageNo = 1;
	$("#field").change(function(){
		$("#class").contents().remove();
		$("#job").contents().remove();
		var field = $("#field").val();
		$.ajax({
			url:"json/selectJobClass",
			data:{"jobField.jfid":field},
			dataType:"json",
			success:function(date){
				var list = date.jobClasses;
				var jobClass = date.jobClass;
				$.each(list,function(){
					var t = $("<option value='"+this.jcid+"'>"+this.jcname+"</option>");
					$("#class").append(t);
				})
				$.each(jobClass.jobNames,function(){
					var tt = $("<option value='"+this.jnid+"'>"+this.jnname+"</option>");
					$("#job").append(tt);
				})
			}
		})
	});
	
	$("#class").change(function(){
		$("#job").contents().remove();
		var classid = $("#class").val();
		$.ajax({
			url:"json/selectJobName",
			data:{"jobClass.jcid":classid},
			dataType:"json",
			success:function(date){
				var list = date.jobNames;
				$.each(list,function(){
					var t = $("<option value='"+this.jnid+"'>"+this.jnname+"</option>");
					$("#job").append(t);
				})
			}
		})
	});
	
	
	$("#bt1").click(function(){
    	pageNo=1;
      $("#div1").contents().remove();
      $("#div2").contents().remove();
      $("#sum").contents().remove();
      var jobName = $("#job").val();
      var date = $("#jiReledate").val();
      var trade = $("#trade").val();
      var stuts = $("input[name='check']:checked").val();  
      $.ajax({  
			    url:"json/selectByHigh",
			    data:{"pageNo":1,"jobName.jnid":jobName,"date":date,"trade.tid":trade,"status":stuts},
			    dataType:"json",
			    success:function(date){
			      var list = date.list;
			      var pageNo1= date.pageNo;
			      var pageNum1 = date.pageNum;
			      var sum = date.sum;
			      if(!list.length==0){
			    	 
					$.each(list,function(){
					         var comInfo = this.comInfo;
					    	 var date = this.jiReledate.substr(0,10);
					    	 
					    	 var tt="<br/><dd><table><ul class='reset my_jobs'><li><h3>"+
									   "<a href='selectCombInforAdmin?comInfo.cid="+comInfo.cid+"'>"
									   +"编号:"+this.jiid+"."+
									   comInfo.comName+"</a><span>需求数量("+this.jiNum+")</span></h3>"+
									   "<div>职位："+this.jobName.jnname+"/工资:"+this.jiSal+"/学历要求："+this.jiEdu+
									   "</div><div class='c9'>发布时间："+date+"</div>"
						   
					    	 if(this.jiStatus==1){
					    		 tt = tt+"<div>审核状态：已通过</div>";
					    	 }
					    	 if(this.jiStatus==2){
					    		 tt = tt+"<div>审核状态：未通过</div>";
					    	 }
						     tt = tt+"<div class='links'><a href='selectJaobInforAdmin?jobInfo.jiid="+this.jiid+"'><input class='job' type='button' id="+this.jiid+" value='修改'/></a></div></li></ul></table></dd>"
						     $("#div1").append($(tt));
					    
					});
				 }
			      var t = $("<span>"+pageNo1+"/"+pageNum1+"</span>"); 
				  $("#div2").append(t);
				  $("#pageNum").val(pageNum1);
				  var zz = $("<span>总条数："+sum+"</span>");
				  $("#sum").append(zz);
			    }
		});
		
    });
	
	$("#shouye").click(function(){
		if(pageNo<=1){	
		}else{
		  pageNo = 1;
		  $("#div1").contents().remove();
	      $("#div2").contents().remove();
	      $("#sum").contents().remove();
	      var jobName = $("#job").val();
	      var date = $("#jiReledate").val();
	      var trade = $("#trade").val();
	      var stuts = $("input[name='check']:checked").val();  
	      $.ajax({  
				    url:"json/selectByHigh",
				    data:{"pageNo":1,"jobName.jnid":jobName,"date":date,"trade.tid":trade,"status":stuts},
				    dataType:"json",
				    success:function(date){
				      var list = date.list;
				      var pageNo1= date.pageNo;
				      var pageNum1 = date.pageNum;
				      var sum = date.sum;
				      if(!list.length==0){
				    	 
						$.each(list,function(){
						         var comInfo = this.comInfo;
						    	 var date = this.jiReledate.substr(0,10);
						    	 
						    	 var tt="<br/><dd><table><ul class='reset my_jobs'><li><h3>"+
										   "<a href='selectCombInforAdmin?comInfo.cid="+comInfo.cid+"'>"
										   +"编号:"+this.jiid+"."+
										   comInfo.comName+"</a><span>需求数量("+this.jiNum+")</span></h3>"+
										   "<div>职位："+this.jobName.jnname+"/工资:"+this.jiSal+"/学历要求："+this.jiEdu+
										   "</div><div class='c9'>发布时间："+date+"</div>"
							   
						    	 if(this.jiStatus==1){
						    		 tt = tt+"<div>审核状态：已通过</div>";
						    	 }
						    	 if(this.jiStatus==2){
						    		 tt = tt+"<div>审核状态：未通过</div>";
						    	 }
							     tt = tt+"<div class='links'><a href='selectJaobInforAdmin?jobInfo.jiid="+this.jiid+"'><input class='job' type='button' id="+this.jiid+" value='修改'/></a></div></li></ul></table></dd>"
							     $("#div1").append($(tt));
						    
						});
					 }
				      var t = $("<span>"+pageNo1+"/"+pageNum1+"</span>"); 
					  $("#div2").append(t);
					  $("#pageNum").val(pageNum1);
					  var zz = $("<span>总条数："+sum+"</span>");
					  $("#sum").append(zz);
				    }
			});
		}	
	    });
	    
	 $("#shangyiye").click(function(){
		 if(pageNo<=1){	
			}else{
	    	pageNo=pageNo-1;
	    	$("#div1").contents().remove();
		      $("#div2").contents().remove();
		      $("#sum").contents().remove();
		      var jobName = $("#job").val();
		      var date = $("#jiReledate").val();
		      var trade = $("#trade").val();
		      var stuts = $("input[name='check']:checked").val();  
		      $.ajax({  
					    url:"json/selectByHigh",
					    data:{"pageNo":pageNo,"jobName.jnid":jobName,"date":date,"trade.tid":trade,"status":stuts},
					    dataType:"json",
					    success:function(date){
					      var list = date.list;
					      var pageNo1= date.pageNo;
					      var pageNum1 = date.pageNum;
					      var sum = date.sum;
					      if(!list.length==0){
					    	 
							$.each(list,function(){
							         var comInfo = this.comInfo;
							    	 var date = this.jiReledate.substr(0,10);
							    	 
							    	 var tt="<br/><dd><table><ul class='reset my_jobs'><li><h3>"+
											   "<a href='selectCombInforAdmin?comInfo.cid="+comInfo.cid+"'>"
											   +"编号:"+this.jiid+"."+
											   comInfo.comName+"</a><span>需求数量("+this.jiNum+")</span></h3>"+
											   "<div>职位："+this.jobName.jnname+"/工资:"+this.jiSal+"/学历要求："+this.jiEdu+
											   "</div><div class='c9'>发布时间："+date+"</div>"
								   
							    	 if(this.jiStatus==1){
							    		 tt = tt+"<div>审核状态：已通过</div>";
							    	 }
							    	 if(this.jiStatus==2){
							    		 tt = tt+"<div>审核状态：未通过</div>";
							    	 }
								     tt = tt+"<div class='links'><a href='selectJaobInforAdmin?jobInfo.jiid="+this.jiid+"'><input class='job' type='button' id="+this.jiid+" value='修改'/></a></div></li></ul></table></dd>"
								     $("#div1").append($(tt));
							    
							});
						 }
					      var t = $("<span>"+pageNo1+"/"+pageNum1+"</span>"); 
						  $("#div2").append(t);
						  $("#pageNum").val(pageNum1);
						  var zz = $("<span>总条数："+sum+"</span>");
						  $("#sum").append(zz);
					    }
				});
			}	
		    });
	    
	    $("#xiayiye").click(function(){
	    	 var pageNum = $("#pageNum").val();
	    	 if(pageNo>=pageNum){	
				}else{
	    	    pageNo=pageNo+1;
		    	$("#div1").contents().remove();
			      $("#div2").contents().remove();
			      $("#sum").contents().remove();
			      var jobName = $("#job").val();
			      var date = $("#jiReledate").val();
			      var trade = $("#trade").val();
			      var stuts = $("input[name='check']:checked").val();  
			      $.ajax({  
						    url:"json/selectByHigh",
						    data:{"pageNo":pageNo,"jobName.jnid":jobName,"date":date,"trade.tid":trade,"status":stuts},
						    dataType:"json",
						    success:function(date){
						      var list = date.list;
						      var pageNo1= date.pageNo;
						      var pageNum1 = date.pageNum;
						      var sum = date.sum;
						      if(!list.length==0){
						    	 
								$.each(list,function(){
								         var comInfo = this.comInfo;
								    	 var date = this.jiReledate.substr(0,10);
								    	 
								    	 var tt="<br/><dd><table><ul class='reset my_jobs'><li><h3>"+
												   "<a href='selectCombInforAdmin?comInfo.cid="+comInfo.cid+"'>"
												   +"编号:"+this.jiid+"."+
												   comInfo.comName+"</a><span>需求数量("+this.jiNum+")</span></h3>"+
												   "<div>职位："+this.jobName.jnname+"/工资:"+this.jiSal+"/学历要求："+this.jiEdu+
												   "</div><div class='c9'>发布时间："+date+"</div>"
									   
								    	 if(this.jiStatus==1){
								    		 tt = tt+"<div>审核状态：已通过</div>";
								    	 }
								    	 if(this.jiStatus==2){
								    		 tt = tt+"<div>审核状态：未通过</div>";
								    	 }
									     tt = tt+"<div class='links'><a href='selectJaobInforAdmin?jobInfo.jiid="+this.jiid+"'><input class='job' type='button' id="+this.jiid+" value='修改'/></a></div></li></ul></table></dd>"
									     $("#div1").append($(tt));
								    
								});
							 }
						      var t = $("<span>"+pageNo1+"/"+pageNum1+"</span>"); 
							  $("#div2").append(t);
							  $("#pageNum").val(pageNum1);
							  var zz = $("<span>总条数："+sum+"</span>");
							  $("#sum").append(zz);
						    }
					});
				}  
	    });
	    
	    $("#moye").click(function(){
		      var pageNum = $("#pageNum").val();
		      if(pageNo>=pageNum){	
				}else{
		      pageNo=pageNum;
		    	$("#div1").contents().remove();
			      $("#div2").contents().remove();
			      $("#sum").contents().remove();
			      var jobName = $("#job").val();
			      var date = $("#jiReledate").val();
			      var trade = $("#trade").val();
			      var stuts = $("input[name='check']:checked").val();  
			      $.ajax({  
						    url:"json/selectByHigh",
						    data:{"pageNo":pageNo,"jobName.jnid":jobName,"date":date,"trade.tid":trade,"status":stuts},
						    dataType:"json",
						    success:function(date){
						      var list = date.list;
						      var pageNo1= date.pageNo;
						      var pageNum1 = date.pageNum;
						      var sum = date.sum;
						      if(!list.length==0){
						    	 
								$.each(list,function(){
								         var comInfo = this.comInfo;
								    	 var date = this.jiReledate.substr(0,10);
								    	 
								    	 var tt="<br/><dd><table><ul class='reset my_jobs'><li><h3>"+
												   "<a href='selectCombInforAdmin?comInfo.cid="+comInfo.cid+"'>"
												   +"编号:"+this.jiid+"."+
												   comInfo.comName+"</a><span>需求数量("+this.jiNum+")</span></h3>"+
												   "<div>职位："+this.jobName.jnname+"/工资:"+this.jiSal+"/学历要求："+this.jiEdu+
												   "</div><div class='c9'>发布时间："+date+"</div>"
									   
								    	 if(this.jiStatus==1){
								    		 tt = tt+"<div>审核状态：已通过</div>";
								    	 }
								    	 if(this.jiStatus==2){
								    		 tt = tt+"<div>审核状态：未通过</div>";
								    	 }
									     tt = tt+"<div class='links'><a href='selectJaobInforAdmin?jobInfo.jiid="+this.jiid+"'><input class='job' type='button' id="+this.jiid+" value='修改'/></a></div></li></ul></table></dd>"
									     $("#div1").append($(tt));
								});
							 }
						      var t = $("<span>"+pageNo1+"/"+pageNum1+"</span>"); 
							  $("#div2").append(t);
							  $("#pageNum").val(pageNum1);
							  var zz = $("<span>总条数："+sum+"</span>");
							  $("#sum").append(zz);
						    }
					});
				}
	    });
	    
});