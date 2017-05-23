
// 城市选择框显示
var inCity = new Object();
inCity.cssParents = function(){ //城市显示
    inCity.top = placeThis.offset().top+27;  //城市选择框  top位置
    inCity.left = placeThis.offset().left;   //城市选择框  left位置
    $(inCity.id).css({"top":inCity.top+"px","left":inCity.left+"px","width":inCity.width+"px","height":inCity.height+"px"});
}
inCity.place = function (e) {
    e.click(function(){
        placeThis = $(this);
        //城市显示
        inCity.cssParents(); 
        $(inCity.id).show();
        return false;
    })
}
inCity.destination = function (e){
    e.click(function(){
        placeThis = $(this);
        //城市显示
        inCity.cssParents();  
        $(inCity.id).show();
        return false;
    })
}

/* 城市HTML模板 */
inCity._template = [
    '<h1>请选择城市</h1>',
    '<div class="screen">',
        '<a href="javascript:void(0)" class="shar">热门</a>',
        '<a href="javascript:void(0)">ABCDEFG</a>',
        '<a href="javascript:void(0)">HIJKL</a>',
        '<a href="javascript:void(0)">MNOPQRST</a>',
        '<a href="javascript:void(0)">WXYZ</a>',
    '</div>',
    '<div class="city_pos">',
        '<div class="city_a_le1">',
        '</div>',
        '<div class="city_a_le1" style="display: none">',
        '</div>',
        '<div class="city_a_le1" style="display: none">',
        '</div>',
        '<div class="city_a_le1" style="display: none">',
        '</div>',
        '<div class="city_a_le1" style="display: none">',
        '</div>',
    '</div>'
];
/* 所有城市数据,可以按照格式自行添加（北京|beijing|bj），前16条为热门城市 */

