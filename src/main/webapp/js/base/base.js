/**
 * jQuery插件扩展，需要自定义扩展插件在函数里面接着往后写。
 * @param $
 * @param w
 */
(function($, w) {
	
	//是否为空判断函数
	$.isEmpty = function(obj){
		if(typeof(obj) == 'string'){
			if("" == obj || $.trim(obj).length == 0||obj=="undefined"){
				return true;
			}else{
				return false;
			}
		}else if(typeof(obj) == 'object'){
			if(obj == null){
				return true;
			}else{
				for(var i in obj){
					if(obj.hasOwnProperty(i)){
						return false;
					}
				}
				return true;
			}
		}else if(typeof(obj) == 'undefined'){
			return true;
		}else if(typeof(obj) == 'boolean' && obj == false){
			return true;
		}else{
			return false;
		}
	};
	
	/**
	 * 
	 * 判断日期格式是否正确
	 */
	$.isValidDate = function(date){
		if($.isEmpty(date)){
			return false;
		}
		if(new Date(date).getDate()==date.substring(date.length-2)){
			return true;
		}
		return false;
	};
	
	/*
	 *$(dom).getSelectHtml();//获取 select 选中的 text值；
	 *Author : Liws
	 */
	$.fn.getSelectHtml = function() {
		var _this = this.eq(0),
			val = this.val(),
			tiem, i = 0;
		var options = _this.find("option");
		while (options.eq(i)) {
			if (i > 1000) return;
			tiem = options.eq(i);
			try{
				if (tiem.get(0).selected) {
					return tiem.html();
				}
			}catch(e){
				return;
			}
			i++;
		}
	};
	
	
	var height = 24;
	var cssSelect = '.select-box-wrap{position: relative;border:1px solid #ddd;width:110px;height:'+height+'px;font-size: 12px;color: #5e5e5e;background:#fff;zoom:1;}\
		.select-box-wrap .icon-arrow-down{position:absolute;top: 10px;right: 8px;width:0;height:0;font:0/0 "";border:4px solid transparent;border-top-color:#333;overflow:hidden;cursor:pointer;}\
		.select-box-wrap .input-val{height:'+(height-4)+'px;overflow: hidden;padding:2px 6px;line-height: '+(height-4)+'px;font-size: 12px;color: #5e5e5e;cursor: pointer;}\
		.select-box-wrap .sul{display:none;position:absolute;max-height:192px;left:-1px;top:'+height+'px;width:100%;overflow-y: auto;border: 1px solid #ddd;background:#fff;}\
		.select-box-wrap .sul .sli{display:block;height: '+height+'px;color: #888;white-space: nowrap;padding-left: 8px;font:12px/'+height+'px "";cursor:pointer;}\
		.select-box-wrap .sul .sli-ed{background:#efefef;}\
		.dis-select-box{background:#f1f8ff;cursor:default;}\
		.dis-select-box .input-val{background:#f1f8ff;cursor:default;}\
		.dis-select-box .icon-arrow-down{cursor:default;border-top-color:#999}\
		.select-box-b{height: 20px;}\
		.select-box-b .input-val{height: 20px;line-height: 20px;padding: 0 6px;}\
		.select-box-b .icon-arrow-down{top: 8px;}\
		.select-box-b .sul{top: 20px;max-height:192px;}\
		.select-box-b .sul .sli{line-height:20px;height:20px;}';
	$("head").append("<style>" + cssSelect + "</style>");
	
	/*
	 *$(dom).gselect({ width : 110 , id="",addClass="",isMin:"1" callback : function(){} );// select 格式化样式 ；
	 *Author : Liws
	 */
	var domstr = '<div class="select-box-wrap">\
					<div class="input-val"></div><i class="icon-arrow-down"></i>\
					<div class="sul"></div>\
				  </div>';
	/**
	 * 请作者补充注释
	 */
	$.fn.gselect = function(options) {
		var def = {
			width: 110,
			callback: function() {},
			height: false,
			maxlen : 6 ,
			isMin : false
		};
		options = $.extend({},def, options);
		return this.each(function() {
			var $wrap = $(domstr).css("width", options.width),
				$this = $(this),
				option = $this.find("option"),
				alertId = "" + (new Date()).getTime() + (Math.random() * 100).toFixed(2),
				reg = /^[\w\-]+$/;
			if(this.selectBoxs && this.selectBoxs.jquery)this.selectBoxs.remove();
			this.selectBoxs = $wrap;
			options.isMin && $wrap.addClass("select-box-b");
			options.addClass && $wrap.addClass(options.addClass);
			option.each(function(i, dom) {
				var li = '<div class="sli" code="' + (dom.value || dom.innerHTML) + '">' + dom.innerHTML + '</div>';
				$wrap.find(".sul").append(li);
				if(i==7)$wrap.find(".sul").css("height",height*8)
			});

			if (options.id && reg.test(options.id)) {
				$wrap.attr("id", options.id);
			}
			if (options.className && reg.test(options.className)) {
				$wrap.addClass(options.className);
			}
			$this.change(function() {

				$wrap.find(".input-val").html($this.getSelectHtml());
			});
			$this.hide().before($wrap);
			$wrap.find(".input-val").html($this.getSelectHtml());
			if($this.attr("disabled")){
				$wrap.addClass("dis-select-box");
				return ;
			}
			var input = $wrap.find(".input-val,.icon-arrow-down"),
				con = $wrap.find(".sul");
			var wrap = $wrap.get(0);
			wrap.endfn = function() {
				con.hide();
				$wrap.css("z-index","");
			};

			input.click(function() {
				option = $this.find("option");
				con.empty();
				option.each(function(i, dom) {
					
				if(dom.value=="绿"){
					//alert(dom.value);
					var li = '<div class="sli" code="' + (dom.value || dom.innerHTML) + '" style="background:#33FF00;">' + dom.innerHTML + '</div>';
				}else if(dom.value=="黄"){
					//alert(dom.value);
					var li = '<div class="sli" code="' + (dom.value || dom.innerHTML) + '" style="background:yellow;">' + dom.innerHTML + '</div>';
				}else if(dom.value=="红"){
					var li = '<div class="sli" code="' + (dom.value || dom.innerHTML) + '" style="background:red;">' + dom.innerHTML + '</div>';
				}else{
					var li = '<div class="sli" code="' + (dom.value || dom.innerHTML) + '">' + dom.innerHTML + '</div>';
				}
				//	var li = '<div class="sli" code="' + (dom.value || dom.innerHTML) + '">' + dom.innerHTML + '</div>';
					con.append(li);

				});
				if (con.is(":hidden")) con.show();
				else con.hide();
				$wrap.css("z-index","1000");
			}).mousedown(function() {
				selectBox = wrap;
				//selectBox.alertId = alertId;
				///selectBox.alertBox = wrap;
				/*selectBox.wrap = $wrap;
				if(!selectBox.alertBoxTo){
					selectBox.alertBoxTo = con;
				}
				if(!selectBox.alertIdTo)selectBox.alertIdTo = alertId;
				if(!selectBox.wrapTo)selectBox.wrapTo= $wrap;
				*/
			});
			con.delegate(".sli", "click", function() {
				input.html($(this).html()).attr("data-selected", true);
				$this.val($(this).attr("code"));
				if($(this).attr("code")=="绿"){
					$("#policesafe").parent("dd").find("div").find(".input-val").attr("style","background:#33FF00;");
				}else if($(this).attr("code")=="黄"){
					$("#policesafe").parent("dd").find("div").find(".input-val").attr("style","background:yellow;");
				}else if($(this).attr("code")=="红"){
					$("#policesafe").parent("dd").find("div").find(".input-val").attr("style","background:red;");
				}
				options.callback.call(this);
				$this.trigger("change");
			}).delegate(".sli", {
				"mouseenter": function() {
					$(this).addClass("sli-ed")
				},
				"mouseleave": function() {
					$(this).removeClass("sli-ed")
				}
			});
		});
	};


	//	树杈插件
	//jsTree
	/*$("class").jsTree( {
		openClass : "open" ,//打开时的 class名
		closeClass : "close"//关闭时的 class名
		callback : function(e, obj){
			obj = {
				Dom: $this , // 整个数节点
				aDom : $(this) , //点击的a 节点
				 liDom : $(this).closest("li") // a 节点的上级 li 节点
				}
			// 当前节点加载完后。把 li 标签 给 从新 渲染下
			$.treeHtimlLi( obj.liDom );
		} // 点击是运行的方法
		open : 0/1 //默认全部打开、关闭；
	})
	*/
	$.jsTree = function(dom, option){
		var options = {openClass : "tr-open" ,open : 0 , closeClass : "tr-close" , click : "a" ,buildTree:false,houseStatus:"", callback : function(){}};
		options = $.extend(options , option);
		var aCName = ["icon-one","icon-two","icon-three","icon-four"];
		var aType ={c:1,b:2,u:3};
		//展开、关闭<ul>
		function treefn(e){
			var $this = $(this),li = $this.closest("li"),treeNum = parseInt($this.attr("data-tree"));
			clasName = aCName[treeNum-1]+"-ed",
			hasUl = li.find("ul").length>0;
//			if(treeNum == 4){
//				$this.find("i").toggleClass(clasName);
//			}
			if(!hasUl)return ;
			if(li.hasClass(options.openClass) ){
				li.removeClass(options.openClass).addClass(options.closeClass);
				li.children("ul,ol").hide();
				$this.attr("data-open","close").find("i");
			}else{
				li.removeClass(options.closeClass).addClass(options.openClass);
				li.children("ul,ol").show();
				$this.attr("data-open","open").find("i");
			}
			//options.callback.call(this);
		}
		//渲染<li>
		function treeHtmlLi(dom , index ){
			if(dom.length >0 && dom.get(0).tagName.toLocaleLowerCase()!="li"){
				dom=dom.find("li").eq(0);
			}
			var $this = dom,
			dom = $this.children("ul"),
			index =parseInt(index || $this.attr("data-tree")) ,
			claN = aCName[index-1]||"",
			itext = '<i class="icon-bg '+ claN +'" data-tree></i>',
			a = $this.attr("data-tree",index).children("a").attr("data-tree",index);
			if(dom.length > 0 || index==4){
				a.children("i[data-tree]").remove();
				a.prepend(itext);
				if(dom.length > 0){
					$this.addClass( "tr-close"||"tr-open");
					dom.hide();
				}
				if(a.attr("data-open")=="open"){
					a.children("i[data-tree]").addClass(claN+'-ed');
					dom.length > 0&&$this.addClass( "tr-open").removeClass("tr-close");
					dom.show();
				}
				treeHtimlUl(dom , index+1)
			}
		}
		//渲染<ul>
		function treeHtimlUl(dom , index){
			if(dom.length >0 && dom.get(0).tagName.toLocaleLowerCase()!="ul"){
				dom=dom.find("ul").eq(0);
			}
			var lis = dom.children("li"),
			index = parseInt(index || aType[dom.find('a').attr("type")]);
			// claN = aCName[index-1]||"",
			// itext = '<i class="icon-bg '+ claN +'" data-tree></i>',a;
			lis.each(function(){
				treeHtmlLi($(this) , index);
				// a=$(this).attr("data-tree",index).children("a").attr("data-tree",index);
				// a.children("i[data-tree]").remove();
				// a.prepend(itext);
				// if(index ==4 && a.attr("selected")=="ed"){
				// 	a.children("i[data-tree]").addClass(claN+'-ed');
				// }
			});
		}
		$.treeHtimlUl = treeHtimlUl;
		$.treeHtimlLi = treeHtmlLi;
		return dom.each(function(i){
			var $this = $(this);
			//treeHtml($this , aCName , 1);
			treeHtimlUl($this , 1);
			if(this.dataTrreHTML)return this;
			$this.on("click",".a",treefn);
			$this.on("click",".a",function(e,queryType){
				if(options.buildTree){
					var $ower = $(this),str = $.trim($ower.text()),i=0,liDom = $ower.closest("li"),aValue = $ower.attr("value");
					if($ower.attr("type")=='c'&& liDom.find('ul').length==0){//小区获得楼宇
						var builddata = ajaxrequestpost('/pmcs/pages/tree/TreeCon/getSyncCommunityTree.json?communityId='+aValue);
						var li = '';
						for(var i=0 ; i < builddata[0]['children'].length;i++){
							var code = builddata[0]['children'][i]['id'];
							var name = builddata[0]['children'][i]['text'];
							li +='<li><a  data-open="open"  class="a" value="'+code+'" type="b"><i class="icon-bg icon-two" data-tree=""></i>'+name+'</a></li>';
						}
						$ower.after('<ul>'+li+'</ul>');
					}
					if($ower.attr("type")=='b'&& liDom.find('ul').length==0){//楼宇获得单元
						var builddata = ajaxrequestpost('/pmcs/pages/tree/TreeCon/getSyncUnitTree.json?buildingCode='+aValue);
						var li = '';
						for(var i=0 ; i < builddata.length;i++){
							var code = builddata[i]['id'];
							var name = builddata[i]['text'];
							li +='<li><a  data-open="open"  class="a" value="'+code+'" type="u"><i class="icon-bg icon-three" data-tree=""></i>'+name+'</a></li>';
						}
						$ower.after('<ul>'+li+'</ul>');
					}
					if($ower.attr("type")=='u'&& liDom.find('ul').length==0){//单元获得房产
						var builddata = ajaxrequestpost('/pmcs/pages/tree/TreeCon/getSyncHouseTree.json?unitId='+aValue+"&houseStatus="+options.houseStatus);
						var li = '';
						for(var i=0 ; i < builddata.length;i++){
							var code = builddata[i]['id'];
							var name = builddata[i]['text'];
							if(builddata[i]['attributes']['isLiveOrNot']=='1'){
								li +='<li><a data-open="open"  class="a" value="'+code+'" type="h">'+name+'</a></li>';
							}else{
							li +='<li><a data-open=""  class="a" value="'+code+'" type="h">'+name+'</a></li>';
							}
						}
						$ower.after('<ul>'+li+'</ul>');
					}
				}
				options.callback.call(this , e ,{Dom: $this ,aDom : $(this) , liDom : $(this).closest("li"),queryType:queryType});
			});
			this.dataTrreHTML = true;
			return this
		});
	};
	$.fn.jsTree = function(option){
		return $.jsTree(this , option);
	};
	
	/*
	$("class").fnTab({
		tabLi :"点击的li 标签"，
		tabCon ： "要切换的 dom 节点"，
		liClass : "点击 添加到 li 标签上的 class"，
		liClick :  绑定 到 li 标签上的 方法
	})
	*/
	$.fn.fnTab = function(options){
		options = $.extend({},$.fn.fnTab.deflault , options);
		var index;
		return this.each(function(){
			var $dom = $(this),lis=$dom.find(options.tabLi),cons=$dom.find(options.tabCon);
			$dom.on("click", options.tabLi , function(e){
				var $this = $(this);
				index = lis.index($this );
				lis.removeClass(options.liClass).eq(index).addClass(options.liClass);
				cons.hide().eq(index).show();
				options.liClick.call( this );
			});
			var findli = $dom.find(options.tabLi);
			findli = findli.filter("."+options.liClass).length>0?findli.filter("."+options.liClass):findli.eq(0);
			findli.trigger("click");
		});
	};
	$.fn.fnTab.deflault = { tabLi : "*[data-tab=li]" , tabCon : "*[data-tab=con]" , liClick : function(){},liClass:"cur"};
	var ie6 = $.browser.msie && $.browser.sersion == "6.0";
	var thickdiv='<div class="thickdiv" id = "thickdiv"></div>';
	var alertText = '<div class="alert-box" id = "alert-box">\
		<div class="modal-top"><img class="icon" src="./images/icon/alert.png"><span class="info">提示</span><a href="javascript:;" class="close">×</a></div>\
		<div class="con"></div><div class="btn-box"><a href="javascript:;" class="alertcenter" name="alertcenter">确定</a></div></div>';
	var confirmText = '<div class="alert-box" id = "confirm-box">\
		<div class="modal-top"><img class="icon" src="./images/icon/confirm.png"><span class="info">警告</span><a href="javascript:;" class="close">×</a></div>\
		<div class="con"></div>\
		<div class="btn-box"><a href="javascript:;" class="d">确定</a><a href="javascript:;" class="c">取消</a></div>\
	</div>';
	var confirmText2 = '<div class="alert-box" id = "confirm-box">\
		<div class="modal-top"><img class="icon" src="./images/icon/confirm.png"><span class="info">警告</span></div>\
		<div class="con"></div>\
		<div class="btn-box"><a href="javascript:;" class="d">确定</a>\
	</div>';
	var confirmTextAlert = '<div class="alert-box" id = "confirm-box">\
		<div class="modal-top"><img class="icon" src="./images/icon/confirm.png"><span class="info">提示</span><a href="javascript:;" class="close">×</a></div>\
		<div class="con"></div>\
		<div class="btn-box"><a href="javascript:;" class="d">确定</a><a href="javascript:;" class="c">取消</a></div>\
	</div>';
	
	/**
	 * 请作者补充注释
	 */
	$.fn.center = function(position) {
		return this.each(function() {
			var $this = $(this),
				scrollTop = $(window.top).scrollTop(),
				top = (document.documentElement.clientHeight - $this.outerHeight()) / 2,
				left = (document.documentElement.clientWidth - $this.outerWidth()) / 2;
			top = top >= 0 ? top : 0;
			if (ie6 || position) {
				$this.css({
					"position": "absolute",
					left: left,
					top: scrollTop==0?100:scrollTop,
					margin : 0
				});
				if(position instanceof Object){
					if(position.top){
						$this.css({top: position.top});
					}
					if(position.left){
						$this.css({left: position.left});
					}
				}
				
			} else {
				$this.css({
					"position": "fixed",
					left: "50%",
					top: "50%",
					margin : -$this.outerHeight() / 2 +"px 0 0 "+ (-$this.outerWidth()/ 2)+"px"
				});
				$(window.top).scrollTop($this.offset().top);
			}
		});
	};
	
	// 弹出框显示时，滚动条在最下面
	$.fn.center2 = function(position) {
		return this.each(function() {
			var $this = $(this),
				scrollTop = $(window).scrollTop(),
				// $(document).height()获取页面的文档高度     $(window).height()  获取浏览器显示区域的高度	//
				top = $(document).height() - $(window).height(),
				left = (document.documentElement.clientWidth - $this.outerWidth()) / 2;
			top = top >= 0 ? top : 0;
			
			if (ie6 || position) {
				$this.css({
					"position": "absolute",
					left: left,
					top: top,
					margin : 0
				});
			} else {
				$this.css({
					"position": "fixed",
					left: "50%",
					top: "50%",
					margin : -$this.outerHeight() / 2 +"px 0 0 "+ (-$this.outerWidth()/ 2)+"px"
				});
			}
			// 滚动条在最下面
			$(document).scrollTop($(document).height());
		});
	};
	
	/**
	 * 请作者补充注释
	 */
	var thickdivNum = 0,thickdivbox = $(thickdiv);
	$.thickdiv = function(option){
		if(option == "add"){
			if(thickdivNum<=0)thickdivbox.appendTo("body");
			thickdivNum++;
			//if (window != top&&$(thickdivbox,top).length==0)thickdivbox.appendTo("body",top);
		}else if(option == "remove"){
			if(thickdivNum>0)thickdivNum--;
			if(thickdivNum<=0)thickdivbox.remove();
			//if (window != top)$(thickdivbox,top).remove();
		}else{
			return $(thickdiv);
		}
		return thickdivNum;
	};
	
	/**
	 * 请作者补充注释
	 */
	$.alert = function(text,time){
		$.thickdiv("add");
		var box = $(alertText).appendTo("body"),timer;
		box.center(1).find(".con").html(text);
		$("html,body").animate({scrollTop:$(box).offset().top});
		box.find(".btn-box a,.close").click(function(){
			$.thickdiv("remove");
			box.remove();
			clearInterval(timer);
		});
		time = time && parseInt(time);
		time = typeof time =="number" && time;
		if(time){
			//box.find(".btn-box a").html("("+time+")确定");
			box.find(".btn-box").remove();
			timer = setInterval(function(){
				//box.find(".btn-box a").html("("+--time+")确定");
				--time;
				if(time<=0){
					box.find(".btn-box a").trigger("click");
					$.thickdiv("remove");
					box.remove();
					clearInterval(timer);
				}
			},1000);
		}
		
		// 如果出现下面语句，那么要进行session失效判断。
		$(".alertcenter").click(function(){
		//	if('请求失败，请检查网络或请联系管理员!' == text){
		       	$.ajax({
				       url:"/pmcs/pages/tree/TreeCon/getShortcutMenuTree.json?sessionVlid=1",
				       type:'post',         //数据发送方式
				       async:false,
				       dataType:'json',     //接受数据格式
				       data:{},         //要传递的数据
				       success:function(_data){
				    	   	// session失效重定向*********************
					       	if("true" == _data.sendRedirect){
					       		top.location.href= _data.redirectUrl;

					       	}
				    	   
				       }
				});
		//	}
		});
	};
	
	/**
	 * 请作者补充注释
	 */
	$.confirm = function(text,fn){
		$.thickdiv("add");
		var box = $(confirmText).appendTo("body");
		box.center(1).find(".con").html(text);
		box.find(".btn-box a,.close").click(function(){
			box.remove();
			$.thickdiv("remove");
		});
		box.find(".d").click(function(){
			fn&&fn();
		});
	};
	
	/**
	 * 请作者补充注释
	 */
	$.confirm2 = function(text,fn){
		$.thickdiv("add");
		var box = $(confirmText2).appendTo("body");
		box.center(1).find(".con").html(text);
		box.find(".btn-box a,.close").click(function(){
			box.remove();
			$.thickdiv("remove");
		});
		box.find(".d").click(function(){
			fn&&fn();
		});
	};
	
	/**
	 * 附带后续操作的提示框
	 * 确定执行fnYes
	 * 取消执行fnNo
	 */
	$.confirmQuit = function(text,fnYes,fnNo){
		$.thickdiv("add");
		var box = $(confirmTextAlert).appendTo("body");
		box.center(1).find(".con").html(text);
		box.find(".btn-box a,.close").click(function(){
			box.remove();
			$.thickdiv("remove");
		});
		box.find(".d").click(function(){
			fnYes&&fnYes();
		});
		box.find(".c,.close").click(function(){
			fnNo&&fnNo();
		});
	};
	
	/**
	 * 请作者补充注释
	 */
	$.fn.placeholder = function(){
		return this.each(function(){
			var $this=$(this),text = $this.attr("placeholder"),val = $this.val();
			//if(this.placeholder || !text)return ;
			//if($this.data("placeholder"))return ;
			//$this.data("placeholder","placeholder");
			$this.focus(function(){
				val = $this.val();
				if(val == text){
					$this.css("color","").val("");
				}
			}).blur(function(){
				val = $this.val();
				if(val==text || val == ""){
					$this.css("color","#999").val(text);
				}
			}).trigger("blur");
		})
	};

	/**
	 * 请作者补充注释
	 */
	  var hintText = '<div class="hint-box" id = "hint-box"><div class="con" style="text-align:center;margin-top:115px"></div></div>';
	  var imgText = '<p> <img src="./img/loading.gif"/></p>';
	  $.hint = function(option, text){
		if(option == "add"){
			$.thickdiv("add");
			var box = $(hintText).appendTo("body");
			box.center(1).find(".con").html("").append(imgText);
		}else if(option == "remove"){
			$(".hint-box > .con").html('');
			$.thickdiv("remove");
			$(".hint-box").remove();
		}
	};
	
	/*
	 * form内元素校验
	 * 可通过扩展fnBlur扩展
	 * 需在提交前手动触发
	 * param参数 {
	 * 		"visible":true/false	//是否只校验可见的元素，用于某些有类型选择的业务。如：费项设置。
	 * }
	 */
	$.fn.formvalidator = function(param){
		if(param&&param.visible){	//只校验可见的元素
			return $("select:visible,input:visible[type=text],textarea:visible",this).fnBlur();
		}else{
			return $("select,input[type=text],textarea",this).fnBlur();
		}
	};
	
	/*
	 * 元素校验
	 * 不影响现有功能的前提下可以根据需要扩展
	 * 需在提交前手动触发
	 */
	$.fn.fnBlur = function(){
		var errornum=0;
		this.each(function(){
			var dom=$(this) ,tagName = dom.get(0).tagName.toLocaleLowerCase() ,
			dl = dom.closest("dl"),dd = dom.closest("dd"),
			text = dl.find("dt").text(),
			val = $.trim(dom.val());
			dd.find(".div-error").remove(),dom.removeAttr("data-error");
			if(dom.hasClass("j-must-input")){
				if(!/[*]/.test(text))return ;
				text = text.replace(/[*:：]*/g,"");
				//if()return ;
				if((tagName == "input" || tagName == "textarea") && (val ==""||val ==dom.attr("placeholder"))){
					text += "不能为空！";
					dd.append('<div class="div-error">'+text+'</div>');
					dom.attr("data-error","error");errornum++;
				}else if(tagName == "select" && ''==val){
					if(dom.attr("disabled")){
						return ;
					}
					text = "请选择" + text;
					dd.append('<div class="div-error">'+text+'</div>');
					dom.attr("data-error",text);errornum++;
				}
			}
			if(dom.hasClass("is-number")){
				var num = $(this).val();
				if(num!=""&&!num.match(/^[0-9]*$/)){
					dd.append('<div class="div-error">'+'必须输入数字,不支持小数</div>');
					dom.attr("data-error","error");errornum++;
				}
			}
			if(dom.hasClass("is-point-number")){
				var num = $(this).val();
				if(num!=""&&!num.match(/^[0-9]*(\.[0-9]{1,2})?$/)){
					dd.append('<div class="div-error">'+'必须输入数字,支持两位小数</div>');
					dom.attr("data-error","error");errornum++;
				}
			}
			if(dom.hasClass("is-money")){
				var num = $(this).val();
				if(num!=""&&!num.match(/^[0-9]*(\.[0-9]{1,4})?$/)){
					dd.append('<div class="div-error">'+'必须输入数字,支持四位小数</div>');
					dom.attr("data-error","error");errornum++;
				}
			}
			if(dom.hasClass("is-phone-number")){
				var num = $(this).val();
				if(num!=""&&!num.match(/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(1[0-9][0-9]\d{8}$))/)){
					dd.append('<div class="div-error">'+'联系电话格式不正确</div>');
					dom.attr("data-error","error");errornum++;
				}
			}
			if(dom.hasClass("is-email")){
				var num = $(this).val();
				if(num!=""&&!num.match(/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/)){
					dd.append('<div class="div-error">'+'联系电话格式不正确</div>');
					dom.attr("data-error","error");errornum++;
				}
			}
		});
		return errornum>0?true:false;
	};
	
	/*
	 * form.resetting()为form内元素绑定focus和change方法永远清除校验信息并
	 * 为form绑定onreset()事件当调用form.reset()方法时触发
	 * element.resetting()清除元素的校验信息
	 * 支持动态添加的元素
	 * 不影响现有功能的前提下可以根据需要扩展
	 */
	$.fn.resetting = function(){
		return this.each(function(){
			var dom=$(this) , dd = dom.closest("dd"),tagName = dom.get(0).tagName.toLocaleLowerCase();
			if(tagName == "form"){
				$(this).on("focus","input[type=text],input[type=password],textarea",function(){
					var dom=$(this) , dd = dom.closest("dd");
					dd.find(".div-error").remove();
					dom.removeAttr("data-error");
				});
				$(this).on("change","select",function(){
					var dom=$(this) , dd = dom.closest("dd");
					dd.find(".div-error").remove();
					dom.removeAttr("data-error");
				});
				this.onreset = function(){
					$("select,input[type=text],input[type=password],textarea",this).each(function(){
						var dom=$(this) , dd = dom.closest("dd"),tagName = dom.get(0).tagName.toLocaleLowerCase();
						dd.find(".div-error").remove();
						dom.removeAttr("data-error");
					});
				};
			}else{
				dd.find(".div-error").remove();
				dom.removeAttr("data-error");
			}
		});
	};

	/**
	 * 逐层覆盖弹出层
	 */
	var shadeDiv = '<div class="shadediv"></div>';
	$.fn.shade = function(options){
		if(options.action == "add"){
			if(!this.parent().is(".shadediv"))
				this.wrap(shadeDiv);
		}else if(options.action == "remove"){
			if(this.parent().is(".shadediv"))
				this.unwrap(shadeDiv);
		}else{
			return $(shadeDiv);
		}
	};
	var ModalFun = function(element,options){
		this.options             = options;
	    this.$body               = $(document.body);
	    this.$element            = $(element);
	    this.$dialog             = this.$element.parent('.shadediv');
	    this.$backdrop           = null;
	    this.isShown             = null;
	    this.originalBodyPad     = null;
	    this.scrollbarWidth      = 0;
	    this.ignoreBackdropClick = false
	};
	ModalFun.DEFAULTS = {
			callback:function(){}
	};
	
	ModalFun.prototype.toggle = function () {
	    return this.isShown ? this.hide() : this.show()
	};
	
	ModalFun.prototype.show = function(){
		var e    = $.Event('show.modalWin.modal');
	    this.$element.trigger(e);
		if (this.isShown || e.isDefaultPrevented()) return;
	    this.isShown = true;
	    this.$element.show().shade({action:"add"});
	};
	ModalFun.prototype.hide = function(e){
		if (e) e.preventDefault();
	    e = $.Event('hide.modalWin.modal');
	    this.$element.trigger(e);
		if (!this.isShown || e.isDefaultPrevented()) return;
	    this.isShown = false;
	    this.$element.hide().shade({action:"remove"});
	};
	
	$.fn.modalWin = function(option){
		return this.each(function(e){
			var $this   = $(this);
		    var data    = $this.data('modalFun.modal');
		    var options = $.extend({}, ModalFun.DEFAULTS, $this.data(), typeof option == 'object' && option);

		    if (!data) $this.data('modalFun.modal', (data = new ModalFun(this, options)));
		    if (typeof option == 'string') data[option]();
		    else if (options.show) data.show(_relatedTarget);
			options.callback.call(this, e,{});
		});
	};
	
	/**
	 * 扩展插件，在这里接着写就行了...
	 */
	
	Date.prototype.pattern=function(fmt) {         
	    var o = {         
	    "M+" : this.getMonth()+1, //月份         
	    "d+" : this.getDate(), //日         
	    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时         
	    "H+" : this.getHours(), //小时         
	    "m+" : this.getMinutes(), //分         
	    "s+" : this.getSeconds(), //秒         
	    "q+" : Math.floor((this.getMonth()+3)/3), //季度         
	    "S" : this.getMilliseconds() //毫秒         
	    };         
	    var week = {         
	    "0" : "/u65e5",         
	    "1" : "/u4e00",         
	    "2" : "/u4e8c",         
	    "3" : "/u4e09",         
	    "4" : "/u56db",         
	    "5" : "/u4e94",         
	    "6" : "/u516d"        
	    };         
	    if(/(y+)/.test(fmt)){         
	        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));         
	    }         
	    if(/(E+)/.test(fmt)){         
	        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);         
	    }         
	    for(var k in o){         
	        if(new RegExp("("+ k +")").test(fmt)){         
	            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));         
	        }         
	    }         
	    return fmt;         
	};
	//日期格式化
	$.formatDate = function(date,pattern){
		return date.pattern(pattern);
	};
	//表单元素转换未对象{}
	$.fn.serializeObject = function() {  
	    var o = {};  
	    var a = this.serializeArray();  
	    $.each(a, function() {  
	        if (o[this.name]) {  
	            if (!o[this.name].push) {  
	                o[this.name] = [ o[this.name] ];  
	            }  
	            o[this.name].push(this.value || '');  
	        } else {  
	            o[this.name] = this.value || '';  
	        }  
	    });  
	    return o;  
	};
	//通用导出方法
	$.exportExcel = function(url,params){
		var form = document.createElement("form");

 form.style.display = 'none';
        form.action = url;
		 form.method="post";  
		 document.body.appendChild(form);  
		   
		 for(var key in params){  
		  var input = document.createElement("input");  
		  input.type = "hidden";  
		  input.name = key;  
		  input.value = params[key];  
		  form.appendChild(input);  
		 }  
		form.submit(); 
		form.remove();
	}
}(jQuery, window));

