$(function(){
        var pageNo = 1;
	    
	    $("#shouye").click(function(){
	    	if(pageNo<=1){
				
			}else{
	      pageNo = 1;
	      var pageNum = $("#pageNum").val();
	      var comName = $("#comName").val().trim();
	      $("#div1").contents().remove();
	      $("#div2").contents().remove();
	      $("#sum").contents().remove();
	      $.ajax({  
				    url:"json/selectUncheckedByNameAdmin",
				    data:{"pageNo":1,"status":"0","comInfo.comName":comName},
				    dataType:"json",
				    success:function(date){
				      var list = date.list;
				      var pageNo1= date.pageNo;
				      var pageNum1 = date.pageNum;
				      var sum = date.sum;
				      if(!list.length==0){
						$.each(list,function(){
						     var comInfo = this.comInfo;
						     if(this.jiStatus==0){
						    	 var date = this.jiReledate.substr(0,10);
						    	 var t=$("<br/><dd><table><ul class='reset my_jobs'><li><h3>"+
										   "<a href='selectCombInforAdmin?comInfo.cid="+comInfo.cid+"'>"
										   +"编号:"+this.jiid+"."+
										   comInfo.comName+"</a><span>需求数量("+this.jiNum+")</span></h3>"+
										   "<div>职位："+this.jobName.jnname+"/工资:"+this.jiSal+"/学历要求："+this.jiEdu+
										   "</div><div class='c9'>发布时间："+date+"</div><div class='links'>"+
										   "<a href='selectJaobInforAdmin?jobInfo.jiid="+this.jiid+"'><input class='job' type='button' id="+this.jiid+" value='审核'/></a></div></li></ul></table></dd>");
							   
							   $("#div1").append(t);
						     }
						});
					 }
				      var tt = $("<span>"+pageNo1+"/"+pageNum1+"</span>"); 
					  $("#div2").append(tt);
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
		      var pageNum = $("#pageNum").val();
		      var comName = $("#comName").val().trim();
		      $("#div1").contents().remove();
		      $("#div2").contents().remove();
		      $("#sum").contents().remove();
		      $.ajax({  
					    url:"json/selectUncheckedByNameAdmin",
					    data:{"pageNo":pageNo,"status":"0","comInfo.comName":comName},
					    dataType:"json",
					    success:function(date){
					      var list = date.list;
					      var pageNo1= date.pageNo;
					      var pageNum1 = date.pageNum;
					      var sum = date.sum;
					      if(!list.length==0){
							$.each(list,function(){
							     var comInfo = this.comInfo;
							     if(this.jiStatus==0){
							    	 var date = this.jiReledate.substr(0,10);
							    	 var t=$("<br/><dd><table><ul class='reset my_jobs'><li><h3>"+
											   "<a href='selectCombInforAdmin?comInfo.cid="+comInfo.cid+"'>"
											   +"编号:"+this.jiid+"."+
											   comInfo.comName+"</a><span>需求数量("+this.jiNum+")</span></h3>"+
											   "<div>职位："+this.jobName.jnname+"/工资:"+this.jiSal+"/学历要求："+this.jiEdu+
											   "</div><div class='c9'>发布时间："+date+"</div><div class='links'>"+
											   "<a href='selectJaobInforAdmin?jobInfo.jiid="+this.jiid+"'><input class='job' type='button' id="+this.jiid+" value='审核'/></a></div></li></ul></table></dd>");
								   
								   $("#div1").append(t);
							     }
							});
						 }
					      var tt = $("<span>"+pageNo1+"/"+pageNum1+"</span>"); 
						  $("#div2").append(tt);
						  $("#pageNum").val(pageNum1);
						  var zz = $("<span>总条数："+sum+"</span>");
						  $("#sum").append(zz);
					    }
			   });
			}
		    });
	    
	    $("#xiayiye").click(function(){
		      var pageNum = $("#pageNum").val();
		      var comName = $("#comName").val().trim();
		      if(pageNo>=pageNum){	
				}else{
		      pageNo=pageNo+1;
		      $("#div1").contents().remove();
		      $("#div2").contents().remove();
		      $("#sum").contents().remove();
		      $.ajax({  
					    url:"json/selectUncheckedByNameAdmin",
					    data:{"pageNo":pageNo,"status":"0","comInfo.comName":comName},
					    dataType:"json",
					    success:function(date){
					      var list = date.list;
					      var pageNo1= date.pageNo;
					      var pageNum1 = date.pageNum;
					      var sum = date.sum;
					      if(!list.length==0){
							$.each(list,function(){
							     var comInfo = this.comInfo;
							     if(this.jiStatus==0){
							    	 var date = this.jiReledate.substr(0,10);
							    	 var t=$("<br/><dd><table><ul class='reset my_jobs'><li><h3>"+
											   "<a href='selectCombInforAdmin?comInfo.cid="+comInfo.cid+"'>"
											   +"编号:"+this.jiid+"."+
											   comInfo.comName+"</a><span>需求数量("+this.jiNum+")</span></h3>"+
											   "<div>职位："+this.jobName.jnname+"/工资:"+this.jiSal+"/学历要求："+this.jiEdu+
											   "</div><div class='c9'>发布时间："+date+"</div><div class='links'>"+
											   "<a href='selectJaobInforAdmin?jobInfo.jiid="+this.jiid+"'><input class='job' type='button' id="+this.jiid+" value='审核'/></a></div></li></ul></table></dd>");
								   
								   $("#div1").append(t);
							     }
							});
						 }
					      var tt = $("<span>"+pageNo1+"/"+pageNum1+"</span>"); 
						  $("#div2").append(tt);
						  $("#pageNum").val(pageNum1);
						  var zz = $("<span>总条数："+sum+"</span>");
						  $("#sum").append(zz);
					    }
			   });
			}
		    });
	    
	    $("#moye").click(function(){
		      var pageNum = $("#pageNum").val();
		      var comName = $("#comName").val().trim();
		      
		      if(pageNo>=pageNum){	
				}else{
		      pageNo=pageNum;
		      $("#div1").contents().remove();
		      $("#div2").contents().remove();
		      $("#sum").contents().remove();
		      $.ajax({  
					    url:"json/selectUncheckedByNameAdmin",
					    data:{"pageNo":pageNo,"status":"0","comInfo.comName":comName},
					    dataType:"json",
					    success:function(date){
					      var list = date.list;
					      var pageNo1= date.pageNo;
					      var pageNum1 = date.pageNum;
					      var sum = date.sum;
					      if(!list.length==0){
							$.each(list,function(){
							     var comInfo = this.comInfo;
							     if(this.jiStatus==0){
							    	 var date = this.jiReledate.substr(0,10);
							    	 var t=$("<br/><dd><table><ul class='reset my_jobs'><li><h3>"+
											   "<a href='selectCombInforAdmin?comInfo.cid="+comInfo.cid+"'>"
											   +"编号:"+this.jiid+"."+
											   comInfo.comName+"</a><span>需求数量("+this.jiNum+")</span></h3>"+
											   "<div>职位："+this.jobName.jnname+"/工资:"+this.jiSal+"/学历要求："+this.jiEdu+
											   "</div><div class='c9'>发布时间："+date+"</div><div class='links'>"+
											   "<a href='selectJaobInforAdmin?jobInfo.jiid="+this.jiid+"'><input class='job' type='button' id="+this.jiid+" value='审核'/></a></div></li></ul></table></dd>");
								   
								   $("#div1").append(t);
							     }
							});
						 }
					      var tt = $("<span>"+pageNo1+"/"+pageNum1+"</span>"); 
						  $("#div2").append(tt);
						  $("#pageNum").val(pageNum1);
						  var zz = $("<span>总条数："+sum+"</span>");
						  $("#sum").append(zz);
					    }
			   });
				}
		    });
	    
	    $("#bt1").click(function(){
	    	pageNo=1;
	      $("#div1").contents().remove();
	      $("#div2").contents().remove();
	      $("#sum").contents().remove();
	      var comName = $("#comName").val().trim();
	      $.ajax({  
				    url:"json/selectUncheckedByNameAdmin",
				    data:{"pageNo":1,"comInfo.comName":comName,"status":"0"},
				    dataType:"json",
				    success:function(date){
				      var list = date.list;
				      var pageNo1= date.pageNo;
				      var pageNum1= date.pageNum;
				      var sum = date.sum;
				      if(!list.length==0){
				    	  
						$.each(list,function(){
						     var comInfo = this.comInfo;
						     if(this.jiStatus==0){
						    	 var date = this.jiReledate.substr(0,10);
						    	 var t=$("<br/><dd><table><ul class='reset my_jobs'><li><h3>"+
										   "<a href='selectCombInforAdmin?comInfo.cid="+comInfo.cid+"'>"
										   +"编号:"+this.jiid+"."+
										   comInfo.comName+"</a><span>需求数量("+this.jiNum+")</span></h3>"+
										   "<div>职位："+this.jobName.jnname+"/工资:"+this.jiSal+"/学历要求："+this.jiEdu+
										   "</div><div class='c9'>发布时间："+date+"</div><div class='links'>"+
										   "<a href='selectJaobInforAdmin?jobInfo.jiid="+this.jiid+"'><input class='job' type='button' id="+this.jiid+" value='审核'/></a></div></li></ul></table></dd>");
							   
							   $("#div1").append(t);
						     }
						});
					 }
				      var tt = $("<span>"+pageNo1+"/"+pageNum1+"</span>"); 
					  $("#div2").append(tt);
					  $("#pageNum").val(pageNum1);
					  var zz = $("<span>总条数："+sum+"</span>");
					  $("#sum").append(zz);
				    }
			});
	    });
	    
	  });