inCity.allCity = ['北京|beijing|bj','上海|shanghai|sh', '重庆|chongqing|cq',  '深圳|shenzhen|sz', '广州|guangzhou|gz', '杭州|hangzhou|hz',
    '南京|nanjing|nj', '苏州|shuzhou|sz', '天津|tianjin|tj', '成都|chengdu|cd', '南昌|nanchang|nc', '三亚|sanya|sy','青岛|qingdao|qd',
    '厦门|xiamen|xm', '西安|xian|xa','长沙|changsha|cs','合肥|hefei|hf','西藏|xizang|xz', '内蒙古|neimenggu|nmg', '安庆|anqing|aq', '阿泰勒|ataile|atl', '安康|ankang|ak',
    '阿克苏|akesu|aks', '包头|baotou|bt', '北海|beihai|bh', '百色|baise|bs','保山|baoshan|bs', '长治|changzhi|cz', '长春|changchun|cc', '常州|changzhou|cz', '昌都|changdu|cd',
    '朝阳|chaoyang|cy', '常德|changde|cd', '长白山|changbaishan|cbs', '赤峰|chifeng|cf', '大同|datong|dt', '大连|dalian|dl', '达县|daxian|dx', '东营|dongying|dy', '大庆|daqing|dq', '丹东|dandong|dd',
    '大理|dali|dl', '敦煌|dunhuang|dh', '鄂尔多斯|eerduosi|eeds', '恩施|enshi|es', '福州|fuzhou|fz', '阜阳|fuyang|fy', '贵阳|guiyang|gy',
    '桂林|guilin|gl', '广元|guangyuan|gy', '格尔木|geermu|gem', '呼和浩特|huhehaote|hhht', '哈密|hami|hm',
    '黑河|heihe|hh', '海拉尔|hailaer|hle', '哈尔滨|haerbin|heb', '海口|haikou|hk', '黄山|huangshan|hs', '邯郸|handan|hd',
    '汉中|hanzhong|hz', '和田|hetian|ht', '晋江|jinjiang|jj', '锦州|jinzhou|jz', '景德镇|jingdezhen|jdz',
    '嘉峪关|jiayuguan|jyg', '井冈山|jinggangshan|jgs', '济宁|jining|jn', '九江|jiujiang|jj', '佳木斯|jiamusi|jms', '济南|jinan|jn',
    '喀什|kashi|ks', '昆明|kunming|km', '康定|kangding|kd', '克拉玛依|kelamayi|klmy', '库尔勒|kuerle|kel', '库车|kuche|kc', '兰州|lanzhou|lz',
    '洛阳|luoyang|ly', '丽江|lijiang|lj', '林芝|linzhi|lz', '柳州|liuzhou|lz', '泸州|luzhou|lz', '连云港|lianyungang|lyg', '黎平|liping|lp',
    '连成|liancheng|lc', '拉萨|lasa|ls', '临沧|lincang|lc', '临沂|linyi|ly', '芒市|mangshi|ms', '牡丹江|mudanjiang|mdj', '满洲里|manzhouli|mzl', '绵阳|mianyang|my',
    '梅县|meixian|mx', '漠河|mohe|mh', '南充|nanchong|nc', '南宁|nanning|nn', '南阳|nanyang|ny', '南通|nantong|nt', '那拉提|nalati|nlt',
    '宁波|ningbo|nb', '攀枝花|panzhihua|pzh', '衢州|quzhou|qz', '秦皇岛|qinhuangdao|qhd', '庆阳|qingyang|qy', '齐齐哈尔|qiqihaer|qqhe',
    '石家庄|shijiazhuang|sjz',  '沈阳|shenyang|sy', '思茅|simao|sm', '铜仁|tongren|tr', '塔城|tacheng|tc', '腾冲|tengchong|tc', '台州|taizhou|tz',
    '通辽|tongliao|tl', '太原|taiyuan|ty', '威海|weihai|wh', '梧州|wuzhou|wz', '文山|wenshan|ws', '无锡|wuxi|wx', '潍坊|weifang|wf', '武夷山|wuyishan|wys', '乌兰浩特|wulanhaote|wlht',
    '温州|wenzhou|wz', '乌鲁木齐|wulumuqi|wlmq', '万州|wanzhou|wz', '乌海|wuhai|wh', '兴义|xingyi|xy', '西昌|xichang|xc',  '襄樊|xiangfan|xf',
    '西宁|xining|xn', '锡林浩特|xilinhaote|xlht', '西双版纳|xishuangbanna|xsbn', '徐州|xuzhou|xz', '义乌|yiwu|yw', '永州|yongzhou|yz', '榆林|yulin|yl', '延安|yanan|ya', '运城|yuncheng|yc',
    '烟台|yantai|yt', '银川|yinchuan|yc', '宜昌|yichang|yc', '宜宾|yibin|yb', '盐城|yancheng|yc', '延吉|yanji|yj', '玉树|yushu|ys', '伊宁|yining|yn', '珠海|zhuhai|zh', '昭通|zhaotong|zt',
    '张家界|zhangjiajie|zjj', '舟山|zhoushan|zs', '郑州|zhengzhou|zz', '中卫|zhongwei|zw', '芷江|zhijiang|zj', '湛江|zhanjiang|zj'];

/* 正则表达式 筛选中文城市名、拼音、首字母 */

inCity.regEx = /^([\u4E00-\u9FA5\uf900-\ufa2d]+)\|(\w+)\|(\w)\w*$/i;
inCity.regExChiese = /([\u4E00-\u9FA5\uf900-\ufa2d]+)/;