(function (original) {
	  jQuery.fn.clone = function () {
	    var result           = original.apply(this, arguments),
	        my_textareas     = this.find('textarea').add(this.filter('textarea')),
	        result_textareas = result.find('textarea').add(result.filter('textarea')),
	        my_selects       = this.find('select').add(this.filter('select')),
	        result_selects   = result.find('select').add(result.filter('select'));

	    for (var i = 0, l = my_textareas.length; i < l; ++i) $(result_textareas[i]).val($(my_textareas[i]).val());
	    for (var i = 0, l = my_selects.length;   i < l; ++i) result_selects[i].selectedIndex = my_selects[i].selectedIndex;

	    return result;
	  };
}) (jQuery.fn.clone);

/**
 * 页面加载完执行代码
 */
$(function(){
	/**
	 * 请作者补充注释
	 */
	window.selectBox = {};
	var selectBoxTo;
	$("body").click(function() {//console.log(selectBoxTo == selectBox)
		if (selectBox && selectBox.nodeType == 1 && selectBox.endfn) {
			if (selectBoxTo && selectBoxTo != selectBox) {
				selectBoxTo && selectBoxTo.endfn && selectBoxTo.endfn();
				selectBoxTo = selectBox;
			} else selectBoxTo = selectBox;
		} else if (selectBoxTo && selectBoxTo.endfn) {
			selectBoxTo.endfn();
			selectBoxTo = null;
		}
		selectBox = null;
	});
	
	/**
	 * 请作者补充注释
	 */
	$(window).resize(function(){//解决在缩放或扩大浏览器时，弹出框不居中的问题,@see center
		var $popUpLayers = $(".pop-up-layer");
		$popUpLayers.each(function(){
			var $layer = $(this);
			if($layer.is(":visible")){
				var scrollTop = $(window.top).scrollTop(),
				top = (document.documentElement.clientHeight - $layer.outerHeight()) / 2,
				left = (document.documentElement.clientWidth - $layer.outerWidth()) / 2;
				top = top >= 0 ? top : 0;
				$layer.css({
					"position": "absolute",
					left: left,
					//top: scrollTop==0?100:scrollTop,
					margin : 0
				});
			}
		});
	});
	
	
	
	
	
});