(function () {
    var citys = inCity.allCity, match, letter,
            regEx = inCity.regEx,
            reg2 = /^[a-g]$/i, reg3 = /^[h-l]$/i, reg4 = /^[m-t]$/i, reg5 = /^[w-z]$/i;
    if (!inCity.oCity) {
        inCity.oCity = {hot:{},ABCDEFG:{}, HIJKL:{}, MNOPQRST:{}, WXYZ:{}};
        //console.log(citys.length);
        for (var i = 0, n = citys.length; i < n; i++) {
            match = regEx.exec(citys[i]); //exec
            letter = match[3].toUpperCase(); //转换字母为大写

            if (reg2.test(letter)) { //test检测一个字符串是否匹配某个模式
                if (!inCity.oCity.ABCDEFG[letter]) inCity.oCity.ABCDEFG[letter] = [];
                inCity.oCity.ABCDEFG[letter].push(match[1]);
            } else if (reg3.test(letter)) {
                if (!inCity.oCity.HIJKL[letter]) inCity.oCity.HIJKL[letter] = [];
                inCity.oCity.HIJKL[letter].push(match[1]);
            } else if (reg4.test(letter)) {
                if (!inCity.oCity.MNOPQRST[letter]) inCity.oCity.MNOPQRST[letter] = [];
                inCity.oCity.MNOPQRST[letter].push(match[1]);
            } else if (reg5.test(letter)) {
                if (!inCity.oCity.WXYZ[letter]) inCity.oCity.WXYZ[letter] = [];
                inCity.oCity.WXYZ[letter].push(match[1]);
            }
            /* 热门城市 前16条 */
            if(i<16){
                if(!inCity.oCity.hot['hot']) inCity.oCity.hot['hot'] = [];
                inCity.oCity.hot['hot'].push(match[1]);
            }
        }
    }
})();
// 热门城市
inCity.Hot = function(cityA){
    var ckey,odda,sortKey,str,odda=[],abc=[],key,regEx = inCity.regEx,oCity = inCity.oCity,len,leni;
    for(key in oCity){
        sortKey=[];
        for(ckey in oCity[key]){
            sortKey.push(ckey);
            // ckey按照ABCDEDG顺序排序
            sortKey.sort();
        }
        for(var j=0,k = sortKey.length;j<k;j++){
            odda = [];
            abc=[];
            for(var i=0,n=oCity[key][sortKey[j]].length;i<n;i++){
                
                if(key == 'hot'){
                   $(inCity.id).find(inCity.Children).eq(0).append('<a href="javascript:void(0)">' + oCity[key][sortKey[j]][i] + '</a>');
                    odda.push(str);
                }else{
                    str = '<a href="javascript:void(0)">' + oCity[key][sortKey[j]][i] + '</a>';
                    inCity.arrRepeat(abc,sortKey,j); //获取字母
                    odda.push(str);
                    len = n;
                    leni = i;
                }
                
            }
            inCity.cityPinyin(leni,len,key,abc,odda);
        }
    }
}

// 按拼音排序
inCity.cityPinyin = function(leni,len,key,abc,odda){
    if(leni != undefined && key != 'hot'){
        if(len-1 == leni){
            var one;
            switch (key)
            {
                case 'ABCDEFG':
                  one = 1;
                  break;
                case 'HIJKL':
                  one = 2;
                  break;
                case 'MNOPQRST':
                  one = 3;
                  break;
                case 'WXYZ':
                  one = 4;
                  break;
            }
            $(inCity.id).find(inCity.Children).eq(one).append('<div class="Letter">'
                +'<span>'+abc[0]+'</span>'
                +'<div>'
                    +odda.join('')
                +'</div>'
            +'</div>');
        }
    }
}

// 数组去重
inCity.arrRepeat = function(abc,sortKey,j){
    var nab = sortKey[j];
    for(var i in abc){
        if(abc[i] == nab){
            return nab = 1;
        }
    }
    if(nab != 1){
        abc.push(sortKey[j])
    }
}
// 城市切换
inCity.payment = function($this){
    var ind = $this.index();
    $this.siblings().removeClass("shar");
    $this.addClass("shar");
    $this.parent().next().children().hide();
    $this.parent().next().children().eq(ind).show();
}
// 给input赋值
inCity.cityClick = function ($this) {
    $(".city_a_le1 a").click(function () {
        var a_city = $(this).text();  //当前选择的城市
        $(inCity.id).hide();  //隐藏城市选择框 
        placeThis.val(a_city);  //赋值
        return false;
    })
}