//------------------------------------------------- 以下是全局函数 -----------------------------------------------

if(typeof console == "undefined"){
	console={log : function(text){}}
}

function getCookie(name){
	if(name && typeof name == "string"){
		name =new RegExp("\\b"+name+"\\b\\s*=([^;]*)");
		name =  name.exec(document.cookie);
		return name&&name.length>1?decodeURIComponent(name[1]):undefined;
	}
}
/**
 * 重置表单
 * @author Harwin
 * @param id form表单的ID
 * */
function formReset(id) {  
   $(id)[0].reset();
}  
 
// 对字符串去两端空格
function stringTrim(str)  {  
	if(str == null || str == undefined){
		return null;
	}
    // 用正则表达式将前后空格  
    // 用空字符串替代。  
    return str.replace(/(^\s*)|(\s*$)/g, "");  
}

// 获取当前时间值
function getDateTime(){
	var nowDate = new Date();
	// 获取年月日时分秒毫秒
	var year = nowDate.getFullYear();
	var month = nowDate.getMonth() + 1; // 0~11
	if(month < 10){
		month = "0" + month;
	}
	var date = nowDate.getDate();	//1~31
	if(date < 10){
		date = "0" + date;
	}
	var hour = nowDate.getHours();	// 0~23
	if(hour < 10){
		hour = "0" + hour;
	}
	var minute = nowDate.getMinutes();	// 0~59
	if(minute < 10){
		minute = "0" + minute;
	}
	var second = nowDate.getSeconds();	// 0~59
	if(second < 10){
		second = "0" + second;
	}
	var ms = nowDate.getMilliseconds();	// 0~999
	if(ms < 10){
		ms = "00" + ms;
	}else if(ms < 100){
		ms = "0" + ms;
	}

	return (""+year+month+date+hour+minute+second+ms);
}

function fnBlur(){
	var dom=$(this) , tagName = dom.get(0).tagName.toLocaleLowerCase() ,
		dl = dom.closest("dl"),
		text = dl.find("dt").text(),
		val = $.trim(dom.val());
	dl.find(".div-error").remove();
	if(dom.hasClass("j-must-input")){
		if(!/[*]/.test(text))return ;
		text = text.replace(/[*:：]*/g,"");
		//if()return ;
		if((tagName == "input" || tagName == "textarea") && (val ==""||val ==dom.attr("placeholder"))){
			text += "不能为空！";
			dl.find("dd:first").append('<div class="div-error">'+text+'</div>');
			dom.attr("data-error","error");
		}else if(tagName == "select" && ''==val){
			if(dom.attr("disabled")){
				return ;
			}
			text = "请选择" + text;
			dl.find("dd").append('<div class="div-error">'+text+'</div>');
			dom.attr("data-error",text);
		}
	}
	if(dom.hasClass("is-number")){
		var num = $(this).val();
		if(num!=""&&!num.match(/^[0-9]*$/)){
			dl.find("dd").append('<div class="div-error">'+'必须输入数字,不支持小数</div>');
			dom.attr("data-error","error");
		}
	}
	if(dom.hasClass("is-point-number")){
		var num = $(this).val();
		if(num!=""&&!num.match(/^[0-9]*(\.[0-9]{1,2})?$/)){
			dl.find("dd").append('<div class="div-error">'+'必须输入数字,支持两位小数</div>');
			dom.attr("data-error","error");
		}
	}
	if(dom.hasClass("is-money")){
		var num = $(this).val();
		if(num!=""&&!num.match(/^[0-9]*(\.[0-9]{1,4})?$/)){
			dl.find("dd").append('<div class="div-error">'+'必须输入数字,支持四位小数</div>');
			dom.attr("data-error","error");
		}
	}
	if(dom.hasClass("is-phone-number")){
		var num = $(this).val();
		if(num!=""&&!num.match(/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(1[0-9][0-9]\d{8}$))/)){
			dl.find("dd").append('<div class="div-error">'+'联系电话格式不正确</div>');
			dom.attr("data-error","error");
		}
	}
}



